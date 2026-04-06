package io.aygh7.location_system.location_system.dto.request;

public record ClientRegisterRequest(
        String name,
        String contactNumber,
        String email
) {
}
