package dev.vladflore.javaeezerotohero.service;

import dev.vladflore.javaeezerotohero.entity.Employee;
import dev.vladflore.javaeezerotohero.entity.Gender;

import java.util.List;

public interface EmployeeService {
    List<Employee> loadEmployees(Gender gender);
}
