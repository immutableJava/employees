package pro.sky.java.course2.lesson4.lesson4employees.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.lesson4.lesson4employees.Employee;
import pro.sky.java.course2.lesson4.lesson4employees.exceptions.EmployeeNotFoundException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Set<Employee> employees = new HashSet<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employees.add(employee);
        if (employees.contains(employee)) {
            return employee;
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Set<Employee> withdrawAllEmployees() {
        return Collections.unmodifiableSet(employees);
    }
}
