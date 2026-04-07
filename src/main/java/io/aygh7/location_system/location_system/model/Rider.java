package io.aygh7.location_system.location_system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "rider")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rider extends AuditFields {

    @Column(name = "name")
    private String name;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "vehicle_number")
    private String vehicleNumber;

    @Column(name = "licence_number")
    private String licenceNumber;

    @Column(name = "is_available", nullable = false)
    private Boolean isAvailable = true;
}
