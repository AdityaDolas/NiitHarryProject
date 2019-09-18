package com.OlShoping.config;

import java.sql.DriverManager;
import java.sql.Connection;

public class DB_connection {
	public static Connection getconnection()
	{
		Connection con=null;
		try {
			Class.forName("org.h2.Driver");
		  con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/rupali", "sa", "sa");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}


}



