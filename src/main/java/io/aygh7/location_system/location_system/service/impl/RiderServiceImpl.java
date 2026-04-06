package io.aygh7.location_system.location_system.service.impl;

import io.aygh7.location_system.location_system.dto.request.RiderRegisterRequest;
import io.aygh7.location_system.location_system.dto.response.RiderProfileResponse;
import io.aygh7.location_system.location_system.mapper.RiderMapper;
import io.aygh7.location_system.location_system.model.Rider;
import io.aygh7.location_system.location_system.repository.RiderRepository;
import io.aygh7.location_system.location_system.service.RiderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class RiderServiceImpl implements RiderService {

    private final RiderMapper riderMapper;
    private final RiderRepository riderRepository;

    @Override
    public RiderProfileResponse registerRider(RiderRegisterRequest riderRegisterRequest) {
        validate(riderRegisterRequest);

        Rider rider = riderMapper.toRider(riderRegisterRequest);

        rider = riderRepository.save(rider);

        return riderMapper.toRiderProfileResponse(rider);

    }

    private void validate(RiderRegisterRequest request) {
        riderRepository.findByName(request.name()).ifPresent(client -> {
            throw new RuntimeException("Rider already exists. Try using different name");
        });
    }
}
