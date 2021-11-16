package pro.sky.java.course2.lesson6.controller;


import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.lesson6.Employee;
import pro.sky.java.course2.lesson6.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String addEmp(@RequestParam String fullName, @RequestParam double salary, @RequestParam int department) {
        Employee employee = employeeService.addEmployee(fullName, salary, department);
        if (employee.getFullName().equals(fullName)) {
            return String.format("Сотрудник %s успешно добавлен.", employee.getFullName());
        } else {
            return String.format("Возникла ошибка! Сотрудник %s не был добавлен.", fullName);
        }
    }

    @GetMapping("/delete")
    public String deleteEmp(@RequestParam String fullName) {
        Employee employee = employeeService.deleteEmployee(fullName);
        if (employee.getFullName().equals(fullName)) {
            return String.format("Сотрудник %s %s успешно удален.", employee.getFullName());
        } else {
            return String.format("Возникла ошибка! Сотрудник %s %s не был удален.", fullName);
        }
    }

    @GetMapping("/find")
    public String findEmp(@RequestParam String fullName) {
        return employeeService.findEmployee(fullName).toString();
    }

    @GetMapping("/department/max-salary")
    public Employee findEmpWithMaxSalaryInCurrentDepartment(@RequestParam int department) {
        return employeeService.findEmpWithMaxSalaryInCurrentDepartment(department);
    }

    @GetMapping("/department/min-salary")
    public Employee findEmpWithMinSalaryInCurrentDepartment(@RequestParam int department) {
        return employeeService.findEmpWithMinSalaryInCurrentDepartment(department);
    }

    @GetMapping("/department/all")
    public List<Employee> showEmps(@Nullable Integer department) {
        return employeeService.outputEmployees(department);
    }
}
