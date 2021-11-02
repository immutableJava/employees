package pro.sky.java.course2.lesson4.employeesWithCollections.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.lesson4.employeesWithCollections.Employee;
import pro.sky.java.course2.lesson4.employeesWithCollections.service.EmployeeService;

import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String addEmp(@RequestParam String firstName, @RequestParam String lastName) {
        if (new Employee(firstName, lastName).equals(employeeService.addEmployee(firstName, lastName))) {
            return String.format("Сотрудник %s %s успешно добавлен.", firstName, lastName);
        }

        return String.format("Возникла ошибка! Сотрудник %s %s не был добавлен.", firstName, lastName);
    }

    @GetMapping("/delete")
    public String deleteEmp(@RequestParam String firstName, @RequestParam String lastName) {
        if (new Employee(firstName, lastName).equals(employeeService.deleteEmployee(firstName, lastName))) {
            return String.format("Сотрудник %s %s успешно удален.", firstName, lastName);
        }

        return String.format("Возникла ошибка! Сотрудник %s %s не был удален.", firstName, lastName);
    }

    @GetMapping("/find")
    public String findEmp(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName).toString();
    }

    @GetMapping("/withdraw")
    public Set<Employee> showInfoAboutFindEmp() {
        return employeeService.withdrawAllEmployees();
    }
}
