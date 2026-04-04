package io.aygh7.location_system.location_system.repository;

import io.aygh7.location_system.location_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
