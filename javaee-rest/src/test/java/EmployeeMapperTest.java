import dev.vladflore.zerotohero.dto.EmployeeDto;
import dev.vladflore.zerotohero.entity.Address;
import dev.vladflore.zerotohero.entity.AddressFactory;
import dev.vladflore.zerotohero.entity.Employee;
import dev.vladflore.zerotohero.mapper.EmployeeMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static dev.vladflore.zerotohero.entity.EmployeeFactory.createEmployee;
import static dev.vladflore.zerotohero.mapper.EmployeeMapper.SPACE;
import static org.assertj.core.api.Assertions.assertThat;

class EmployeeMapperTest {

    @Test
    @DisplayName("Convert from Employee entity to Employee DTO")
    void testMappingOne() {

        Address address = AddressFactory.createAddress("Street", 15, "Location", "90443", "Germany");
        Employee employee = createEmployee("John", "Doe", 15, 11, 1985, 1000, address);

        EmployeeDto employeeDto = EmployeeMapper.INSTANCE.employeeToEmployeeDto(employee);

        assertThat(employeeDto.getFullName()).isEqualTo(employee.getFirstName() + SPACE + employee.getLastName());
        assertThat(employeeDto.getAge()).isEqualTo(33);
        assertThat(employeeDto.getSalary()).isEqualTo(employee.getSalary());

        assertThat(employeeDto.getAddress().getStreetAndNumber()).isEqualTo(address.getStreet() + SPACE + address.getNumber());
        assertThat(employeeDto.getAddress().getPlz()).isEqualTo(address.getPostalCode());
        assertThat(employeeDto.getAddress().getLocation()).isEqualTo(address.getLocation());
        assertThat(employeeDto.getAddress().getCountry()).isEqualTo(address.getCountry().toUpperCase());
        String initials = employee.getFirstName().charAt(0) + "" + employee.getLastName().charAt(0);
        assertThat(employeeDto.getInitials()).isEqualTo(initials.toUpperCase());
    }
}