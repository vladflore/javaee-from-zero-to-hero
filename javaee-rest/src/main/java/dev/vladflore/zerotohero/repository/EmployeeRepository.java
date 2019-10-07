package dev.vladflore.zerotohero.repository;

import dev.vladflore.zerotohero.entity.Address;
import dev.vladflore.zerotohero.entity.AddressFactory;
import dev.vladflore.zerotohero.entity.Employee;

import java.util.List;

import static dev.vladflore.zerotohero.entity.EmployeeFactory.createEmployee;
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
