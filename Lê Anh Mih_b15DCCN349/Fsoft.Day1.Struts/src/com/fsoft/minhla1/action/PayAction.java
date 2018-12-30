package com.fsoft.minhla1.action;

import java.net.InetAddress;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.fsoft.minhla1.dao.InvoiceBookDAO;
import com.fsoft.minhla1.dao.InvoiceDAO;
import com.fsoft.minhla1.entities.Book;
import com.fsoft.minhla1.entities.User;
import com.fsoft.minhla1.model.Cart;

public class PayAction extends Action {
	Date date = new Date();
	private int invoiceID = 10;
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
//		String ipAddress = request.getHeader("X-FORWARDED-FOR");  
//		   if (ipAddress == null) {  
//		       ipAddress = request.getRemoteAddr();  
//		       System.out.println("A: "+ipAddress+"\n");
//		       System.out.println("B: "+request.getLocalAddr()+"\n");
//		       System.out.println(java.time.LocalTime.now());  
//		   } 
//		request.getSession(false).setAttribute("cart", new Cart());
		InvoiceDAO invoiceDao = new InvoiceDAO();
		InvoiceBookDAO invoiceBookDao = new InvoiceBookDAO();
		
		User user = (User) request.getSession().getAttribute("user");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		System.out.println("----------------------------------------------------------");
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			Calendar cal = Calendar.getInstance();  
			Timestamp sqlDate = new Timestamp(cal.getTimeInMillis());
			cart.getItems().forEach((book,interger) -> {
				System.out.println(book.getId() +" : " +interger);
			});
			
			System.out.println("userID: "+user.getId());
		System.out.println("----------------------------------------------------------");
		if(invoiceDao.addInvoice(user.getId(), sqlDate, 1)) {
			int i = invoiceDao.selectLateInvoice();
			cart.getItems().forEach((book,interger) -> {
				try {
					invoiceBookDao.addInvoiceBook(i, book.getId(), interger);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			return mapping.findForward("success");
		}else {
			return mapping.findForward("fail");
		}
		
		
		
		
	}
}
