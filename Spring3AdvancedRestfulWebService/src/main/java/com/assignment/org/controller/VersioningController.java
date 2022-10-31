package com.assignment.org.controller;

import com.assignment.org.entity.*;
import com.assignment.org.service.AdvUserService;
import com.assignment.org.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VersioningController {

    @Autowired
    UserService userService;

    @Autowired
    AdvUserService advUserService;

    @GetMapping("/v1/versioning")
    public List<User> showUsers1(){
        return userService.getUserList();
    }
    @GetMapping("/v2/versioning")
    public List<AdvUser> showUser2(){
        return advUserService.getUserList();
    }
    @GetMapping(path="/versioning",params="version=1")
    public List<User> showUser3(){
        return userService.getUserList();
    }

    @GetMapping(path="/versioning",params="version=2")
    public List<AdvUser> showUser4(){
        return advUserService.getUserList();
    }

    @GetMapping(path="/versioning",headers="X-API-Version=1")
    public List<User> showUser5(){
        return userService.getUserList();
    }

    @GetMapping(path="/versioning",headers="X-API-Version=2")
    public List<AdvUser> showUser6(){
        return advUserService.getUserList();
    }

    @GetMapping(path="/versioning",produces="application/v1+json")
    public List<User> showUser7(){
        return userService.getUserList();
    }
    @GetMapping(path="/versioning",produces="application/v2+json")
    public List<AdvUser> showUser8(){
        return advUserService.getUserList();
    }

}
