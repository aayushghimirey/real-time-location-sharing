package io.aygh7.location_system.location_system.dto.response;

import io.aygh7.location_system.location_system.shared.UserRole;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ClientResponse(
        Long id,
        String username,
        String phoneNumber,
        UserRole role,
        LocalDateTime creationDateTime,
        LocalDateTime lastUpdatedDateTime
) {
}
