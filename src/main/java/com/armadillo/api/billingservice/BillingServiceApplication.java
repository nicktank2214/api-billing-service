package com.armadillo.api.billingservice;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@SpringBootApplication
public class BillingServiceApplication implements CommandLineRunner {


	private final Logger log = LoggerFactory.getLogger(this.getClass());
	


	public static void main(String[] args) {		
		SpringApplication.run(BillingServiceApplication.class, args);
	}




    



	@Override
	public void run(String... args) throws Exception {



		//TESTING SERVICES----------------------------------------------------------------------------->	
		//TESTING SERVICES----------------------------------------------------------------------------->


		LocalTime currentTime = new LocalTime();
		LocalDate currentDate = new LocalDate();
		
		log.info(
				"["+this.getClass().getName()+"] "+new java.util.Date()+
				" BillingServiceApplication - current local time is: " + currentDate+"T"+currentTime
				);


	}

}