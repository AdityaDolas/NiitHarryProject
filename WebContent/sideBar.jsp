<%@page import="java.util.List"%>
<%@page import="com.OlShoping.doa.productDao"%>
<div class="col-lg-3">
<%List<String> li=new productDao().getcategory();%>
        <h1 class="my-4">Shop Name</h1>
       
        <div class="list-group">
        <%for(String s:li){ %>
          <a href="#" class="list-group-item"><%=s %></a>
          <%} %>
        </div>

      </div>