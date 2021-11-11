package pro.sky.java.course2.lesson5.lesson5employeebook.service;


import pro.sky.java.course2.lesson5.lesson5employeebook.Employee;

import java.util.List;


public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee deleteEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    List<Employee> withdrawAllEmployees();
}
