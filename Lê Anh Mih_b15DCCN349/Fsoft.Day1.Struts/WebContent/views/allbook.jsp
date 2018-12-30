<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="body">
		<div class="row">
			<c:forEach items="${books}" var="book">
				<div class="list-group-item col-md-3 col-sm-12">
					<img alt="${book.name}"
						src="${pageContext.request.contextPath}/views/res/img/${book.image}"
						class="item-image" />
					<div>
						<a class="item-caption"
							href="${pageContext.request.contextPath}/bookDetails.do?id=${book.id}">${book.name}</a>
						<form action="addtocart.do">
							<input hidden="true" name="id" value="${book.id}"> 
							<input class="btn btn-danger" value="Add to cart" type="submit">
						</form>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="pagination page-list">
			Page ${page} of total ${total}
			<c:forEach begin="0" end="${total}" varStatus="loop">
				<a href="goseeall.do?page=${loop.index}">${loop.index+1}</a>
			</c:forEach>
		</div>
	</div>
</div>
