<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Додати товар</title>
</head>
<body>
		
		<form method="post" enctype="multipart/form-data" action="?${_csrf.parameterName}=${_csrf.token}">
		<table>
		<tr>
			<td><label for="articul">Артикль</label></td>
			<td><input name="articul" id="articul"></input></td>
		</tr>
		<tr>
			<td><label for="productName">Назва товару</label></td>
			<td><input name="productName" id="productName"></input></td>
		</tr>
		<tr>
			<td><label for="price">Ціна</label></td>
			<td><input name="price" id="price"></input></td>
		</tr>
		<tr>
			<td><label for="size">Виберіть розмір</label></td>
			<td><select name="size_id" id="size">
			<c:forEach var="size" items="${sizes}">
			<option value="${size.id}">${size.sizeName}</option>
			</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td><label for="pidCategory">Виберіть підкатегорію</label></td>
			<td><select name="pidCategory_id" id="pidCategory">
			<c:forEach var="pidCategory" items="${pidCategorys}">
			<option value="${pidCategory.id}">${pidCategory.categoryProduct.nameCategory} - ${pidCategory.namePidkategory}</option>
			</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td><label for="image">Виберіть зображення</label></td>
			<td><input type="file" name="file" id="image"></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="OK"></td>
		</tr>
		</table>
		</form>
		
		<a href="/Alisa/admin">Назад</a>
</body>
</html>