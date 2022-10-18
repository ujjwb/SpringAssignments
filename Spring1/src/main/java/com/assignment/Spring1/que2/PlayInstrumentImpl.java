package com.assignment.Spring1.que2;



public class PlayInstrumentImpl {

    private Instrument instrument;



    public PlayInstrumentImpl(Instrument instrument) {
        this.instrument = instrument;
    }

    public void playInstrument(){

        System.out.println("Instrument will start playing.");

        instrument.play();

        System.out.println("Instrument is done playing.");
    }
}
