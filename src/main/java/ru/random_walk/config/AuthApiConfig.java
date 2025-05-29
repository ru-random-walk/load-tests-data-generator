package ru.random_walk.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties("api.auth")
@Configuration
@NoArgsConstructor
public class AuthApiConfig {

    private String username;

    private String password;
}
