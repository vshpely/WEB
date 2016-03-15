<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
<%@include file='css/form.css' %></style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Розміра</title>
</head>
<body>
	
	<form method="post" accept-charset="UTF-8">
		<label for="sizeName">Міжнародний розмір</label>
		<input name="sizeName" id="sizeName"></input>
		<label for="ukrSize">Український розмір</label>
		<input name="ukrSize" id="ukrSize"></input>
		<input type="submit" value="OK"> 
	</form>
	
	
	<c:forEach var="size" items="${sizes}">
	<table>
		<tr>
			<td>${size.sizeName}</td>
			<td>${size.ukrSize}</td>
			<td><c:url value="${size.id}"></c:url></td>
			<td><a href="size/${size.id}">delete</a></td>
		</tr>
	</table>
	</c:forEach> 
	<a href="/Alisa/admin">Назад</a>
	
	<form>
	<select name="size.id">
	<c:forEach var="size" items="${sizes}">
	<option value="${size.id}">${size.sizeName}</option>
	</c:forEach>
	</select>
	
</body>
</html>