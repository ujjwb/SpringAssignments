package com.assignment.org.service;

import com.assignment.org.entity.Employee;
import com.assignment.org.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserService {

    private static List<User> userList=new ArrayList<>();
    static{
        userList.add(new User("Ujjwal",21,"Delhi"));
        userList.add(new User("Anubhav",32,"Meerut"));
        userList.add(new User("Sejal",27,"Hansi"));
    }

    public List<User> getUserList() {
        return List.copyOf(userList);
    }

    public void addOne(User user){
        userList.add(user);
    }
    public void delOne(String name){
        userList.removeIf(e->e.getName().equals(name));
    }
    public User findOne(String name){
        return userList.stream().filter(e->e.getName().equals(name)).findFirst().get();
    }
}
