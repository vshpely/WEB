<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
<%@include file='css/form.css' %></style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Виробники</title>
</head>
<body>
	<form method="post" accept-charset="UTF-8">
		<label for="producerName">Виробник</label>
		<input name="producerName" id="producerName"></input>
		<input type="submit" value="OK"> 
	</form>
	
	
	<c:forEach var="producer" items="${producers}">
	<table>
		<tr>
			<td>${producer.producerName}</td>
			<td><c:url value="${producer.id}"></c:url></td>
			<td><a href="producer/${producer.id}">delete</a></td>
		</tr>
	</table>
	</c:forEach> 
	<a href="/Alisa/admin">Назад</a>
</body>
</html>