package pro.sky.java.course2.lesson6.departmentservice;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.lesson6.Employee;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeDepartmentServiceImpl implements EmployeeDepartmentService {
    Map<String, Employee> employees = new HashMap<>();

    public Employee findEmpWithMinSalaryInCurrentDepartment(int department) {
        return employees.values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .get();
    }

    public Employee findEmpWithMaxSalaryInCurrentDepartment(int department) {
        return employees.values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .get();
    }

    public List<Employee> getEmployeesByDepartment(Integer department) {
        Stream<Employee> employeeStream = employees.values().stream();
        if (department != null) {
            employeeStream = employeeStream.filter(employee -> employee.getDepartment() == department);
        }
        return employeeStream.sorted(Comparator.comparing(Employee::getDepartment)
                .thenComparing(Employee::getFullName))
                .collect(Collectors.toList());
    }
}
