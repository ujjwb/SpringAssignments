package com.assignment.org.controller;

import com.assignment.org.entity.Employee;
import com.assignment.org.service.Emp2Service;
import com.assignment.org.service.EmpService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class EmpController {
    @Autowired
    EmpService empService;
    @Autowired
    Emp2Service emp2Service;
    @GetMapping("/emps/s")
    public List<Employee> showEmpsStatic(){
        return empService.getAll();
    }
    @GetMapping("/emps/d")
    public MappingJacksonValue showEmpsDynamic(){

        MappingJacksonValue mappingjacksonvalue=new MappingJacksonValue(emp2Service.getAll());
        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("password","id");

        FilterProvider filters=new SimpleFilterProvider().addFilter("NewBeanFilter",filter);

        return mappingjacksonvalue;
    }


}
