package pro.sky.java.course2.lesson6.service;


import pro.sky.java.course2.lesson6.Employee;

import java.util.List;


public interface EmployeeService {
    Employee addEmployee(String fullName, double salary, int department);

    Employee deleteEmployee(String fullName);

    Employee findEmployee(String fullName);

    Employee findEmpWithMaxSalaryInCurrentDepartment(int department);

    Employee findEmpWithMinSalaryInCurrentDepartment(int department);

    List<Employee> outputEmployees(Integer department);
}
