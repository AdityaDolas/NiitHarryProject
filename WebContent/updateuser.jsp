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
<%user u=(user)session.getAttribute("u"); %>
	<form action="user" method="post">
	<input type="hidden" name="action" value="updateUser">
		<table align="center" cellpadding="10" cellspacing="10" border="2">
			<tr>
				<td>NAME</td>
				<td><input type="text" name="name" value="<%=u.getName()%>"></td>
			</tr>

			<tr>
				<td>CONTACT</td>
				<td><input type="text" name="contact" value="<%=u.getContact()%>"></td>
			</tr>
			<tr>
				<td>ADDRESS</td>
				<td><input type="text" name="add" value="<%=u.getAddress()%>"></td>
			</tr>
			<tr>
				<td>EMAIL ID</td>
				<td><input type="text" name="emailid" value="<%=u.getEmail()%>" readonly="readonly"></td>
			</tr>
			<tr>
				<td>PASSWORD</td>
				<td><input type="password" name="pass" value="<%=u.getPass()%>"></td>
			</tr>
			
			<tr>
				<td align="center"><input type="submit" value="SAVE"></td>
				<td align="center"><input type="submit" value="RESET"></td>
		
		</tr>
		</table>
	</form>
</body>

</html>