package ru.random_walk.database.auth.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Accessors(chain = true)
@Table(name = "refresh_token")
public class RefreshToken {

    @Id
    @Column(name = "user_id", unique = true, nullable = false)
    private UUID userId;

    private UUID token;

    @Column(name = "expires_at")
    private LocalDateTime expiresAt;
}
