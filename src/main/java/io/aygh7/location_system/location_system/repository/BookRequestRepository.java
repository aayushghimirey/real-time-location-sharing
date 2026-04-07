package io.aygh7.location_system.location_system.repository;

import io.aygh7.location_system.location_system.model.BookRequest;
import io.aygh7.location_system.location_system.model.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRequestRepository extends JpaRepository<BookRequest, Long> {

    List<BookRequest> findByRiderAndStatus(Long riderId, BookingStatus status);

}
