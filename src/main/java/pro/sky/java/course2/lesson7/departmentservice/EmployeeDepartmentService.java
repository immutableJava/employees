package pro.sky.java.course2.lesson7.departmentservice;


import pro.sky.java.course2.lesson7.Employee;

import java.util.List;

public interface EmployeeDepartmentService {
    Employee findEmpWithMaxSalary(int department);

    Employee findEmpWithMinSalary(int department);

    List<Employee> outputEmployees(Integer department);
}
