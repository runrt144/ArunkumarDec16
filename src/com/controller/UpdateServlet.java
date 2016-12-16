package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernate.util.UserDao;
import com.model.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("password");
		String gender = request.getParameter("gender");
		String zip = request.getParameter("zip");
		String phone_no = request.getParameter("phone_no");
		
		try {
	        //loading driver 

	        Class.forName("com.mysql.jdbc.driver");

	        //creating connection with the database 
	        Connection connection =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/capstone", "root", "root");

	        String query = "update registration set firstName=?, lastName=?, password=?, confirm_password=?, gender=?, zip=?, phone_no=? where email='+ user.getEmail() +'";
			
	        PreparedStatement preparedStatement =  (PreparedStatement) connection.prepareStatement(query);
			
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, password);
			preparedStatement.setString(4, confirmPassword);
			preparedStatement.setString(5, gender);
			preparedStatement.setString(6, zip);
			preparedStatement.setString(7, phone_no);
			
			preparedStatement.executeUpdate();
	    } catch (Exception se) {
	        out.println("Error Occured : \n" + se.getLocalizedMessage());
	        se.printStackTrace();
	    }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		
	}
}