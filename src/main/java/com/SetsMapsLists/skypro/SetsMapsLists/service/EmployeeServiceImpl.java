package com.SetsMapsLists.skypro.SetsMapsLists.service;

import com.SetsMapsLists.skypro.SetsMapsLists.exception.EmployeeAreadyAddedException;
import com.SetsMapsLists.skypro.SetsMapsLists.exception.EmployeeNotFoundException;
import com.SetsMapsLists.skypro.SetsMapsLists.exception.InvalidException;
import com.SetsMapsLists.skypro.SetsMapsLists.model.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employeeList;

    public EmployeeServiceImpl() {
        this.employeeList = new ArrayList<>();
    }

    @Override
    public Employee add(String firstName, String lastName, int department, int salary) {
        if (!checkFio(firstName, lastName)) {
            throw new InvalidException();
        }
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employeeList.contains(employee)) {
            System.out.println(employeeList.contains(employee));
            throw new EmployeeAreadyAddedException();
        }

        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName, int department, int salary) {
        if (!checkFio(firstName, lastName)) {
            throw new InvalidException();
        }
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName, int department, int salary) {
        if (!checkFio(firstName, lastName)) {
            throw new InvalidException();
        }
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employeeList.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public int maxSalaryPerDepartment(int department) {
        return employeeList.stream()
                .filter(e -> e.getDepartment() == department)
                .map(Employee::getSalary)
                .max(Comparator.comparingInt(e -> e.intValue()))
                .get();
    }

    @Override
    public int minSalaryPerDepartment(int department) {
        return employeeList.stream()
                .filter(e -> e.getDepartment() == department)
                .map(Employee::getSalary)
                .min(Comparator.comparingInt(e -> e.intValue()))
                .get();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employeeList); //Чтобы не могли поменять. Эта копия будет неизменяемая. Можно ещё return new ArrayList<>(employeeList); - передача копии

    }

    private boolean checkFio(String firstname, String lastname) {
        return StringUtils.isAlpha(firstname) && StringUtils.isAlpha(lastname);


    }
}
