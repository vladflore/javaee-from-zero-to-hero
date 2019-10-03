package dev.vladflore.zerotohero.repository;

import dev.vladflore.zerotohero.entity.Employee;

import java.util.List;

import static dev.vladflore.zerotohero.entity.EmployeeFactory.createEmployee;
import static java.util.Arrays.asList;

public class EmployeeRepository {
    public List<Employee> loadEmployees() {
        return asList(
                createEmployee("John", "Doe", 15, 11, 1985, 1000),
                createEmployee("Jane", "Doe", 12, 10, 1986, 1500)
        );
    }
}
