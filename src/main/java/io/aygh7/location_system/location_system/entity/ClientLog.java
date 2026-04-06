package io.aygh7.location_system.location_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "client_log")
@Getter
@Setter
public class ClientLog extends AuditFields {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_round_id")
    private BookRound bookRound;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "recorded_at")
    private LocalDateTime recordedAt;
}
