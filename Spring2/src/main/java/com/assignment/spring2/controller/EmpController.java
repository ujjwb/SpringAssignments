package com.assignment.spring2.controller;


import com.assignment.spring2.entity.Employee;
import com.assignment.spring2.exception.EmployeeNotFoundException;
import com.assignment.spring2.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmpController {
    private EmployeeService empService;

    public EmpController(EmployeeService empService) {
        this.empService = empService;
    }

    @GetMapping("/spring")
    public String say() {
        return "Welcome to spring boot";
    }

    @GetMapping("/emps")
    public List<Employee> getAll() {
        return List.copyOf(empService.findAll());
    }

    @GetMapping("/emps/{id}")
    public Employee getOne(@PathVariable int id) {

        Employee e1 = empService.findOne(id);
        if (e1 == null) {
            throw new EmployeeNotFoundException("id: " + id);
        }
        return e1;
    }

    @PostMapping("/emps")
    public void postOne(@Valid @RequestBody Employee employee) {
        empService.addOne(employee);
    }

    @DeleteMapping("/emps/{id}")
    public void delOne(@PathVariable int id) {

        if (!empService.remOne(id)) {
            throw new EmployeeNotFoundException("id: " + id);
        }
    }

    @PutMapping("/emps")
    public void putOne(@Valid @RequestBody Employee employee) {
        if (!empService.update(employee)) {
            throw new EmployeeNotFoundException("id: " + employee.getId());
        }
    }
}
