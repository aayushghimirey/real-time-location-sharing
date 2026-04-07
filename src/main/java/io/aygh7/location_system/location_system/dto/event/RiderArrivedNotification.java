package io.aygh7.location_system.location_system.dto.event;

public record RiderArrivedNotification(
        Double pickupLat,
        Double pickupLng,
        Long bookRequestId
) {
}
