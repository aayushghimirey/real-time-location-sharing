package io.aygh7.location_system.location_system.shared;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ApiResponse<T> {

    private String message;
    private int status;
    private LocalDateTime timestamp;
    private T data;

}
