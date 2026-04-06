package io.aygh7.location_system.location_system.service;


import io.aygh7.location_system.location_system.dto.request.UserRegistrationRequest;
import io.aygh7.location_system.location_system.dto.response.DriverResponse;
import io.aygh7.location_system.location_system.mapper.DriverMapper;
import io.aygh7.location_system.location_system.model.Driver;
import io.aygh7.location_system.location_system.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;
    private final UserDetailsServiceImpl userDetailsService;
    private final DriverMapper driverMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public DriverResponse saveDriver(UserRegistrationRequest request) {

        if (userDetailsService.existsByUsername(request.username())) {
            throw new RuntimeException("Username already exits.Try using another username");
        }

        Driver driver = driverMapper.buildDriver(request);
        driver.setPassword(passwordEncoder.encode(request.password()));

        Driver save = driverRepository.save(driver);

        return driverMapper.toResponse(save);

    }

    public List<DriverResponse> getAllDriver() {
        return driverRepository.findAll().stream().map(driverMapper::toResponse).toList();
    }

}
