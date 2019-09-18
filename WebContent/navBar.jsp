
<%String userName=(String)session.getAttribute("userName");
String adminName=(String)session.getAttribute("adminName");
%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="#">Start Bootstrap</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          
           <li class="nav-item">
            <a class="nav-link" href="productServlet">ProductList</a>
          </li>
          
          
          <%if(userName!=null && adminName==null){ %>
          
          <li class="nav-item">
            <a class="nav-link" href="CartSevlet">CartList</a>
          </li>
          
           <li class="nav-item">
            <a class="nav-link" href="#">Feedback</a>
          </li>
          
          <%} %>
          
          <%if(userName==null && adminName!=null){ %>
          
           <li class="nav-item">
            <a class="nav-link" href="#">AddProduct</a>
          </li>
          
            
          <li class="nav-item">
            <a class="nav-link" href="#">UserList</a>
          </li>
          
           <li class="nav-item">
            <a class="nav-link" href="#">OrderList</a>
          </li>
          <%} %>
          
          <%if(userName==null && adminName==null){ %>
          
           <li class="nav-item">
            <a class="nav-link" href="registration.jsp">Register</a>
          </li>
          
          <li class="nav-item">
            <a class="nav-link" href="login.jsp">Login</a>
          </li>
          
          <%} %>
        
         <li class="nav-item">
            <a class="nav-link" href="#">AboutUs</a>
          </li>
         
          
         <%if(userName!=null || adminName!=null) {%>
           <li class="nav-item">
            <a class="nav-link" href="LoginServlet">LogOut</a>
          </li>
         <%} %>
         
        
        
         
        </ul>
      </div>
    </div>
  </nav>