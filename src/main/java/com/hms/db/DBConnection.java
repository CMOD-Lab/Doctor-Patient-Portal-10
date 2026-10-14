package com.hms.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * DBConnection - Provides JDBC connection to MySQL database.
 * Updated to use com.mysql.cj.jdbc.Driver (MySQL Connector/J 8.x+).
 */
public class DBConnection {

	private static Connection conn;
	
	public static Connection getConn() {
		
		try {
			
			// Load the MySQL JDBC driver (com.mysql.cj.jdbc.Driver for MySQL 8.x+)
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Create a connection with timezone and SSL parameters for Java 17 compatibility
			conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/hospital?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true",
				"root",
				"wasim"
			);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
