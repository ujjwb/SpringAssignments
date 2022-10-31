package com.assignment.org.controller;

import com.assignment.org.entity.Employee;
import com.assignment.org.entity.Employee2;
import com.assignment.org.service.Emp2Service;
import com.assignment.org.service.EmpService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind. annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class EmpController {
    @Autowired
    EmpService empService;
    @Autowired
    Emp2Service emp2Service;
    @ApiOperation("Show All Employees with Static Filtering")
    @GetMapping("/emps/s")
    public List<Employee> showEmpsStatic(){
        return empService.getAll();
    }
    @ApiOperation("Show All Employees with Dynamic Filtering")
    @GetMapping("/emps/d")
    public MappingJacksonValue showEmpsDynamic(){

        MappingJacksonValue mappingjacksonvalue=new MappingJacksonValue(emp2Service.getAll());
        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.serializeAllExcept("password");

        FilterProvider filters=new SimpleFilterProvider().addFilter("Filter",filter);

        mappingjacksonvalue.setFilters(filters);

        return mappingjacksonvalue;
    }
    @ApiOperation("Show All Employees")
    @GetMapping("/emps")
    public List<Employee2> showAllEmps2(){
        return emp2Service.getAll();
    }


}
