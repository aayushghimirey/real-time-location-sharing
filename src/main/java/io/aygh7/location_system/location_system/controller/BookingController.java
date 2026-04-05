package io.aygh7.location_system.location_system.controller;


import io.aygh7.location_system.location_system.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<?> createBooking(
            @RequestParam("riderId") Long riderId, @RequestParam("clientId") Long clientId) {
        return ResponseEntity.ok(bookingService.createBooking(riderId, clientId));
    }

    @PostMapping("/response")
    public ResponseEntity<Void> responseToBooking(
            @RequestParam("bookingId") Long bookingId,
            @RequestParam("riderId") Long riderId,
            @RequestParam("isAccepted") boolean isAccepted
    ) {
        bookingService.respondToBooking(bookingId, riderId, isAccepted);
        return ResponseEntity.noContent().build();
    }

}
