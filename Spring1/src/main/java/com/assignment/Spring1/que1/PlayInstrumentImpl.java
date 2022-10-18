package com.assignment.Spring1.que1;


import com.assignment.Spring1.que2.Bongos;

public class PlayInstrumentImpl {


    public void playInstrument(){

        System.out.println("Instrument will start playing.");

        Guitar guitar=new Guitar();


        guitar.play();


        System.out.println("Instrument is done playing.");
    }
}
