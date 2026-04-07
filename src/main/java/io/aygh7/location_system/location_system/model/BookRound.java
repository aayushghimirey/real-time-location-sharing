package io.aygh7.location_system.location_system.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Table(name = "book_round")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
