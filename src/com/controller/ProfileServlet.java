package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.LoginService;
import com.model.User;

public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		LoginService lg = new LoginService();
		HttpSession session = (HttpSession)request.getSession();
		String email = (String)request.getSession().getAttribute("email");
		if(email != null)
		{
			com.model.User user = lg.getUserByEmail(email);
			
			session.setAttribute("email", user.getEmail());
			session.setAttribute("lastName", user.getLastName());
			session.setAttribute("firstName", user.getFirstName());
			session.setAttribute("gender", user.getGender());
			session.setAttribute("zip", user.getZip());
			session.setAttribute("password", user.getPassword());
			session.setAttribute("confirm_password", user.getConfirm_password());
			session.setAttribute("phone_no", user.getPhone_no());
			
			
            RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
			
			rd.include(request, response);
			
			
			
		}else
			out.println("email--"+email);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		
	}

}
