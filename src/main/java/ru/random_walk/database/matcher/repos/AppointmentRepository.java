package ru.random_walk.database.matcher.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.random_walk.database.matcher.entities.Appointment;
import ru.random_walk.database.matcher.entities.prkeys.AppointmentPK;

import java.util.List;
import java.util.UUID;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, AppointmentPK> {

    @Transactional(transactionManager = "matcherTransactionManager")
    @Modifying
    void deleteByAppointmentId(UUID appointmentId);

    List<Appointment> findByAppointmentId(UUID appointmentId);

    List<Appointment> findAllByPersonId(UUID personId);
}
