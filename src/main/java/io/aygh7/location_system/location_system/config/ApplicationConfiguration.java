package io.aygh7.location_system.location_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {

        return httpSecurity.csrf(CsrfConfigurer::disable)
                .authorizeHttpRequests(request -> {
                    request.anyRequest().authenticated();
                })
                .addFilterBefore(null, UsernamePasswordAuthenticationFilter.class)
                .build();

    }

}
