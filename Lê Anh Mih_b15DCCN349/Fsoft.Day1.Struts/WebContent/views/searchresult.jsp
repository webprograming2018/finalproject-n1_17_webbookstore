<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="container">
	<div class="body">
		<div class="row text-center">
			<h3>Search result for ${requestScope.q}: </h3>
		</div>
		<c:choose>
			<c:when test="${result==null}">
				<c:out value="${results.size()} results."/>
				<div class="row">
					<c:forEach items="${results}" var="book">
						<div class="list-group-item col-md-3 col-sm-12">
							<img alt="${book.name}"
								src="${pageContext.request.contextPath}/views/res/img/${book.image}"
								class="item-image" />
							<div>
								<a class="item-caption"
									href="${pageContext.request.contextPath}/bookDetails.do?id=${book.id}">${book.name}</a>
								<form action="addtocart.do">
									<input hidden="true" name="id" value="${book.id}"> <input
										class="btn btn-danger" value="Add to cart" type="submit">
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

			</c:when>
			<c:otherwise>
				<h5>No record's found.</h5>
			</c:otherwise>
		</c:choose>
	</div>
</div>
