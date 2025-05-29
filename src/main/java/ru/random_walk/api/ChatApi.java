package ru.random_walk.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.random_walk.config.AutotestUserConfig;

import java.util.UUID;

import static io.restassured.RestAssured.given;

@Service
@RequiredArgsConstructor
public class ChatApi {

    private final AutotestUserConfig autotestUserConfig;

    public void createChat(UUID firstUserId, UUID secondUserId) {
        given()
                .baseUri("https://random-walk.ru:44424/chat")
                .header("Authorization", "Bearer " + autotestUserConfig.getToken())
                .contentType("application/json")
                .body("""
                        {
                          "chatMember1": "%s",
                          "chatMember2": "%s"
                        }
                        """.formatted(firstUserId, secondUserId))
                .post("/test/create-private-chat-event")
                .andReturn();
    }
}
