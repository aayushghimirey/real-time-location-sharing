package io.aygh7.location_system.location_system.controller;

import io.aygh7.location_system.location_system.dto.SendLocationDto;
import io.aygh7.location_system.location_system.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationService locationService;

    @PostMapping
    public ResponseEntity<Void> saveLocation(@RequestBody SendLocationDto sendLocationDto) {
        locationService.saveLocation(sendLocationDto);
        return ResponseEntity.noContent().build();

    }

}
