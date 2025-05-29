package ru.random_walk.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.random_walk.config.AuthApiConfig;
import ru.random_walk.model.TokenResponse;

import java.util.Map;

import static io.restassured.RestAssured.given;

@Service
@RequiredArgsConstructor
public class AuthApi {

    @Autowired
    private AuthApiConfig authApiConfig;

    public String refreshAuthToken(String refreshToken) {
        var mapOfRequestParams = Map.of("grant_type", "refresh_token", "refresh_token", refreshToken);

        return given()
                .baseUri("https://random-walk.ru:44424/auth")
                .auth().basic(authApiConfig.getUsername(), authApiConfig.getPassword())
                .contentType("application/x-www-form-urlencoded")
                .formParams(mapOfRequestParams)
                .post("/token")
                .as(TokenResponse.class).getAccessToken();
    }
}
