package io.aygh7.location_system.location_system.service;


import io.aygh7.location_system.location_system.dto.UserRegisterDto;
import io.aygh7.location_system.location_system.dto.UserResponse;
import io.aygh7.location_system.location_system.mapper.UserMapper;
import io.aygh7.location_system.location_system.model.Rider;
import io.aygh7.location_system.location_system.repository.RiderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RiderService {

    private final RiderRepository riderRepository;

    @Transactional
    public UserResponse saveRider(UserRegisterDto userRegisterDto) {
        if (riderRepository.existsByUsername(userRegisterDto.username())) {
            throw new IllegalArgumentException("{} already exits. Try using another name");
        }

        Rider save = riderRepository.save(UserMapper.toRiderEntity(userRegisterDto));

        return UserMapper.toRiderResponse(save.getId(), save.getUsername(), save.isAvailable());
    }

    @Transactional(readOnly = true)
    public List<UserResponse> getAllRider() {
        return riderRepository.findAll().stream()
                .map(rider -> UserMapper.toRiderResponse(rider.getId(), rider.getUsername(), rider.isAvailable()))
                .toList();
    }


}
