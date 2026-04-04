package io.aygh7.location_system.location_system.service;

import io.aygh7.location_system.location_system.dto.CreateUserDto;
import io.aygh7.location_system.location_system.dto.UserResponseDto;
import io.aygh7.location_system.location_system.model.User;
import io.aygh7.location_system.location_system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto createUser(CreateUserDto createUserDto) {
        User user = new User();
        user.setUsername(createUserDto.username());
        user.setRole(createUserDto.role());
        return toResponse(userRepository.save(user));
    }

    private UserResponseDto toResponse(User user) {
        return new UserResponseDto(
            user.getId(),
            user.getUsername(),
            user.getRole()
        );
    }
}
