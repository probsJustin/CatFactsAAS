package com.probsjustin.catfacts;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.TimeUnit;

public class runnable_send_real_sms implements Runnable{
	private String output = ""; 
	private String phoneNumber = ""; 
	private String delayField = ""; 
	private String catFact =  ""; 
	
	runnable_send_real_sms(String phoneNumber, String delayField, String catFact){
		
		this.phoneNumber = phoneNumber; 
		this.delayField = delayField; 
		this.catFact = catFact; 
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(phoneNumber == "") {
        	System.out.println(this.catFact); 
        	output = "Sending cat fact to:" + phoneNumber + "\n" + this.catFact;
        	System.out.println("Sending cat fact to:" + phoneNumber);
        	try {
				TimeUnit.SECONDS.sleep(Integer.parseInt(delayField));
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}else {
    		System.out.println("The Phone Number Needs To Be Filled Out.");
    		output = " [ERROR] The Phone Number Needs To Be Filled Out.";
    	}
	}

}
