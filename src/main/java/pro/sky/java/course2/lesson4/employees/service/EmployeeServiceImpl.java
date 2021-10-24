package pro.sky.java.course2.lesson4.employees.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.lesson4.employees.Employee;
import pro.sky.java.course2.lesson4.employees.exceptions.EmployeeArrayIsFilledException;
import pro.sky.java.course2.lesson4.employees.exceptions.EmployeeNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Employee[] employees = new Employee[10];

    @Override
    public void addEmployee(String firstName, String lastName) {
        boolean flag = true;
        for (int i = 0; i < employees.length; i++) {
            if(employees[i] == null){
                employees[i] = new Employee(firstName,lastName);
                flag = false;
                break;
            }
        }
        if (flag) {
            throw new EmployeeArrayIsFilledException();
        }
    }

    @Override
    public void deleteEmployee(String firstName, String lastName) {
        boolean flag = true;
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                employee = null;
                flag = false;
            }
        }
        if(flag) {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }
}
