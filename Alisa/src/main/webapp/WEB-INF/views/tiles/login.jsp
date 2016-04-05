<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.login{
	margin: 0 auto;
	height:500px;
	width: 200px;
	padding-top:20px;
	}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Форма входу</title>
</head>
<body>
<div class="login">
	<form action="?${_csrf.parameterName}=${_csrf.token}" method="post">
		<table>
		<tr>
			<td>Логін</td>
			<td><input name="username"></td>
		</tr>
		<tr>
			<td>Пароль</td>
			<td><input name="password" type="password"></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="OK"></td>
		</tr>
		</table> 
	</form>
</div>
</body>
</html>