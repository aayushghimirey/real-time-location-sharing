package io.aygh7.location_system.location_system.dto;

import lombok.Builder;

@Builder
public record BookRequestDto(
        Long clientId,
        Long bookId,
        String clientName
) {
}
