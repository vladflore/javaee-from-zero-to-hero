package dev.vladflore.javaeezerotohero.converters;

import dev.vladflore.javaeezerotohero.entity.Gender;

import javax.ws.rs.ext.ParamConverter;

public class GenderConverter implements ParamConverter<Gender> {
    @Override
    public Gender fromString(String value) {
        System.out.println(GenderConverter.class.getName() + " converting to enum");
        return Gender.valueOf(value);
    }

    @Override
    public String toString(Gender value) {
        return value.toString();
    }
}
