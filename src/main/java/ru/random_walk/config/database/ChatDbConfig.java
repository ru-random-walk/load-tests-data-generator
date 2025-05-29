package ru.random_walk.config.database;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("datasource.chat")
public class ChatDbConfig extends DatabaseAuthConfig {}
