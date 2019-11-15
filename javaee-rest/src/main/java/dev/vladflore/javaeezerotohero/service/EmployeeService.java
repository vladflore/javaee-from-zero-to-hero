package dev.vladflore.javaeezerotohero.service;

import dev.vladflore.javaeezerotohero.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> loadEmployees();
}
