package io.aygh7.location_system.location_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "book_round")
@Getter
@Setter
public class BookRound extends AuditFields {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_request_id")
    private BookRequest bookRequest;

    @Column(name = "round_number")
    private Integer roundNumber;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "ended_at")
    private LocalDateTime endedAt;

    @Column(name = "distance_km")
    private Double distanceKm;
}
