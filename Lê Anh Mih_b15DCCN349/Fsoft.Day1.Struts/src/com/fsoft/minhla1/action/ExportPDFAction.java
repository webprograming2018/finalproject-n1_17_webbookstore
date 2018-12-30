package com.fsoft.minhla1.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.fsoft.minhla1.entities.Invoice;
import com.fsoft.minhla1.model.Cart;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;


public class ExportPDFAction extends Action{
	int i=0;
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

	        Document document = new Document();
	        PdfWriter.getInstance(document, new FileOutputStream("invoice.pdf"));
	        document.open();
	        Paragraph paragraph1 = new Paragraph("Order summary");
	        Paragraph paragraph2 = new Paragraph("This is Paragraph 2");
	       
	        paragraph1.setIndentationLeft(80);
	        paragraph1.setIndentationRight(80);
	        paragraph1.setAlignment(Element.ALIGN_CENTER);
	        paragraph1.setSpacingAfter(15);
	   
	        document.add(paragraph1);
	        
	        PdfPTable table = new PdfPTable(4);
	        table.addCell("Item");
	        table.addCell("Price");
	        table.addCell("Quantity");
	        table.addCell("Totals");
	        
	        Cart c = (Cart) request.getSession().getAttribute("cart");
			System.out.println("quantity: "+ c.getQuantity());
			
			c.getItems().forEach((book , integer) -> {
				table.addCell(book.getName());
				table.addCell(String.valueOf(book.getPrice()));
				table.addCell(String.valueOf(integer));
				table.addCell(String.valueOf(book.getPrice() * integer));
				i+= book.getPrice() * integer;
				}	
		    );
			
			table.addCell("");
	        table.addCell("");
	        table.addCell("Subtotal");
	        table.addCell(String.valueOf(i));
	        
	        table.addCell("");
	        table.addCell("");
	        table.addCell("TAX");
	        table.addCell(String.valueOf(i*10/100));
	        
	        table.addCell("");
	        table.addCell("");
	        table.addCell("Totals");
	        table.addCell(String.valueOf(i+i*10/100));
	        
	        document.add(table);
	        document.close();
	        
	        File downloadFile = new File("invoice.pdf");
	        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
	        response.setContentType("application/pdf");
	        response.setHeader("Content-Disposition", headerValue);
	        FileInputStream inStream = new FileInputStream(downloadFile);
	        OutputStream outStream = response.getOutputStream();
		     byte[] buffer = new byte[1024*4];
		     int bytesRead = -1; 
		     while ((bytesRead = inStream.read(buffer)) != -1) {
		         outStream.write(buffer, 0, bytesRead); 
		     }
		     inStream.close();
		     outStream.close();
		request.getSession(false).setAttribute("cart", new Cart());
		return mapping.findForward("success");
	}
	
}
