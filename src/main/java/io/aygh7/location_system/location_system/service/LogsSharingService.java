package io.aygh7.location_system.location_system.service;

import io.aygh7.location_system.location_system.dto.request.LogCreationRequest;

public interface LogsSharingService {

    void shareLogs(LogCreationRequest logsRequest);

}
