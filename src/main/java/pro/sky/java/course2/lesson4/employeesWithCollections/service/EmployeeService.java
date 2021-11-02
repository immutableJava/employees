package pro.sky.java.course2.lesson4.employeesWithCollections.service;


import pro.sky.java.course2.lesson4.employeesWithCollections.Employee;

import java.util.Set;


public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee deleteEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Set<Employee> withdrawAllEmployees();
}
