package com.assignment.spring2;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeService {

    private static List<Employee> empList=new ArrayList<>();

    static{
        empList.add(new Employee(1,"Ramesh",25));
        empList.add(new Employee(2,"Ashish",27));
        empList.add(new Employee(3,"Anubhav",32));
        empList.add(new Employee(4,"Dave",40));
    }

    public List<Employee> findAll(){
        return List.copyOf(empList);
    }

    public Employee findOne(int id){
        for(Employee i:empList){
            if(i.getId()==id){
                return i;
            }
        }
        return null;
    }
    public Employee addOne(Employee employee){
        empList.add(employee);
        return employee;
    }
    public boolean remOne(int id){
        Employee e=findOne(id);
        if(e==null){
            throw new EmployeeNotFoundException("Employee not found");
        }
        empList.remove(e);
        return true;
    }

    public boolean update(Employee e1){
        //empList.stream().filter(e->e.getId()==e1.getId()).
        for(Employee e:empList){
            if(e.getId()==e1.getId()){
                e.setName(e1.getName());
                e.setAge(e1.getAge());
                return true;
            }
        }
        return false;
    }

}
