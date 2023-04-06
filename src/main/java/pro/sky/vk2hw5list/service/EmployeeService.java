package pro.sky.vk2hw5list.service;

import pro.sky.vk2hw5list.exception.EmployeeAlreadyAddedException;
import pro.sky.vk2hw5list.exception.EmployeeNotFoundException;
import pro.sky.vk2hw5list.exception.EmployeeStorageIsFullException;
import pro.sky.vk2hw5list.model.Employee;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeService {
    private static final int SIZE = 3;

    private final List<Employee> employees = new ArrayList<>(SIZE);

    @PostConstruct
    public void init(){
        employees.add(new Employee("Вася", "Петров"));
        employees.add(new Employee("Иван", "Иванов"));
    }

    public Employee add(String name, String lastName){
        Employee employee = new Employee(name, lastName);
        if(employees.size() < SIZE){
            for(Employee emp : employees){
                if(emp.equals(employee)){
                    try {
                        throw new EmployeeAlreadyAddedException();
                    } catch (EmployeeAlreadyAddedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            employees.add(employee);
            return employee;
        }
        try {
            throw new EmployeeStorageIsFullException();
        } catch (EmployeeStorageIsFullException e) {
            throw new RuntimeException(e);
        }

    }


    public Employee find(String name, String lastName)  {
        Employee employee = new Employee(name, lastName);
        if(employees.contains(employee)){
                return employee;
            }
        try {
            throw new EmployeeNotFoundException();
        } catch (EmployeeNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Employee remove(String name, String lastName)  {
        Employee employee = new Employee(name, lastName);
        if(employees.remove(employee)){
            return employee;
        }
        try {
            throw new EmployeeNotFoundException();
        } catch (EmployeeNotFoundException e) {
            throw new RuntimeException(e);
        }
       //public List <Employee> list() {
           // return (Employee) Collections.unmodifiableList(employees);
       // }
    }
}

