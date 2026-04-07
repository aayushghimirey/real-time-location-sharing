package io.aygh7.location_system.location_system.service.impl;

import io.aygh7.location_system.location_system.dto.request.BookRegisterRequest;
import io.aygh7.location_system.location_system.mapper.BookRequestMapper;
import io.aygh7.location_system.location_system.mapper.BookRideNotificationMapper;
import io.aygh7.location_system.location_system.model.BookRequest;
import io.aygh7.location_system.location_system.model.Client;
import io.aygh7.location_system.location_system.model.Rider;
import io.aygh7.location_system.location_system.repository.BookRequestRepository;
import io.aygh7.location_system.location_system.repository.BookRoundRepository;
import io.aygh7.location_system.location_system.repository.ClientRepository;
import io.aygh7.location_system.location_system.repository.RiderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookingRequestServiceImplTest {

    @Mock
    BookRequestRepository bookRequestRepository;
    @Mock
    ClientRepository clientRepository;
    @Mock
    RiderRepository riderRepository;
    @Mock
    BookRequestMapper bookRequestMapper;
    @Mock
    BookRoundRepository bookRoundRepository;
    @Mock
    BookRideNotificationMapper bookRideNotificationMapper;
    @Mock
    ApplicationEventPublisher applicationEventPublisher;

    @InjectMocks
    BookingRequestServiceImpl bookingRequestService;

    BookRegisterRequest bookRegisterRequest;
    BookRequest bookRequest;
    Client client = mock(Client.class);
    Rider rider = mock(Rider.class);

    @BeforeEach
    void setUp() {
        Long clientId = 1L;
        Long riderId = 2l;
        Double pickupLat = 1.1;
        Double pickUpLng = 2.2;
        Double destLat = 3.3;
        Double destLng = 4.4;

        bookRegisterRequest = new BookRegisterRequest(
                clientId, riderId, pickupLat, pickUpLng, destLat, destLng
        );


    }

    @Test
    void create_success_booking() {

        when(bookRequestMapper.toBookRequest(bookRegisterRequest)).thenReturn(bookRequest);
        when(clientRepository.findById(bookRegisterRequest.clientId())).thenReturn(Optional.of(client));
        when(riderRepository.findById(bookRegisterRequest.riderId())).thenReturn(Optional.of(rider));

    }

}