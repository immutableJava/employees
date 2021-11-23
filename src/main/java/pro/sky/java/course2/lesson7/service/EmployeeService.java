package pro.sky.java.course2.lesson7.service;


import org.springframework.stereotype.Service;
import pro.sky.java.course2.lesson7.Employee;

@Service
public interface EmployeeService {
    Employee addEmployee(String fullName, double salary, int department);

    Employee deleteEmployee(String fullName);

    Employee findEmployee(String fullName);

}
