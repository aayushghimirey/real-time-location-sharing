package io.aygh7.location_system.location_system.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.aygh7.location_system.location_system.shared.UserType;
import lombok.Builder;

@Builder
@JsonIgnoreProperties
public record UserResponse(
        Long id,
        String username,
        Boolean isAvailable,
        UserType userType
) {
}
