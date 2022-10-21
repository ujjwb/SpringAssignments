package com.assignment.org;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
public class NewController {

    private MessageSource messageSource;
    private UserService userService=new UserService();

    @GetMapping("/hello")
    public String saySomething(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
    }

    @GetMapping("/hello/{username}")
    public String saySomething(@PathVariable String username){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("hello.message "+username, null,"Default Message",locale);
    }

    @PostMapping("/users")
    public void postXml(@RequestBody User user){
        userService.addOne(user);
    }

    @GetMapping("/users")
    public List<User> getXml(){
        return userService.getUserList();
    }

    @DeleteMapping("/users/{variable}")
    public void delOne(@PathVariable String name){
        userService.delOne(name);
    }


}
