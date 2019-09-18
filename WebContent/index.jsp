
<!DOCTYPE html>
<%@page import="com.OlShoping.doa.productDao"%>
<%@page import="com.OlShoping.pojo.product"%>
<%@page import="java.util.List"%>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Homepage - Start Bootstrap Template</title>

<!-- Bootstrap core CSS -->
<link href="resource/css/bootMin.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="resource/css/myshop.css" rel="stylesheet">

</head>

<body>
<%String userName=(String)session.getAttribute("userName");
String adminName=(String)session.getAttribute("adminName");
%>

	<!-- Navigation -->
	<jsp:include page="navBar.jsp"></jsp:include>

	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<!-- SideBar -->
			<jsp:include page="sideBar.jsp"></jsp:include>

			<!-- /.col-lg-3 -->

			<div class="col-lg-9">

				<!-- silder -->
				<jsp:include page="slider.jsp"></jsp:include>
				
					<%String cartMsg=(String)request.getAttribute("cartMsg"); %>
					<%if(cartMsg!=null){ %>
					<h3 align="center" style="color: red"><%=cartMsg %></h3>
					<%} %>

				<div class="row">

					<%
						productDao pd = new productDao();
						List<product> pl = pd.getlist();
						for (product p : pl) {
					%>

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top"
								src="resource/image/<%=p.getProductname()%>.jpg" alt=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#"><%=p.getProductname()%></a>
								</h4>
								<h5><%=p.getProductprice()%>
									Rs.
								</h5>
								<%if(userName==null){ %>
								
								<h4>
									<a href="login.jsp">addToCart</a>
								</h4>
								<%} %>
								<%if (userName!=null){ %>
								<h4>
									<a href="CartSevlet?action=addToCart&pid=<%=p.getPid()%>">addToCart</a>
								</h4>
								<%} %>
								<%if(adminName!=null){ %>
								<h4>
									<a>Edit</a>
								</h4>
								<h4>
									<a>Delete</a>
								</h4>
								<%} %>


								<p class="card-text"><%=p.getProductdescription()%></p>
							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>
					<%
						}
					%>

				</div>
				<!-- /.row -->

			</div>
			<!-- /.col-lg-9 -->

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>

	<!-- Bootstrap core JavaScript -->
	<script src="resource/js/jquery.js"></script>
	<script src="resource/js/bootJquery.js"></script>

</body>

</html>
