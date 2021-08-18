package com.probsjustin.catfacts;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet_catfacts")
public class servlet_catfacts extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public servlet_catfacts() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response = controller_catfacts.parseRequest(request, response); 
		} catch (Exception e){
			response.setStatus(400);
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response = controller_catfacts.parseRequest(request, response); 
		} catch (Exception e){
			response.setStatus(400);
			e.printStackTrace();
		}
	}

}
