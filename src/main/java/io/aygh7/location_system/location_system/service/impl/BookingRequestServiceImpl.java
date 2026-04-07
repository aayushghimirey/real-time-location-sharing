package io.aygh7.location_system.location_system.service.impl;

import io.aygh7.location_system.location_system.dto.event.BookAcceptedNotification;
import io.aygh7.location_system.location_system.dto.event.BookRideNotification;
import io.aygh7.location_system.location_system.dto.event.RideRejectedNotification;
import io.aygh7.location_system.location_system.dto.request.BookRegisterRequest;
import io.aygh7.location_system.location_system.dto.response.BookRegisterResponse;
import io.aygh7.location_system.location_system.exception.InvalidBookingRequestException;
import io.aygh7.location_system.location_system.exception.RiderNotAvailableException;
import io.aygh7.location_system.location_system.mapper.BookRequestMapper;
import io.aygh7.location_system.location_system.mapper.BookRideNotificationMapper;
import io.aygh7.location_system.location_system.model.*;
import io.aygh7.location_system.location_system.repository.BookRequestRepository;
import io.aygh7.location_system.location_system.repository.BookRoundRepository;
import io.aygh7.location_system.location_system.repository.ClientRepository;
import io.aygh7.location_system.location_system.repository.RiderRepository;
import io.aygh7.location_system.location_system.service.BookingRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingRequestServiceImpl implements BookingRequestService {

    private final BookRequestRepository bookRequestRepository;
    private final ClientRepository clientRepository;
    private final RiderRepository riderRepository;
    private final BookRequestMapper bookRequestMapper;
    private final BookRoundRepository bookRoundRepository;
    private final BookRideNotificationMapper bookRideNotificationMapper;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    @Transactional
    public BookRegisterResponse createBooking(BookRegisterRequest request) {

        BookRequest bookRequest = bookRequestMapper.toBookRequest(request);

        validateAndSetup(request, bookRequest);

        bookRequest = bookRequestRepository.save(bookRequest);

        BookRideNotification bookRideNotification =
                bookRideNotificationMapper.toBookRideNotification(bookRequest);

        // todo : listen this event and send to rider
        applicationEventPublisher.publishEvent(bookRideNotification);

        return bookRequestMapper.toBookRegisterResponse(bookRequest);

    }

    @Override
    @Transactional
    public BookRegisterResponse reviewBooking(Long bookRequestId, boolean isAccepted) {

        BookRequest bookRequest = bookRequestRepository.findById(bookRequestId)
                .orElseThrow(() -> new InvalidBookingRequestException("Invalid booking id"));

        if (bookRequest.getStatus() != BookingStatus.PENDING) {
            throw new InvalidBookingRequestException(
                    "Booking already " + bookRequest.getStatus()
            );
        }

        if (isAccepted) {
            int updated = riderRepository.markUnavailable(bookRequest.getRider().getId());
            if (updated == 0) {
                throw new RiderNotAvailableException("Rider was just taken");
            }

            // 2. Reject all other pending requests for this rider
            List<BookRequest> otherPending = bookRequestRepository
                    .findByRiderAndStatus(bookRequest.getRider().getId(), BookingStatus.PENDING)
                    .stream()
                    .filter(other -> !other.getId().equals(bookRequestId))
                    .toList();

            otherPending.forEach(other -> other.setStatus(BookingStatus.REJECTED));
            bookRequestRepository.saveAll(otherPending);

            otherPending.forEach(other ->
                    applicationEventPublisher.publishEvent(
                            new RideRejectedNotification(other.getId(), other.getClient().getId())
                    )
            );

            // 3. Accept this booking
            bookRequest.setStatus(BookingStatus.ACCEPTED);
            bookRequest.setAcceptedAt(LocalDateTime.now());

            // 4. Build round AFTER acceptedAt is set
            bookRoundRepository.save(buildBookRound(bookRequest, 1));

            applicationEventPublisher.publishEvent(
                    new BookAcceptedNotification(
                            bookRequest.getId(),
                            bookRequest.getClient().getId(),
                            bookRequest.getRider().getId(),
                            bookRequest.getAcceptedAt()
                    )
            );

        } else {
            bookRequest.setStatus(BookingStatus.REJECTED);

            applicationEventPublisher.publishEvent(
                    new RideRejectedNotification(
                            bookRequest.getId(),
                            bookRequest.getClient().getId()
                    )
            );
        }

        return bookRequestMapper.toBookRegisterResponse(bookRequest);
    }

    private BookRound buildBookRound(BookRequest bookRequest, int round) {
        return BookRound.builder()
                .bookRequest(bookRequest)
                .roundNumber(round)
                .startedAt(bookRequest.getAcceptedAt())
                .build();
    }

    private void validateAndSetup(BookRegisterRequest request, BookRequest bookRequest) {
        Client client = clientRepository.findById(request.clientId())
                .orElseThrow(() -> new InvalidBookingRequestException("Invalid client id"));

        Rider rider = riderRepository.findById(request.riderId())
                .orElseThrow(() -> new InvalidBookingRequestException("Invalid rider id"));

        if (!rider.getIsAvailable()) {
            throw new RiderNotAvailableException("Rider is not available");
        }

        bookRequest.setClient(client);
        bookRequest.setRider(rider);
        bookRequest.setStatus(BookingStatus.PENDING);
        bookRequest.setRequestedAt(LocalDateTime.now());
    }

}
