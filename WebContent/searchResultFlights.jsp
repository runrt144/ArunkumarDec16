<%-- 
    Document   : SearchFlights
    Created on : Nov 13, 2016, 7:22:36 PM
    Author     : Arun
--%>

<%@page import="com.flight.TripSearch"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SearchFlights</title>
<style>
body {
	margin-left: 50px;
	background-color: lightblue;
	-background: url("images/h5.jpg") no-repeat center center fixed; -
	-background-size: cover;
	color: black;
	font-weight: bold;
	font-size: 100%;
	font-variant: small-caps;
	font-family: 'FranchiseRegular', 'Arial Narrow', Arial, sans-serif;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 5px;
}

th {
	text-align: left;
}

input {
	background-color: brown;
	color: white;
	padding: 7px 40px 7px 40px;
	border-radius: 5px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}
</style>
</head>

<body>
	<div align="center">
		<br> <img src="images/head1.jpg" alt=" " height="60" width="100%"
			align="middle" />
	</div>
	<br>
	<h1>
		<u>Search Flight Results</u>
	</h1>
	<form align="left" class="book" method="post" action="ContactServlet">
		<input type="hidden" name="bookingInfo" id="bookingInfo" />
		<input type="hidden" name="tripoptFlight" id="tripoptFlight" />
		<input type="hidden" name="tripoptFromTo" id="tripoptFromTo" />
		<input type="hidden" name="tripoptDate" id="tripoptDate" />
		<input type="hidden" name="tripoptDur" id="tripoptDur" />
		<input type="hidden" name="tripoptCost" id="tripoptCost" />
		
		<table style="width: 100%">
			<tr>
				<td>Flight Carrier</td>
				<td>Flight Number</td>
				<td>Origin</td>
				<td>Destination</td>
				<td>Departure Date</td>
				<td>Arrival Date</td>
				<td>Travel Time</td>
			</tr>
			<c:forEach items="${flightSearchResults.trips.tripOption}"
				var="tripOption" varStatus="loop">

				<c:set var="tripopt" value="" />
				<c:set var="tripoptFlight" value="" />
				<c:set var="tripoptFromTo" value="" />
				<c:set var="tripoptDate" value="" />
				<c:set var="tripoptDur" value="" />
				<c:set var="tripoptCost" value="" />
				<c:forEach items="${tripOption.slice}" var="slice" varStatus="loop">

					<c:forEach items="${slice.segment}" var="segment" varStatus="loop">
						<tr>
							<c:forEach items="${flightSearchResults.trips.data.carrier}"
								var="carrier" varStatus="loop">
								<c:if test="${carrier.code == segment.flight.carrier }">
									<td><c:out value="${carrier.name}" /></td>
									<c:set var="tripopt"
										value=" ${tripopt} ${carrier.name }" />
									<c:set var="tripoptFlight"
										value=" ${tripoptFlight} ${carrier.name }" />
								</c:if>
							</c:forEach>
							<td><c:out value="${segment.flight.number}" /></td>
							<c:set var="tripopt"
								value="${tripopt} ;  ${segment.flight.number} \n " />
							<c:set var="tripoptFlight"
								value="${tripoptFlight} Number ${segment.flight.number} \n " />
							<c:forEach items="${segment.leg}" var="leg" varStatus="loop">
								<td><c:out value="${leg.origin}" /></td>
								<td><c:out value="${leg.destination}" /></td>
								<td><c:out value="${leg.departureTime}" /></td>
								<td><c:out value="${leg.arrivalTime}" /></td>
								<c:set var="tripopt"
									value=" ${tripopt} ; ${leg.origin} ;  ${leg.destination }  ;  ${leg.departureTime } ;  ${leg.arrivalTime } ;" />
								<c:set var="tripoptFromTo"
									value=" ${tripoptFomTo} ; From:  ${leg.origin} ; To:  ${leg.destination } \n " />
								<c:set var="tripoptDate"
									value=" ${tripoptDate} ; Dep Date:  ${leg.departureTime } ; Arr Date:  ${leg.arrivalTime }" />
							</c:forEach>
							<td><c:out value="${segment.duration}" /></td>

							<!-- <td><c:out value="${slice.duration}" /></td> -->
							<!-- <td><c:out value="${segment.bookingCodeCount}" /></td> -->

							<c:set var="tripopt"
								value="${tripopt}   ${segment.duration};" />
							<c:set var="tripoptDur"
								value="${tripoptDur} Travel Time: ${segment.duration};" />
						</tr>

					</c:forEach>
				</c:forEach>
				<tr>

					<c:forEach items="${tripOption.pricing}" var="pricing1"
						varStatus="loop">
						<td><c:out value="Fare ${pricing1.saleFareTotal}" /></td>
						<td><c:out value="Tax ${pricing1.saleTaxTotal}" /></td>
						<td><c:out value="Per Tic ${pricing1.saleTotal}" /></td>
					</c:forEach>

					<td><c:out value="Total Cost ${tripOption.saleTotal}" /></td>
					<c:set var="tripoptCost"
								value="${tripOption.saleTotal}\n" />
					
					<td colspan="4"
						style="text-align: center; backgroud-color: blue; color: white">
						<script type="text/javascript">
				
							function setBookingInfo(){
									//alert(bookingInfo);
									document.getElementById('bookingInfo').value = ('<c:out value='${tripopt}' />');
									document.getElementById('tripoptFlight').value = ('<c:out value='${tripoptFlight}' />');
									document.getElementById('tripoptFromTo').value = ('<c:out value='${tripoptFromTo}' />');
									document.getElementById('tripoptDate').value = ('<c:out value='${tripoptDate}' />');
									document.getElementById('tripoptDur').value = ('<c:out value='${tripoptDur}' />');
									document.getElementById('tripoptCost').value = ('<c:out value='${tripoptCost}' />');
							}
						</script> <input onclick="setBookingInfo();"
						class="search" type="submit" value="Book" />
					</td>
					
					
					<%-- <td colspan="4"
						style="text-align: center; backgroud-color: blue; color: white">
						<script type="text/javascript">
				
							function setBookingInfo(bookingInfo){
									alert(bookingInfo);
									//document.getElementById('bookingInfo').value = (bookingInfo);
							}
						</script> 
						<input onclick="setBookingInfo('<c:out value='${tripopt}' />');"
						class="search" type="submit" value="Book" />
					</td> --%>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>
