package dev.vladflore.javaeezerotohero.dto;

import org.mapstruct.Named;

public class UpperCaseMapper {

    @Named("toUpperCase")
    public String toUpperCase(String str) {
        return str.toUpperCase();
    }
}
