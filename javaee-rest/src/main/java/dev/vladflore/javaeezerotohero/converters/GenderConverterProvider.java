package dev.vladflore.javaeezerotohero.converters;

import dev.vladflore.javaeezerotohero.entity.Gender;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
public class GenderConverterProvider implements ParamConverterProvider {
    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
        if (rawType.equals(Gender.class)) {
            return (ParamConverter<T>) new GenderConverter();
        }
        return null;
    }
}
