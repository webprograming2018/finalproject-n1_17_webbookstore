package com.fsoft.minhla1.action;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.fsoft.minhla1.dao.InvoiceBookDAO;
import com.fsoft.minhla1.dao.InvoiceDAO;
import com.fsoft.minhla1.model.StatisticDetail;

public class DetailStatisticHourAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ArrayList<StatisticDetail> list = new ArrayList<>();
		Date d = new Date();
		int month = d.getMonth()+1;
		int date = d.getDate();
		int day = d.getDay();
		int hour = d.getHours();
		
		int z=date-day;
		int y =1900+d.getYear();
		InvoiceDAO invoiceDao = new InvoiceDAO();
		InvoiceBookDAO invoiceBookDao = new InvoiceBookDAO();
		
		String s1=y+"-"+month+"-"+d.getDate()  +" "+ d.getHours() +":59:59";
		String s2=y+"-"+month+"-"+d.getDate()  +" "+ d.getHours() +":0:0";
		String s3=y+"-"+month+"-%";
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println("-----------------------------------------------------------------------");
		
		list = invoiceBookDao.detailRvenueByHour(s1, s2);
		for(int i=0;i<list.size();i++) {
			System.out.println("$: "+ list.get(i).getNameBook()+"---"+list.get(i).getNumberOfBook());
		}
		request.setAttribute("list", list);
		return mapping.findForward("success");
	}
}
