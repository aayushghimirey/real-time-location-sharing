package io.aygh7.location_system.location_system.dto;

import io.aygh7.location_system.location_system.shared.UserRole;

public record UserResponseDto(
        Long id,
        String username,
        UserRole role
) {
}
