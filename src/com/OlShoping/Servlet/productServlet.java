package com.OlShoping.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.OlShoping.doa.productDao;
import com.OlShoping.pojo.product;


@WebServlet("/productServlet")
public class productServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	product p=new product();
	productDao pd=new productDao();
   
    public productServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String action=request.getParameter("action");
		if(action!=null&&action.equals("delete"))
		{

			int id=Integer.parseInt(request.getParameter("Pid")) ;
			boolean b=pd.deleteProduct(id);
			if(b)
			{
				response.sendRedirect("productServlet");	
			}

		}
		else if(action!=null && action.equals("edit"))
		{
			int id=Integer.parseInt(request.getParameter("Pid"));
			System.out.println(action+" Jada Dataa  :  "+request.getParameter("Pid"));
			product p=pd.getproductById(id);
			System.out.println("Data  "+p);
			session.setAttribute("pa", p);
			response.sendRedirect("UpdateProduct.jsp");
		}

		else 
		{
			List<product>li=pd.getlist();
			session.setAttribute("plist",li);
			response.sendRedirect("ProductList.jsp");
		}

		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("prodname"); 
		String category=request.getParameter("category");
		String quantity=request.getParameter("prodqty");
		String price=request.getParameter("prodprice");
		String description=request.getParameter("proddes");
		
		p.setProductname(name);
		p.setProductcatagory(category);
		p.setProductquantity(quantity);
		p.setProductprice(price);
		p.setProductdescription(description);
		
		
		boolean b=pd.addproduct(p);
		if(b)
		{
			response.sendRedirect("Success.jsp");
		}
		else
		{
			response.sendRedirect("Error.jsp");
		}
		
		
		
	}

}
