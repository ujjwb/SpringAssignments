package com.assignment.org;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
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
        for(User user:userList){
            if(name.equals(user.getName())){
                userList.remove(user);
            }
        }
    }
}
