package pro.sky.java.course2.lesson7.controller;

import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.lesson7.Employee;
import pro.sky.java.course2.lesson7.departmentservice.EmployeeDepartmentService;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee findEmpWithMaxSalary(@RequestParam int department) {
        return departmentService.findEmpWithMaxSalary(department);
    }

    @GetMapping("//min-salary")
    public Employee findEmpWithMinSalary(@RequestParam int department) {
        return departmentService.findEmpWithMinSalary(department);
    }

    @GetMapping("/all")
    public List<Employee> showEmps(@Nullable Integer department) {
        return departmentService.outputEmployees(department);
    }
}
