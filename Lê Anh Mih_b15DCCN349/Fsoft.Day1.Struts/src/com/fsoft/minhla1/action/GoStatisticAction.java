package com.fsoft.minhla1.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.fsoft.minhla1.dao.InvoiceBookDAO;
import com.fsoft.minhla1.dao.InvoiceDAO;
import com.fsoft.minhla1.model.ForStatistic;

public class GoStatisticAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Date d = new Date();
		int month = d.getMonth()+1;
		int date = d.getDate();
		int day;
		if(d.getDay()==0) {
			day=7;
		}else {
			day=d.getDay();
		}
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
		int numberInvoiceByHour=invoiceDao.getNumberRecordByHour(s1,s2);
		int numberInvoiceByWeek=0;
		for(int i=date;i>z;i--) {
			String y1=y+"-"+month+"-"+i +" "+ d.getHours() +":59:59";
			String y2=y+"-"+month+"-"+i  +" "+"0:0:0";
			System.out.println("y1: "+y1+"____ y2: "+y2 +" @: "+invoiceDao.getNumberRecordByDay(y1, y2));
			numberInvoiceByWeek+=invoiceDao.getNumberRecordByDay(y1,y2);
		}
		int numberInvoiceByMonth = invoiceDao.getNumberRecordByMonth(s3);
		System.out.println("-----------------------------------------------------------------------");
		int revenueByHour = invoiceBookDao.revenueByHour(s1,s2);
		int revenueByWeek=0;
		for(int i=date;i>=z;i--) {
			String y1=y+"-"+d.getMonth()+"-"+i  +" "+d.getHours() + ":59:59";
			String y2=y+"-"+d.getMonth()+"-"+i  +" "+ "0:0:0";
			System.out.println("y1: "+y1+"____ y2: "+y2+" @: "+invoiceBookDao.revenueByDay(y1, y2));
			revenueByWeek+=invoiceBookDao.revenueByDay(y1,y2);
		}
		int revenueByMonth=invoiceBookDao.revenueByMonth(s3);
		System.out.println(numberInvoiceByHour+"-"+numberInvoiceByWeek+"-"+numberInvoiceByMonth+"-"+revenueByHour+"-"+revenueByWeek+"-"+revenueByMonth);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		ForStatistic forStatistic= new ForStatistic();
		forStatistic.setNumberInvoiceByHour(numberInvoiceByHour);
		forStatistic.setNumberInvoiceByWeek(numberInvoiceByWeek);
		forStatistic.setNumberInvoiceByMonth(numberInvoiceByMonth);
		forStatistic.setRevenueByHour(revenueByHour);
		forStatistic.setRevenueByWeek(revenueByWeek);
		forStatistic.setRevenueByMonth(revenueByMonth);
		
		request.setAttribute("fs",forStatistic);
		return mapping.findForward("success");
	}
}
