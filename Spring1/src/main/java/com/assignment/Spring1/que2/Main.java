package com.assignment.Spring1.que2;


public class Main {
    public static void main(String[] args) {
        PlayInstrumentImpl play=new PlayInstrumentImpl(new Bongos());
        play.playInstrument();

        play=new PlayInstrumentImpl(new Guitar());
        play.playInstrument();
    }
}
