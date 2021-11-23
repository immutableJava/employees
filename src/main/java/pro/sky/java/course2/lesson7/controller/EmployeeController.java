package pro.sky.java.course2.lesson7.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.lesson7.Employee;
import pro.sky.java.course2.lesson7.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmp(@RequestParam String fullName, @RequestParam double salary, @RequestParam int department) {
        return employeeService.addEmployee(fullName, salary, department);
    }

    @GetMapping("/delete")
    public Employee deleteEmp(@RequestParam String fullName) {
        return employeeService.deleteEmployee(fullName);
    }

    @GetMapping("/find")
    public Employee findEmp(@RequestParam String fullName) {
        return employeeService.findEmployee(fullName);
    }
}
