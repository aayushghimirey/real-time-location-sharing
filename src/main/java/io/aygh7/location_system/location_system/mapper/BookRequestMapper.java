package io.aygh7.location_system.location_system.mapper;

import io.aygh7.location_system.location_system.dto.request.BookRegisterRequest;
import io.aygh7.location_system.location_system.dto.response.BookRegisterResponse;
import io.aygh7.location_system.location_system.model.BookRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BookRequestMapper {

    @Mapping(target = "client", ignore = true)
    @Mapping(target = "rider", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "requestedAt", ignore = true)
    @Mapping(target = "acceptedAt", ignore = true)
    BookRequest toBookRequest(BookRegisterRequest request);

    @Mapping(target = "clientId", source = "client.id")
    @Mapping(target = "riderId", source = "rider.id")
    BookRegisterResponse toBookRegisterResponse(BookRequest bookRequest);

}
