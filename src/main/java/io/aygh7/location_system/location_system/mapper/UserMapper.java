package io.aygh7.location_system.location_system.mapper;

import io.aygh7.location_system.location_system.dto.UserRegisterDto;
import io.aygh7.location_system.location_system.dto.UserResponse;
import io.aygh7.location_system.location_system.model.Client;
import io.aygh7.location_system.location_system.model.Rider;
import io.aygh7.location_system.location_system.shared.UserType;


public final class UserMapper {

    private UserMapper() {
    }

    public static Client toClientEntity(UserRegisterDto request) {
        return Client.builder()
                .username(request.username())
                .password(request.password())
                .build();
    }


    public static Rider toRiderEntity(UserRegisterDto request) {
        return Rider.builder()
                .username(request.username())
                .password(request.password())
                .isAvailable(true)
                .build();
    }


    public static UserResponse toResponse(Long id, String username, UserType userType) {
        return UserResponse.builder()
                .id(id)
                .isAvailable(null)
                .userType(userType)
                .username(username).build();
    }

    public static UserResponse toRiderResponse(Long id, String username, boolean isAvailable) {
        return UserResponse.builder()
                .id(id)
                .isAvailable(isAvailable)
                .username(username).build();
    }
}
