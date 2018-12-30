package com.fsoft.minhla1.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Invoice implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int id;
	public int book_id;
	public Timestamp createDate;
	public int ischeckedout;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public int getIscheckout() {
		return ischeckedout;
	}
	public void setIscheckout(int ischeckedout) {
		this.ischeckedout = ischeckedout;
	}
	
}
