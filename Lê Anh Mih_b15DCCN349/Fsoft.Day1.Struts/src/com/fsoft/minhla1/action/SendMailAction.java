package com.fsoft.minhla1.action;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.fsoft.minhla1.model.Cart;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.sun.xml.internal.ws.util.ByteArrayDataSource;

public class SendMailAction extends Action{
	int i=0;
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			
		 ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			Document document = new Document();
	        PdfWriter.getInstance(document, outputStream);
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
	    byte[] bytes = outputStream.toByteArray();
       
		String host ="smtp.gmail.com";
		String user="vklfall@gmail.com";
		String password="vsatldolt";
		String to="thanhbk1.16@gmail.com";
		String from="vklfall@gmail.com";
		String subject="INVOICE";
		String messageText="Gà vl";
		boolean sessionDebug=false;
		
		Properties pro = System.getProperties();
		pro.put("mail.smtp.starttls.enable", "true");
		pro.put("mail.smtp.host", host);
		pro.put("mail.smtp.port", "587");
		pro.put("mail.smtp.auth", "true");
		pro.put("mail.smtp.starttls.required", "true");
		
		java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		
		Session mailSesstion = Session.getDefaultInstance(pro, null);
//		mailSesstion.setDebug(sessionDebug);
//		Message msg = new MimeMessage(mailSesstion);
//		msg.setFrom(new InternetAddress(from));
//		InternetAddress[] addresses = {new InternetAddress(to)};
//		msg.setRecipients(Message.RecipientType.TO, addresses);
//		msg.setSubject(subject);
//		msg.setSentDate(new Date());
		 
		 MimeBodyPart textBodyPart = new MimeBodyPart();     
		 textBodyPart.setText("Invoice");
         String filename = "invoice.pdf";//change accordingly     
         DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");    
         MimeBodyPart pdfBodyPart = new MimeBodyPart();
         pdfBodyPart.setDataHandler(new DataHandler(dataSource));
         pdfBodyPart.setFileName("invoice.pdf");          

         MimeMultipart mimeMultipart = new MimeMultipart();
         mimeMultipart.addBodyPart(textBodyPart);
         mimeMultipart.addBodyPart(pdfBodyPart);
          
         //create the sender/recipient addresses
         InternetAddress iaSender = new InternetAddress(from);
         InternetAddress iaRecipient = new InternetAddress(to);
          
         //construct the mime message
         MimeMessage mimeMessage = new MimeMessage(mailSesstion);
         mimeMessage.setSender(iaSender);
         mimeMessage.setSubject(subject);
         mimeMessage.setRecipient(Message.RecipientType.TO, iaRecipient);
         mimeMessage.setContent(mimeMultipart);
          
        
         
		Transport transport=mailSesstion.getTransport("smtp");
		transport.connect(host, user, password);
		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
		transport.close();
		System.out.println("mail send success");
		request.getSession(false).setAttribute("cart", new Cart());
		return mapping.findForward("success");
	}
	
	
}
