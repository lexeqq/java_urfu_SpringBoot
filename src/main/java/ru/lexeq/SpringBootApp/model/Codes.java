package ru.lexeq.SpringBootApp.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Codes {

    SUCCES("success"),

    FAILED("failed");

    private final String name;

    Codes(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
