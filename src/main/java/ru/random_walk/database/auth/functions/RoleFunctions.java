package ru.random_walk.database.auth.functions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.random_walk.database.auth.entities.Role;
import ru.random_walk.database.auth.repos.RoleRepository;


import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleFunctions {
    private final RoleRepository roleRepository;

    public List<Role> getAllData() {
        return roleRepository.findAllData();
    }
}
