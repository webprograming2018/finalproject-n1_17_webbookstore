package com.fsoft.minhla1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fsoft.minhla1.entities.Book;
import com.fsoft.minhla1.utils.DbHelper;

public class BookDAO {
	private Connection connection;
	private PreparedStatement statement;

	public List<Book> retrieveAllBook() throws ClassNotFoundException, SQLException {
		try {
			ArrayList<Book> books = new ArrayList<>();
			String sql = "SELECT * FROM BOOK";
			connection = DBConnector.getConnection();
			statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			Book book;
			while (rs.next()) {
				book = new Book();
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setId(rs.getInt("id"));
				book.setImage(rs.getString("image"));
				book.setIsbn(rs.getString("isbn"));
				book.setPrice(rs.getInt("price"));
				book.setPublisher(rs.getString("publisher"));
				book.setReleaseDate(rs.getDate("release_date"));
				books.add(book);
			}
			return books;
		} finally {
			DbHelper.dispose(connection, statement);
		}
	}

	public List<Book> retrieveBooksByCategory(int categoryId) throws ClassNotFoundException, SQLException {
		try {
			ArrayList<Book> books = new ArrayList<>();
			String sql = "SELECT * FROM BOOK WHERE CATEGORY_ID=?";
			connection = DBConnector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, categoryId);
			ResultSet rs = statement.executeQuery();
			Book book;
			while (rs.next()) {
				book = new Book();
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setId(rs.getInt("id"));
				book.setImage(rs.getString("image"));
				book.setIsbn(rs.getString("isbn"));
				book.setPrice(rs.getInt("price"));
				book.setPublisher(rs.getString("publisher"));
				book.setReleaseDate(rs.getDate("release_date"));
				books.add(book);
			}
			return books;
		} finally {
			DbHelper.dispose(connection, statement);
		}
	}

	public List<Book> findByName(String input) throws ClassNotFoundException, SQLException {
		try {
			ArrayList<Book> books = new ArrayList<>();
			String sql = "SELECT * FROM BOOK WHERE NAME LIKE ?";
			connection = DBConnector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, "%" + input + "%");
			ResultSet rs = statement.executeQuery();
			Book book;
			while (rs.next()) {
				book = new Book();
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setId(rs.getInt("id"));
				book.setImage(rs.getString("image"));
				book.setIsbn(rs.getString("isbn"));
				book.setPrice(rs.getInt("price"));
				book.setPublisher(rs.getString("publisher"));
				book.setReleaseDate(rs.getDate("release_date"));
				books.add(book);
			}
			return books;
		} finally {
			DbHelper.dispose(connection, statement);
		}
	}

	public List<Book> findByAuthor(String input) throws ClassNotFoundException, SQLException {
		try {
			ArrayList<Book> books = new ArrayList<>();
			String sql = "SELECT * FROM BOOK WHERE AUTHOR LIKE ?";
			connection = DBConnector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1,  "%" + input + "%");
			ResultSet rs = statement.executeQuery();
			Book book;
			while (rs.next()) {
				book = new Book();
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setId(rs.getInt("id"));
				book.setImage(rs.getString("image"));
				book.setIsbn(rs.getString("isbn"));
				book.setPrice(rs.getInt("price"));
				book.setPublisher(rs.getString("publisher"));
				book.setReleaseDate(rs.getDate("release_date"));
				books.add(book);
			}
			return books;
		} finally {
			DbHelper.dispose(connection, statement);
		}
	}

	public List<Book> findByPublisher(String input) throws ClassNotFoundException, SQLException {
		try {
			ArrayList<Book> books = new ArrayList<>();
			String sql = "SELECT * FROM BOOK WHERE PUBLISHER LIKE ?";
			connection = DBConnector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1,  "%" + input + "%");
			ResultSet rs = statement.executeQuery();
			Book book;
			while (rs.next()) {
				book = new Book();
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setId(rs.getInt("id"));
				book.setImage(rs.getString("image"));
				book.setIsbn(rs.getString("isbn"));
				book.setPrice(rs.getInt("price"));
				book.setPublisher(rs.getString("publisher"));
				book.setReleaseDate(rs.getDate("release_date"));
				books.add(book);
			}
			return books;
		} finally {
			DbHelper.dispose(connection, statement);
		}
	}

	public List<Book> justFind(String input) throws ClassNotFoundException, SQLException {
		try {
			ArrayList<Book> books = new ArrayList<>();
			String sql = "SELECT * FROM BOOK WHERE publisher LIKE ? OR AUTHOR LIKE ? OR NAME LIKE ?";
			connection = DBConnector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1,  "%" + input + "%");
			statement.setString(2,  "%" + input + "%");
			statement.setString(3,  "%" + input + "%");
			ResultSet rs = statement.executeQuery();
			Book book;
			while (rs.next()) {
				book = new Book();
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setId(rs.getInt("id"));
				book.setImage(rs.getString("image"));
				book.setIsbn(rs.getString("isbn"));
				book.setPrice(rs.getInt("price"));
				book.setPublisher(rs.getString("publisher"));
				book.setReleaseDate(rs.getDate("release_date"));
				books.add(book);
			}
			return books;
		} finally {
			DbHelper.dispose(connection, statement);
		}
	}

	public Book retrieveABook(int id) throws SQLException, ClassNotFoundException {
		Book book = null;
		try {
			String sql = "SELECT * FROM BOOK WHERE ID=?";
			connection = DBConnector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				book = new Book();
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setId(rs.getInt("id"));
				book.setImage(rs.getString("image"));
				book.setIsbn(rs.getString("isbn"));
				book.setPrice(rs.getInt("price"));
				book.setPublisher(rs.getString("publisher"));
				book.setReleaseDate(rs.getDate("release_date"));
			}
			return book;
		} finally {
			DbHelper.dispose(connection, statement);
		}
	}

	public int saveBook(Book book) throws ClassNotFoundException, SQLException {
		try {
			if (isExist(book.getId())) {
				String sql = "UPDATE BOOK SET NAME=?,AUTHOR=?,IMAGE=?,ISBN=?,PRICE=?,PUBLISHER=?,RELEASE_DATE=? WHERE ID=?";
				connection = DBConnector.getConnection();
				statement = connection.prepareStatement(sql);
				statement.setString(1, book.getName());
				statement.setString(2, book.getAuthor());
				statement.setString(3, book.getImage());
				statement.setString(4, book.getIsbn());
				statement.setInt(5, book.getPrice());
				statement.setString(6, book.getPublisher());
				statement.setDate(7, book.getReleaseDate());
				statement.setInt(8, book.getId());
			} else {
				String sql = "INSERT INTO BOOK(name,author,image,isbn,price,publisher,release_date) VALUES(?,?,?,?,?,?,?)";
				connection = DBConnector.getConnection();
				statement = connection.prepareStatement(sql);
				statement.setString(1, book.getName());
				statement.setString(2, book.getAuthor());
				statement.setString(3, book.getImage());
				statement.setString(4, book.getIsbn());
				statement.setInt(5, book.getPrice());
				statement.setString(6, book.getPublisher());
				statement.setDate(7, book.getReleaseDate());
			}
			return statement.executeUpdate();
		} finally {
			DbHelper.dispose(connection, statement);
		}

	}

	public int deleteBook(int id) throws ClassNotFoundException, SQLException {
		try {
			connection = DBConnector.getConnection();
			String sql = "DELETE FROM BOOK WHERE id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			return statement.executeUpdate();
		} finally {
			DbHelper.dispose(connection, statement);
		}
	}

	private boolean isExist(int id) throws SQLException, ClassNotFoundException {
		try {
			String sql = "SELECT * FROM BOOK WHERE id=?";
			connection = DBConnector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return true;
			}
			return false;
		} finally {
			DbHelper.dispose(connection, statement);
		}
	}
}
