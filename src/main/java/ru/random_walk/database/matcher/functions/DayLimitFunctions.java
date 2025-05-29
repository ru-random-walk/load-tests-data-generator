package ru.random_walk.database.matcher.functions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.random_walk.database.matcher.entities.DayLimit;
import ru.random_walk.database.matcher.entities.prkeys.DayLimitPK;
import ru.random_walk.database.matcher.repos.DayLimitRepository;

@Service
@RequiredArgsConstructor
public class DayLimitFunctions {

    private final DayLimitRepository dayLimitRepository;

    public DayLimit getById(DayLimitPK dayLimitPK) {
        return dayLimitRepository.findById(dayLimitPK).orElse(null);
    }

    public void setDayLimitByDateAndPersonId(DayLimitPK dayLimitPK) {
        dayLimitRepository.setDayLimitById(dayLimitPK);
    }
}
