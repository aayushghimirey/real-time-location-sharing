package io.aygh7.location_system.location_system.model;

import io.aygh7.location_system.location_system.shared.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Enumerated(EnumType.STRING)

    private UserRole role;

    @OneToMany(mappedBy = "sender")
    private List<LocationData> locationData;

    @OneToMany(mappedBy = "receiver")
    private List<LocationData> receivedLocationData;
}
