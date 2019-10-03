package dev.vladflore.zerotohero.mapper;

import dev.vladflore.zerotohero.dto.EmployeeDto;
import dev.vladflore.zerotohero.entity.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static dev.vladflore.zerotohero.entity.EmployeeFactory.createEmployee;
import static org.assertj.core.api.Assertions.assertThat;

class EmployeeMapperTest {

    @Test
    @DisplayName("Convert from Employee entity to Employee DTO")
    void testMappingOne() {

        Employee employee = createEmployee("John", "Doe", 15, 11, 1985, 1000);
        EmployeeDto employeeDto = EmployeeMapper.INSTANCE.toDto(employee);

        assertThat(employeeDto.getFullName()).isEqualTo("John Doe");
        assertThat(employeeDto.getAge()).isEqualTo(33);
        assertThat(employeeDto.getSalary()).isEqualTo(1000);

    }

    @Test
    @DisplayName("Convert from list of Employee entities to list of Employee DTOs")
    void testMappingMany() {

        List<Employee> employees = Arrays.asList(
                createEmployee("John", "Doe", 15, 11, 1985, 1000),
                createEmployee("Jane", "Doe", 15, 10, 1985, 1500)
        );

        List<EmployeeDto> employeeDtos = EmployeeMapper.INSTANCE.toDto(employees);
        assertThat(employeeDtos).isNotNull();
        assertThat(employeeDtos.size()).isEqualTo(2);

    }

}
