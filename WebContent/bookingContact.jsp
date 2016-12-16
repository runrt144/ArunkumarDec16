<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact Information</title>

<style type="text/css">
.form {
	color: blue;
	background-color: ghostwhite;
	padding: 20px;
	border: 1px solid black;
	border-radius: 20px;
	font-weight: bold;
	font-size: 100%;
	font-variant: small-caps;
	font-family: 'FranchiseRegular', 'Arial Narrow', Arial, sans-serif;
	width: 100%;
	width: 70%;
	position: relative;
	top: 20%;
	left: 20%;
	margin-top: 50px;
	margin-left: -50px;
}

hr {
	color: #123455;
}
</style>
</head>
<body>
	<div style="hight: 30%" ; align="center" class="form">
		<h2><u>Flight Information</u></h2>
		
		<div>
			<h6>${sessionScope.sampleFlight11}</h6>
			<h6>${sessionScope.sampleFlight21}</h6>
			<h6>${sessionScope.sampleFlight31}</h6>
			<h6>${sessionScope.sampleFlight41}</h6>
			<h6>${sessionScope.sampleFlight51}</h6>
			<h5>Total Cost: ${sessionScope.tripoptCost}</h5>

		</div>
		<%  String  fl1  = (String) session.getAttribute("sampleFlight11");%>
		<%  String  fl2  = (String) session.getAttribute("sampleFlight21");%>
		<%  String  fl3  = (String) session.getAttribute("sampleFlight31");%>
		<%  String  fl4  = (String) session.getAttribute("sampleFlight41");%>
		<%  String  fl5  = (String) session.getAttribute("sampleFlight51");%>
		<%  String  flcost  = (String) session.getAttribute("tripoptCost");%>
		
		
		<textarea name = "flight1" rows="1" cols="100">${sessionScope.sampleFlight11}</textarea>
		<textarea name = "flight2" rows="2" cols="50">${sessionScope.sampleFlight21}</textarea>
		<textarea name = "flight3" rows="3" cols="50">${sessionScope.sampleFlight31}</textarea>
		<textarea name = "flight4" rows="4" cols="50">${sessionScope.sampleFlight41}</textarea>
		<textarea name = "flight5" rows="5" cols="50">${sessionScope.sampleFlight51}</textarea>
		<textarea name = "cost" rows="1" cols="50">${sessionScope.tripoptCost}</textarea>

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
    		String command = "INSERT INTO flight VALUES('AR0002','"+fl1+"')";
            statement.executeUpdate(command);
            command = "INSERT INTO flight VALUES('AR0002','"+fl2+"')";
            statement.executeUpdate(command);
            command = "INSERT INTO flight VALUES('AR0002','"+fl3+"')";
            statement.executeUpdate(command);
            command = "INSERT INTO flight VALUES('AR0002','"+fl4+"')";
            statement.executeUpdate(command);
            command = "INSERT INTO flight VALUES('AR0002','"+fl5+"')";
            statement.executeUpdate(command);
            command = "INSERT INTO flight VALUES('AR0002','"+flcost+"')";
            statement.executeUpdate(command);
          %> 
		<h2>
			<u>Fill details to proceed</u>
		</h2>
		<form onsubmit="setBookingInfor()" id="passengerform" action="ConfirmServlet" method="post">
		<input type="hidden" name="flightx1" id="flightx1" />
		<input type="hidden" name="flightx2" id="flightx2" />
		<input type="hidden" name="flightx3" id="flightx3" />
		<input type="hidden" name="flightx4" id="flightx4" />
		<input type="hidden" name="flightx5" id="flightx5" />
		<input type="hidden" name="costx" id="costx" />
		
			<div>
				<u>Passanger Details:</u> <br> <br>
				<table>
					<tr>
						<td></td>
						<td>First Name</td>
						<td>Last Name</td>
						<td>Passport Number</td>
						<td>Dob</td>
						<td>Gener</td>
						<td>Senior</td>

					</tr>
					<tr>
						<td>1.</td>
						<td><input type="text" name="firstName" required
							placeholder="Firstname" /></td>


						<td><input type="text" name="lastName" required
							placeholder="Lastname" /></td>


						<td><input type="text" name="passportNum" required
							placeholder="Passport Number" /></td>


						<td><input type="date" name="dob" required
							placeholder="Dob(mm/dd/yyyy)" /></td>

						<td><select name="gender">
								<option value="Male">Male</option>
								<option value="Female">Female</option>
						</select></td>

						<td><select name="senior">
								<option value="No">No</option>
								<option value="Yes">Yes</option>
						</select></td>
					</tr>

					<tr>
						<td>2.</td>
						<td><input type="text" name="firstName1"
							placeholder="Firstname" /></td>


						<td><input type="text" name="lastName1"
							placeholder="Lastname" /></td>


						<td><input type="text" name="passportNum1"
							placeholder="Passport Number" /></td>


						<td><input type="date" name="dob1"
							placeholder="Dob(mm/dd/yyyy)" /></td>

						<td><select name="gender1">
								<option value="Male">Male</option>
								<option value="Female">Female</option></td>

						<td><select name="senior1">
								<option value="No">No</option>
								<option value="Yes">Yes</option></td>

					</tr>
				</table>
			</div>
			<hr color:blue>
			<hr>
			<u>Contact Information: </u><br> <br>
			<div>
				<table>
					<tr>
						<td>Email:</td>
						<td><input type="email" name="email" required
							placeholder="Your Email" /></td>
						<td>Phone Number:</td>
						<td><input type="text" name="phoneNo"
							placeholder="Phone Number" /></td>
					</tr>
				</table>
			</div>
			<hr>
			<hr>
			<u>Payment Information: </u><br> <br>
			<div>
				<table>
					<tr>
						<td>Card Holder Name:</td>
						<td><input type="text" name="cardHolderName" required
							placeholder="Card Holder Name" /></td>

						<td>Card Number:</td>
						<td><input type="text" name="cardNumber" required
							placeholder="Card Number" maxlength=16 /></td>
					</tr>
					<tr>
						<td>CVV:</td>
						<td><input type="text" name="cvv" required placeholder="CVV"
							minlength=3 maxlength=3 /></td>

						<td>Expire Date:</td>
						<td><input type="date" name="expireDate" required
							placeholder="Expire Date(mm/dd/yyyy)" /></td>
					</tr>
				</table>
			</div>
			<br>

			<div>
				<table>
					<tr>
						<td colspan="4" style="text-align: center;"><br> 
					
						<script type="text/javascript">
				
							function setBookingInfor(){
									//alert(bookingInfo);
									document.getElementById('flightx1').value = ('<c:out value='${sessionScope.sampleFlight11}' />');
									document.getElementById('flightx2').value = ('<c:out value='${sessionScope.sampleFlight21}' />');
									document.getElementById('flightx3').value = ('<c:out value='${sessionScope.sampleFlight31}' />');
									document.getElementById('flightx4').value = ('<c:out value='${sessionScope.sampleFlight41}' />');
									document.getElementById('flightx5').value = ('<c:out value='${sessionScope.sampleFlight51}' />');
									document.getElementById('costx').value = ('<c:out value='${sessionScope.tripoptCost}' />');
									alert(flightx1);
									alert(flightx2);
									alert(costx);
									alert('${sessionScope.sampleFlight11}');
							}
						</script> 
						<input  class="search" type="submit" value="Book" />
						<!-- <input onclick="setBookingInfor();" class="search" type="submit" value="Book" /> -->
					</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
</html>