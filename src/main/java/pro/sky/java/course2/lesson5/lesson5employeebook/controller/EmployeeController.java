package pro.sky.java.course2.lesson5.lesson5employeebook.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.lesson5.lesson5employeebook.Employee;
import pro.sky.java.course2.lesson5.lesson5employeebook.service.EmployeeService;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String addEmp(@RequestParam String firstName, @RequestParam String lastName) {
        Employee employee = employeeService.addEmployee(firstName, lastName);
        if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
            return String.format("Сотрудник %s %s успешно добавлен.", employee.getFirstName(), employee.getLastName());
        } else {
            return String.format("Возникла ошибка! Сотрудник %s %s не был добавлен.", firstName, lastName);
        }
    }

    @GetMapping("/delete")
    public String deleteEmp(@RequestParam String firstName, @RequestParam String lastName) {
        Employee employee = employeeService.deleteEmployee(firstName, lastName);
        if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
            return String.format("Сотрудник %s %s успешно удален.", employee.getFirstName(), employee.getLastName());
        } else {
            return String.format("Возникла ошибка! Сотрудник %s %s не был удален.", firstName, lastName);
        }
    }

    @GetMapping("/find")
    public String findEmp(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName).toString();
    }

    @GetMapping("/withdraw")
    public Map<String, Employee> showInfoAboutFindEmp() {
        return employeeService.withdrawAllEmployees();
    }
}
