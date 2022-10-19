package com.assignment.spring2;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeService {

    private static List<Employee> empList=new ArrayList<>();

    @GetMapping("/emp")
    public List<Employee> findAll(){
        return List.copyOf(empList);
    }

}
