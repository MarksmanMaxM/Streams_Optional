package com.SetsMapsLists.skypro.SetsMapsLists;

import com.SetsMapsLists.skypro.SetsMapsLists.model.Employee;
import com.SetsMapsLists.skypro.SetsMapsLists.service.EmployeeService;
import com.SetsMapsLists.skypro.SetsMapsLists.EmployeeTestCostantes.*;
import com.SetsMapsLists.skypro.SetsMapsLists.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import javax.naming.Name;

import static com.SetsMapsLists.skypro.SetsMapsLists.EmployeeTestCostantes.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentsTest {

    @Mock
    private Employee employee;

    @InjectMocks
    private EmployeeServiceImpl service;

    @Test
    public void maxSalaryPerDepartmentTest() {
        when(employee.getDepartment()).thenReturn(DEP1);
        service.add(NAME1, LASTNAME1, DEP1, SALARY_MAX);
        assertEquals(SALARY_MAX, service.maxSalaryPerDepartment(DEP1));

    }

    @Test
    public void minSalaryPerDepartmentTest() {
        when(employee.getDepartment()).thenReturn(DEP1);
        service.add(NAME1, LASTNAME1, DEP1, SALARY_MIN);
        assertEquals(SALARY_MIN, service.maxSalaryPerDepartment(DEP1));

    }



}
