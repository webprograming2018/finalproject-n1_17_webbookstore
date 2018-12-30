<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div class="text-center">
		<h3>Product cart</h3>
	</div>
	<div class="cart">
		<table border="1" class="col-md-10">
			<thead class="text-center">
				<p>All item chose by ${user.username}</p>
				<tr>
					<th>Book</th>
					<th>Quantity</th>
					<th>Amount</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody class="text-center"z>
				<c:forEach items="${cart.items.keySet()}" var="cartItem">
					<tr>
						<td class="col-md-3 col-lg-4">
							<div class="column text-left">
								<img
									src="${pageContext.request.contextPath}/views/res/img/${cartItem.image}" />
								<a
									href="${pageContext.request.contextPath}/bookDetails.do?id=${cartItem.id}">${cartItem.name}</a>
							</div>
						</td>
						<td>
							<p>${cart.items.get(cartItem)}</p>
						</td>
						<td class="col-md-4">
							<p>
								<span>${cartItem.price}</span> x <span>${cart.items.get(cartItem)}</span>
								= <span>${cartItem.price*cart.items.get(cartItem)}</span>
							</p>
						</td>
						<td><a
							href="${pageContext.request.contextPath}/removefromcart.do?id=${cartItem.id}">Remove</a>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td>Total:</td>
					<td>${cart.quantity}</td>
					<td>${cart.totalAmount}</td>
					<td></td>
				</tr>
				<c:if test="${cart.items.size()>0}">
					<tr>
						<td colspan="4" class="text-center">
							<button class="btn btn-danger">
								<a href="${pageContext.request.contextPath}/pay.do">Confirm</a>
							</button>
						</td>
					</tr>
				</c:if>
			</tbody>
		</table>

	</div>
</div>