package io.aygh7.location_system.location_system.dto.event;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record BookRideNotification(

        // Booking reference
        Long bookingId,
        Long riderId,
        Long clientId,

        // Client info
        String clientName,
        String clientPhone,

        // Location
        Double pickupLat,
        Double pickupLng,
        Double destLat,
        Double destLng,

        // Timing
        LocalDateTime requestedAt


) {
}
