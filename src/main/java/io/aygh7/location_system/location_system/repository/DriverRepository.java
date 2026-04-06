package io.aygh7.location_system.location_system.repository;

import io.aygh7.location_system.location_system.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    Optional<Driver> findByUsername(String username);
}
