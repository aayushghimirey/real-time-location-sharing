package io.aygh7.location_system.location_system.shared;


import org.springframework.http.ResponseEntity;

public class AppResponse {

    public static <T> ResponseEntity<ApiResponse<T>> success(T data, String message) {

        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage(message);
        apiResponse.setData(data);

        return ResponseEntity.ok(apiResponse);

    }

}
