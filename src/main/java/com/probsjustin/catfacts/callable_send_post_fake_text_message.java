package com.probsjustin.catfacts;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Callable;

public class callable_send_post_fake_text_message implements Callable<String>{
	private static String messageBody = "";
	private static String toNumber = ""; 
	private static String runnable_output = ""; 
	
	callable_send_post_fake_text_message(String toNumber, String messageBody){
		this.messageBody = messageBody; 
		this.toNumber = toNumber; 
	}
	@Override
	public String call() {
		String returnObject = null;
		String fromPhoneNumber = "From=+55555555555";
		String payloadBody = "Body=";
		String buildURL = ""; 
		
		buildURL = "?" + payloadBody + encodeValue(messageBody) + "&" + fromPhoneNumber + "&" + "To=+" + this.toNumber;
		
		HttpClient postClient = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://webhook.site/e6017324-34ab-49ba-8c8d-910ae0d8ef68"))
				.POST(HttpRequest.BodyPublishers.ofString(buildURL))
				.build(); 
		
		HttpResponse<String> response;
		try {
			response = postClient.send(request, HttpResponse.BodyHandlers.ofString());
			returnObject = response.body().toString(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			returnObject = "its broken"; 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			returnObject = "its broken"; 
		}
		
		return returnObject; 
		
	}
	private String encodeValue(String value) {
		// TODO Auto-generated method stub
		try {
			return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
