package pro.sky.java.course2.lesson7.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.lesson7.Employee;
import pro.sky.java.course2.lesson7.exceptions.EmployeeNotFoundException;
import pro.sky.java.course2.lesson7.exceptions.WrongFullNameException;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee addEmployee(String fullName, double salary, int department) {
        String[] splattedFullName = StringUtils.split(fullName);
        for (String current : splattedFullName) {
            if (!StringUtils.isAlpha(current) && StringUtils.isAllUpperCase(current.substring(0, 1))) {
                throw new WrongFullNameException();
            }
        }
        Employee employee = new Employee(fullName, salary, department);
        employees.put(fullName, employee);
        return employee;
    }

    @Override
    public Employee deleteEmployee(String fullName) {
        if (employees.containsKey(fullName)) {
            return employees.remove(fullName);
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String fullName) {
        String[] splattedFullName = StringUtils.split(fullName);
        int counter = 0;
        for (String current : splattedFullName) {
            if (StringUtils.isAlpha(current)) {
                counter++;
            }
        }
        if (employees.containsKey(fullName) && counter == 2) {
            return employees.get(fullName);
        }
        throw new EmployeeNotFoundException();
    }
}
