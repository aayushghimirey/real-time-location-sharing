package io.aygh7.location_system.location_system.service;

import io.aygh7.location_system.location_system.dto.request.BookRegisterRequest;
import io.aygh7.location_system.location_system.dto.response.BookRegisterResponse;

public interface BookingRequestService {

    BookRegisterResponse createBooking(BookRegisterRequest request);

    BookRegisterResponse reviewBooking(Long bookingId, boolean isAccepted);

}
