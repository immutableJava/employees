package pro.sky.java.course2.lesson6.departmentservice;

import pro.sky.java.course2.lesson6.Employee;

import java.util.List;

public interface EmployeeDepartmentService {
    Employee findEmpWithMaxSalaryInCurrentDepartment(int department);

    Employee findEmpWithMinSalaryInCurrentDepartment(int department);

    List<Employee> getEmployeesByDepartment(Integer department);
}
