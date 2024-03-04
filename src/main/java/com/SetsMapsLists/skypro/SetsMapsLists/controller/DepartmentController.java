package com.SetsMapsLists.skypro.SetsMapsLists.controller;

import com.SetsMapsLists.skypro.SetsMapsLists.model.Employee;
import com.SetsMapsLists.skypro.SetsMapsLists.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Comparator;





        import com.SetsMapsLists.skypro.SetsMapsLists.model.Employee;
        import com.SetsMapsLists.skypro.SetsMapsLists.service.EmployeeService;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.RestController;

        import javax.swing.*;
        import java.util.Collection;
        import java.util.Comparator;

@RestController
@RequestMapping("/departments")

public class DepartmentController {

    private final EmployeeService service;

    public DepartmentController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/max-salary")
    public String maxSalaryPerDepartment(@RequestParam("dep") int dep) {
        return String.valueOf(service.maxSalaryPerDepartment(dep));

    }

    @GetMapping("/min-salary")
    public String minSalaryPerDepartment(@RequestParam("dep") int dep) {
        return String.valueOf(service.minSalaryPerDepartment(dep));

    }

    @GetMapping("/all")
    public Collection<Employee> findAllDepartment() {
        return service.findAll().stream()
                .sorted(Comparator.comparingInt(Employee::getDepartment))
                .toList();
    }

    @GetMapping("/dep")
    public Collection<Employee> findAllPerDepartment(@RequestParam("dep") int dep) {
        return service.findAll().stream()
                .filter(e -> e.getDepartment() == dep)
                .toList();
    }

}
