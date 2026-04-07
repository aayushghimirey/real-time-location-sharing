package io.aygh7.location_system.location_system.service;

import io.aygh7.location_system.location_system.dto.request.ClientRegisterRequest;
import io.aygh7.location_system.location_system.dto.response.ClientProfileResponse;

public interface ClientService {
    ClientProfileResponse registerClient(ClientRegisterRequest clientRegisterRequest);

    ClientProfileResponse getClientProfile(Long id);
}
