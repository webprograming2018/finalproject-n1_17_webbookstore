package com.fsoft.minhla1.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if (getUsername() == null || ("".equals(getUsername()))||getPassword()==null||"".equals(getPassword())) {
			errors.add("login.fields.missed", new ActionMessage("login.fields.missed"));
		}
		return errors;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		username = "";
		password = "";
	}
}
