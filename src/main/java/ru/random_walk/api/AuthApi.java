package ru.random_walk.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
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
        var response = given()
                .baseUri("https://random-walk.ru:44424/auth")
                .auth().basic(authApiConfig.getUsername(), authApiConfig.getPassword())
                .contentType("application/x-www-form-urlencoded")
                .formParams(mapOfRequestParams)
                .post("/token")
                .then().log().ifError().extract().response();
        String body = response.getBody().asString();
        System.out.println(body);
        if (body == null || body.isBlank()) {
            throw new IllegalStateException("Empty or null response body for token refresh" + response.asPrettyString() + " " + response.getStatusCode());
        }

        return JsonPath.from(body).getString("access_token");
    }
}
