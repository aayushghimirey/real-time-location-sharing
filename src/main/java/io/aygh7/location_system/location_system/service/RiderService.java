package io.aygh7.location_system.location_system.service;

import io.aygh7.location_system.location_system.dto.request.RiderRegisterRequest;
import io.aygh7.location_system.location_system.dto.response.RiderProfileResponse;

public interface RiderService {

    RiderProfileResponse registerRider(RiderRegisterRequest riderRegisterRequest);

}
