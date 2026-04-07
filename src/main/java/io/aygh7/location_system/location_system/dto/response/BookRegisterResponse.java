package io.aygh7.location_system.location_system.dto.response;

import io.aygh7.location_system.location_system.model.BookingStatus;

import java.time.LocalDateTime;

public record BookRegisterResponse(

        Long id,
        Long clientId,
        Long riderId,
        Double pickupLat,
        Double pickupLng,
        Double destLat,
        Double destLng,
        BookingStatus status,
        LocalDateTime requestedAt,
        LocalDateTime acceptedAt

) {
}
