package com.OlShoping.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.OlShoping.doa.UserDao;
import com.OlShoping.pojo.user;

import sun.security.action.GetBooleanAction;


@WebServlet("/user")
public class userservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	user u=new user();
	UserDao au=new UserDao();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		HttpSession session=request.getSession();
		String action=request.getParameter("action");

		if(action!=null && action.equals("delet"))
		{
			String nm=request.getParameter("emailid");

			boolean d=au.deletuser(nm);
			if(d) {
				response.sendRedirect("user");
			}
		}
		else if (action!=null && action.equals("edit")) {
			String nm=request.getParameter("emailid");
			user u1=au.getUserById(nm);
			session.setAttribute("u", u1);
			response.sendRedirect("updateuser.jsp");
		}

		else {
			List<user> li=au.getlist();
			session.setAttribute("ulist", li);
			response.sendRedirect("userlist.jsp");
		}




	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action=request.getParameter("action");
		String name=request.getParameter("name");
		String contact=request.getParameter("contact");
		String address=request.getParameter("add");
		String emailid=request.getParameter("emailid");
		String pass=request.getParameter("pass");
		String cpass=request.getParameter("cpass");

		u.setName(name);
		u.setContact(contact);
		u.setAddress(address);
		u.setEmail(emailid);
		u.setPass(pass);

		if(action!=null && action.equals("addUser"))
		{
			if(pass!=null && pass.equals(cpass))
			{
				boolean b=au.adduser(u);

				if(b)
				{
					response.sendRedirect("Success.jsp");
				}
			}else
			{
				response.sendRedirect("Error.jsp");
			}

		}
		else if (action!=null && action.equals("updateUser")) {

			boolean b=au.edituser(u);
			if(b) {
				response.sendRedirect("user");
			}

		}

	}

}
