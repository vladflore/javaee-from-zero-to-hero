package dev.vladflore.javaeezerotohero.entity;

public class AddressFactory {
    public static Address createAddress(String street,
                                        Integer number,
                                        String location,
                                        String postalCode,
                                        String country) {
        return Address.builder()
                .street(street)
                .number(number)
                .location(location)
                .postalCode(postalCode)
                .country(country)
                .build();
    }
}
