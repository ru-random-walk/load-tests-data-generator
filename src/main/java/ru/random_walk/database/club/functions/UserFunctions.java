package ru.random_walk.database.club.functions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.random_walk.database.club.entities.User;
import ru.random_walk.database.club.repos.UserRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserFunctions {

    private final UserRepository userRepository;

    public User getById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }
}
