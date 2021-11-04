package pro.sky.java.course2.lesson4.lesson4employees.service;


import pro.sky.java.course2.lesson4.lesson4employees.Employee;

import java.util.Set;


public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee deleteEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Set<Employee> withdrawAllEmployees();
}
