package com.assignment.org.service;

import com.assignment.org.entity.AdvUser;
import com.assignment.org.entity.Employee;
import com.assignment.org.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdvUserService {

    private static List<AdvUser> userList=new ArrayList<>();
    static{
        userList.add(new AdvUser("Ujjwal",21,"Delhi","RedmiNote5",5));
        userList.add(new AdvUser("Anubhav",32,"Meerut","Iphone12",6));
        userList.add(new AdvUser("Sejal",27,"Hansi","LenovoThinkpad",8));
    }

    public List<AdvUser> getUserList() {
        return List.copyOf(userList);
    }

    public void addOne(AdvUser user){
        userList.add(user);
    }
    public void delOne(String name){
        userList.removeIf(e->e.getName().equals(name));
    }
    public AdvUser findOne(String name){
        return userList.stream().filter(e->e.getName().equals(name)).findFirst().get();
    }
}
