package io.aygh7.location_system.location_system.mapper;

import io.aygh7.location_system.location_system.dto.request.ClientRegisterRequest;
import io.aygh7.location_system.location_system.dto.response.ClientProfileResponse;
import io.aygh7.location_system.location_system.model.Client;
import org.mapstruct.Mapper;

@Mapper
public interface ClientMapper {

    Client toClient(ClientRegisterRequest clientRegisterRequest);
    ClientProfileResponse toClientProfileResponse(Client client);

}
