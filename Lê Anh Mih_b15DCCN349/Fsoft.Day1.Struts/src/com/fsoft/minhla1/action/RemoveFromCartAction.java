package com.fsoft.minhla1.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.fsoft.minhla1.dao.BookDAO;
import com.fsoft.minhla1.entities.Book;
import com.fsoft.minhla1.model.Cart;

public class RemoveFromCartAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Cart cart = (Cart) request.getSession(false).getAttribute("cart");
		BookDAO bookDAO = new BookDAO();
		try {
			int bookId = Integer.parseInt(request.getParameter("id"));
			Book book = bookDAO.retrieveABook(bookId);
			cart.removeItem(book);
			
		} catch (Exception ex) {
			return mapping.findForward("success");
		}
		return mapping.findForward("success");
	}
}
