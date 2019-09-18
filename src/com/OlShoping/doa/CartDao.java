package com.OlShoping.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.OlShoping.config.DB_connection;
import com.OlShoping.pojo.Cart;

public class CartDao {

	Connection con=DB_connection.getconnection();
	
	public boolean addToCart(int pid,String email) {
		String sql="insert into cart(pid,email) values(?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setString(2, email);
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public List<Cart> getCartList(String email){
		String sql="select PRODUCT_NAME ,PRODUCT_PRICE, PRODUCT_DESCRIPTION    from product p  inner join cart c on p.PRODUCT_ID =c.pid where email=?";
		List<Cart> cl=new ArrayList<Cart>();
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Cart c=new Cart();
				c.setPname(rs.getString(1));
				c.setPrice(rs.getDouble(2));
				c.setDescription(rs.getString(3));
				cl.add(c);
			}
			return cl;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
