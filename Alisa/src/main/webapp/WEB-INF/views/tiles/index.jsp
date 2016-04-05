<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
	.ipage{
	width: 90%;
	margin: 0 auto;
	}
	.product{
		width: 250px;
		height:180px;
		float: left;
		border:1px solid black;
		margin: 5px;
		background-color:#F0F8FF; 
		
	}
	.product:hover{
		background-color:white; 
	}
	table{
		width: 249px;
	}
	td{
		text-align: center;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="ipage">
<div class="content">
	<c:forEach var="Product" items="${Products}">
				<div class="product">
				<table>
				<tr>
					<td><img src="${Product.productPhotoUtl}"></img></td>
				</tr>
				<tr>
					<td>${Product.articul}</td>
				</tr>
				<tr>
					<td>${Product.price}</td>
				</tr>
				</table>
				</div>
				</c:forEach>

</div>
</div>
</body>
</html>