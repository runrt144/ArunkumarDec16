<%@ page import="java.sql.*" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<HTML>
    <HEAD>
        <TITLE>Confirmation</TITLE>
    </HEAD>

    <BODY>
<%--         
			<%  String  flight1  = (String) session.getAttribute("flight1");%>
			<%  String  flight2  = (String) session.getAttribute("flight2");%>
			<%  String  flight3  = (String) session.getAttribute("flight3");%>
			<%  String  flight4  = (String) session.getAttribute("flight4");%>
			<%  String  flight5  = (String) session.getAttribute("flight5");%>
			<%  String  cost  = (String) session.getAttribute("cost");%> --%>
			
			<%  String  email  = (String) session.getAttribute("email");%>
			<%  String  phoneNo  = (String) session.getAttribute("phoneNo");%>
			
			<%  String  firstName  = (String) session.getAttribute("firstName");%>
			<%  String  lastName  = (String) session.getAttribute("lastName");%>
			<%  String  passportNum  = (String) session.getAttribute("passportNum");%>
			<%  String  dob  = (String) session.getAttribute("dob");%>
			<%  String  gender  = (String) session.getAttribute("gender");%>
			<%  String  senior  = (String) session.getAttribute("senior");%>
			<%  String  firstName1  = (String) session.getAttribute("firstName1");%>
			<%  String  lastName1  = (String) session.getAttribute("lastName1");%>
			<%  String  passportNum1  = (String) session.getAttribute("passportNum1");%>
			<%  String  dob1  = (String) session.getAttribute("dob1");%>
			<%  String  gender1  = (String) session.getAttribute("gender1");%>
			<%  String  senior1  = (String) session.getAttribute("senior1");%>

        <%  
            Connection connection = null;
			Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/capstone", "root", "root");
	
            Statement statement = connection.createStatement();
            /* String command = "select max(bookingId) AS maxId from flight";
            
            ResultSet rs = statement.executeQuery(command);
            if (rs.next()){
            	int maxId = rs.getInt("maxId");
            	int bookId = maxId +1;
            } */
           
    		statement = connection.createStatement();
    		
            String command = "INSERT INTO contact_info VALUES('AR0002','"+email+"','"+phoneNo+"')";
            statement.executeUpdate(command);
            
            command = "INSERT INTO passenger values ('01','AR0002','"+firstName+"','"+lastName+"', '"+passportNum+"','"+dob+"', '"+gender+"', '"+senior+"')";
            statement.executeUpdate(command);
            
            command = "INSERT INTO passenger values ('02','AR0002','"+firstName1+"','"+lastName1+"', '"+passportNum1+"','"+dob1+"', '"+gender1+"', '"+senior1+"')";
            statement.executeUpdate(command);    
        %> 
        
        <H1><center> Booking is successful</center> </H1>
        <H1><center>And your Booking Id is AR0002 <center></H1>
        <center><table><tr>
					<td colspan="4" style="text-align: center">
					<a href="viewTicket.html">View Ticket/Print Ticket</a></td>
		</tr></table><center>
    </BODY>
</HTML>