package dev.vladflore.javaeezerotohero.mapper;

import dev.vladflore.javaeezerotohero.dto.AddressDto;
import dev.vladflore.javaeezerotohero.dto.EmployeeDto;
import dev.vladflore.javaeezerotohero.dto.UpperCaseMapper;
import dev.vladflore.javaeezerotohero.entity.Address;
import dev.vladflore.javaeezerotohero.entity.Employee;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.List;

@Mapper(uses = UpperCaseMapper.class)
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    String SPACE = " ";

    @AfterMapping
    default void processEmployeeDto(Employee employee, @MappingTarget EmployeeDto employeeDto) {
        String fullName = employee.getFirstName() + " " + employee.getLastName();
        employeeDto.setFullName(fullName);

        Integer age = Period.between(LocalDate.of(employee.getYearOfBirth(), Month.of(employee.getMonthOfBirth()), employee.getDayOfBirth()), LocalDate.now()).getYears();
        employeeDto.setAge(age);

//        String initials = employee.getFirstName().charAt(0) + "" + employee.getLastName().charAt(0);
//        employeeDto.setInitials(initials.toUpperCase());
    }

    @Mapping(target="initials", expression = "java(employee.getFirstName().charAt(0) + \"\" + employee.getLastName().charAt(0))")
    EmployeeDto employeeToEmployeeDto(Employee employee);

    @Mapping(target = "plz", source = "postalCode")
    @Mapping(target = "country", qualifiedByName = "toUpperCase")
    @Mapping(target = "streetAndNumber", expression = "java(address.getStreet() + SPACE + address.getNumber())")
    AddressDto addressToAddressDto(Address address);

//    @AfterMapping
//    default void processAddressDto(Address address, @MappingTarget AddressDto addressDto) {
//        addressDto.setStreetAndNumber(address.getStreet() + SPACE + address.getNumber());
//    }

    List<EmployeeDto> employeeToEmployeeDto(List<Employee> employees);
}
