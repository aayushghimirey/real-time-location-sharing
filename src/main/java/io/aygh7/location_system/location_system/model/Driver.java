package io.aygh7.location_system.location_system.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "drivers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Driver {

    @Column(name = "is_available")
    private Boolean available = true;
    private Double rating = 0.0;

}
