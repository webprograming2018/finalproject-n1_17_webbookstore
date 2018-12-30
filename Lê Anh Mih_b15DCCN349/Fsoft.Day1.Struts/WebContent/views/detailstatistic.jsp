<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib  prefix="display" uri="http://displaytag.sf.net"%>
	<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
    <%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
    <%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<style>
		div.a {
  			text-align: center;
		}
	</style>
</head>
<body>
    
<div class="container">
	<div>
		<div class="left leftmargin">
			<address>
				<strong>Bảng thống kê chi tiết các đầu sách:</strong><br>
					Admin<br>
					1234 Street<br>
					Hà Đông<br>
					Hà Nội- 6789 Street
			</address>
		</div>
		<div class="right">
			<address>
				<strong>Thống kê bắt đầu từ </strong><br>
				1/1/2018 - 31/12/2018<br>
				
			</address>
			<address>
				<strong>Time Now:</strong><br>
				<%= new java.util.Date() %><br><br>
			</address>
	    	</div>		
    </div>
 	<div class="clear"><br>
 		<div class="a">
 			<h2><strong>Detail Satistic</strong></h2>
 		</div>
 	</div>	<br><br>
 	
 	<!-- ----------------------------------------------------------------------------------------------------  --> 
 	
 	<div class="container">
 	
		<table class="table table-condensed">
				<thead>
	                <tr>
						<td class="text-center"><strong>Tên Sách</strong></td>
						<td class="text-center"><strong>Số lượng bán ra</strong></td>
	                </tr>
				</thead>
				
				<tbody class="text-center">
				<c:forEach items="${list}" var="id">
					<tr>
						<td class="text-center">
							<strong>
								<span>${id.nameBook }</span>
							</strong>
						</td>
						<td class="text-center">
							<strong>
								<span>${id.numberOfBook }</span>
							</strong>
						</td>
		           </tr>
		        </c:forEach>
				</tbody>
		</table><br><br><br><br><br><br><br><br>		 	
 	</div>
</div>
</body>
</html>