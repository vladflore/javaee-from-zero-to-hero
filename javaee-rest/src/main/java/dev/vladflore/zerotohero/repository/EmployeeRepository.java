package dev.vladflore.zerotohero.repository;

import dev.vladflore.zerotohero.entity.Employee;

import java.util.List;

import static java.util.Arrays.asList;

public class EmployeeRepository {
    public List<Employee> loadEmployees() {
        return asList(
                createEmployee("First Name", "Last Name", 33),
                createEmployee("First Name1", "Last Name1", 32),
                createEmployee("First Name2", "Last Name2", 31)
        );
    }

    private Employee createEmployee(String firstName, String lastName, int age) {
        return Employee.builder()
                .firstName(firstName)
                .lastName(lastName)
                .age(age)
                .build();
    }
}
