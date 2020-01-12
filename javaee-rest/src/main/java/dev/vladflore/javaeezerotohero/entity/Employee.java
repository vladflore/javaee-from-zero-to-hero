package dev.vladflore.javaeezerotohero.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Employee extends Person {
    private Integer dayOfBirth;
    private Integer monthOfBirth;
    private Integer yearOfBirth;
    private Integer salary;
    private Address address;

    @Builder(toBuilder = true)
    public Employee(Integer dayOfBirth, Integer monthOfBirth, Integer yearOfBirth, Integer salary, Address address, String firstName, String lastName) {
        super(firstName, lastName);
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.salary = salary;
        this.address = address;
    }
}
