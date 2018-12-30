<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<div class="bg-header overflow-hidden">
			<div class="clear header-menu col-lg-12 col-md-12">
				<ul class="nav nav-bar">
					<c:if test="${user.type==0}">
						<li class="col-md-3 col-lg-3 link">
							<a href="${pageContext.request.contextPath}/gocreate.do">Add new book </a>
						</li>
					</c:if>
					
					<li class="col-md-3 col-lg-3 link">
						<a href="${pageContext.request.contextPath}/goseeall.do">See all book </a>
					</li>
					
					<li class="col-md-3 col-lg-3 link">
						<a href="${pageContext.request.contextPath}/gocart.do">My shopping cart</a>
					</li>
					
					<c:if test="${user.type==0}">
						<li class="col-md-3 col-lg-3 link">
							<a href="${pageContext.request.contextPath}/gostatistic.do">Statistics</a>
						</li>
					</c:if>
					
					<li class="col-md-3 col-lg-3 link right">
						<p>
							Welcome ${user.username}
							<span>
								<a href="${pageContext.request.contextPath}/logout.do">[Logout]</a>
							</span>
						</p>
					</li>
				</ul>
			</div>
			<div class="clear">
				<form class="row col-md-4 col-lg-4 right" action="search.do">
					<input type="text" name="q" class="form-control col-md-9 col-lg-9 no-padding" placeholder="Keywords" value="${requestScope.q}">
					<span class="input-group-btn col-md-3 col-lg-3 right no-padding">
						<button class="btn" type="submit">
							<i class="fa fa-search" aria-hidden="true"></i>
						</button>
					</span>
				</form>
			</div>
		</div>