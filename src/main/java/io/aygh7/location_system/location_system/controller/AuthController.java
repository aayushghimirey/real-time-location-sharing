package io.aygh7.location_system.location_system.controller;

import io.aygh7.location_system.location_system.dto.request.LoginRequest;
import io.aygh7.location_system.location_system.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public ResponseEntity<?> auth(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.authUser(request));
    }


}
