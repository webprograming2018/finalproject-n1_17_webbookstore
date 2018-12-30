package com.fsoft.minhla1.form;

import org.apache.struts.action.ActionForm;

import com.fsoft.minhla1.entities.Book;

public class AddToCartForm extends ActionForm {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
