package dev.vladflore.zerotohero.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
    private String firstName;
    private String lastName;
    private Integer age;
}
