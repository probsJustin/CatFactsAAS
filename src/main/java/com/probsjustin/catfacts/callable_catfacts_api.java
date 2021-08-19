package com.probsjustin.catfacts;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.Callable;



public class callable_catfacts_api implements Callable<String>{
	private String returnObj_catFact = ""; 
	
	@Override
	public String call() throws Exception {
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
		return this.returnObj_catFact; 
	}

}
