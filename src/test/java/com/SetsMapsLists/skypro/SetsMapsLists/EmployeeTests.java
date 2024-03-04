package com.SetsMapsLists.skypro.SetsMapsLists;

import com.SetsMapsLists.skypro.SetsMapsLists.model.Employee;
import com.SetsMapsLists.skypro.SetsMapsLists.service.EmployeeService;
import com.SetsMapsLists.skypro.SetsMapsLists.EmployeeTestCostantes.*;
import com.SetsMapsLists.skypro.SetsMapsLists.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;

import javax.naming.Name;

import static com.SetsMapsLists.skypro.SetsMapsLists.EmployeeTestCostantes.*;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTests {

    private final EmployeeService service = new EmployeeServiceImpl();


    @Test
    public void addTest() {
        service.add(NAME1, LASTNAME1, DEP1, SALARY_MIN);
        assertEquals(1, service.size() );
        Employee employee = new Employee(NAME1, LASTNAME1, DEP1, SALARY_MIN);
        assertEquals(service.find(NAME1, LASTNAME1, DEP1, SALARY_MIN), employee);
    }

    @Test
    public void removeTest() {
        service.add(NAME2, LASTNAME2, DEP2, SALARY_MAX);
        assertEquals(1, service.findAll().size());
        service.remove(NAME2, LASTNAME2, DEP2, SALARY_MAX);
        assertTrue(service.findAll().isEmpty());
    }

    @Test
    public void findTest() {
        service.add(NAME2, LASTNAME2, DEP2, SALARY_MAX);
        assertEquals(1, service.findAll().size());
        Employee employee = new Employee(NAME2, LASTNAME2, DEP2, SALARY_MAX);
        assertEquals(employee, service.find(NAME2, LASTNAME2, DEP2, SALARY_MAX));
    }



}
