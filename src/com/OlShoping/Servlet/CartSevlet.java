
package com.OlShoping.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.OlShoping.doa.CartDao;
import com.OlShoping.pojo.Cart;

@WebServlet("/CartSevlet")
public class CartSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CartDao cd=new CartDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String userName=(String)session.getAttribute("userName");
		String action=request.getParameter("action");
		if(action!=null && action.equals("addToCart")) {
			
			int pid=Integer.parseInt(request.getParameter(("pid")));
			boolean b=cd.addToCart(pid, userName);
			if(b) {
				
				request.setAttribute("cartMsg", "Cart Added Successfully");
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
			}
			
		}else{
			List<Cart> cartList=cd.getCartList(userName);
			session.setAttribute("cartList", cartList);
			response.sendRedirect("cartList.jsp");
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}
