package io.aygh7.location_system.location_system.controller;

import io.aygh7.location_system.location_system.dto.AuthRequest;
import io.aygh7.location_system.location_system.dto.UserRegisterDto;
import io.aygh7.location_system.location_system.service.AuthService;
import io.aygh7.location_system.location_system.service.ClientService;
import io.aygh7.location_system.location_system.service.RiderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final ClientService clientService;
    private final RiderService riderService;
    private final AuthService authService;


    @PostMapping("/client")
    public ResponseEntity<?> createClient(@RequestBody UserRegisterDto userRegisterDto) {
        return ResponseEntity.ok(clientService.saveClient(userRegisterDto));
    }

    @PostMapping("/rider")
    public ResponseEntity<?> createRider(@RequestBody UserRegisterDto userRegisterDto) {
        return ResponseEntity.ok(riderService.saveRider(userRegisterDto));
    }

    @PostMapping("/auth")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        return ResponseEntity.ok(authService.login(authRequest));
    }


    @GetMapping("/rider")
    public ResponseEntity<?> getAllRiders() {
        return ResponseEntity.ok(riderService.getAllRider());
    }
}
