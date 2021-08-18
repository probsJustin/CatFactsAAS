package com.probsjustin.catfacts;

import java.io.IOException;
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
	
	void checkRequestParameter_Validator() {
		
	}
	
	static HttpServletResponse parseRequest(HttpServletRequest func_request, HttpServletResponse func_response) {
		holder_catFact = ""; 
		holder_toPhoneNumber = func_request.getParameter("toPhoneNumber"); 
		holder_fromPhoneNumber = func_request.getParameter("fromPhoneNumber");
		holder_debug = func_request.getParameter("debug"); 
		
		return func_response;
	}
}
