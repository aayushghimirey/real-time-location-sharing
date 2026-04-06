package io.aygh7.location_system.location_system.mapper;

import io.aygh7.location_system.location_system.dto.request.RiderRegisterRequest;
import io.aygh7.location_system.location_system.dto.response.RiderProfileResponse;
import io.aygh7.location_system.location_system.model.Rider;
import org.mapstruct.Mapper;

@Mapper
public interface RiderMapper {

    Rider toRider(RiderRegisterRequest riderRegisterRequest);

    RiderProfileResponse toRiderProfileResponse(Rider rider);

}
