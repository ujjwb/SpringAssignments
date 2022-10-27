package com.assignment.org.controller;


import com.assignment.org.entity.User;
import com.assignment.org.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Locale;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserService userService;



    @GetMapping("/hello")
    public String saySomething(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
    }

    @GetMapping("/hello/{username}")
    public String saySomething(@PathVariable String username){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("hello.message",null,"Default Hello "+username,locale)+username;
    }

    @PostMapping("/users")
    public void postXml(@RequestBody User user){
        userService.addOne(user);
    }

    @GetMapping("/users")
    public List<User> getXml(){
        return userService.getUserList();
    }

    @DeleteMapping("/users/{name}")
    public void delOne(@PathVariable String name){
        userService.delOne(name);
    }

    @GetMapping("/users/{name}")
    public EntityModel<User> findOne(@PathVariable String name){

        EntityModel<User> entityModel=EntityModel.of(userService.findOne(name));
        WebMvcLinkBuilder link= linkTo(methodOn(this.getClass()).getXml());
        entityModel.add(link.withRel(" "));
        return entityModel;
    }




}
