package io.aygh7.location_system.location_system.mapper;


import io.aygh7.location_system.location_system.dto.request.UserRegistrationRequest;
import io.aygh7.location_system.location_system.dto.response.DriverResponse;
import io.aygh7.location_system.location_system.model.Driver;
import org.springframework.stereotype.Component;

@Component
public class DriverMapper {

    public DriverResponse toResponse(Driver driver) {
        return DriverResponse.builder()
                .id(driver.getId())
                .username(driver.getUsername())
                .phoneNumber(driver.getPhoneNumber())
                .role(driver.getRole())
                .available(driver.getAvailable())
                .rating(driver.getRating())
                .creationDateTime(driver.getCreationDateTime())
                .lastUpdatedDateTime(driver.getLastUpdatedDateTime()).build();
    }

    public Driver buildDriver(UserRegistrationRequest request) {
        return Driver.builder()
                .username(request.username())
                .password(request.password())
                .role(request.role())
                .phoneNumber(request.phoneNumber())
                .build();
    }
}
