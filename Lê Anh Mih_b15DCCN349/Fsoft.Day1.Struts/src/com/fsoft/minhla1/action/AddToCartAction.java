package com.fsoft.minhla1.action;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.fsoft.minhla1.dao.BookDAO;
import com.fsoft.minhla1.entities.Book;
import com.fsoft.minhla1.form.AddToCartForm;
import com.fsoft.minhla1.model.Cart;

public class AddToCartAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		AddToCartForm itemForm = (AddToCartForm) form;

		int id = itemForm.getId();
		HttpSession session = request.getSession(false);
		Cart cart = (Cart) session.getAttribute("cart");

		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		BookDAO bookDAO = new BookDAO();

		Book book = bookDAO.retrieveABook(id);

		cart.addItem(book);

		Set<Book> bookSet = cart.getItems().keySet();

		return mapping.findForward("success");
	}
}
