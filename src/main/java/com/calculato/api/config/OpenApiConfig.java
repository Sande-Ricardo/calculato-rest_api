package com.calculato.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Calculato API Gateway")
                        .version("1.0")
                        .description("API Gateway for the Calculato educational platform. Handles routing to microservices for mathematical calculations."));
    }
}
