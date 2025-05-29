package ru.random_walk.database.chat.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "chat")
@NoArgsConstructor
public class Chat {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private UUID id;

    @Column(name = "type", nullable = false)
    private String type;
}
