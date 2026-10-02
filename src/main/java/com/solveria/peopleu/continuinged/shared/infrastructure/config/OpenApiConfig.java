package com.solveria.peopleu.continuinged.shared.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI continuingedOpenApi() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("PeopleU Continuing Education Service API")
                                .version("1.0.0")
                                .description(
                                        "APIs de PeopleU Continuing Education Service organizadas por modulos EC."));
    }
}
