package com.demoqa.data.enums;

public enum GendersEnum {

    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    private String name;

    GendersEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
