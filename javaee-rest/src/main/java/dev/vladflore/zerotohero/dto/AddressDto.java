package dev.vladflore.zerotohero.dto;

import lombok.Data;

@Data
public class AddressDto {
    private String streetAndNumber;
    private String location;
    private String plz;
    private String country;
}
