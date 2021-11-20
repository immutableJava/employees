package pro.sky.java.course2.lesson6.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.lesson6.Employee;
import pro.sky.java.course2.lesson6.exceptions.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee addEmployee(String fullName, double salary, int department) {
        Employee employee = new Employee(fullName, salary, department);
        employees.put(fullName, employee);
        if (employees.get(fullName).equals(employee))
            return employee;
        else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee deleteEmployee(String fullName) {
        if (employees.containsKey(fullName)) {
            return employees.remove(fullName);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee findEmployee(String fullName) {
        if (employees.containsKey(fullName)) {
            return employees.get(fullName);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    public List<Employee> withdrawAllEmployees() {
        return new ArrayList<>(employees.values());
    }
}
