<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- jqGrid 
<spring:url value="/resources/jqgrid/css/ui.jqgrid.css" var="jqgrid_css" />
<spring:url value="/resources/jqgrid/js/jquery.jqGrid.min.js" var="jqGrid_url" />
<link rel="stylesheet" type="text/css" href="${jqgrid_css}"> 
<script type="text/javascript" src="${jqGrid_url}"><jsp:text/></script> 
-->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Адміністрування</title>
</head>
<body>
<p>Тестування jqGrid</p>
	<!-- 	
	<script type="text/javascript">
		$(function()){
			$("#list").jgGrid({
				url:'/list',
				datatype:'json',
				mtype:'GET',
				colNames:['${ProductID}','${ProductArticul}','${ProductName}','${ProductPrice}',
				          '${ProductProducer}','${ProductSize}','${ProductPidcategory}'],
				colMode: [
				          {name:'id', index:'id', width:50},
				          {name:'article', index:'article', width:100},
				          {name:'name', index:'name', width:100},
				          {name:'price', index:'price', width:100},
				          {name:'producer', index:'producer', width:100},
				          {name:'size', index:'size', width:100},
				          {name:'pidcategory', index:'pidcategory', width:100},
				          ],
				jsonReader:{
							root:"productData",
							page:"currentPage",
							total:"totalPage",
							records:"totalRecords",
							repeatitems:false,
							id:"id"
				},
				pager:'#pager',
				rowNum:10,
				rowList:[10,20,30],
				sortname:'name',
				sortorder:'asc',
				viewrecords: true,
				gridview: true,
				height:250,
				width:500,
				caption:'${labelProductList}',
				onSelectRow: function(id){
					document.location.href="${/}" + id; 
				}
			});	
		});
	</script>
	<div>
		<table id="list"><tr></td></tr> </table>
	</div>
	<div>
		<tr></td></tr>
	</div>
 -->
</body>
</html>