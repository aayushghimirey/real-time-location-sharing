package io.aygh7.location_system.location_system.dto;

import io.aygh7.location_system.location_system.shared.BookStatus;
import lombok.Builder;

@Builder
public record BookResponse(
        BookStatus status,
        String riderName,
        Long riderId,
        Long bookId
) {
}
