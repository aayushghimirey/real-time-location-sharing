package io.aygh7.location_system.location_system.service;

import io.aygh7.location_system.location_system.dto.request.RiderRegisterRequest;
import io.aygh7.location_system.location_system.dto.response.RiderProfileResponse;

import java.util.List;

public interface RiderService {

    RiderProfileResponse registerRider(RiderRegisterRequest riderRegisterRequest);

    List<RiderProfileResponse> getAllAvailableRider();

}
