package com.fsoft.minhla1.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.fsoft.minhla1.dao.BookDAO;
import com.fsoft.minhla1.dao.CategoryDAO;
import com.fsoft.minhla1.entities.Book;
import com.fsoft.minhla1.entities.Category;

public class BookDetailsAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			BookDAO bookDAO = new BookDAO();
			int id = Integer.parseInt(request.getParameter("id"));
			Book book = bookDAO.retrieveABook(id);
			if (book == null)
				return mapping.findForward("fail");
			CategoryDAO categoryDAO = new CategoryDAO();
			List<Category> categories = categoryDAO.getCategories();
			request.setAttribute("book", book);
			request.setAttribute("categories", categories);
			return mapping.findForward("success");
		} finally {

		}

	}
}
