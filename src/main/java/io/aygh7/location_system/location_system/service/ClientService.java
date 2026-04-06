package io.aygh7.location_system.location_system.service;


import io.aygh7.location_system.location_system.dto.request.UserRegistrationRequest;
import io.aygh7.location_system.location_system.dto.response.ClientResponse;
import io.aygh7.location_system.location_system.mapper.ClientMapper;
import io.aygh7.location_system.location_system.model.Client;
import io.aygh7.location_system.location_system.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final UserDetailsServiceImpl userDetailsService;
    private final ClientMapper clientMapper;
    private final PasswordEncoder passwordEncoder;


    @Transactional
    public ClientResponse saveClient(UserRegistrationRequest request) {

        if (userDetailsService.existsByUsername(request.username())) {
            throw new RuntimeException("Username already exits.Try using another username");
        }

        Client client = clientMapper.buildClient(request);
        client.setPassword(passwordEncoder.encode(request.password()));

        Client save = clientRepository.save(client);

        return clientMapper.toResponse(save);

    }

}
