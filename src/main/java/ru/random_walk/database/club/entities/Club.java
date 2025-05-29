package ru.random_walk.database.club.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "club")
@NoArgsConstructor
public class Club {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private UUID id;

    private String name;

    private String description;

    @Column(name = "photo_version")
    private Integer photoVersion;
}
