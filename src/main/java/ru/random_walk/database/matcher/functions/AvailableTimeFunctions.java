package ru.random_walk.database.matcher.functions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.random_walk.database.matcher.entities.AvailableTime;
import ru.random_walk.database.matcher.repos.AvailableTimeRepository;
import ru.random_walk.util.PointConverterUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AvailableTimeFunctions {

    private final AvailableTimeRepository availableTimeRepository;

    public List<AvailableTime> getUserAvailableTime(UUID personId) {
        return availableTimeRepository.findByPersonId(personId);
    }

    public AvailableTime getById(UUID id) {
        return availableTimeRepository.findById(id).orElse(null);
    }

    public List<AvailableTime> getUserAvailableTimeByDateAndPersonId(LocalDate date, UUID personId) {
        return availableTimeRepository.findByDateAndPersonId(date, personId)
                .stream()
                .map(r -> r.setLocation(PointConverterUtils.convertToPoint(r.getLocation()).toString()))
                .toList();
    }

    public void deleteUserAvailableTime(UUID personId) {
        availableTimeRepository.deleteByPersonId(personId);
    }

    public void deleteById(UUID id) {
        availableTimeRepository.deleteById(id);
    }

    public List<AvailableTime> getAllAvailableTime() {
        return availableTimeRepository.findAll();
    }
}
