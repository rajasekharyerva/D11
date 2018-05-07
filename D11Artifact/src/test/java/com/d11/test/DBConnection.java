package com.d11.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public static void main(String[] argv) {
		System.out.println("-------- MySQL JDBC Connection Testing ------");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}
		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mysql","root", "Passwd@123");
			Statement stmt=connection.createStatement();  
			//ResultSet rs=stmt.executeQuery("select * from Persons");  
			ResultSet rs=stmt.executeQuery("select * from Students inner join Marks on Students.FirstName = Marks.FirstName where Marks = (select max(Marks) from Marks)"); 
			while(rs.next())  
				//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3) + rs.getString(4) + rs.getString(5));  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2));  
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} /*else {
			//System.out.println("Failed to make connection!");
		}*/
	}
}
