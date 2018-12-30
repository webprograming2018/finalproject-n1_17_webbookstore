package com.fsoft.minhla1.action;

import java.time.LocalTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.fsoft.minhla1.dao.UserDAO;
import com.fsoft.minhla1.entities.IpAddress;
import com.fsoft.minhla1.entities.User;
import com.fsoft.minhla1.form.LoginForm;
import com.fsoft.minhla1.model.Cart;

public class LoginAction extends Action {
	IpAddress ipAddress = new IpAddress();
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
	    HttpServletResponse response) throws Exception {
		LoginForm loginForm = (LoginForm) form;
		UserDAO userDAO = new UserDAO();
		User user = userDAO.login(loginForm.getUsername(), loginForm.getPassword());
		if (user != null) {
			HttpSession session = request.getSession(false);
			session.setAttribute("user", user);
			Cart cart = new Cart();
			session.setAttribute("cart", cart);
			
			
			String ip = request.getRemoteAddr();
			LocalTime ltime = LocalTime.now();
			String time=ltime.toString();
			ipAddress.addIP(ip, time);
			session.setAttribute("ip", ipAddress);
			System.out.println("so luog client truy cap: "+ ipAddress.getListIP().size());
			return mapping.findForward("success");
		} else
			return mapping.findForward("fail");
	}

}
