<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/views/res/css/register.css" />
<div id="register-form" class="container text-center center-block">
	<form method="post" action="register.do">
		<p class="form-heading">Register</p>
		<div class="col-md-4 center-block">
			<div class="form-group pagination-centered">
				<label for="username" class="sr-only col-md-6 left">Username:</label>
				<input id="username" class="form-control right" type="text"
					name="username" placeholder="Username">
			</div>
			<div class="form-group pagination-centered">
				<label for="password" class="sr-only col-md-6 left">Password:</label>
				<input id="password" required class="form-control right"
					type="password" name="password" placeholder="Password">
			</div>
			<div class="form-group pagination-centered">
				<label for="password" class="sr-only col-md-6 left">Re-password:</label>
				<input id="repassword" required class="form-control right"
					type="password" name="repassword" placeholder="Re-type password">
			</div>
			<div class="form-group pagination-centered">
				<label for="password" class="sr-only col-md-6 left">Password:</label>
				<input required class="form-control right"
					type="text" name="name" placeholder="Name">
			</div>
			<div class="form-group pagination-centered">
				<label for="password" class="sr-only col-md-6 left">Re-password:</label>
				<input class="form-control right"
					type="text" name="address" placeholder="Address">
			</div>
			
			<div class="form-group pagination-centered">
				<label for="password" class="sr-only col-md-6 left">Re-password:</label>
				<input required class="form-control right"
					type="email" name="email" placeholder="Email">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-login col-md-6">Submit</button>
			</div>
		</div>
	</form>
	<a class="link" href="${pageContext.request.contextPath}/gologin.do">Login</a>
</div>