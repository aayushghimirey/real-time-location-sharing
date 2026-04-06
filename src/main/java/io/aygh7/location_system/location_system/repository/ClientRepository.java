package io.aygh7.location_system.location_system.repository;

import io.aygh7.location_system.location_system.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByUsername(String username);
}
