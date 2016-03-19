<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
<%@include file='css/form.css' %></style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" accept-charset="UTF-8">
	<label for="login">І'мя</label>
	<input name="login" id="login"><br>
	<label for="password">Пароль</label>
	<input name="password" type="password" id="password"><br>
	<label for="email">E-mail</label>
	<input name="email" id="email"><br>
	<label for="phone">Телефон</label>
	<input name="phone" id="phone"><br>
	<input type="submit" value="OK">
	</form>
	<a href="/Alisa">Назад</a>
</body>
</html>