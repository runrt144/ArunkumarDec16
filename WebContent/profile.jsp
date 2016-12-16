<%@page import="org.springframework.web.context.annotation.SessionScope"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile Information</title>
<style type="text/css">
         
         .form{ 
         color: darkblue;
         padding:20px;  
         border:1px solid black;  
         border-radius:20px;  
         font-weight:bold; 
         font-size: 100%;
         font-variant: small-caps;
         font-family: 'FranchiseRegular','Arial Narrow',Arial,sans-serif;
         width: 60%;
         width: 250px;
         position: relative;	
         top: 10%;
         left: 42%;
         margin-top: 50px;
         margin-left: -50px;
         }  
      </style>
</head>

<body>

  <form id="regform" action="UpdateServlet" method = "post" align="center" class="form">
            <h1> <b><u>Personal Information </u></b></h1>
            <table>
               <tr>
                  <td>First Name:</td>
                  <td><input type="text" name="firstName" value = <%=session.getAttribute("firstName") %> ></td>
               </tr>
               <tr>
                  <td>Last Name:</td>
                  <td><input type="text" name="lastName" value =<%= session.getAttribute("lastName") %>></td>
               </tr> 
               
               <tr>
                  <td>Password:</td>
                  <td><input  type="text" name="password" id="password" required placeholder="Password"
                             minlength=5 maxlength=12 value =<%= session.getAttribute("password") %>></td>
               </tr>
               
				<tr>
                  <td>gender:</td>
                  <td><input type="gender" name="gender"  value =<%= session.getAttribute("gender") %>></td>
               </tr>
               <tr>
                  <td>Zip:</td>
                  <td><input type="zip" name="zip"  value =<%= session.getAttribute("zip") %>></td>
               </tr>
                
                <tr>
                  <td>Phone Number:</td>
                  <td><input type="text" name="phone_no" value =<%= session.getAttribute("phone_no") %>></td>
               </tr>
               <tr>
                  <td colspan="4" style="text-align: center;" >
                     <br><input class="sub" type="submit" value="Update" />
                  </td>
               </tr>
            </table>
         </form>
</body>
</html>