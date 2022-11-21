<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<head>
<script src="http://code.jquery.com/jquery-1.11.3.js"></script>
<title>재고관리</title>
<link href="https://fonts.googleapis.com/css?family=Inter&display=swap"
	rel="stylesheet" />
<link rel="stylesheet" href="/resources/css/inventory.css">

<script>

window.onload = function() {
	var rows = document.getElementsByName('tdPrice');
	
	for(var i=0; i<rows.length; i++){		rows[i].innerText = rows[i].innerText.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	}					
};
</script>
</head>

<body>

	<%@include file="/WEB-INF/views/top.jsp"%>
	<br>
	<h1>재고관리</h1>
	<hr>
	<div class="tableDiv">
		<table class="InventoryInfoTable">
			<tr>
				<th style="text-align: left">상품코드</th>
				<th>상품명</th>
				<th style="text-align: right">가격</th>
				<th style="text-align: right">수량</th>
			</tr>

			<tbody>
			<c:forEach items="${inventoryList}" var="inventoryList">
					<tr>
					<td class="tdId">${inventoryList.p_id}</td>
					<td class="tdName"><a id="hypertext"
						href="/admin/inventory/inventoryInfo?p_id=${inventoryList.p_id}"
						onMouseover="this.style.textDecoration='underline'"
						onmouseout="this.style.textDecoration='none'">${inventoryList.p_name}</a></td>
						
						<td class="tdPrice" id="tdPrice" name="tdPrice">￦ ${inventoryList.p_unitPrice}</td>
					<td class="tdStock">${inventoryList.p_unitsInStock}</td>
				</tr>
				</c:forEach>
							</tbody>
		</table>
		<br>
		<div>
			<div class="search">
		<select id="searchType" name="searchType">
			<option value="p_id">상품코드</option>
			<option value="p_name">상품명</option>
			<option value="p_unitPrice">가격</option>
			<option value="p_unitsInStock">수량</option>
		</select> <input type="text" id="keyword" name="keyword" />
		<button type="button" class="searchBtn" onclick="search()">검색</button>
		
		<br><div class="pageList">
		</div>
</div>
<br><br>
		</div>
	</div>

	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>