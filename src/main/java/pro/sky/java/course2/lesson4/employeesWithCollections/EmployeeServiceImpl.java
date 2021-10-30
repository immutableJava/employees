package pro.sky.java.course2.lesson4.employeesWithCollections;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.lesson4.employeesWithCollections.exceptions.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>();

    @Override
    public void addEmployee(String firstName, String lastName) {
        employees.add(new Employee(firstName, lastName));
    }

    @Override
    public void deleteEmployee(String firstName, String lastName) {
        boolean isNotExists = true;
        for (Employee currentEmployee : employees) {
            if (currentEmployee.getFirstName().equals(firstName) && currentEmployee.getLastName().equals(lastName)) {
                employees.remove(currentEmployee);
                isNotExists = false;
                break;
            }
        }
        if (isNotExists) {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public List<Employee> withdrawAllEmployees() {
        return employees;
    }
}
