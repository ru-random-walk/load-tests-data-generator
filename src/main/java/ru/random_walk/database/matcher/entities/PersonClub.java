package ru.random_walk.database.matcher.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import ru.random_walk.database.matcher.entities.prkeys.PersonClubPK;

import java.util.UUID;

@Data
@Entity
@Table(name = "person_club")
@NoArgsConstructor
@IdClass(PersonClubPK.class)
public class PersonClub {

    @Id
    @Column(name = "person_id", nullable = false)
    private UUID personId;

    @Id
    @Column(name = "club_id", nullable = false)
    private UUID clubId;
}
