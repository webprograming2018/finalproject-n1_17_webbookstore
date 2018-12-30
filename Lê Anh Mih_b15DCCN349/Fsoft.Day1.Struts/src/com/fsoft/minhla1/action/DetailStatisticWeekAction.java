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

public class DetailStatisticWeekAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ArrayList<StatisticDetail> list = new ArrayList<>();
		Date d = new Date();
		int month = d.getMonth()+1;
		int date = d.getDate();
		int day;
		int hour = d.getHours();
		if(d.getDay()==0) {
			day=7;
		}else {
			day=d.getDay();
		}
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
		for(int i=date;i>z;i--) {
			ArrayList<StatisticDetail> l = new ArrayList<>();
			String y1=y+"-"+month+"-"+i +" "+ d.getHours() +":59:59";
			String y2=y+"-"+month+"-"+i  +" "+"0:0:0";
			System.out.println("y1: "+y1+"____ y2: "+y2 +" @: "+invoiceDao.getNumberRecordByDay(y1, y2));
			l = invoiceBookDao.detailRevenueByDay(y1, y2);
			for(int j=0;j<l.size();j++) {
				StatisticDetail sd= new StatisticDetail();
				sd.setNameBook(l.get(j).getNameBook());
				sd.setNumberOfBook(l.get(j).getNumberOfBook());
				list.add(sd);
			}
		}
		
		for(int i=0;i<list.size();i++) {
			System.out.println("$: "+ list.get(i).getNameBook()+"---"+list.get(i).getNumberOfBook());
		}
		request.setAttribute("list", list);
		return mapping.findForward("success");
	}
}
