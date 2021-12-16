package pro.sky.java.course2.lesson7.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.lesson7.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee findEmpWithMinSalary(int department) {
        return employees.values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .get();
    }

    public Employee findEmpWithMaxSalary(int department) {
        return employees.values().stream()
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
                .thenComparing(Employee::getFullName))
                .collect(Collectors.toList());
    }
}
