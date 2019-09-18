package com.OlShoping.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.OlShoping.config.DB_connection;
import com.OlShoping.pojo.user;

public class UserDao {
	Connection con=DB_connection.getconnection();

	public boolean adduser(user u)
	{
		String sql="insert into newuser values (?,?,?,?,?)";

		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,u.getName());
			ps.setString(2,u.getContact());
			ps.setString(3,u.getAddress());
			ps.setString(4,u.getEmail());
			ps.setString(5,u.getPass());
			
			int i=ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	public boolean deletuser(String emailid) 
	{
		String sql="delete from newuser where EMAIL=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, emailid);
			int i=ps.executeUpdate();
			System.out.println(" oPTION "+emailid+"   "+i);
			if(i>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;



	} 
	public boolean edituser(user u)
	{
		String sql="update newuser set name=?,contact=?,address=?,pass=? where email=?;";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,u.getName());
			ps.setString(2,u.getContact());
			ps.setString(3,u.getAddress());

			ps.setString(4,u.getPass());
			ps.setString(5,u.getEmail());
			
			int i=ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;

	}
	public List<user> getlist()
	{
		List<user> li=new ArrayList<>();
		String sql="select * from newuser";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				user u=new user();
				u.setName(rs.getString(1));
				u.setContact(rs.getString(2));
				u.setAddress(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setPass(rs.getString(5));
				

				li.add(u);
			}


			return li;
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return null;	
	}


	public user getUserById(String email)
	{
		user u=new user();
		String sql="select * from newuser where email=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,email);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				
				u.setName(rs.getString(1));
				u.setContact(rs.getString(2));
				u.setAddress(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setPass(rs.getString(5));
				

			}


			return u;
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return null;	
	}

		
	public user getLogin(String uname,String password) {
		String sql="SELECT email,pass FROM NEWUSER  where email=? and pass=?";
		user u=new user();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,uname);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				u.setEmail(rs.getString(1));
				u.setPass(rs.getString(2));
			}
			return u;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
