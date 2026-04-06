package io.aygh7.location_system.location_system.dto.response;

public record RiderProfileResponse(
        String name,
        String contactNumber,
        String email,
        String vehicleNumber,
        String licenseNumber,
        Boolean isAvailable,
        Long id
) {
}
