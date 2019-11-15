package dev.vladflore.javaeezerotohero.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
    private String firstName;
    private String lastName;
    private Integer dayOfBirth;
    private Integer monthOfBirth;
    private Integer yearOfBirth;
    private Integer salary;
    private Address address;
}
