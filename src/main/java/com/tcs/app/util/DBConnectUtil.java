package com.tcs.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectUtil {
	

	public static String dbUrl = "jdbc:mysql://localhost/devquaddb";
	public static String userName = "root";
	public static String password = "devquad";
	
	
	public static Connection getDBConnection() {
		Connection conn = null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 conn = DriverManager.getConnection(dbUrl, userName, password);
		 
		}catch (SQLException e) {
			System.out.println("SQLException : " +e);
		}catch(ClassNotFoundException c) {
			System.out.println("ClassNotFoundException : "+c);
		}
		
		return conn;
		
	}

}
