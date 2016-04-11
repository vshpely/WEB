<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" uri="/resources/taglib/customTaglib.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
<!-- CSS для роботи jqgrid -->
<link href="<c:url value="/resources/css/ui.jqgrid.css" />" rel="stylesheet">
<!-- Script для роботи jqgrid -->
<script src="<c:url value="/resources/js/jquery-1.7.2.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.jqGrid.min.js" />"></script>
<!-- Bootstrap -->
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<title>Тестування Bootstrap</title>
</head>
<body>
<div class=".container-fluid">
	<div class="row">
    	<div class="col-md-10">
    	<table class="table table-hover table-bordered">
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
			<tr>
				<td colspan="9" style="text-align: center">
					<ul class="pagination">
  					<li><a href="#">&laquo;</a></li>
  					<li><a href="#">1</a></li>
  					<li><a href="#">2</a></li>
  					<li><a href="#">3</a></li>
  					<li><a href="#">4</a></li>
  					<li><a href="#">5</a></li>
  					<li><a href="#">&raquo;</a></li>
</ul>
				</td>
			</tr> 
			</table>
    	
    	</div>
	</div>

	

</div>
<!-- <script type="text/javascript">
		$(function(){
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
<table id="list"><tr><td></td></tr></table> 
    <div id="pager"></div>  -->
</body>
</html>