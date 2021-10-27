package pro.sky.java.course2.lesson4.employees.service;


import pro.sky.java.course2.lesson4.employees.Employee;


public interface EmployeeService {
    void addEmployee(String firstName, String lastName);

    void deleteCurrentEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);
}
