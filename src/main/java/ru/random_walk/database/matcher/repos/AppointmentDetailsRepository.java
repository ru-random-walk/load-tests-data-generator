package ru.random_walk.database.matcher.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.random_walk.database.matcher.entities.AppointmentDetails;

import java.util.List;
import java.util.UUID;

@Repository
public interface AppointmentDetailsRepository extends JpaRepository<AppointmentDetails, UUID> {

    @Query(nativeQuery = true, value = "SELECT * FROM appointment_details WHERE requester_id = ?1")
    List<AppointmentDetails> findByRequesterId(UUID requesterId);
}
