package com.assignment.Spring1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Guitar implements Instrument {
    public void play(){
        System.out.println("Guitar is being played....");
    }
}
