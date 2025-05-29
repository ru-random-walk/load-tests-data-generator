package ru.random_walk.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Data
@ConfigurationProperties("api.autotest-user")
@Configuration
@NoArgsConstructor
public class AutotestUserConfig {

    private String token;

    private UUID id;
}
