<%@page import="java.util.List"%>
<%@page import="com.OlShoping.pojo.user"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		List<user> li = (List<user>) session.getAttribute("ulist");
	%>
	<table cellpadding="10" cellspacing="10" border="2">
		<tr>
		<th>Name</th>
		<th>contact</th>
		<th>address</th>
		<th>email</th>
		<th>password</th>
		<th colspan="2">Action</th>
		</tr>
		<%
			for (user u : li) {
		%>
		<tr>
			<td><%=u.getName()%></td>
			<td><%=u.getContact()%></td>
			<td><%=u.getAddress()%></td>
			<td><%=u.getEmail()%></td>
			<td><%=u.getPass()%></td>
			<td><a href="user?action=delet&emailid=<%=u.getEmail()%>">Delete</a></td>
			<td><a href="user?action=edit&emailid=<%=u.getEmail()%>">EDIT</a></td>
		</tr>

		<%} %>
	</table>
</body>
</html>