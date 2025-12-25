package com.example.demo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Apartment Facility Booking System API")
                        .version("1.0.0")
                        .description("API for managing apartment facility bookings with user registration, " +
                                "apartment assignment, facility management, booking creation and " +
                                "cancellation, and booking log tracking")
                        .contact(new Contact()
                                .name("API Support")
                                .url("https://9248.408procr.amypo.ai/")))
                .components(new Components()
                        .addSecuritySchemes("bearer-jwt",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        .description("JWT Bearer token for API authentication")))
                .addSecurityItem(new SecurityRequirement().addList("bearer-jwt"));
    }
}
