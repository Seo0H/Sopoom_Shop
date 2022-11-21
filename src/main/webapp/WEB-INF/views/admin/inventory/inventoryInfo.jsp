<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8">
<title>발주 페이지</title>
<link href="https://fonts.googleapis.com/css?family=Inter&display=swap"
	rel="stylesheet" />
<link rel="stylesheet" href="/resources/css/inventory.css">
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
window.onload = function() {
	$("#p_price").val($("#p_price").val().replace(/\B(?=(\d{3})+(?!\d))/g, ","));		
};

function modifyInfo(){
	if(parseInt(document.getElementById('p_amount_value').value) <= 0) { 
		alert("올바른 수량을 입력해주세요");  
		document.getElementById('p_amount_value').focus(); 
		return false;  
	}
	if(confirm('수정하시겠습니까?')){
		$("#ModifyForm").attr("action", "/admin/inventory/inventoryInfo?p_id=${view.p_id}").submit();
	}
}

function deleteInventory(){
	if(confirm('삭제하시겠습니까?')==true){
		$("#ModifyForm").attr("action", "/admin/inventory/deleteInventoryInfo?p_id=${view.p_id}").submit();
	}
}
</script>

</head>
<body>

	<%@include file="/WEB-INF/views/top.jsp"%>
	<div align="center">
		<h1 class="editTitle">상품 발주</h1>
		<br>

	<form id="ModifyForm" name="ModifyForm" method="POST">
		<div class="row">
				<label class="title">상품이미지</label> 
				<input type="image" src="/resources/upload/${view.p_fileName}" alt="상품이미지" class="p_image" id="p_image" disabled>
		</div>
		<div class="row">
				<label class="title">상품코드</label> 
				<input type="text" class="p_id" id="p_id" value="${view.p_id}" disabled></input>
		</div>
		<div class="row">
				<label class="title">상품이름</label> 
				<input type="text" class="p_name" id="p_name" value="${view.p_name}" disabled></input>
		</div>
		<div class="row">
				<label class="title">상품가격</label> 
				<input type="text" class="p_price" id="p_price" value="${view.p_unitPrice} ￦" disabled></input>
		</div>
		<div class="row">
				<label class="title">상품수량</label>
				<input type="number" class="p_amount_value" id="p_amount_value" name="p_amount_value" value="${view.p_unitsInStock}"></input> 
		</div>

		<input type="button" id="btn_modify" class="button" onclick="modifyInfo()" value="수정">
		<input type="button" id="btn_delete" class="button" onclick="deleteInventory()" value="삭제">
		<br>
		<input type="button" id="btn_list" class="button" onclick="location.href='/admin/inventory/inventoryList'" value="목록"></input>
	</form>
	</div>

	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>