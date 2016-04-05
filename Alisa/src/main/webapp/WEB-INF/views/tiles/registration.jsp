<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.error {
    color: #ff0000;
    font-weight: bold;
}
.registration{
	margin: 0 auto;
	height:500px;
	width: 400px;
	padding-top:20px;
	}
</style> 

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="registration">
	<f:form method="POST" modelAttribute="user" action="?${_csrf.parameterName}=${_csrf.token}">
	<table >
	<tr>
		<td><f:label path="login">Ім`я</f:label></td>
		<td><f:input path="login" name="login"/></td>
		<td><f:errors path="login" cssClass="error" /></td>
	</tr>
	<tr>
		<td><f:label path="password">Пароль</f:label></td>
		<td><f:input path="password"/></td>
		<td><f:errors path="password" cssClass="error" /></td>
	</tr>
		<tr>
		<td><f:label path="email">E-mail</f:label></td>
		<td><f:input path="email"/></td>
		<td><f:errors path="email" cssClass="error" /></td>
	</tr>
	<tr>
		<td><f:label path="phone">Телефон</f:label></td>
		<td><f:input path="phone" /></td>
		<td><f:errors path="phone" cssClass="error" /><td>
	</tr>
	<tr>
	<td></td>
	<td><input type="submit" value="OK"></td>
	</tr>
	</table>
	</f:form> 
	
	<%-- <form method="post" action="?${_csrf.parameterName}=${_csrf.token}">
		<table>
			<tr>
				<td>Введіть логін користувача</td>
				<td><input name="login"></td>
			</tr>
			<tr>
				<td>Введіть пароль користувача</td>
				<td><input name="password"></td>
			</tr>
				<tr>
				<td>Введіть Email</td>
				<td><input name="email"></td>
			</tr>
			<tr>
				<td>Введіть контактний телефон</td>
				<td><input name="phone"></td>
			</tr>
		
				
		</table>
		<br><input type="submit" value="OK">
	</form>
	 --%>
	
	
	<a href="/Alisa">Назад</a>
	</div>
</body>
</html>