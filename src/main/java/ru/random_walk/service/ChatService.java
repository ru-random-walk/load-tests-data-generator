package ru.random_walk.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.random_walk.database.chat.functions.ChatFunctions;
import ru.random_walk.database.chat.functions.ChatMembersFunctions;
import ru.random_walk.database.chat.functions.MessageFunctions;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatService {

    private final ChatMembersFunctions chatMembersFunctions;

    private final ChatFunctions chatFunctions;

    private final MessageFunctions messageFunctions;

    public void deleteChatBetweenUsers(UUID firstUser, UUID secondUser) {
        log.info("Удаляем чат между {} и {}", firstUser, secondUser);
        var chatId = chatMembersFunctions.deleteChatMembers(firstUser, secondUser);
        messageFunctions.deleteMessagesByChatId(chatId);
        chatFunctions.deleteByChatId(chatId);
    }

    public void deleteChatById(UUID chatId) {
        log.info("Удаляем чат {}", chatId);
        chatMembersFunctions.deleteByChatId(chatId);
        messageFunctions.deleteMessagesByChatId(chatId);
        chatFunctions.deleteByChatId(chatId);
    }
}
