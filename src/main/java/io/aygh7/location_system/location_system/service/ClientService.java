package io.aygh7.location_system.location_system.service;


import io.aygh7.location_system.location_system.dto.UserRegisterDto;
import io.aygh7.location_system.location_system.dto.UserResponse;
import io.aygh7.location_system.location_system.mapper.UserMapper;
import io.aygh7.location_system.location_system.model.Client;
import io.aygh7.location_system.location_system.repository.ClientRepository;
import io.aygh7.location_system.location_system.shared.UserType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;


    @Transactional
    public UserResponse saveClient(UserRegisterDto userRegisterDto) {
        if (clientRepository.existsByUsername(userRegisterDto.username())) {
            throw new IllegalArgumentException(String.format("'%s' already exits. Try using another name", userRegisterDto.username()));
        }

        Client save = clientRepository.save(UserMapper.toClientEntity(userRegisterDto));

        return UserMapper.toResponse(save.getId(), save.getUsername(), UserType.CLIENT);
    }



}
