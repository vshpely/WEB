<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
<%@include file="css/index.css" %>
</style> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Аліса</title>
</head>
<body>

<div class="header">
		<div class="header-login">
			<div class="header-login-logo">
			<ul>
				<c:forEach var="categoryProduct" items="${categoryProducts}">
				<li>
				<a href="#">${categoryProduct.nameCategory}</a>
				</li>
				</c:forEach>
			</ul>
			</div>
			<div class="header-login-menu">
				<ul>
					<li><a href="admin" class="login-img"></a></li>
					<li><a href="login">Вхід</a></li>
					<li><a href="registration">Реєстрація</a></li>
				</ul>
			</div>
		</div>
		<div class="header-center">
			<div class="header-center-left">
				<table>
				<tr>
					<td><img alt="" src="resources/image/happy-family.png" width="150"></td>
				</tr>
				</table>
			</div>
			<div class="header-center-center">
				<div class="contact">
				<img alt="" src="resources/image/g3676.png">
				</div>
			</div>
			<div class="header-center-right">
				<table>
				<tr>
					<td><img alt="" src="resources/image/shopping-basket.png"></td>
				</tr>
				<tr>
					<td>Товарів в корзині: 0</td>
				</tr>
				<tr>
					<td>Cума: 0</td>
				</tr>
				
				<tr>
					<td><input type="text"></td>
					<td><input type="submit" value="Пошук"></td>
				</tr>
				</table>
			</div>
		</div>
		<div class="header-bottom">
		
		</div>
		</div>
</body>
</html>