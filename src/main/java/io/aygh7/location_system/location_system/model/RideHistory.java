package io.aygh7.location_system.location_system.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ride_history")
@Getter
@Setter
public class RideHistory extends AuditFields {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_request_id")
    private BookRequest bookRequest;

    @Column(name = "total_distance_km")
    private Double totalDistanceKm;

    @Column(name = "price_per_km", precision = 10, scale = 2)
    private BigDecimal pricePerKm;

    @Column(name = "total_price", precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    @Column(name = "rating")
    private Integer rating;
}
