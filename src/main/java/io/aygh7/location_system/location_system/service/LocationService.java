package io.aygh7.location_system.location_system.service;


import io.aygh7.location_system.location_system.model.Booking;
import io.aygh7.location_system.location_system.repository.BookRepository;
import io.aygh7.location_system.location_system.shared.BookStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final BookRepository bookRepository;
    private final SimpMessagingTemplate simpMessagingTemplate;

    public void sendRiderLocation(Long bookingId, double latitude, double longitude) {
        Booking booking = bookRepository.findById(bookingId).orElseThrow(
                () -> new IllegalArgumentException("Booking not found: " + bookingId)
        );

        if (booking.getBookStatus() != BookStatus.ACCEPTED) {
            throw new RuntimeException("Booking is not accepted yet");
        }

        simpMessagingTemplate.convertAndSendToUser(
                booking.getClient().getId().toString(),
                "/queue/location",
                Map.of(
                        "latitude", latitude,
                        "longitude", longitude,
                        "riderId", booking.getRider().getId(),
                        "bookingId", bookingId
                )

        );

    }

}
