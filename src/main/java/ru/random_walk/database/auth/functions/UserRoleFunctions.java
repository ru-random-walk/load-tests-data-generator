package ru.random_walk.database.auth.functions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.random_walk.database.auth.entities.UserRole;
import ru.random_walk.database.auth.repos.UserRoleRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserRoleFunctions {
    private final UserRoleRepository userRoleRepository;

    public List<UserRole> getAll() {
        return userRoleRepository.findAll();
    }

    public void save(UserRole userRole) {
        userRoleRepository.save(userRole);
    }

    public void delete(UUID id) {
        userRoleRepository.deleteById(id);
    }
}
