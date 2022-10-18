package com.assignment.Spring1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Spring1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext=SpringApplication.run(Spring1Application.class,args);
		PlayInstrumentImpl playInstrument=applicationContext.getBean(PlayInstrumentImpl.class);
		System.out.println("\nBean: "+ playInstrument.getInstrument());
		playInstrument.playInstrument();
	}

}
