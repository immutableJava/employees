package pro.sky.java.course2.lesson4.employeesWithCollections;


import java.util.List;


public interface EmployeeService {
    void addEmployee(String firstName, String lastName);

    void deleteEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    List<Employee> withdrawAllEmployees();
}
