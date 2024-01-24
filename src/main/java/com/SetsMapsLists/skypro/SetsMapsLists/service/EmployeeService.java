package com.SetsMapsLists.skypro.SetsMapsLists.service;

import com.SetsMapsLists.skypro.SetsMapsLists.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName, int department, int salary);
    Employee remove(String firstName, String lastName, int department, int salary);
    Employee find(String firstName, String lastName, int department, int salary);

    int maxSalaryPerDepartment(int department);

    int minSalaryPerDepartment(int department);




    Collection<Employee> findAll();
}
