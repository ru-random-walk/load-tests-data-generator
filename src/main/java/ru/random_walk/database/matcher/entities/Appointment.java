package ru.random_walk.database.matcher.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import ru.random_walk.database.matcher.entities.prkeys.AppointmentPK;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@Table(name = "appointment")
@IdClass(AppointmentPK.class)
public class Appointment {

    @Id
    @Column(name = "appointment_id", nullable = false)
    private UUID appointmentId;

    @Id
    @Column(name = "person_id")
    private UUID personId;
}
