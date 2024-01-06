package com.SetsMapsLists.skypro.SetsMapsLists.service;

import com.SetsMapsLists.skypro.SetsMapsLists.exception.EmployeeAreadyAddedException;
import com.SetsMapsLists.skypro.SetsMapsLists.exception.EmployeeNotFoundException;
import com.SetsMapsLists.skypro.SetsMapsLists.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employeeList;

    public EmployeeServiceImpl() {
        this.employeeList = new ArrayList<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            System.out.println(employeeList.contains(employee));
            throw new EmployeeAreadyAddedException();
        }

        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employeeList); //Чтобы не могли поменять. Эта копия будет неизменяемая. Можно ещё return new ArrayList<>(employeeList); - передача копии

    }
}
