<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
<%@include file='css/form.css' %>
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<form method="post" action="?${_csrf.parameterName}=${_csrf.token}">
		<table>
		<tr>
			<td><label for="categoryProduct_id">Виберіть категорію</label></td>
			<td><select name="categoryProduct_id" id="categoryProduct_id">
			<c:forEach var="categoryproduct" items="${categoryproducts}">
			<option value="${categoryproduct.id}">${categoryproduct.nameCategory}</option>
			</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td><label for="namePidkategory">Введіть ім'я категорії</label></td>
			<td><input name="namePidkategory" id="namePidkategory"></input></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="OK"></td>
		</tr>
		</table> 
	</form>
	<c:forEach var="category" items="${categorys}">
	<table>
		<tr>
			<td>${category.namePidkategory}</td>
			<td>${category.categoryProduct.nameCategory}</td>
			<td><c:url value="${category.id}"></c:url></td>
			<td><a href="category/${category.id}">delete</a></td>
		</tr>
	</table>
	</c:forEach> 
	
<a href="/Alisa/admin">Назад</a>
</body>
</html>