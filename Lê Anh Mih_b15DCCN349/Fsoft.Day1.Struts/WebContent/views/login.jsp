<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/views/res/css/login.css"/>
<div id="login-form" class="container text-center center-block">
	<form method="post" action="login.do">
		<p class="form-heading">Login</p>
		<div class="form-signin center-block col-md-4">
			<div class="form-group pagination-centered">
				<label for="username" class="sr-only">Username:</label> <input
					id="username" required class="form-control" type="text"
					name="username" placeholder="Username">
			</div>
			<div class="form-group pagination-centered">
				<label for="password" class="sr-only">Password:</label> <input
					id="password" required class="form-control" type="password"
					name="password" placeholder="Password">
			</div>
			<input type="submit" class="btn btn-login form-group">
		</div>
	</form>
	<a class="link" href="${pageContext.request.contextPath}/goregister.do">Register</a>
</div>
