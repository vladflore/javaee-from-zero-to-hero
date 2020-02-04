package dev.vladflore.javaeezerotohero.repository;

import dev.vladflore.javaeezerotohero.entity.Address;
import dev.vladflore.javaeezerotohero.entity.AddressFactory;
import dev.vladflore.javaeezerotohero.entity.Employee;
import dev.vladflore.javaeezerotohero.entity.Gender;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static dev.vladflore.javaeezerotohero.entity.EmployeeFactory.createEmployee;
import static dev.vladflore.javaeezerotohero.entity.Gender.FEMALE;
import static dev.vladflore.javaeezerotohero.entity.Gender.MALE;

public class EmployeeRepository {
    public List<Employee> loadEmployeesByGender(Gender gender) {

        Address address = AddressFactory.createAddress("Street", 15, "Location", "90443", "Germany");

        return Stream.of(
                createEmployee("John", "Doe", 15, 11, 1985, 1000, address, MALE),
                createEmployee("Jane", "Doe", 12, 10, 1986, 1500, address, FEMALE)
        ).filter(employee -> employee.getGender() == gender)
                .collect(Collectors.toList());
    }
}
