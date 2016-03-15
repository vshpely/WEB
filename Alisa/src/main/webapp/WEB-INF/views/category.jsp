<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<form method="post" accept-charset="UTF-8">
		
		<select name="categoryProduct_id">
		<c:forEach var="categoryproduct" items="${categoryproducts}">
		<option value="${categoryproduct.id}">${categoryproduct.nameCategory}</option>
		</c:forEach>
		</select>
		
		<label for="namePidkategory">Введіть ім'я категорії</label>
		<input name="namePidkategory" id="namePidkategory"></input>
		
		<input type="submit" value="OK"> 
	</form>
<a href="/Alisa/admin">Назад</a>
</body>
</html>