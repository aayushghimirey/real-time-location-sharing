package io.aygh7.location_system.location_system.dto.request;

import io.aygh7.location_system.location_system.shared.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRegistrationRequest(

        @NotBlank(message = "Username must not be blank")
        @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
        String username,

        @NotBlank(message = "Password must not be blank")
        @Size(min = 6, message = "Password must be at least 6 characters")
        String password,

        @Pattern(regexp = "^\\+?[0-9]{7,15}$", message = "Invalid phone number format")
        String phoneNumber,

        @NotBlank(message = "Role is required ")
        UserRole role

) {
}
