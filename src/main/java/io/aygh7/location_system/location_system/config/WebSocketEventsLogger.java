package io.aygh7.location_system.location_system.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocketEventsLogger {

    private static final Logger log = LoggerFactory.getLogger(WebSocketEventsLogger.class);

    @EventListener
    public void handleWebSocketConnectionListener(SessionConnectedEvent event) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());

        log.info("WS CONNECTED: sessionId = {}", accessor.getSessionId());
    }

    @EventListener
    public void onDisconnect(SessionDisconnectEvent event) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
        log.info("DISCONNECT | sessionID={} | userId={}", accessor.getSessionId(), accessor.getUser());
    }
}
