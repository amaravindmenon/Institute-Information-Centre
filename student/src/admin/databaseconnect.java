package admin;

import java.sql.*;

import javax.swing.JOptionPane;

public class databaseconnect {
	
	final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	
	final static String DB_URL = "jdbc:mysql://localhost:8889/student?serverTimezone=UTC";
	
	final static String user = "root";
	final static String pass = "root";
	
	public static Connection connection() {
		
		try {
			Class.forName(JDBC_DRIVER);
			
			Connection conn = DriverManager.getConnection(DB_URL,user,pass);
			
			return conn;
		}
		catch(ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}
}
