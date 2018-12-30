package com.fsoft.minhla1.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.fsoft.minhla1.dao.BookDAO;
import com.fsoft.minhla1.entities.Book;

public class SeeAllBookAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		BookDAO bookDAO=new BookDAO();
		List<Book> books=bookDAO.retrieveAllBook();
		session.setAttribute("books", books);
		// TODO Auto-generated method stub
	return mapping.findForward("success");
	}
}
