package ru.random_walk.database.chat.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.random_walk.database.chat.entities.Message;

import java.util.List;
import java.util.UUID;

@Repository
public interface MessageRepository extends JpaRepository<Message, UUID> {

    List<Message> findAllByChatId(UUID chatId);

    void deleteByChatId(UUID chatId);
}
