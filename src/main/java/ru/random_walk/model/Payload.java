package ru.random_walk.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Payload {
    private String type;
    private String text;
}
