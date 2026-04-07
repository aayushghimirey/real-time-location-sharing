package io.aygh7.location_system.location_system.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "rider_log")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
