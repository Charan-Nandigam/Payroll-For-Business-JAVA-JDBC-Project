package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JavaOracleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dbURL ="jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password ="123456";
		
		try {
			Connection connection = DriverManager.getConnection(dbURL,username,password);
			System.out.println("Connected to oracle server");
			
		}
		catch(SQLException e) {
			System.out.println("Opps error:");
			e.printStackTrace();
		}

	}

}
