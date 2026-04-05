package io.aygh7.location_system.location_system.service;


import io.aygh7.location_system.location_system.dto.AuthRequest;
import io.aygh7.location_system.location_system.dto.UserResponse;
import io.aygh7.location_system.location_system.mapper.UserMapper;
import io.aygh7.location_system.location_system.repository.ClientRepository;
import io.aygh7.location_system.location_system.repository.RiderRepository;
import io.aygh7.location_system.location_system.shared.UserType;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private static final Logger log = LoggerFactory.getLogger(AuthService.class);
    private final ClientRepository clientRepository;
    private final RiderRepository riderRepository;

    public UserResponse login(AuthRequest authRequest) {
        String username = authRequest.username();
        String password = authRequest.password();

        log.debug("Username is : {} and password is : {}", username, password);
        return clientRepository.findByUsername(username)
                .map(client -> {
                    if (client.getPassword().equals(password)) {
                        return UserMapper.toResponse(client.getId(), client.getUsername(), UserType.CLIENT);
                    } else {
                        throw new RuntimeException("Invalid credentials");
                    }
                })
                .orElseGet(() -> riderRepository.findByUsername(username)
                        .map(rider -> {
                            if (rider.getPassword().equals(password)) {
                                return UserMapper.toResponse(rider.getId(), rider.getUsername(), UserType.RIDER);
                            } else {
                                throw new RuntimeException("Invalid credentials");
                            }
                        })
                        .orElseThrow(() -> new RuntimeException("Invalid credentials"))
                );
    }

}
