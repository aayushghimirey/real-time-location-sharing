package io.aygh7.location_system.location_system.service;

import io.aygh7.location_system.location_system.dto.LocationDataResponse;
import io.aygh7.location_system.location_system.dto.SendLocationDto;
import io.aygh7.location_system.location_system.model.LocationData;
import io.aygh7.location_system.location_system.model.User;
import io.aygh7.location_system.location_system.repository.LocationDataRepository;
import io.aygh7.location_system.location_system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final UserRepository userRepository;
    private final LocationDataRepository locationDataRepository;
    private final SimpMessagingTemplate template;

    public void saveLocation(SendLocationDto sendLocationDto) {
        userRepository.findById(sendLocationDto.senderId())
                .ifPresentOrElse(
                        user -> {
                            userRepository.findById(sendLocationDto.receiverId()).ifPresent(
                                    receiver -> {
                                        locationDataRepository.save(buildLocationData(user, receiver, sendLocationDto));
                                        template.convertAndSendToUser(
                                                receiver.getId().toString(),
                                                "/topic/location", new LocationDataResponse(
                                                        sendLocationDto.longitude(),
                                                        sendLocationDto.latitude()
                                                ));
                                    }
                            );
                        },
                        () -> {
                            throw new RuntimeException("User not found");
                        }
                );
    }

    private LocationData buildLocationData(User sender, User receiver, SendLocationDto sendLocationDto) {
        LocationData locationData = new LocationData();
        locationData.setSender(sender);
        locationData.setReceiver(receiver);
        locationData.setLongitude(sendLocationDto.longitude());
        locationData.setLatitude(sendLocationDto.latitude());
        return locationData;
    }
}
