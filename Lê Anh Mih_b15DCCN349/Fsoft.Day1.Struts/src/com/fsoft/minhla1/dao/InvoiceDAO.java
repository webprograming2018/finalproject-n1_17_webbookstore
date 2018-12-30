package com.fsoft.minhla1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.fsoft.minhla1.utils.DbHelper;

public class InvoiceDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public boolean addInvoice(int accountId,Timestamp date,int ischeckout) throws ClassNotFoundException, SQLException {
		try {
			String sql="INSERT INTO INVOICE (ACCOUNT_ID,CREATEDATE,ISCHECKEDOUT) values(?,?,?)";
			connection = DBConnector.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, accountId);
			preparedStatement.setTimestamp(2, date);
			preparedStatement.setInt(3, 1);
			return preparedStatement.executeUpdate() > 0;
		} finally {
			DbHelper.dispose(connection, preparedStatement);
		}
	}
	
	public int selectLateInvoice() throws ClassNotFoundException, SQLException {
		try {
		int i = 0;
		String sql="SELECT COUNT(*) AS INVOICELATE FROM INVOICE";
		connection = DBConnector.getConnection();
		preparedStatement = connection.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()) {
			i = rs.getInt("INVOICELATE");
		}
		return i;
		} finally {
			DbHelper.dispose(connection, preparedStatement);
		}
	}
	
	public int getNumberRecordByHour(String s1, String s2) throws ClassNotFoundException, SQLException {
		try {
			int i = 0;
			String sql="select count(*) from invoice where createdate <= ? and createdate >= ?";
			connection = DBConnector.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, s1);
			preparedStatement.setString(2, s2);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				i = rs.getInt("count(*)");
			}
			return i;
			} finally {
				DbHelper.dispose(connection, preparedStatement);
			}
	}
	public int getNumberRecordByDay(String s1,String s2) throws ClassNotFoundException, SQLException {
		try {
			int i = 0;
			String sql="select count(*) from invoice where createdate <=? and createdate >=?";
			connection = DBConnector.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, s1);
			preparedStatement.setString(2, s2);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				i = rs.getInt("count(*)");
			}
			return i;
			} finally {
				DbHelper.dispose(connection, preparedStatement);
			}
	}
	public int getNumberRecordByMonth(String s) throws ClassNotFoundException, SQLException {
		try {
			int i = 0;
			String sql="select count(*) from invoice where createdate like ?";
			connection = DBConnector.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, s);			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				i = rs.getInt("count(*)");
			}
			return i;
			} finally {
				DbHelper.dispose(connection, preparedStatement);
			}
	}
	
	
}
