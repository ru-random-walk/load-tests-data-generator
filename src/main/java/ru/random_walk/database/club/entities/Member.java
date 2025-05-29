package ru.random_walk.database.club.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import ru.random_walk.database.club.entities.prkeys.MemberPK;
import ru.random_walk.enums.MemberRole;

import java.util.UUID;

@Data
@Entity
@Table(name = "member")
@IdClass(MemberPK.class)
@NoArgsConstructor
public class Member {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Id
    @Column(name = "club_id", nullable = false)
    private UUID clubId;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private MemberRole role;

}
