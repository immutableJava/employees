package pro.sky.java.course2.lesson7.service;


import pro.sky.java.course2.lesson7.Employee;

import java.util.List;

public interface DepartmentService {
    Employee findEmpWithMaxSalary(int department);

    Employee findEmpWithMinSalary(int department);

    List<Employee> outputEmployees(Integer department);
}
