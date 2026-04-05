package io.aygh7.location_system.location_system.service;

import io.aygh7.location_system.location_system.dto.BookResponse;
import io.aygh7.location_system.location_system.dto.BookRequestDto;
import io.aygh7.location_system.location_system.model.Booking;
import io.aygh7.location_system.location_system.model.Client;
import io.aygh7.location_system.location_system.model.Rider;
import io.aygh7.location_system.location_system.repository.BookRepository;
import io.aygh7.location_system.location_system.repository.ClientRepository;
import io.aygh7.location_system.location_system.repository.RiderRepository;
import io.aygh7.location_system.location_system.shared.BookStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Slf4j
public class BookingService {

    private final ClientRepository clientRepository;
    private final RiderRepository riderRepository;
    private final BookRepository bookRepository;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @Transactional
    public BookResponse
    createBooking(Long riderId, Long clientId) {

        log.info("Creating booking with riderId {} and client {}", riderId, clientId);

        Rider rider = riderRepository.findById(riderId).orElseThrow(
                () -> new IllegalArgumentException(String.format("Invalid rider id: '%s' ", riderId))
        );

        Client client = clientRepository.findById(clientId).orElseThrow(
                () -> new IllegalArgumentException(String.format("Invalid client id: '%s' ", riderId))
        );

        if (!rider.isAvailable()) {
            log.warn("Rider is not avaliable");
            throw new RuntimeException("Rider is not available");
        }

        Booking booking = Booking.builder()
                .rider(rider)
                .client(client)
                .bookStatus(BookStatus.PENDING)
                .build();

        booking = bookRepository.save(booking);

        simpMessagingTemplate.convertAndSendToUser(
                riderId.toString(),
                "/queue/booking",
                BookRequestDto.builder()
                        .clientId(clientId)
                        .clientName(client.getUsername())
                        .bookId(booking.getId()).build()
        );


        return BookResponse.builder()
                .riderName(rider.getUsername())
                .riderId(riderId)
                .status(booking.getBookStatus())
                .bookId(booking.getId())
                .build();

    }

    @Transactional
    public void respondToBooking(Long bookingId, Long riderId, boolean accepted) {
        Booking booking = bookRepository.findById(bookingId).orElseThrow(
                () -> new IllegalArgumentException("Booking not found: " + bookingId)
        );

        if (!booking.getRider().getId().equals(riderId)) {
            throw new RuntimeException("This booking does not belong to this rider");
        }

        if (accepted) {
            booking.setBookStatus(BookStatus.ACCEPTED);
            booking.getRider().setAvailable(false);
        } else {
            booking.setBookStatus(BookStatus.REJECTED);
        }

        bookRepository.save(booking);

        simpMessagingTemplate.convertAndSendToUser(
                booking.getClient().getId().toString(),
                "/queue/booking",
                BookResponse.builder()
                        .riderName(booking.getRider().getUsername())
                        .riderId(riderId)
                        .status(booking.getBookStatus())
                        .bookId(booking.getId())
                        .build()
        );


    }

}
