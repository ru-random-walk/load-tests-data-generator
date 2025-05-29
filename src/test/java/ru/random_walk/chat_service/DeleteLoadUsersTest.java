package ru.random_walk.chat_service;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.random_walk.LoadTestsDataGeneratorApplication;
import ru.random_walk.chat_service.extension.RestAssuredExtension;
import ru.random_walk.database.auth.entities.AuthUser;
import ru.random_walk.database.auth.functions.AuthUserFunctions;
import ru.random_walk.database.auth.functions.RefreshTokenFunctions;
import ru.random_walk.database.auth.functions.UserRoleFunctions;
import ru.random_walk.database.chat.functions.ChatMembersFunctions;
import ru.random_walk.service.ChatService;

@ExtendWith(RestAssuredExtension.class)
@SpringBootTest(classes = LoadTestsDataGeneratorApplication.class)
@Tag("websocket-load-delete")
public class DeleteLoadUsersTest {

    @Autowired
    private AuthUserFunctions authUserFunctions;

    @Autowired
    private UserRoleFunctions userRoleFunctions;

    @Autowired
    private RefreshTokenFunctions refreshTokenFunctions;

    @Autowired
    private ChatService chatService;

    @Autowired
    private ChatMembersFunctions chatMembersFunctions;

    @Test
    void deleteUsers() {
        var usersToDelete = authUserFunctions.getByPartOfUsername("loadtestuser").stream().map(AuthUser::getId).toList();
        usersToDelete.forEach(
                user -> {
                    userRoleFunctions.delete(user);
                    refreshTokenFunctions.delete(user);
                    authUserFunctions.delete(user);
                    var userChats = chatMembersFunctions.getChatsByUserId(user);
                    userChats.parallelStream().forEach(
                            chat -> chatService.deleteChatById(chat.getChatId())
                    );
                }
        );
    }

}
