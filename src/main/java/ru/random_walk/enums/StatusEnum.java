package ru.random_walk.enums;

import java.io.IOException;

public enum StatusEnum {
    REQUESTED("REQUESTED"),

    APPOINTED("APPOINTED"),

    IN_PROGRESS("IN_PROGRESS"),

    DONE("DONE"),

    CANCELED("CANCELED");

    private String value;

    StatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static StatusEnum fromValue(String value) {
        for (StatusEnum b : StatusEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
