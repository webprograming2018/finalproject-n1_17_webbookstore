<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
			<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
			<html>

			<head>
				<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
				<title>
					<tiles:getAsString name="title" />
				</title>
				<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
				 crossorigin="anonymous">
				<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
				<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
				 crossorigin="anonymous"></script>
				<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
				<link rel="stylesheet" href="${pageContext.request.contextPath}/views/res/css/common.css">

			</head>

			<body>
				<table class="center-block col-md-10" id="table-main">
					<tr>
						<td>
							<tiles:insert attribute="header"></tiles:insert>
						</td>
					</tr>
					<tr>
						<td>
							<tiles:insert attribute="menu"></tiles:insert>
						</td>
					</tr>
					<tr>
						<td>
							<tiles:insert attribute="body"></tiles:insert>
						</td>
					</tr>
					<tr>
						<td>
							<tiles:insert attribute="footer"></tiles:insert>
						</td>
					</tr>
				</table>
			</body>

			</html>