package pro.sky.java.course2.lesson7.employees;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.lesson7.Employee;
import pro.sky.java.course2.lesson7.service.DepartmentServiceImpl;
import pro.sky.java.course2.lesson7.service.EmployeeService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static pro.sky.java.course2.lesson7.employees.constant.EmployeeServiceConstant.EMPLOYEE_1_DEP;
import static pro.sky.java.course2.lesson7.employees.constant.EmployeeServiceConstant.EMPLOYEE_LIST;

@ExtendWith(MockitoExtension.class)
public class EmployeeDepartmentServiceTest {
    @Mock
    EmployeeService employeeService;

    @InjectMocks
    DepartmentServiceImpl sut;

    @Test
    public void shouldReturnEmptyListByIncorrectDepartment() {
        when(employeeService.getAll()) // когда производится вызов метода getAll внутри DepartmentService.outputEmployees
                .thenReturn(EMPLOYEE_LIST); // верни EMPLOYEE_LIST из трех сотрудников (1, 2 и 3 отделы)

        assertTrue(sut.outputEmployees(4).isEmpty()); // Проверить, что результат вызова outputEmployees по 4 отделу возвращает пустой список
    }

    @Test
    public void shouldReturnOneEmployeeByCorrectDepartment() {
        when(employeeService.getAll()) // когда производится вызов метода getAll внутри DepartmentService.outputEmployees
                .thenReturn(EMPLOYEE_LIST); // верни EMPLOYEE_LIST из трех сотрудников (1, 2 и 3 отделы)

        List<Employee> result = sut.outputEmployees(1);
        assertFalse(result.isEmpty()); // Проверить, что результат вызова outputEmployees по 1 отделу не возвращает 0 сотрудников
        assertEquals(EMPLOYEE_1_DEP, result.get(0)); // Проверить, что результат содержит нужного работника
    }

    @Test
    public void shouldReturnAllEmpsIIfTheyArentNull() {
        when(employeeService.getAll())
                .thenReturn(EMPLOYEE_LIST);
        Employee firstDemp = sut.outputEmployees(1).get(0);
        Employee secondDemp = sut.outputEmployees(2).get(0);
        Employee thirdDemp = sut.outputEmployees(3).get(0);

        assertNotNull(firstDemp);
        assertNotNull(secondDemp);
        assertNotNull(thirdDemp);

        assertArrayEquals(EMPLOYEE_LIST.toArray(), List.of(firstDemp, secondDemp, thirdDemp).toArray());
    }
}
