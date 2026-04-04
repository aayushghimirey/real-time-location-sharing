package io.aygh7.location_system.location_system.repository;

import io.aygh7.location_system.location_system.model.LocationData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationDataRepository extends JpaRepository<LocationData, Long> {
}
