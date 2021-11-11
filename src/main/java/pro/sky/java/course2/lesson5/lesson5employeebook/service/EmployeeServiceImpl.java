package pro.sky.java.course2.lesson5.lesson5employeebook.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.lesson5.lesson5employeebook.Employee;
import pro.sky.java.course2.lesson5.lesson5employeebook.exceptions.EmployeeNotFoundException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employees.put(firstName + " " + lastName, employee);
        return employee;
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) {
        if (employees.containsKey(firstName + " " + lastName)) {
            employees.remove(firstName + " " + lastName);
            return employees.remove(firstName + " " + lastName);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        if (employees.containsKey(firstName + " " + lastName)) {
            return employees.get(firstName + " " + lastName);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public List<Employee> withdrawAllEmployees() {
        List<Employee> employeeList = new ArrayList<>(employees.values());
        return Collections.unmodifiableList(employeeList);
    }
}
