package com.assignment.org.service;


import com.assignment.org.entity.Employee2;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;

@Service
public class Emp2Service {

    private static List<Employee2> empList;

    static{
        empList=Arrays.asList(new Employee2("Ujjwal",10001l,"password12"),
                new Employee2("Khushal",10002l,"Password13"),
                new Employee2("Swaggy",10003l,"Pas@13"));
    }

    public List<Employee2> getAll(){
        return empList;
    }
    public void addOne(Employee2 e){
        empList.add(e);
    }
    public void delOne(long id){
        empList.removeIf(e->e.getId()==id);
    }

    public Employee2 findOne(long id){
        return empList.stream().filter(e->e.getId()==id).findFirst().get();
    }

}
