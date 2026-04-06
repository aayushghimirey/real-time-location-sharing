package io.aygh7.location_system.location_system.controller;

import io.aygh7.location_system.location_system.dto.request.UserRegistrationRequest;
import io.aygh7.location_system.location_system.service.ClientService;
import io.aygh7.location_system.location_system.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public/users")
@RequiredArgsConstructor
public class UserController {

    private final ClientService clientService;
    private final DriverService driverService;

    @PostMapping("/client")
    public ResponseEntity<?> createUser(@RequestBody UserRegistrationRequest request) {
        return ResponseEntity.ok(clientService.saveClient(request));
    }

    @PostMapping("/driver")
    public ResponseEntity<?> createDriver(@RequestBody UserRegistrationRequest request) {
        return ResponseEntity.ok(driverService.saveDriver(request));
    }

    @GetMapping("/all/drivers")
    public ResponseEntity<?> getAllDrivers() {
        return ResponseEntity.ok(driverService.getAllDriver());
    }

}
