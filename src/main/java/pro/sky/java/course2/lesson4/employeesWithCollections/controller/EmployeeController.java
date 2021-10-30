package pro.sky.java.course2.lesson4.employeesWithCollections.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.lesson4.employeesWithCollections.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String showInfoAboutAddEmp(@RequestParam String firstName, @RequestParam String lastName) {
        employeeService.addEmployee(firstName, lastName);
        return String.format("Сотрудник %s %s успешно создан.", firstName, lastName);
    }

    @GetMapping("/delete")
    public String showInfoAboutDeleteEmp(@RequestParam String firstName, @RequestParam String lastName) {
        employeeService.deleteEmployee(firstName, lastName);
        return String.format("Сотрудник %s %s удален.", firstName, lastName);
    }

    @GetMapping("/find")
    public String showInfoAboutFindEmp(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName).toString();
    }

    @GetMapping("/withdraw")
    public String showInfoAboutFindEmp() {
        return employeeService.withdrawAllEmployees().toString();
    }
}
