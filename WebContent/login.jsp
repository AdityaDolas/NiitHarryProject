<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="LoginServlet" method="post">
<table align="center" cellpadding="10" cellspacing="10" border="2">

<tr>
<td>UserName</td><td><input type="text" name="uname"></td>
</tr>

<tr>
<td>Password</td><td><input type="text" name="pass"></td>
</tr>

<tr>
<td><input type="submit" value="Login"></td><td><a href="">Click Here For Register</a></td>
</tr>


</table>

</form>
</body>
</html>