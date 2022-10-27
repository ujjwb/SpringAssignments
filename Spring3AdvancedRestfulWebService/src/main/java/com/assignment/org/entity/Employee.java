package com.assignment.org.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Employee {
    private String Name;
    private Long id;
    @JsonIgnore
    private String password;

    public Employee(String name, Long id, String password) {
        Name = name;
        this.id = id;
        this.password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                '}';
    }
}
