package com.assignment.Spring1;

import org.springframework.stereotype.Component;

@Component
public class Bongos implements Instrument {
    public void play(){
        System.out.println("Bongos are being played.....");
    }
}
