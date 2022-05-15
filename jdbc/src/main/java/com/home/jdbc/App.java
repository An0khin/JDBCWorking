package com.home.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * JDBC only for reading sql tables
 *
 */
public class App {
	public static void main(String[] args) {
		App app = new App();
		app.test();
	}
	
	public void test() {
			String url = "jdbc:mysql://localhost:3306/sqlisevil";
			String login = "root";
			String password = "1234";
			
			try(Connection con = DriverManager.getConnection(url, login, password)) {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM drinks"); //SQL request
				while(rs.next()) { //checking exist next row
					String str = rs.getString(6); //get 6 column of row as string
					System.out.println(str);
				}
				rs.close();
				stmt.close();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
	}
}