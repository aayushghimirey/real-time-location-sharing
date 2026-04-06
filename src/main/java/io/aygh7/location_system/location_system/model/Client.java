package io.aygh7.location_system.location_system.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Client extends User {



}
