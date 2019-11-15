package dev.vladflore.javaeezerotohero.repository;

import dev.vladflore.javaeezerotohero.entity.Address;
import dev.vladflore.javaeezerotohero.entity.AddressFactory;
import dev.vladflore.javaeezerotohero.entity.Employee;

import java.util.List;

import static dev.vladflore.javaeezerotohero.entity.EmployeeFactory.createEmployee;
import static java.util.Arrays.asList;

public class EmployeeRepository {
    public List<Employee> loadEmployees() {

        Address address = AddressFactory.createAddress("Street", 15, "Location", "90443", "Germany");

        return asList(
                createEmployee("John", "Doe", 15, 11, 1985, 1000, address),
                createEmployee("Jane", "Doe", 12, 10, 1986, 1500, address)
        );
    }
}
