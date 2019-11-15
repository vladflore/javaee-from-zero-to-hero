package dev.vladflore.javaeezerotohero.service;

import dev.vladflore.javaeezerotohero.entity.Employee;
import dev.vladflore.javaeezerotohero.repository.EmployeeRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class EmployeeServiceImpl implements EmployeeService {

    @Inject
    private EmployeeRepository employeeRepository;

    public List<Employee> loadEmployees() {
        return employeeRepository.loadEmployees();
    }
}
