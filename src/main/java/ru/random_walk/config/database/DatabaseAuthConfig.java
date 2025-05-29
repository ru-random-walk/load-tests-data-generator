package ru.random_walk.config.database;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class DatabaseAuthConfig {

    private String username;

    private String password;
}
