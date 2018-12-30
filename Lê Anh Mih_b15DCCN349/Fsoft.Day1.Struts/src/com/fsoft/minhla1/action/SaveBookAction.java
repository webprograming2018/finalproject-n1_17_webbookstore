package com.fsoft.minhla1.action;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.fsoft.minhla1.dao.BookDAO;
import com.fsoft.minhla1.entities.Book;
import com.fsoft.minhla1.form.SaveBookForm;

public class SaveBookAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		System.out.println(request.getParameter("author"));
		SaveBookForm bookForm = (SaveBookForm) form;
		Book book = new Book();
		book.setId(bookForm.getId());
		book.setName(bookForm.getName());
		book.setAuthor(bookForm.getAuthor());
		book.setCategoryId(bookForm.getCategory());
		book.setIsbn(bookForm.getIsbn());
		book.setPrice(bookForm.getPrice());
		book.setPublisher(bookForm.getPublisher());
		File file = bookForm.getImage();
		if (file != null) {
			System.out.println(file.getAbsolutePath());
//			String fileName = file.getName();
//			Files.copy(Paths.get(file.getAbsolutePath()), Paths.get(FileHelper.RELATIVE_URL),
//					StandardCopyOption.REPLACE_EXISTING);
//			book.setImage(fileName);
//		} else {
//			book.setImage("bookstore-logo.jpg");
		}
		book.setImage("herewego.jpg");
		System.out.println(bookForm.getAuthor());
		BookDAO bookDAO = new BookDAO();
		if (bookDAO.saveBook(book) > 0) {
			return mapping.findForward("success");
		} else
			return mapping.findForward("fail");
	}
}
