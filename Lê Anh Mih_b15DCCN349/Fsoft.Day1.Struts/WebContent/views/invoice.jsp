<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib uri="http://displaytag.sf.net" prefix="display" %>

<div class="container" id="">
	<div>
		<div class="left leftmargin">
			<address>
				<strong>Billed To:</strong><br>
					Le Anh Minh<br>
					1234 Street<br>
					Hà Đông<br>
					Hà Nội- 6789 Street
			</address>
		</div>
		<div class="right">
			<address>
				<strong>Payment Method:</strong><br>
				Visa ending **** 4242<br>
				leanhminh1410@email.com
			</address>
			<address>
				<strong>Order Date:</strong><br>
				<%= new java.util.Date() %><br><br>
			</address>
	    	</div>		
    </div>
 	<div class="clear">
		<h3 class="panel-title"><strong>Order summary</strong></h3>
			<table class="table table-condensed">
				<thead>
                          <tr>
  							<td><strong>Item</strong></td>
  							<td class="text-center"><strong>Price</strong></td>
  							<td class="text-center"><strong>Quantity</strong></td>
  							<td class="text-right"><strong>Totals</strong></td>
                          </tr>
				</thead>
				<tbody class="text-center">
					<c:set var="total" value="${0}"/>
					<c:forEach items="${cart.items.keySet()}" var="cartItem">
					<tr>
						<td class="col-md-3 col-lg-4">
							<div class="column text-left">
								${cartItem.name}
							</div>
						</td>
						<td>
							<p>
								<span>${cartItem.price}</span> x <span>${cart.items.get(cartItem)}</span>
								= <span>${cartItem.price*cart.items.get(cartItem)}</span>
							</p>
						</td>
						<td class="col-md-4">
							<p>${cart.items.get(cartItem)}</p>
						</td>
						<td>
							<span>${cartItem.price*cart.items.get(cartItem)}</span>
							<c:set var="total" value="${total + cartItem.price*cart.items.get(cartItem)}" />
						</td>
					</tr>
				</c:forEach>
					<tr>
						<td class="no-line"></td>
						<td class="no-line"></td>
						<td class="no-line text-center"><strong>Subtotal</strong></td>
						<td class="no-line text-right">
							<c:out value = "${total}"/>
							<c:set var="sum" value="${total}"/>
						</td>
					</tr>
					
					<tr>
						<td class="no-line"></td>
						<td class="no-line"></td>
						<td class="no-line text-center"><strong>TAX</strong></td>
						<td class="no-line text-right">
							<c:out value = "${total/100*10}"/>
							<c:set var="sum" value="${sum + total/100*10}" />
						</td>
					</tr>
					
					<tr>
						<td class="no-line"></td>
						<td class="no-line"></td>
						<td class="no-line text-center"><strong>Total</strong></td>
						<td class="no-line text-right">
							<c:out value = "${sum}"/>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<div class="clear">
			<table class="table table-condensed">
				<tr>
					<td colspan="4" class="text-center">
						<button class="btn btn-danger">
							<a href="${pageContext.request.contextPath}/reset.do">Reset</a>
						</button>
					</td>	
					<td colspan="4" class="text-center">
						<button class="btn btn-danger">
						    <a href="${pageContext.request.contextPath}/exportpdf.do">DownLoad PDF</a>
							<!-- <a href="javascript:genPDF()"> Download PDF</a> -->
						</button>
					</td>	
					<td colspan="4" class="text-center">
						<button class="btn btn-danger">
							<a href="${pageContext.request.contextPath}/sendmail.do">Gửi Mail</a>
						</button>
					</td>	
				</tr>
			</table>
		</div>	
</div>

<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.4/jspdf.min.js">
	window.genPDF =function() {
		var doc= new jsPDF();
		doc.fromHTML($('pdf').get(0), 20,20, {
			'witdh': 500
		});
		
		doc.save("invoice.pdf");
	}
</script>  -->
    		