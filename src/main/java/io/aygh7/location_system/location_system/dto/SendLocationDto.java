package io.aygh7.location_system.location_system.dto;

public record SendLocationDto(
        String longitude,
        String latitude,
        Long senderId,
        Long receiverId
) {
}
