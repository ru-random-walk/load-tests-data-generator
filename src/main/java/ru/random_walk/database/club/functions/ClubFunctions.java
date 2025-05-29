package ru.random_walk.database.club.functions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.random_walk.database.club.entities.Club;
import ru.random_walk.database.club.repos.ClubRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClubFunctions {

    private final ClubRepository clubRepository;

    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }

    public Club getById(UUID id) {
        return clubRepository.findById(id).orElse(null);
    }
}
