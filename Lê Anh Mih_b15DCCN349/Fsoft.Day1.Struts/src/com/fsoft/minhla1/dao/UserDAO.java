package com.fsoft.minhla1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fsoft.minhla1.entities.User;
import com.fsoft.minhla1.utils.DbHelper;

public class UserDAO {
	private PreparedStatement pStatement;
	private Connection connection;

	public User login(String username, String password) throws ClassNotFoundException, SQLException {
		connection = DBConnector.getConnection();
		try {
			User user = null;
			String sql = "SELECT * FROM ACCOUNT WHERE (USERNAME=? AND PASSWORD=?) OR (EMAIL=? AND PASSWORD=?)";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, username);
			pStatement.setString(2, password);
			pStatement.setString(3, username);
			pStatement.setString(4, password);
			ResultSet resultSet = pStatement.executeQuery();
			if (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setEmail(resultSet.getString("email"));
				user.setAddress(resultSet.getString("address"));
				user.setDescription(resultSet.getString("description"));
				user.setType(resultSet.getInt("type"));
				user.setCreateDate(resultSet.getDate("create_date"));
			}
			return user;
		} finally {
			DbHelper.dispose(connection, pStatement);
		}
	}

	public int save(User user) throws ClassNotFoundException, SQLException {
		connection = DBConnector.getConnection();
		try {
			if (isExists(user.getUsername())) {
				String sql = "UPDATE ACCOUNT SET password=?,email=?,address=?,name=? WHERE username=?";
				pStatement = connection.prepareStatement(sql);
				pStatement.setString(1, user.getPassword());
				pStatement.setString(2, user.getEmail());
				pStatement.setString(3, user.getAddress());
				pStatement.setString(4, user.getName());
				pStatement.setString(5, user.getUsername());
			} else {
				String sql = "INSERT INTO ACCOUNT(password,email,address,name,username) VALUES(?,?,?,?,?)";
				pStatement = connection.prepareStatement(sql);
				pStatement.setString(1, user.getPassword());
				pStatement.setString(2, user.getEmail());
				pStatement.setString(3, user.getAddress());
				pStatement.setString(4, user.getName());
				pStatement.setString(5, user.getUsername());
			}
			return pStatement.executeUpdate();
		} finally {
			DbHelper.dispose(connection, pStatement);
		}
	}

	private boolean isExists(String username) throws ClassNotFoundException, SQLException {
		connection = DBConnector.getConnection();
		try {
			String sql = "SELECT * FROM ACCOUNT WHERE USERNAME=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, username);
			ResultSet resultSet = pStatement.executeQuery();
			return resultSet.next();
		} finally {
			DbHelper.dispose(connection, pStatement);
		}
	}
}
