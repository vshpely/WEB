<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
<%@include file="CSS/admin.css" %>
</style>
</head>
<body>
	<div class="center-right">
			<table>
				<tr>
					<th>ID</th>
					<th>Артикль</th>
					<th>Назва</th>
					<th>Ціна</th>
					<th>Виробник</th>
					<th>Розмір</th>
					<th>Категорія</th>
					<th>Редагувати</th>
					<th>Видалити</th>
				</tr>
			<c:forEach var="product" items="${products}">
				<tr>
					<td><c:url value="${product.id}"></c:url></td>
					<td>${product.articul}</td>
					<td>${product.productName}</td>
					<td>${product.price}</td>
					<td>${product.producer.producerName}</td>
					<td>${product.size.sizeName}</td>
					<td>${product.pidCategory.namePidkategory}</td>
					
					<td><a href="<c:url value="/admin/edit/${product.id}" />"><img src="resources/image/1459211840_Edit.png"> ред.</a></td>
					<td><a href="admin/${product.id}"><img alt="" src="resources/image/1458580850_Delete.png">  видалити</a></td>
				</tr>
			</c:forEach> 
			</table>
			</div>

</body>
</html>