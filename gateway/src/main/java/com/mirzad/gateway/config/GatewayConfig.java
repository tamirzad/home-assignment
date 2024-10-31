package com.mirzad.gateway.config;

import com.mirzad.gateway.filter.JwtAuthenticationFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    private final JwtAuthenticationFilter filter;

    public GatewayConfig(JwtAuthenticationFilter filter) {
        this.filter = filter;
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r.path("/v1/user/**")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:8091"))

                .route("garment-service", r -> r.path("/v1/clothes/**")
                        .uri("http://localhost:8092"))

                .route("auth-service", r -> r.path("/v1/auth/**")
                        .uri("http://localhost:8090")).build();
    }
}