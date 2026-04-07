package io.aygh7.location_system.location_system.controller;

import io.aygh7.location_system.location_system.dto.request.ClientRegisterRequest;
import io.aygh7.location_system.location_system.dto.request.RiderRegisterRequest;
import io.aygh7.location_system.location_system.dto.response.ClientProfileResponse;
import io.aygh7.location_system.location_system.dto.response.RiderProfileResponse;
import io.aygh7.location_system.location_system.service.ClientService;
import io.aygh7.location_system.location_system.service.RiderService;
import io.aygh7.location_system.location_system.shared.ApiResponse;
import io.aygh7.location_system.location_system.shared.AppResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
@RequiredArgsConstructor
public class PublicController {

    private final RiderService riderService;
    private final ClientService clientService;


    @PostMapping
    public ResponseEntity<ApiResponse<RiderProfileResponse>> createRider(@RequestBody RiderRegisterRequest request) {
        return AppResponse.success(riderService.registerRider(request), "Rider register successfully");
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ClientProfileResponse>> createClient(@RequestBody ClientRegisterRequest request) {
        return AppResponse.success(clientService.registerClient(request), "Client register successfully");
    }


}
