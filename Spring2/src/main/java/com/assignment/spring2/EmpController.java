package com.assignment.spring2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class EmpController {

    private EmployeeService empService=new EmployeeService();

    public EmpController(EmployeeService empService) {
        this.empService = empService;
    }

    @GetMapping("/spring")
    public String say(){
        return "Welcome to spring boot";
    }

    @GetMapping("/emp")
    public List<Employee> getAll(){
        return List.copyOf(empService.findAll());
    }

    @GetMapping("/emp/{id}")
    public Employee getOne(@PathVariable int id){

        Employee e1=empService.findOne(id);
        if(e1==null){
            throw new EmployeeNotFoundException("id: "+id);
        }
        return e1;
    }

    @PostMapping("/emp")
    public ResponseEntity<Employee> putOne(@Valid @RequestBody Employee employee){
        empService.addOne(employee);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId())
                 .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/emp/{id}")
    public void delOne(@PathVariable int id){
        empService.remOne(id);
    }
}
