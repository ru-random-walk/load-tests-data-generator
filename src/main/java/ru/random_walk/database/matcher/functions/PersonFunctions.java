package ru.random_walk.database.matcher.functions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.random_walk.database.matcher.entities.Person;
import ru.random_walk.database.matcher.repos.PersonRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonFunctions {

    private final PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonInfo(UUID id) {
        return personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Не найден пользователь с id = " + id));
    }
}
