package pro.sky.java.course2.lesson6.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.lesson6.Employee;
import pro.sky.java.course2.lesson6.exceptions.EmployeeNotFoundException;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee addEmployee(String fullName, double salary, int department) {
        Employee employee = new Employee(fullName, salary, department);
        employees.put(fullName, employee);
        return employee;
    }

    @Override
    public Employee deleteEmployee(String fullName) {
        if (employees.containsKey(fullName)) {
            employees.remove(fullName);
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

    public Employee findEmpWithMinSalaryInCurrentDepartment(int department) {
        return employees.values()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .get();
    }

    public Employee findEmpWithMaxSalaryInCurrentDepartment(int department) {
        return employees.values()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .get();
    }

    public List<Employee> outputEmployees(Integer department) {
        Stream<Employee> employeeStream = employees.values().stream();
        if (department != null) {
            employeeStream = employeeStream.filter(employee -> employee.getDepartment() == department);
        }
        return employeeStream.sorted(Comparator.comparing(Employee::getDepartment)
                .thenComparing(Employee::getFullName)).collect(Collectors.toList());
    }
}
