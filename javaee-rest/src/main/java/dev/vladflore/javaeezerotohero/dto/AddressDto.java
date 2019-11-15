package dev.vladflore.javaeezerotohero.dto;

import lombok.Data;

@Data
public class AddressDto {
    private String streetAndNumber;
    private String location;
    private String plz;
    private String country;
}
