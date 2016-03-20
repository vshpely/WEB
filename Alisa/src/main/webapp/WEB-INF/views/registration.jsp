<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
<%@include file='css/form.css' %></style>
<style>
.error {
    color: #ff0000;
    font-style: italic;
    font-weight: bold;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<f:form method="POST" modelAttribute="user">
	<table >
	<tr>
		<td><f:label path="login">Ім`я</f:label></td>
		<td><f:input path="login" name="login"/><br>
		<f:errors path="login" cssClass="error" />
	</tr>
	<tr>
		<td><f:label path="password">Пароль</f:label></td>
		<td><f:input path="password"/>
		<f:errors path="password" cssClass="error" />
		</td>
	</tr>
		<tr>
		<td><f:label path="email">E-mail</f:label></td>
		<td><f:input path="email"/>
		<f:errors path="email" cssClass="error" />
		</td>
	</tr>
	<tr>
		<td><f:label path="phone">Телефон</f:label></td>
		<td><f:input path="phone" />
		<f:errors path="phone" cssClass="error" />
		</td>
	</tr>
	<tr>
	<td></td>
	<td><input type="submit" value="OK"></td>
	</tr>
	</table>
	</f:form>
	
	<a href="/Alisa">Назад</a>
</body>
</html>