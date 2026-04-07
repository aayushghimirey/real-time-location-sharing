package io.aygh7.location_system.location_system.dto.event;

import java.time.LocalDateTime;

public record BookAcceptedNotification(
        Long bookRequestId,
        Long clientId,
        Long riderId,
        LocalDateTime acceptedAt
) {
}
