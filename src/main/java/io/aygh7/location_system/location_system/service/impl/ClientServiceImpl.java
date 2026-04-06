package io.aygh7.location_system.location_system.service.impl;

import io.aygh7.location_system.location_system.dto.request.ClientRegisterRequest;
import io.aygh7.location_system.location_system.dto.response.ClientProfileResponse;
import io.aygh7.location_system.location_system.mapper.ClientMapper;
import io.aygh7.location_system.location_system.model.Client;
import io.aygh7.location_system.location_system.repository.ClientRepository;
import io.aygh7.location_system.location_system.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Component
@Slf4j
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientProfileResponse registerClient(ClientRegisterRequest clientRegisterRequest) {
        validate(clientRegisterRequest);

        Client client = clientMapper.toClient(clientRegisterRequest);

        client = clientRepository.save(client);

        return clientMapper.toClientProfileResponse(client);
    }

    private void validate(ClientRegisterRequest request) {
        clientRepository.findByName(request.name()).ifPresent(client -> {
            throw new RuntimeException("Client already exists. Try using different name");
        });
    }
}
