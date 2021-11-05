package pro.sky.java.course2.lesson5.lesson5employeebook.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.lesson5.lesson5employeebook.Employee;
import pro.sky.java.course2.lesson5.lesson5employeebook.exceptions.EmployeeNotFoundException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employees.put(firstName + " " + lastName, employee);
        if (employees.containsKey(firstName + " " + lastName)) {
            return employee;
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(firstName + " " + lastName)) {
            employees.remove(firstName + " " + lastName);
            return employee;
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(firstName + " " + lastName)) {
            return employee;
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Map<String, Employee> withdrawAllEmployees() {
        return Collections.unmodifiableMap(employees);
    }
}
