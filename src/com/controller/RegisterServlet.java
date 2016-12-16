package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.service.RegisterService;


public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	 response.setContentType("text/html;charset=UTF-8");
	 PrintWriter out = response.getWriter();
	 String id = request.getParameter("id");
	 String firstName = request.getParameter("firstName");
	 String lastName = request.getParameter("lastName");
	 String email = request.getParameter("email");
	 String password = request.getParameter("password");
	 String confirm_password = request.getParameter("confirm_password");
	 String gender = request.getParameter("gender");
	 String zip = request.getParameter("zip");
	 String phone_no = request.getParameter("phone_no");
	 User user = new User( id, firstName,lastName, email, password,confirm_password,gender,zip,phone_no);
	 		
	 try {	
		 RegisterService registerService = new RegisterService();
		 boolean result = registerService.register(user);
		 
		 if(result)
			 response.sendRedirect("success.html");
		 else
			 response.sendRedirect("registererror.html");
	 	}
	 finally {
		 	out.close();
		 }
}
}