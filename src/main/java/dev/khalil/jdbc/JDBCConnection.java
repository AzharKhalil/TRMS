package dev.khalil.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCConnection {
	
	
	
	
	
	public static Connection conn = null;
	static Properties pros = new Properties();
	public static Connection getConnection() {
	
	if(conn== null) {
	try {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		FileInputStream input = new FileInputStream(JDBCConnection.class.getClassLoader().getResource("connection.properties").getFile());
		pros.load(input);
		
		String url = pros.getProperty("url");
		String username = pros.getProperty("username");
		String password = pros.getProperty("password");
		
		
		conn= DriverManager.getConnection(url, username, password);
		return conn;
		
	} catch (Exception e) {
		// TODO: handle exception
	}	
	}
	
	
	return conn;
	}
	
	
}
