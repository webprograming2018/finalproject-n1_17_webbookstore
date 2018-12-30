package com.fsoft.minhla1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fsoft.minhla1.model.ForStatistic;
import com.fsoft.minhla1.model.StatisticDetail;
import com.fsoft.minhla1.utils.DbHelper;
import com.lowagie.text.List;

public class InvoiceBookDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public boolean addInvoiceBook(int invoiceId, int invoiceBookId,int number) throws ClassNotFoundException, SQLException {
		try {
		String sql ="INSERT INTO INVOICE_BOOKS(INVOICE_ID,INVOICE_BOOK_ID,NUMBER) VALUES(?,?,?)";
		connection = DBConnector.getConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, invoiceId);
		preparedStatement.setInt(2, invoiceBookId);
		preparedStatement.setInt(3, number);
		return preparedStatement.executeUpdate() > 0;
		} finally {
			DbHelper.dispose(connection, preparedStatement);
		}
	}
	public int revenueByHour(String s1,String s2) throws ClassNotFoundException, SQLException {
		try {
			int i = 0;
			int j=0;
			int s=0;
			String sql="select INVOICE_BOOK_ID, count(INVOICE_ID), PRICE FROM invoice as inv INNER JOIN invoice_books as inv_b ON inv.id=inv_b.INVOICE_ID INNER join book as b on b.id=inv_b.invoice_book_id Where inv.CREATEDATE  <= ? and inv.createdate >= ? group by invoice_book_id";
			connection = DBConnector.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, s1);
			preparedStatement.setString(2, s2);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				i = rs.getInt("count(INVOICE_ID)");
				j=rs.getInt("PRICE");
				s+=(i*j);
			}
			return s;
			} finally {
				DbHelper.dispose(connection, preparedStatement);
			}
	}
	public int revenueByDay(String s1, String s2) throws ClassNotFoundException, SQLException {

		try {
			int i = 0;
			int j=0;
			int s=0;
			String sql="select INVOICE_BOOK_ID, count(INVOICE_ID), PRICE FROM invoice as inv INNER JOIN invoice_books as inv_b ON inv.id=inv_b.INVOICE_ID INNER join book as b on b.id=inv_b.invoice_book_id Where inv.CREATEDATE  <= ? and inv.createdate >= ? group by invoice_book_id";
			connection = DBConnector.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, s1);
			preparedStatement.setString(2, s2);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				i = rs.getInt("count(INVOICE_ID)");
				j=rs.getInt("PRICE");
				s+=(i*j);
			}
			return s;
			} finally {
				DbHelper.dispose(connection, preparedStatement);
			}
	}
	public int revenueByMonth(String s1) throws ClassNotFoundException, SQLException {
		try {
			int i = 0;
			int j=0;
			int s=0;
			String sql="select INVOICE_BOOK_ID, count(INVOICE_ID),PRICE FROM invoice as inv INNER JOIN invoice_books as inv_b ON inv.id=inv_b.INVOICE_ID INNER join book as b on b.id=inv_b.invoice_book_id Where inv.CREATEDATE like ? group by invoice_book_id";
			connection = DBConnector.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, s1);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				i = rs.getInt("count(INVOICE_ID)");
				j=rs.getInt("PRICE");
				s+=(i*j);
			}
			return s;
			} finally {
				DbHelper.dispose(connection, preparedStatement);
			}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public ArrayList<StatisticDetail> detailRvenueByHour(String s1,String s2) throws ClassNotFoundException, SQLException {
		ArrayList<StatisticDetail> list = new ArrayList<>();
		try {
			String sql="select INVOICE_BOOK_ID, count(INVOICE_ID), NAME FROM invoice as inv INNER JOIN invoice_books as inv_b ON inv.id=inv_b.INVOICE_ID INNER join book as b on b.id=inv_b.invoice_book_id Where inv.CREATEDATE  <= ? and inv.createdate >= ? group by invoice_book_id";
			connection = DBConnector.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, s1);
			preparedStatement.setString(2, s2);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				int a=rs.getInt("count(INVOICE_ID)");
				String b=rs.getString("NAME");
				StatisticDetail sd= new StatisticDetail();
				sd.setNumberOfBook(a);
				sd.setNameBook(b);
				list.add(sd);
			}
			return list;
			} finally {
				DbHelper.dispose(connection, preparedStatement);
			}
	}
	public ArrayList<StatisticDetail> detailRevenueByDay(String s1, String s2) throws ClassNotFoundException, SQLException {
		ArrayList<StatisticDetail> list = new ArrayList<>();
		try {
			String sql="select INVOICE_BOOK_ID, count(INVOICE_ID), NAME FROM invoice as inv INNER JOIN invoice_books as inv_b ON inv.id=inv_b.INVOICE_ID INNER join book as b on b.id=inv_b.invoice_book_id Where inv.CREATEDATE  <= ? and inv.createdate >= ? group by invoice_book_id";
			connection = DBConnector.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, s1);
			preparedStatement.setString(2, s2);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				int a=rs.getInt("count(INVOICE_ID)");
				String b=rs.getString("NAME");
				StatisticDetail sd= new StatisticDetail();
				sd.setNumberOfBook(a);
				sd.setNameBook(b);
				list.add(sd);
			}
			return list;
			} finally {
				DbHelper.dispose(connection, preparedStatement);
			}
	}
	public ArrayList<StatisticDetail> detailRevenueByMonth(String s1) throws ClassNotFoundException, SQLException {
		ArrayList<StatisticDetail> list = new ArrayList<>();
		try {
			String sql="select INVOICE_BOOK_ID, count(INVOICE_ID),NAME FROM invoice as inv INNER JOIN invoice_books as inv_b ON inv.id=inv_b.INVOICE_ID INNER join book as b on b.id=inv_b.invoice_book_id Where inv.CREATEDATE like ? group by invoice_book_id";
			connection = DBConnector.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, s1);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				int a=rs.getInt("count(INVOICE_ID)");
				String b=rs.getString("NAME");
				StatisticDetail sd= new StatisticDetail();
				sd.setNumberOfBook(a);
				sd.setNameBook(b);
				list.add(sd);
			}
			return list;
			} finally {
				DbHelper.dispose(connection, preparedStatement);
			}
	}
}
