package dev.vladflore.zerotohero.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String street;
    private Integer number;
    private String location;
    private String postalCode;
    private String country;
}
