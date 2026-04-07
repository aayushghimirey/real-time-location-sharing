package io.aygh7.location_system.location_system.dto.request;

public record LogCreationRequest(
        Long bookRoundId,
        Long clientId,
        Long riderId,
        Double latitude,
        Double longitude
) {
}
