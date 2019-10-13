package dev.vladflore.zerotohero.service;

import dev.vladflore.zerotohero.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> loadEmployees();
}
