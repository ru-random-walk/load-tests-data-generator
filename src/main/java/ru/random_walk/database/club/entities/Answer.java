package ru.random_walk.database.club.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import ru.random_walk.enums.AnswerStatus;

import java.util.UUID;

@Data
@Entity
@Table(name = "answer")
@NoArgsConstructor
public class Answer {

    @Id
    private UUID id;

    @Column(name = "approvement_id")
    private UUID approvementId;

    @Column(name = "user_id")
    private UUID userId;

    private String data;

    @Enumerated(EnumType.STRING)
    private AnswerStatus status;
}
