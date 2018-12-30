package com.fsoft.minhla1.filter;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fsoft.minhla1.entities.IpAddress;
import com.fsoft.minhla1.model.Cart;
import com.sun.net.httpserver.Filter.Chain;

public class PayFilter implements Filter{
	String logFile;
	IpAddress IP;
	String ipaddress;
	public PayFilter() {
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.logFile = filterConfig.getInitParameter("logFile");
	}
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse res = (HttpServletResponse) arg1;
		 
	    String servletPath = req.getServletPath();
	    
	    PrintStream pr = new PrintStream(new BufferedOutputStream(new FileOutputStream("log.txt",true)));
		System.setOut(pr);
		
	    System.out.println("#INFO " + new Date() + " - ServletPath :" + servletPath + ", URL =" + req.getRequestURL());
	    HttpSession session = req.getSession(false);
	    IP= (IpAddress) session.getAttribute("ip");
//	    if (IP == null) {
//	    	IP = new IpAddress();
//			session.setAttribute("ip", IP);
//		}
	    
	    IP.getListIP().forEach((ip,time) ->{
	    	System.out.println("@: " +ip+ "    Time: " +time);
	    	ipaddress=ip;
	    });
	    pr.close();
    
	    String[] s=ipaddress.split("[:]");
	    if(!s[0].equals("183")) {  //1.14. 23. 27. 42.43.47.103.123 ..... 
	    	arg2.doFilter(arg0, arg1);
	    }else {
	    	res.sendRedirect("/Fsoft.Day1.Struts/views/error.jsp");
	    }
	}
	private void logToFile(String fileName) {
        System.out.println("Write log to file " + fileName);
    }
}
