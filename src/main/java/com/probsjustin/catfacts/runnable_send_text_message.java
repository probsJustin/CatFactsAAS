package com.probsjustin.catfacts;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class runnable_send_text_message implements Runnable{
	private String[] runnable_output = null; 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// This is a GET request and I am pretty sure it wont work - can't test beause twilio account is locked. 
		
				String returnObject = new String(); 
				
				HttpClient messageClient = HttpClient.newHttpClient(); 
				HttpRequest request = HttpRequest.newBuilder()
						.uri(URI.create("https://api.twilio.com/2010-04-01/Accounts/${account_sid}/Messages"))
						.build(); 
			    HttpResponse<String> response;
				try {
					response = messageClient.send(request, HttpResponse.BodyHandlers.ofString());
				    returnObject = response.body();
				} catch (IOException e) {
					System.out.println("IOException");
					e.printStackTrace();
				} catch (InterruptedException e) {
					System.out.println("InterruptedException");
					e.printStackTrace();
				}
				String[] returnObject_split = returnObject.toString().split("\"");
				this.runnable_output = returnObject_split;
	}

}
