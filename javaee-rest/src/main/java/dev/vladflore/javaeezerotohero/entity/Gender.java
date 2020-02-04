package dev.vladflore.javaeezerotohero.entity;

import java.util.stream.Stream;

public enum Gender {
    MALE,
    FEMALE;

    public static Gender fromString(String genderStr) {
        System.out.println(Gender.class.getName() + " converting to enum");
        return Stream.of(Gender.values())
                .filter(gender -> gender.name().equalsIgnoreCase(genderStr))
                .findFirst()
                .orElse(null);
    }
}
