package com.OlShoping.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.OlShoping.config.DB_connection;
import com.OlShoping.pojo.product;

public class productDao {
	private static final String Pid = null;
	Connection con=DB_connection.getconnection();
	public boolean addproduct(product p)
	{

		String sql="insert into product (product_name,category,quantity,product_price,product_description) values(?,?,?,?,?)";
		try 
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,p.getProductname());
			ps.setString(2, p.getProductcatagory());
			ps.setString(3, p.getProductquantity());
			ps.setString(4, p.getProductprice());
			ps.setString(5, p.getProductdescription());
			int i=ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
			return false;
		

	}
	public boolean deleteProduct(int id)
	{
		String sql="delete from product where PRODUCT_ID =?";
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,id);
			int a=ps.executeUpdate();
			System.out.println("result"+a);
			if(a>0)
			{
				return true;
				
			}
				return false;
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean editProduct(product p)
	{
		String sql="update PRODUCT set  PRODUCT_NAME=?,  CATEGORY=?, QUANTITY=?, PRODUCT_PRICE=?, PRODUCT_DESCRIPTION=? where PRODUCT_ID=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,p.getProductname());
			ps.setString(2, p.getProductcatagory());
			ps.setString(3, p.getProductquantity());
			ps.setString(4,p.getProductprice());
			ps.setString(5,p.getProductdescription());
			ps.setInt(6, p.getPid());
			int i =ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
			return false;
		}
		catch (Exception e) {
	e.printStackTrace();
		}
		return false;
	}
	
	public product getproductById(int Pid) {
		String sql="select * from product where PRODUCT_ID=? ";
		try {
			product p=new product();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, Pid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				p.setPid(rs.getInt(1));
				p.setProductname(rs.getString(2));
				p.setProductcatagory(rs.getString(3));
				p.setProductquantity(rs.getString(4));
				p.setProductprice(rs.getString(5));
				p.setProductdescription(rs.getString(6));

				
			}
			return p;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public List<product>  getlist()
	{ 
		List<product> li=new ArrayList<>();
		String sql="SELECT * FROM PRODUCT ";
		
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
				{
				product p=new product();
				p.setPid(rs.getInt(1));
				p.setProductname(rs.getString(2));
				p.setProductcatagory(rs.getString(3));
				p.setProductquantity(rs.getString(4));
				p.setProductprice(rs.getString(5));
				p.setProductdescription(rs.getString(6));
				li.add(p);
				System.out.println(p);
			
			}
			return li;
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
			
			
		}
	public List<String> getcategory()
	{
		List<String> li=new ArrayList<>();
		String sql=" select  distinct CATEGORY  from PRODUCT";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				li.add(rs.getString(1));
			}
			return li;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		new productDao().getproductById(7);
	}
	}

