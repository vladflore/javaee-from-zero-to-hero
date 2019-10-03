package dev.vladflore.zerotohero.mapper;

import dev.vladflore.zerotohero.dto.EmployeeDto;
import dev.vladflore.zerotohero.entity.Employee;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.List;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);


    @AfterMapping
    default void processDto(Employee employee, @MappingTarget EmployeeDto employeeDto) {
        String fullName = employee.getFirstName() + " " + employee.getLastName();
        employeeDto.setFullName(fullName);

        Integer age = Period.between(LocalDate.of(employee.getYearOfBirth(), Month.of(employee.getMonthOfBirth()), employee.getDayOfBirth()), LocalDate.now()).getYears();
        employeeDto.setAge(age);
    }

    EmployeeDto toDto(Employee employee);

    List<EmployeeDto> toDto(List<Employee> employees);
}
