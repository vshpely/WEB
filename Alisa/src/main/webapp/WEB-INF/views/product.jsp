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
		<form method="post" accept-charset="UTF-8">
		
		<label for="articul">Артикль</label><br>
		<input name="articul" id="articul"></input><br>
		
		<label for="productName">Назва товару</label><br>
		<input name="productName" id="productName"></input><br>
		
		<label for="price">Ціна</label><br>
		<input name="price" id="price"></input><br>
		
		<label for="size">Виберіть розмір</label><br>
		<select name="size_id" id="size">
		<c:forEach var="size" items="${sizes}">
		<option value="${size.id}">${size.sizeName}</option>
		</c:forEach>
		</select><br>
		
		<label for="pidCategory">Виберіть підкатегорію</label><br>
		<select name="pidCategory_id" id="pidCategory">
		<c:forEach var="pidCategory" items="${pidCategorys}">
		<option value="${pidCategory.id}">${pidCategory.categoryProduct.nameCategory} - ${pidCategory.namePidkategory}</option>
		</c:forEach>
		</select><br>
		</form>
		<input type="submit" value="OK"><br>
		<a href="/Alisa/admin">Назад</a>
</body>
</html>