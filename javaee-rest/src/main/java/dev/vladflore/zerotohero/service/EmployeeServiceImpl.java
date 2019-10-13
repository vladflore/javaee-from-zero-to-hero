package dev.vladflore.zerotohero.service;

import dev.vladflore.zerotohero.entity.Employee;
import dev.vladflore.zerotohero.repository.EmployeeRepository;

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
