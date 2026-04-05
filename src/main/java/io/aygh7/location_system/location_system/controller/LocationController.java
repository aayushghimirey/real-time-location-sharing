package io.aygh7.location_system.location_system.controller;


import io.aygh7.location_system.location_system.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/location")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;


    @GetMapping
    public ResponseEntity<?> streamLocation(
            @PathVariable("bookingId") Long bookingId, @PathVariable("longitude") double longitude,
            @PathVariable("latitude") double latitude
    ) {
        locationService.sendRiderLocation(bookingId, latitude, longitude);
        return ResponseEntity.noContent().build();
    }

}
