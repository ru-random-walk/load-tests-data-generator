package ru.random_walk.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonPropertyOrder({ "chatId", "token", "sender", "recipient"})
@Data
public class JsonData {

    private String chatId;

    private String token;

    private String sender;

    private String recipient;
}