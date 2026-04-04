package io.aygh7.location_system.location_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LocationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocationSystemApplication.class, args);
	}

}
