<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.error {
    color: #ff0000;
    font-weight: bold;
}
</style> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Додати товар</title>
</head>
<body>
	<div class="center-right">
		
		<f:form method="post" enctype="multipart/form-data" modelAttribute="product">
		<input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
		<table>
		<tr>
			<td><label for="articul">Артикль</label></td>
			<td><f:input path="articul" id="articul"></f:input></td>
			<td><f:errors path="articul" cssClass="error" /></td>
		</tr>
		<tr>
			<td><label for="productName">Назва товару</label></td>
			<td><f:input path="productName" id="productName"></f:input></td>
			<td><f:errors path="productName" cssClass="error" /></td>
		</tr>
		<tr>
			<td><label for="price">Ціна</label></td>
			<td><f:input path="price" id="price"></f:input></td>
		</tr>
		<tr>
			<td><label for="size">Виберіть розмір</label></td>
			<td><f:select path="size" items="${sizes}" id="size" itemValue="id" itemLabel="sizeName">
			
			</f:select></td>
		</tr>
		<tr>
			<td><label for="pidCategory">Виберіть підкатегорію</label></td>
			<td><f:select path="pidCategory" id="pidCategory" items="${pidCategorys}" itemValue="id"
						 itemLabel="namePidkategory">
			</f:select></td>
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
		</f:form>
		
		<a href="/Alisa/admin">Назад</a>
		</div>
</body>
</html>