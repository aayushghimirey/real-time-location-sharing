package io.aygh7.location_system.location_system.mapper;

import io.aygh7.location_system.location_system.dto.event.BookRideNotification;
import io.aygh7.location_system.location_system.model.BookRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BookRideNotificationMapper {

    @Mapping(target = "riderId", source = "rider.id")
    @Mapping(target = "clientId", source = "client.id")
    @Mapping(target = "clientName", source = "client.name")
    @Mapping(target = "bookingId", source = "id")
    @Mapping(target = "clientPhone", source = "client.contactNumber")
    BookRideNotification toBookRideNotification(BookRequest request);

}
