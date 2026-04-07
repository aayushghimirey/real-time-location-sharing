package io.aygh7.location_system.location_system.dto.request;


import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public record BookRegisterRequest(
        @NotNull Long clientId,
        @NotNull Long riderId,
        @NotNull @DecimalMin("-90.0") @DecimalMax("90.0") Double pickupLat,
        @NotNull @DecimalMin("-180.0") @DecimalMax("180.0") Double pickupLng,
        @NotNull @DecimalMin("-90.0") @DecimalMax("90.0") Double destLat,
        @NotNull @DecimalMin("-180.0") @DecimalMax("180.0") Double destLng
) {
}