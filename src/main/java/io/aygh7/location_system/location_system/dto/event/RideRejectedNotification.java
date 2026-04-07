package io.aygh7.location_system.location_system.dto.event;

public record RideRejectedNotification(
        Long bookRequestId,

        Long clientId
        ) {
}
