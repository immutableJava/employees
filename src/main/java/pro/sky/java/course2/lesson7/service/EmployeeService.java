package pro.sky.java.course2.lesson7.service;


import pro.sky.java.course2.lesson7.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String fullName, double salary, int department);

    Employee deleteEmployee(String fullName);

    Employee findEmployee(String fullName);

}
