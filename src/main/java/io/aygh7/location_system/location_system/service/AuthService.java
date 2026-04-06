package io.aygh7.location_system.location_system.service;

import io.aygh7.location_system.location_system.dto.request.LoginRequest;
import io.aygh7.location_system.location_system.dto.response.AuthResponse;
import io.aygh7.location_system.location_system.shared.JwtHelperService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private final JwtHelperService jwtHelperService;


    public AuthResponse authUser(LoginRequest loginRequest) {

        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.username());

        if (!passwordEncoder.matches(loginRequest.password(), userDetails.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        Map<String, Object> claims = new HashMap<>();
        claims.put("role", userDetails.getAuthorities());

        String token = jwtHelperService.generateToken(claims, userDetails);

        return new AuthResponse(token);

    }


}
