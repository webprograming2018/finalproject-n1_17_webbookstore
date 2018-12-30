package com.fsoft.minhla1.filter;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class LimitedFilter implements Filter{
	 private int limit = 5;
	    private int count;
	    private Object lock = new Object();

	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	    	HttpServletResponse res = (HttpServletResponse) response;
	    	
	        try {
	            boolean ok;
	            synchronized (lock) {
	                ok = count++ < limit;
	            }
	            if (ok) {
//	            	PrintStream pr = new PrintStream(new BufferedOutputStream(new FileOutputStream("log.txt",true)));
//	    			System.setOut(pr);
	            	System.out.println("XX: " +ok+" + : " +count);
	                chain.doFilter(request, response);
	            } else {
	            	res.sendRedirect("/Fsoft.Day1.Struts/views/error.jsp");
	            }
	        } finally {
	            synchronized (lock) {
	                count--;
	            }           
	        }
	    }
}
