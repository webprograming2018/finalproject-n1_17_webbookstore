package com.fsoft.minhla1.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.fsoft.minhla1.dao.BookDAO;
import com.fsoft.minhla1.dao.DBConnector;
import com.fsoft.minhla1.dao.UserDAO;
import com.fsoft.minhla1.entities.Book;

public class DbHelper {
	public static void dispose(Connection connection, Statement statement) {
		try {
			if (connection != null) {
				/* connection.close(); */

			}
			if (statement != null) {
				statement.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void main(String[] args) {
		BookDAO bookDao=new BookDAO();
		try {
			Book book=bookDao.retrieveABook(1);
			System.out.println(book.getName());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
