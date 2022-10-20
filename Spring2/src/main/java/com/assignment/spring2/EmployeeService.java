package com.assignment.spring2;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeService {

    private static List<Employee> empList=new ArrayList<>();

    public List<Employee> findAll(){
        return List.copyOf(empList);
    }

    public Employee findOne(int id){
        return empList.stream().filter(e->e.getId()==id).findFirst().orElse(null);
    }
    public Employee addOne(Employee employee){
        empList.add(employee);
        return employee;
    }
    public void remOne(int id){

        empList.removeIf(e->e.getId()==id);
    }

}
