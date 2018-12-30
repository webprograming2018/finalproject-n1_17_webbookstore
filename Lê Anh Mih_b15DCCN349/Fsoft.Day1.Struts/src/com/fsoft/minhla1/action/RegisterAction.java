package com.fsoft.minhla1.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.fsoft.minhla1.dao.UserDAO;
import com.fsoft.minhla1.entities.User;
import com.fsoft.minhla1.form.RegisterForm;

public class RegisterAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		UserDAO userDAO = new UserDAO();
		User user = new User();
		RegisterForm rForm = (RegisterForm) form;
		user.setName(rForm.getName());
		user.setUsername(rForm.getUsername());
		user.setPassword(rForm.getPassword());
		user.setAddress(rForm.getAddress());
		user.setEmail(rForm.getEmail());
		if (userDAO.save(user) > 0) {
			return mapping.findForward("success");
		}
		return mapping.findForward("fail");
	}
}
