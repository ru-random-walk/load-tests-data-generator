package ru.random_walk.database.matcher.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import ru.random_walk.database.matcher.entities.prkeys.DayLimitPK;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@Table(name = "day_limit")
@IdClass(DayLimitPK.class)
public class DayLimit {

    @Id
    @Column(name = "person_id", nullable = false)
    private UUID personId;

    @Id
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "walk_count")
    private Integer walkCount;

}
