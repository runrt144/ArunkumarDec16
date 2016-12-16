package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

public class ViewTicket extends HttpServlet {

	private static final long serialVersionUID = 1L;
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/capstone";

	   static final String USER = "root";
	   static final String PASS = "root";

	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



	   Connection conn = null;
	   Statement stmt = null;{
	   try{
	      Class.forName("com.mysql.jdbc.Driver");

	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      
	      stmt = (Statement) conn.createStatement();

	      String sql = "SELECT firstName, lastName, email FROM registration";
	      ResultSet rs = stmt.executeQuery(sql);
	      while(rs.next()){
	         String firstName = rs.getString("firstName");
	         String lastName = rs.getString("lastName");
	         String email = rs.getString("email");

	         System.out.print("FirstName: " + firstName);
	         System.out.print(", lastName: " + lastName);
	         System.out.print(", email: " + email);
	      }
	      rs.close();
	   }catch(SQLException se){
	      se.printStackTrace();
	   }catch(Exception e){
	      e.printStackTrace();
	   }finally{
	      try{
	         if(stmt!=null)
	            conn.close();
	      }catch(SQLException se){
	      }
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }
	   }
	}
	}}