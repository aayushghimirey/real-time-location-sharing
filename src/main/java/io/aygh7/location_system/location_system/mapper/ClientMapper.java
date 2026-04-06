package io.aygh7.location_system.location_system.mapper;

import io.aygh7.location_system.location_system.dto.request.UserRegistrationRequest;
import io.aygh7.location_system.location_system.dto.response.ClientResponse;
import io.aygh7.location_system.location_system.model.Client;
import org.springframework.stereotype.Component;


@Component
public class ClientMapper {

    public ClientResponse toResponse(Client client) {
        return ClientResponse.builder()
                .id(client.getId())
                .username(client.getUsername())
                .phoneNumber(client.getPhoneNumber())
                .role(client.getRole())
                .creationDateTime(client.getCreationDateTime())
                .lastUpdatedDateTime(client.getLastUpdatedDateTime()).build();
    }

    public Client buildClient(UserRegistrationRequest request) {
        return Client.builder()
                .username(request.username())
                .password(request.password())
                .role(request.role())
                .phoneNumber(request.phoneNumber())
                .build();
    }
}
