package com.fsoft.minhla1.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.fsoft.minhla1.dao.BookDAO;
import com.fsoft.minhla1.entities.Book;
import com.fsoft.minhla1.form.SearchForm;

public class SearchAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SearchForm searchForm = (SearchForm) form;
		String query = searchForm.getQ();
		BookDAO bookDAO = new BookDAO();
		List<Book> result = bookDAO.justFind(query);
		request.setAttribute("results", result);
		return mapping.findForward("success");
	}
}
