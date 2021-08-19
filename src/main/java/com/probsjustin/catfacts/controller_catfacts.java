package com.probsjustin.catfacts;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class controller_catfacts {
	private static String holder_catFact = "";
	private static String holder_toPhoneNumber = "";
	private static String holder_fromPhoneNumber = "";
	private static String holder_debug = "";

	
	controller_catfacts(){

	}
	
	Map <String,String> checkRequestParameter_Validator(HttpServletRequest func_request, String func_parameter_to_check) {
		Map<String,String> returnMap = null;
		if(func_request.getParameter(func_parameter_to_check) != null) {
			returnMap.put("bool", "true");
			returnMap.put("parameter_value", func_request.getParameter(func_parameter_to_check));
		}else {
			returnMap.put("bool", "false");
		}
		return null;
		
	}
	
	String run_catFactCallable() {
		String returnString = ""; 
		ExecutorService executor = Executors.newSingleThreadExecutor(); 
		callable_catfacts_api temp_callable_catfacts_api = new callable_catfacts_api();
		Future<String> future = executor.submit(temp_callable_catfacts_api);
		try {
			returnString = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		executor.shutdown(); 
		return returnString;
	}
	
	String run_sendFakeTextMessagesCallable(String func_toPhoneNumber, String func_messageBody) {
		String returnString = ""; 
		ExecutorService executor = Executors.newSingleThreadExecutor(); 
		callable_send_post_fake_text_message temp_callable_send_post_fake_text_message = new callable_send_post_fake_text_message(func_toPhoneNumber, func_messageBody); 
		Future<String> future = executor.submit(temp_callable_send_post_fake_text_message);
		try {
			returnString = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		executor.shutdown(); 
		return returnString;
	}
	
	HttpServletResponse parseRequest(HttpServletRequest func_request, HttpServletResponse func_response) {
		holder_catFact = this.run_catFactCallable(); 
		Map <String,String> tempMap_toPhoneNumber = checkRequestParameter_Validator(func_request, "toPhoneNumber");
		Map <String,String> tempMap_fromPhoneNumber = checkRequestParameter_Validator(func_request, "fromPhoneNumber");
		Map <String,String> tempMap_debug = checkRequestParameter_Validator(func_request, "debug");
		
		if(tempMap_toPhoneNumber.get("bool") == "true" && tempMap_fromPhoneNumber.get("bool") == "true" && tempMap_debug.get("bool") == "true") {
			holder_toPhoneNumber = func_request.getParameter("toPhoneNumber"); 
			holder_fromPhoneNumber = func_request.getParameter("fromPhoneNumber");
			holder_debug = func_request.getParameter("debug"); 
			
			// this is a success
		}else {
			func_response.setStatus(400);
		}
		return func_response;
	}
}
