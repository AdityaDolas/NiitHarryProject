package com.OlShoping.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.OlShoping.doa.UserDao;
import com.OlShoping.pojo.user;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDao ud=new UserDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.invalidate();
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String uname=request.getParameter("uname");
		String password=request.getParameter("pass");

		if(uname !=null && uname.equals("admin@123") && password.equals("admin"))
		{

			session.setAttribute("adminName",uname );
			response.sendRedirect("indexPage.jsp");
		}
		else {

			user ul=ud.getLogin(uname, password);
			if(ul!=null) {	
				if(ul!=null && ul.getEmail().equals(uname) && ul.getPass().equals(password)) {
					session.setAttribute("userName",uname );
					response.sendRedirect("index.jsp");
				}
			}else {
				request.setAttribute("lmsg", "Invalid UserName And Password");
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.include(request, response);

			}
		}

	}

}
