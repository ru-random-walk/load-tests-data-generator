package ru.random_walk.database.club.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.random_walk.database.club.entities.Approvement;

import java.util.List;
import java.util.UUID;

@Repository
public interface ApprovementRepository extends JpaRepository<Approvement, UUID> {

    List<Approvement> findByClubId(UUID clubId);
}
