package io.aygh7.location_system.location_system.repository;

import io.aygh7.location_system.location_system.model.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RiderRepository extends JpaRepository<Rider, Long> {

    boolean existsByUsername(String username);

    Optional<Rider> findByUsername(String username);
}
