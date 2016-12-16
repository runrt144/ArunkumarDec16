<%@ page import="java.sql.*"%>
<%
	Class.forName("com.mysql.jdbc.Driver");
%>

<HTML>
<HEAD>
<TITLE>Fetching Data From a Database</TITLE>
</HEAD>

<BODY>

	<H1>Fetching Data From a Database</H1>

	<%
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/capstone", "root", "root");

		Statement statement = connection.createStatement();

		String bookingId1 = request.getParameter("bookingId");

		ResultSet resultset = statement.executeQuery(
				"select  f.detail from flight f where bookingId = '"+bookingId1+"'");

		while (resultset.next()) {
	%>
			Flight:==> <%=resultset.getString(1)%>
	<BR>
	<%
		}
	%>
	<%
	ResultSet resultset2 = statement.executeQuery(
				"select  email, phone_no from contact_info where bookingId = '"+bookingId1+"'");

		while (resultset.next()) {
	%>
<TABLE BORDER="1">
		<TR>
			<TH>Email</TH>
			<TH>Phone number</TH>
		</TR>
		<TR>
			<TD><%=resultset.getString(1)%></TD>
			<TD><%=resultset.getString(2)%></TD>
		</TR>
	</TABLE>
	<BR>
	<%
		}
	%>
	<%
	ResultSet resultset3 = statement.executeQuery(
				"select  firstName, lastName, passportNo, dob, gender, senior from passenger where bookingId = '"+bookingId1+"'");

		while (resultset.next()) {
	%>
<TABLE BORDER="1">
		<TR>
			<TH>First Name</TH>
			<TH>Last Name</TH>
			<TH>Passport Number</TH>
			<TH>DOB</TH>
			<TH>Gender</TH>
			<TH>Senior</TH>
		</TR>
		<TR>
			<TD><%=resultset.getString(1)%></TD>
			<TD><%=resultset.getString(2)%></TD>
			<TD><%=resultset.getString(3)%></TD>
			<TD><%=resultset.getString(4)%></TD>
			<TD><%=resultset.getString(5)%></TD>
			<TD><%=resultset.getString(6)%></TD>
			<TD><%=resultset.getString(7)%></TD>
		</TR>
	</TABLE>
	<BR>
	<%
		}
	%>

</BODY>
</HTML>
