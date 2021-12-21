package pro.sky.java.course2.lesson7.employees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.lesson7.Employee;
import pro.sky.java.course2.lesson7.service.EmployeeService;
import pro.sky.java.course2.lesson7.service.EmployeeServiceImpl;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeServiceTest {

    EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        employeeService = new EmployeeServiceImpl();
    }

    @Test
    public void shouldAddEmp() {
        Employee firstEmployee = employeeService.addEmployee("Tamerlan Radzhabov", 4000, 2);
        Employee secondEmployee = employeeService.findEmployee("Tamerlan Radzhabov");
        assertEquals(firstEmployee, secondEmployee);
    }

    @Test
    public void shouldThrowsExceptionIfEmpWasAdded() {
        employeeService.addEmployee("Tamerlan Radzhabov", 4000, 2);
        assertDoesNotThrow(() -> employeeService.findEmployee("Tamerlan Radzhabov"));
    }
}
