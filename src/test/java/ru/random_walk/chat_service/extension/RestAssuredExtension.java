package ru.random_walk.chat_service.extension;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.parsing.Parser;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.Arrays;

public class RestAssuredExtension implements BeforeAllCallback {
    @Override
    public void beforeAll(ExtensionContext context) {
        RestAssured.reset();
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL);
        RestAssured
                .filters(Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter()));
    }
}
