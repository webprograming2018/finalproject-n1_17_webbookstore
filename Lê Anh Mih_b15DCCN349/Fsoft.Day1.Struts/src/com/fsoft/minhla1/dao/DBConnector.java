package com.fsoft.minhla1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private static Connection connection;
	private static final String url = "jdbc:mysql://localhost/bookstore";
	private static final String username = "root";
	private static final String password = "root";

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		if (connection == null	|| connection.isClosed()) {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		}
		return connection;
	}
}
