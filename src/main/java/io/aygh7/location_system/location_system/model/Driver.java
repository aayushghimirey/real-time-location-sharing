package io.aygh7.location_system.location_system.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "drivers")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Driver extends User {

    @Column(name = "is_available")
    @Builder.Default
    private Boolean available = true;

    @Builder.Default
    private Double rating = 0.0;

}
