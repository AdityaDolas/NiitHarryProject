<%@page import="com.OlShoping.pojo.Cart"%>
<%@page import="java.util.List"%>
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
List<Cart> li=(List<Cart>)session.getAttribute("cartList");
%>
<table cellpadding="10" cellspacing="10" border="2" align="center">
<tr>
<th>Product_Name</th><th>Product_Quantity</th><th>Product_Price</th><th>Product_description</th>
<th colspan="2">Action</th>
<%for(Cart p:li) {%>
<tr>

<td><%=p.getPname()%></td>
<td><input type="number"  name="qty" value="1"></td>
<td><%=p.getPrice()%></td>
<td><%=p.getDescription() %></td>
<td><a href="">DELETE</a></td>
</tr>
<%} %>
<tr><td colspan="4" align="center"><input type="submit" value="PlaceOrder"></td></tr>
</table>

</body>
</html>