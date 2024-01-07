package com.SetsMapsLists.skypro.SetsMapsLists.controller;

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
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstname") String firstName,
                                @RequestParam("lastname") String lastName,
                                @RequestParam("dep") int department,
                                @RequestParam("salary") int salary) {
        return service.add(firstName, lastName, department, salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstname") String firstName,
                                   @RequestParam("lastname") String lastName,
                                   @RequestParam("dep") int department,
                                   @RequestParam("salary") int salary) {
        return service.remove(firstName, lastName, department, salary);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstname") String firstName,
                                 @RequestParam("lastname") String lastName,
                                 @RequestParam("dep") int department,
                                 @RequestParam("salary") int salary) {
        return service.find(firstName, lastName, department, salary);
    }

    @GetMapping("/findall")
    public Collection<Employee> findAll() {
        return service.findAll();
    }

    @GetMapping("/departments/max-salary")
    public String maxSalaryPerDepartment(@RequestParam("dep") int dep) {
        return String.valueOf(service.maxSalaryPerDepartment(dep));

    }

    @GetMapping("/departments/min-salary")
    public String minSalaryPerDepartment(@RequestParam("dep") int dep) {
        return String.valueOf(service.minSalaryPerDepartment(dep));

    }

    @GetMapping("/departments/all")
    public Collection<Employee> findAllDepartment() {
        return service.findAll().stream()
                .sorted(Comparator.comparingInt(Employee::getDepartment))
                .toList();
    }

    @GetMapping("/departments/dep")
    public Collection<Employee> findAllPerDepartment(@RequestParam("dep") int dep) {
        return service.findAll().stream()
                .filter(e -> e.getDepartment() == dep)
                .toList();
    }

}
