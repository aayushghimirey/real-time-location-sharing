package io.aygh7.location_system.location_system.repository;

import io.aygh7.location_system.location_system.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Booking, Long> {
}
