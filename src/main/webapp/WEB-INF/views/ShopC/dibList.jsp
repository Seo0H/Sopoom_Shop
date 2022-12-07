<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<head>
<script src="http://code.jquery.com/jquery-1.11.3.js"></script>
<title>찜목록</title>
<link rel="stylesheet" href="/resources/css/myDibs.css">
</head>

<script>
function orderCancle(shipID) { 
	console.log(shipID);
	if(confirm("정말로 취소하시겠습니까?") == true) {
		location.href='modify_myOrder.jsp?ship_id='+shipID+'&statusSelect=주문취소';
	}
}
</script>

<body>

	<%@include file="/WEB-INF/views/top.jsp"%>
	<h1 class="title">찜목록</h1>
	<hr>
	
	<c:forEach items="${dibsList}" var="dibsList">			
	<div class="whole">
		<li class="goods_pay_item payorder">
			<div class="goods_item">
			 	<!-- 상품 상세 페이지로 이동 -->
				<a href="/product/productDetail?id=${dibsList.p_id}" class="goods_thumb"> <img  src="/resources/upload/${dibsList.p_fileName}" width="60" height="60" alt="상품사진">
				</a>
				<div class="goods_info">
					<a class="goods" href="/product/productDetail?id=${dibsList.p_id}">
						<p class="name">${dibsList.p_name}</p>
						<ul class="info">
							<li><span class="blind">상품금액</span> ${dibsList.p_unitPrice}원</li>
							<li class="date"><span class="blind"></span></li>
						</ul>
					</a> <span class="state _statusName "></span>
					
				</div>
			</div>
		</li>
		<br>
	</div>
	</c:forEach>
<br><br>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>