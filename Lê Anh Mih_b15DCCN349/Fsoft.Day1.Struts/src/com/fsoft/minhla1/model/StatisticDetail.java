package com.fsoft.minhla1.model;

import java.io.Serializable;

public class StatisticDetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nameBook;
	private int numberOfBook;
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
	
	
}
