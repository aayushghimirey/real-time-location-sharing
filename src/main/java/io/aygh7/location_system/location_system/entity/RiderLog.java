package io.aygh7.location_system.location_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "rider_log")
@Getter
@Setter
public class RiderLog extends AuditFields {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_round_id")
    private BookRound bookRound;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rider_id")
    private Rider rider;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "recorded_at")
    private LocalDateTime recordedAt;
}
