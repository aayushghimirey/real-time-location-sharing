package io.aygh7.location_system.location_system.service.impl;

import io.aygh7.location_system.location_system.dto.event.RiderArrivedNotification;
import io.aygh7.location_system.location_system.dto.request.LogCreationRequest;
import io.aygh7.location_system.location_system.exception.ClientNotFoundException;
import io.aygh7.location_system.location_system.model.*;
import io.aygh7.location_system.location_system.repository.*;
import io.aygh7.location_system.location_system.service.LogsSharingService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LogsSharingServiceImpl implements LogsSharingService {

    private final RiderLogRepository riderLogRepository;
    private final ClientLogRepository clientLogRepository;
    private final BookRoundRepository bookRoundRepository;
    private final ClientRepository clientRepository;
    private final RiderRepository riderRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    @Transactional
    public void shareLogs(LogCreationRequest logsRequest) {

        BookRound bookRound = bookRoundRepository.findById(logsRequest.bookRoundId()).orElseThrow(
                () -> new RuntimeException("Invalid book round id")
        );
        if (logsRequest.clientId() != null) {
            Client client = clientRepository.findById(logsRequest.clientId()).orElseThrow(() -> new ClientNotFoundException("Client not found"));

            ClientLog log = new ClientLog();
            log.setClient(client);
            log.setLatitude(log.getLatitude());
            log.setLongitude(log.getLongitude());
            log.setBookRound(bookRound);

            clientLogRepository.save(log);


        } else if (logsRequest.riderId() != null) {
            Rider rider = riderRepository.findById(logsRequest.riderId()).orElseThrow(() -> new ClientNotFoundException("Client not found"));

            if (bookRound.getBookRequest().getPickupLat().equals(logsRequest.latitude())
                    && bookRound.getBookRequest().getPickupLng().equals(logsRequest.longitude())) {
                bookRound.getBookRequest().setStatus(BookingStatus.ARRIVED);

                RiderArrivedNotification riderArrivedNotification =
                        new RiderArrivedNotification(
                                logsRequest.latitude(),
                                logsRequest.longitude(),
                                bookRound.getId()
                        );

                applicationEventPublisher.publishEvent(riderArrivedNotification);

            }

            RiderLog log = new RiderLog();
            log.setRider(rider);
            log.setLatitude(log.getLatitude());
            log.setLongitude(log.getLongitude());
            log.setBookRound(bookRound);
            riderLogRepository.save(log);
        }

    }


}
