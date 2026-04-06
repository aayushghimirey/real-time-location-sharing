package io.aygh7.location_system.location_system.dto.request;

public record RiderRegisterRequest(
        String name,
        String contactNumber,
        String email,
        String vehicleNumber,
        String licenseNumber
) {
}
