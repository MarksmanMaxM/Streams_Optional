package com.SetsMapsLists.skypro.SetsMapsLists.service;

import com.SetsMapsLists.skypro.SetsMapsLists.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName);
    Employee remove(String firstName, String lastName);
    Employee find(String firstName, String lastName);


    Collection<Employee> findAll();
}
