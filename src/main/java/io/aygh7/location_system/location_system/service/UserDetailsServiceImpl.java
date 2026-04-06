package io.aygh7.location_system.location_system.service;

import io.aygh7.location_system.location_system.model.Client;
import io.aygh7.location_system.location_system.model.Driver;
import io.aygh7.location_system.location_system.model.User;
import io.aygh7.location_system.location_system.repository.ClientRepository;
import io.aygh7.location_system.location_system.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final ClientRepository clientRepository;
    private final DriverRepository driverRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Try to find client first
        Optional<Client> client = clientRepository.findByUsername(username);
        if (client.isPresent()) {
            return client.get();
        }

        // Try to find driver
        Optional<Driver> driver = driverRepository.findByUsername(username);
        if (driver.isPresent()) {
            return driver.get();
        }

        throw new UsernameNotFoundException("User not found: " + username);
    }

    public boolean existsByUsername(String username) {
        return clientRepository.findByUsername(username).isPresent() ||
               driverRepository.findByUsername(username).isPresent();
    }
}
