package com.probsjustin.catfacts;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



public class runnable_catfacts_api implements Runnable{
	private static String returnObj_catFact = ""; 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String returnObject = ""; 
	    HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	            .uri(URI.create("https://catfact.ninja/fact"))
	            .build();
	
	    HttpResponse<String> response;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		    returnObject = response.body();
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException");
			e.printStackTrace();
		}
		String[] returnObject_split = returnObject.toString().split("\"");
		this.returnObj_catFact = returnObject_split[3]; 
		
	}

}
