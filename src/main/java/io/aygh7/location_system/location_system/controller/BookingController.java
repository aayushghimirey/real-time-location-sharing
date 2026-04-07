package io.aygh7.location_system.location_system.controller;

import io.aygh7.location_system.location_system.dto.request.BookRegisterRequest;
import io.aygh7.location_system.location_system.dto.response.BookRegisterResponse;
import io.aygh7.location_system.location_system.service.BookingRequestService;
import io.aygh7.location_system.location_system.shared.ApiResponse;
import io.aygh7.location_system.location_system.shared.AppResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingRequestService bookingRequestService;

    @PostMapping
    public ResponseEntity<ApiResponse<BookRegisterResponse>> createBooking(@RequestBody BookRegisterRequest request) {
        return AppResponse.success(bookingRequestService.createBooking(request), "Booking request successfully");
    }

    @PostMapping("/{bookId}/accept/{accept}")
    public ResponseEntity<ApiResponse<BookRegisterResponse>> acceptBooking(@PathVariable("bookId") Long bookId, @PathVariable("accept") Boolean accept) {
        return AppResponse.success(bookingRequestService.reviewBooking(bookId, accept), "Booking request successfully");
    }


}
