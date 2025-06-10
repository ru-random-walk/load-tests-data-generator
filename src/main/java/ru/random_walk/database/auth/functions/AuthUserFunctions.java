package ru.random_walk.database.auth.functions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.random_walk.database.auth.entities.AuthUser;
import ru.random_walk.database.auth.repos.AuthUserRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthUserFunctions {

    private final AuthUserRepository authUserRepository;

    public List<AuthUser> getAllUsers() {
        return authUserRepository.findAllData();
    }

    public AuthUser getUserByFullName(String fullName) {
        return authUserRepository.findByFullName(fullName);
    }

    public AuthUser getById(UUID id) {
        return authUserRepository.findById(id).orElse(null);
    }

    public List<AuthUser> getByPartOfUsername(String partOfUsername) {
        return authUserRepository.getAllByPartOfUsername(partOfUsername + "%");
    }

    public void save(AuthUser authUser) {
        authUserRepository.save(authUser);
    }

    public void delete(UUID id) {authUserRepository.deleteById(id);}
}
