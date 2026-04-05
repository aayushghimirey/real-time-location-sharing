package io.aygh7.location_system.location_system.config;

import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;

@Slf4j
public class CustomHandSakeHandler extends DefaultHandshakeHandler {

    @Override
    protected @Nullable Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
        String token = request.getURI().getQuery();
        log.info("User connection token : {}", token);

        return () -> token;
    }
}
