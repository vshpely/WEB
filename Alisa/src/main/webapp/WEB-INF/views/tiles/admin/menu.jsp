<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
<%@include file="CSS/admin.css" %>
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Меню</title>
</head>
<body>
<div class="center-left">
			<ul>
				<li><a href="<c:url value="/product" />">Товар</a></li>
				<li><a href="<c:url value="/category" />">Категорії</a></li>
				<li><a href="<c:url value="/size" />">Розміри</a></li>
				<li><a href="<c:url value="/producer" />">Виробники</a></li>
				<li><a href="#">Користувачі</a></li>
				<li><a href="#">Замовлення</a></li>
			</ul>
			</div>
</body>
</html>