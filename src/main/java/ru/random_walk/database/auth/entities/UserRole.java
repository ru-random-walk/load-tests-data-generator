package ru.random_walk.database.auth.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Accessors(chain = true)
@Table(name = "user_role")
public class UserRole {

    @Id
    @Column(name = "user_id", nullable = false, unique = true)
    private UUID userId;

    @Column(name = "role_id", nullable = false, unique = true)
    private Integer roleId;

}
