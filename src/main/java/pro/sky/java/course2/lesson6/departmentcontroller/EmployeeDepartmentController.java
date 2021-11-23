package pro.sky.java.course2.lesson6.departmentcontroller;

import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.lesson6.Employee;
import pro.sky.java.course2.lesson6.departmentservice.EmployeeDepartmentService;

import java.util.List;

@RestController
@RequestMapping("/department")
public class EmployeeDepartmentController {
    private final EmployeeDepartmentService employeeDepartmentService;

    public EmployeeDepartmentController(EmployeeDepartmentService employeeDepartmentService) {
        this.employeeDepartmentService = employeeDepartmentService;
    }

    @GetMapping("/max-salary")
    public Employee findEmpWithMaxSalaryInCurrentDepartment(@RequestParam int department) {
        return employeeDepartmentService.findEmpWithMaxSalaryInCurrentDepartment(department);
    }

    @GetMapping("/min-salary")
    public Employee findEmpWithMinSalaryInCurrentDepartment(@RequestParam int department) {
        return employeeDepartmentService.findEmpWithMinSalaryInCurrentDepartment(department);
    }

    @GetMapping("/all")
    public List<Employee> showEmps(@Nullable Integer department) {
        return employeeDepartmentService.getEmployeesByDepartment(department);
    }
}
