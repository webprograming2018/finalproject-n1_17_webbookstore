package com.fsoft.minhla1.model;

import java.io.Serializable;
import java.util.HashMap;

public class ForStatistic implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nameBook;
	private int numberOfBook;
	private HashMap<String, Integer> listDetailNumberBook;
	
	public HashMap<String, Integer> getListDetailNumberBook() {
		return listDetailNumberBook;
	}
	public void setListDetailNumberBook(HashMap<String, Integer> listDetailNumberBook) {
		this.listDetailNumberBook = listDetailNumberBook;
	}
	public String getNameBook() {
		return nameBook;
	}
	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}
	public int getNumberOfBook() {
		return numberOfBook;
	}
	public void setNumberOfBook(int numberOfBook) {
		this.numberOfBook = numberOfBook;
	}
	private int numberInvoiceByHour;
	private int numberInvoiceByWeek;
	private int numberInvoiceByMonth;
	private int revenueByHour;
	private int revenueByWeek;
	private int revenueByMonth;
	public int getNumberInvoiceByHour() {
		return numberInvoiceByHour;
	}
	public void setNumberInvoiceByHour(int numberInvoiceByHour) {
		this.numberInvoiceByHour = numberInvoiceByHour;
	}
	public int getNumberInvoiceByWeek() {
		return numberInvoiceByWeek;
	}
	public void setNumberInvoiceByWeek(int numberInvoiceByWeek) {
		this.numberInvoiceByWeek = numberInvoiceByWeek;
	}
	public int getNumberInvoiceByMonth() {
		return numberInvoiceByMonth;
	}
	public void setNumberInvoiceByMonth(int numberInvoiceByMonth) {
		this.numberInvoiceByMonth = numberInvoiceByMonth;
	}
	public int getRevenueByHour() {
		return revenueByHour;
	}
	public void setRevenueByHour(int revenueByHour) {
		this.revenueByHour = revenueByHour;
	}
	public int getRevenueByWeek() {
		return revenueByWeek;
	}
	public void setRevenueByWeek(int revenueByWeek) {
		this.revenueByWeek = revenueByWeek;
	}
	public int getRevenueByMonth() {
		return revenueByMonth;
	}
	public void setRevenueByMonth(int revenueByMonth) {
		this.revenueByMonth = revenueByMonth;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
