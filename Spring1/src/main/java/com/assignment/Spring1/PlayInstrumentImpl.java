package com.assignment.Spring1;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

@Component
public class PlayInstrumentImpl {
    @Autowired
    private Instrument instrument;

    public void playInstrument(){

        System.out.println("Instrument will start playing.");

        instrument.play();

        System.out.println("Instrument is done playing.");
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }
}
