package ru.random_walk.chat_service;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.random_walk.LoadTestsDataGeneratorApplication;
import ru.random_walk.api.AuthApi;
import ru.random_walk.api.ChatApi;
import ru.random_walk.chat_service.extension.RestAssuredExtension;
import ru.random_walk.config.AutotestUserConfig;
import ru.random_walk.database.auth.entities.AuthUser;
import ru.random_walk.database.auth.entities.RefreshToken;
import ru.random_walk.database.auth.entities.UserRole;
import ru.random_walk.database.auth.functions.AuthUserFunctions;
import ru.random_walk.database.auth.functions.RefreshTokenFunctions;
import ru.random_walk.database.auth.functions.UserRoleFunctions;
import ru.random_walk.database.chat.functions.ChatMembersFunctions;
import ru.random_walk.enums.AuthType;
import ru.random_walk.model.JsonData;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@ExtendWith(RestAssuredExtension.class)
@SpringBootTest(classes = LoadTestsDataGeneratorApplication.class)
@Tag("websocket-load")
public class CreateFileForWebsocketLoadTest {

    @Autowired
    private AuthUserFunctions authUserFunctions;

    @Autowired
    private UserRoleFunctions userRoleFunctions;

    @Autowired
    private RefreshTokenFunctions refreshTokenFunctions;

    @Autowired
    private ChatMembersFunctions chatMembersFunctions;

    @Autowired
    private ChatApi chatApi;

    @Autowired
    private AuthApi api;

    @Autowired
    private AutotestUserConfig autotestUserConfig;

    @Test
    void createFile() throws Exception  {
        String usersCount = System.getProperty("userCount");
        int finalUsersCount = (usersCount == null || usersCount.isEmpty()) ? 1 : Integer.parseInt(usersCount);

        List<JsonData> users = IntStream.range(0, finalUsersCount)
                .parallel()
                .mapToObj(i -> {
                    UUID firstUserId = UUID.randomUUID();
                    String firstUserEmail = "loadtestuser%s@rv.com".formatted(firstUserId);
                    AuthUser firstUser = new AuthUser().setAuthType(AuthType.GOOGLE).setId(firstUserId).setEmail(firstUserEmail).setUsername(firstUserEmail).setEnabled(true);
                    UUID firstUserRefreshToken = UUID.randomUUID();
                    RefreshToken firstRefreshToken = new RefreshToken().setUserId(firstUserId).setToken(firstUserRefreshToken).setExpiresAt(LocalDateTime.now().plusDays(7));
                    UserRole firstUserRole = new UserRole().setUserId(firstUserId).setRoleId(1);

                    saveUser(firstUser, firstRefreshToken, firstUserRole);

                    var secondUserId = autotestUserConfig.getId();
                    chatApi.createChat(firstUserId, secondUserId);
                    var chatId = chatMembersFunctions.getUsersChat(firstUserId, secondUserId);

                    JsonData data = new JsonData();
                    data.setSender(firstUserId.toString());
                    data.setRecipient(secondUserId.toString());
                    data.setToken(api.refreshAuthToken(firstUserRefreshToken.toString()).getAccessToken());
                    data.setChatId(chatId.toString());
                    return data;
                })
                .collect(Collectors.toList());

        JsonMapper jsonMapper = new JsonMapper();
        try {
            jsonMapper.writeValue(new File("src/main/resources/chatUsers.json"), users);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveUser(AuthUser authUser, RefreshToken refreshToken, UserRole userRole) {
        authUserFunctions.save(authUser);
        userRoleFunctions.save(userRole);
        refreshTokenFunctions.save(refreshToken);
    }
}
