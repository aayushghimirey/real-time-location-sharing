package io.aygh7.location_system.location_system.repository;

import io.aygh7.location_system.location_system.model.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RiderRepository extends JpaRepository<Rider, Long> {
    Optional<Rider> findByName(String name);

    List<Rider> findAllByIsAvailable(boolean isAvailable);

    @Modifying
    @Query("UPDATE Rider r SET r.isAvailable = false " +
            "WHERE r.id = :id AND r.isAvailable = true")
    int markUnavailable(@Param("id") Long id);

}
