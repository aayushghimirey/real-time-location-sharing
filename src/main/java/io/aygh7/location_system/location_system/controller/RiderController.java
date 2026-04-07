package io.aygh7.location_system.location_system.controller;

import io.aygh7.location_system.location_system.dto.response.RiderProfileResponse;
import io.aygh7.location_system.location_system.service.RiderService;
import io.aygh7.location_system.location_system.shared.ApiResponse;
import io.aygh7.location_system.location_system.shared.AppResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/riders")
@RequiredArgsConstructor
public class RiderController {

    private final RiderService riderService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<RiderProfileResponse>>> getAllAvailableRider() {
        return AppResponse.success(riderService.getAllAvailableRider(), "Fetch successfully");
    }

}
