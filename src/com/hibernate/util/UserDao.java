package com.hibernate.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.model.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UserDao {
	
	public void updateUser(User user) {
		try {
			Connection connection =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/capstone", "root", "root");
			PreparedStatement preparedStatement = null;
			System.out.println("User : " +", " +user.getFirstName()  +"Last : " +user.getLastName() +user.getPassword() 
			+user.getGender() +user.getZip() + user.getPhone_no());
					
			String query = "update registration set firstName=?, lastName=?, password=?, confirm_password=?, gender=?, zip=?, phone_no=? where email='+ user.getEmail() +'";
			
			preparedStatement =  (PreparedStatement) connection.prepareStatement(query);
			
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getGender());
			preparedStatement.setString(6, user.getZip());
			preparedStatement.setString(7, user.getPhone_no());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}