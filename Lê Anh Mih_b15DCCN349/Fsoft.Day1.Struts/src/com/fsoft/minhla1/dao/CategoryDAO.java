package com.fsoft.minhla1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fsoft.minhla1.entities.Category;
import com.fsoft.minhla1.utils.DbHelper;

public class CategoryDAO {
	private Connection connection;
	private PreparedStatement statement;

	public List<Category> getCategories() throws SQLException, ClassNotFoundException {
		try {
			connection = DBConnector.getConnection();
			String sql = "SELECT * FROM CATEGORY";
			statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			List<Category> categories = new ArrayList<Category>();
			Category category = null;
			while (rs.next()) {
				category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setDescription(rs.getString("description"));
				category.setCreateDate(rs.getDate("create_date"));
				categories.add(category);
			}
			return categories;
		} finally {
			DbHelper.dispose(connection, statement);
		}
	}
}
