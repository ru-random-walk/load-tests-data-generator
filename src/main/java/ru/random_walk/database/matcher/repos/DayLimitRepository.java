package ru.random_walk.database.matcher.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.random_walk.database.matcher.entities.DayLimit;
import ru.random_walk.database.matcher.entities.prkeys.DayLimitPK;

@Repository
public interface DayLimitRepository extends JpaRepository<DayLimit, DayLimitPK> {

    @Transactional(transactionManager = "matcherTransactionManager")
    @Modifying
    @Query(nativeQuery = true,
            value = "update day_limit set walk_count = 1 where person_id = :#{#dayLimitPK.getPersonId()} and date = :#{#dayLimitPK.getDate()}")
    void setDayLimitById(DayLimitPK dayLimitPK);
}
