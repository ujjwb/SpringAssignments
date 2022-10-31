package com.assignment.org.entity;

public class AdvUser {
    private String name;
    private int age;
    private String city;
    private String deviceName;
    private int onlinetimeInHours;

    public AdvUser(String name, int age, String city, String deviceName, int onlinetimeInHours) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.deviceName = deviceName;
        this.onlinetimeInHours = onlinetimeInHours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getOnlinetimeInHours() {
        return onlinetimeInHours;
    }

    public void setOnlinetimeInHours(int onlinetimeInHours) {
        this.onlinetimeInHours = onlinetimeInHours;
    }

    @Override
    public String toString() {
        return "AdvUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", onlinetimeInHours=" + onlinetimeInHours +
                '}';
    }
}
