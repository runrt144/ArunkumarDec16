package com.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ConfirmServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String flight1 = request.getParameter("flightx1").toString();
		String flight2 = request.getParameter("flightx2").toString();
		String flight3 = request.getParameter("flightx3").toString();
		String flight4 = request.getParameter("flightx4").toString();
		String flight5 = request.getParameter("flightx5").toString();
		String cost = request.getParameter("costx").toString();
		
		
		 String firstName1 = request.getParameter("firstName1");
		 String lastName1 = request.getParameter("lastName1");
		 String passportNum1 = request.getParameter("passportNum1");
		 String dob1 = request.getParameter("dob1");
		 String gender1 = request.getParameter("gender1");
		 String senior1 = request.getParameter("senior1");
		 	
		 String firstName = request.getParameter("firstName");
		 String lastName = request.getParameter("lastName");
		 String passportNum = request.getParameter("passportNum");
		 String dob = request.getParameter("dob");
		 String gender = request.getParameter("gender");
		 String senior = request.getParameter("senior");
		 
		 String email = request.getParameter("email");
		 String phoneNo = request.getParameter("phoneNo");

		if (email.equals(null))
			System.out.println("No information fetched.");
		else {
			HttpSession session = request.getSession();
//			session.setAttribute("flight1", flight1);
//			session.setAttribute("flight2", flight2);
//			session.setAttribute("flight3", flight3);
//			session.setAttribute("flight4", flight4);
//			session.setAttribute("flight5", flight5);
//			session.setAttribute("cost", cost);
			
			session.setAttribute("firstName", firstName);
			session.setAttribute("lastName", lastName);
			session.setAttribute("passportNum", passportNum);
			session.setAttribute("dob", dob);
			session.setAttribute("gender", gender);
			session.setAttribute("senior", senior);
			
			session.setAttribute("firstName1", firstName1);
			session.setAttribute("lastName1", lastName1);
			session.setAttribute("passportNum1", passportNum1);
			session.setAttribute("dob1", dob1);
			session.setAttribute("gender1", gender1);
			session.setAttribute("senior1", senior1);
			
			session.setAttribute("email", email);
			session.setAttribute("phoneNo", phoneNo);
			
			try {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/insertDB.jsp");
                rd.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
			
		}
	}
}
