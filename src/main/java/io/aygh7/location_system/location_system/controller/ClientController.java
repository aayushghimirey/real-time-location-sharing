package io.aygh7.location_system.location_system.controller;

import io.aygh7.location_system.location_system.dto.response.ClientProfileResponse;
import io.aygh7.location_system.location_system.service.ClientService;
import io.aygh7.location_system.location_system.shared.ApiResponse;
import io.aygh7.location_system.location_system.shared.AppResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/{clientId}")
    public ResponseEntity<ApiResponse<ClientProfileResponse>> getClientProfile(@PathVariable("clientId") Long clientId) {
        return AppResponse.success(clientService.getClientProfile(clientId), "Profile fetched");
    }

}
