package ru.random_walk.database.club.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import ru.random_walk.enums.ApprovementType;

import java.util.UUID;

@Data
@Entity
@Table(name = "approvement")
@NoArgsConstructor
public class Approvement {

    @Id
    private UUID id;

    @Column(name = "club_id")
    private UUID clubId;

    @Enumerated(EnumType.STRING)
    private ApprovementType type;

    private String data;

}
