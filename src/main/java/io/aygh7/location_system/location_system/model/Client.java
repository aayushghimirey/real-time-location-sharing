package io.aygh7.location_system.location_system.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;

}
