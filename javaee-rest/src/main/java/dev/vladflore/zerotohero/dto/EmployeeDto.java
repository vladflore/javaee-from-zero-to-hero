package dev.vladflore.zerotohero.dto;


import lombok.Data;

@Data
public class EmployeeDto {
    private String fullName;
    private Integer age;
    private Integer salary;
    private AddressDto address;
    private String initials;
}
