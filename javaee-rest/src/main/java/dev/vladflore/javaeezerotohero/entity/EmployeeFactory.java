package dev.vladflore.javaeezerotohero.entity;

public class EmployeeFactory {
    public static Employee createEmployee(String firstName,
                                          String lastName,
                                          Integer dayOfBirth,
                                          Integer monthOfBirth,
                                          Integer yearOfBirth,
                                          Integer salary,
                                          Address address, Gender gender) {
        return Employee.builder()
                .firstName(firstName)
                .lastName(lastName)
                .dayOfBirth(dayOfBirth)
                .monthOfBirth(monthOfBirth)
                .yearOfBirth(yearOfBirth)
                .salary(salary)
                .address(address)
                .gender(gender)
                .build();
    }
}
