<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<c:choose>
		<c:when test="${user.type==0}">
			<form action="saveBook.do" method="post"
				enctype="multipart/form-data" class="row" accept-charset="UTF-8">
				<div class="col-md-4">
					<img
						src="${pageContext.request.contextPath}/views/res/img/${book.image}" />
					<input type="file" name="image" value="Choose image">
				</div>
				<div class="col-md-8">
					<div class="row">
						<p class="col-md-4">Title:</p>
						<input type="text" required="required" name="name"
							class="form-control col-md-8" value="${book.name}">
					</div>
					<div class="row">
						<p class="col-md-4">Author:</p>
						<input type="text" name="author" class="form-control col-md-8"
							value="${book.author}">
					</div>
					<div class="row">
						<p class="col-md-4">ISBN:</p>
						<input type="text" name="isbn" class="form-control col-md-8"
							value="${book.isbn}">
					</div>
					<div class="row">
						<p class="col-md-4">Publisher:</p>
						<input type="text" name="publisher" class="form-control col-md-8"
							value="${book.publisher}">
					</div>
					<div class="row">
						<p class="col-md-4">Price:</p>
						<input type="money" name="price" class="form-control col-md-8"
							value="${book.price}">
					</div>
					<input type="text" name="id" hidden="true" value="${book.id}">
					<div class="row">
						<c:if test="${categories.size()>0 }">
							<p class="col-md-4">Category:</p>
							<select name="category">
								<c:forEach items="${categories}" var="category">
									<option value="${category.id}">
											${category.name}
										</option>
								</c:forEach>
							</select>
						</c:if>
					</div>
				</div>
				<button type="submit" class="btn btn-danger vertical-middle">Save</button>

			</form>
			<c:if test="${book!=null}">
				<form action="deleteBook.do" method="POST" class="col-md-12">
					<input name="id" value="${book.id}" hidden>
					<button type="submit"
						class="btn btn-danger center-block vertical-middle">
						Delete</button>
				</form>
			</c:if>
		</c:when>
		<c:otherwise>
			<div class="row">
				<div class="col-md-4">
					<button class="col-md-12" name="image" type="file">
						<img
							src="${pageContext.request.contextPath}/views/res/img/${book.image}" />
					</button>
				</div>
				<div class="col-md-8">
					<div class="row">
						<p class="col-md-4">Title:</p>
						<p class="col-md-8">
							<c:out value="${book.name}" />
						</p>
					</div>
					<div class="row">
						<p class="col-md-4">Author:</p>
						<p class="col-md-8">
							<a href="search.do?c=author&q=${book.author}"> <c:out
									value="${book.author}" />
							</a>
						</p>
					</div>
					<div class="row">
						<p class="col-md-4">ISBN:</p>
						<p class="col-md-8">
							<c:out value="${book.isbn}" />
						</p>
					</div>
					<div class="row">
						<p class="col-md-4">Publisher:</p>
						<p class="col-md-8">
							<a href="search.do?c=author&q=${book.publisher}"> <c:out
									value="${book.publisher}" />
							</a>
						</p>
					</div>
					<div class="row">
						<p class="col-md-4">Price:</p>
						<p class="col-md-8">
							<c:out value="${book.price}" />
						</p>
					</div>
					<div class="row">
						<p class="col-md-4">Category:</p>
						<c:if test="${categories.size()>0 }">
							<c:forEach items="${categories}" var="category">
								<c:if test="${category.id.equals(book.categoryId)}">
									<a href="search.do?c=category&q=${category.id}"
										class="col-md-8"> <c:out value="${category.name}" />
									</a>
								</c:if>
							</c:forEach>
						</c:if>

					</div>
					<div class="row">
						<form action="addtocart.do">
							<input hidden="true" name="id" value="${book.id}">
							<button class="btn btn-danger" type="submit">Add to cart</button>
						</form>
					</div>
				</div>

			</div>
		</c:otherwise>
	</c:choose>
</div>