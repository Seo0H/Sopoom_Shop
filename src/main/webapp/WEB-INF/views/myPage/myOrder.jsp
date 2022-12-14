<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<head>
<script src="http://code.jquery.com/jquery-1.11.3.js"></script>
<title>주문내역</title>
<link rel="stylesheet" href="/resources/css/myOrder.css">

</head>

<%
String userID = request.getParameter("userID");
%>

<script>
	function orderCancle(shipID) {
		console.log(shipID);
		if (confirm("정말로 취소하시겠습니까?") == true) {
			location.href = 'modify_myOrder?ship_id=' + shipID
					+ '&statusSelect=주문취소';
		}
	}
</script>

<body>

	<%@include file="/WEB-INF/views/top.jsp"%>
	<h1 class="title">주문내역</h1>
	<hr>

	<c:if test="${orderListSize!=0}">
		<c:forEach var="list" items="${order}" varStatus="status" >

			<div class="whole">
				<li class="goods_pay_item payorder">
					<div class="goods_item">
						<!-- 상품 상세 페이지로 이동 -->
						<a href="/Category/product.jsp?id=${list.p_id}" class="goods_thumb"> <img src="/resources/upload/${list.p_fileName}" width="60" height="60" alt="상품사진">
						</a>
						<!--N=a:csh.detail-->
						<div class="goods_info">
							<!-- NV_MID: -->
							<a class="goods" href="#">
								<p class="name">${list.p_name}</p>
								<ul class="info">
									<li><span class="blind">상품금액</span> ${list.totalPrice} 원</li>
									<li class="date"><span class="blind">상품구매날짜</span> ${list.orderDate}</li>
								</ul>
							</a> <span class="state _statusName ">&nbsp; ${list.status}</span>
							<p class="guide notify">
								<b>결제 및 상세 내역 확인 및 취소요청은 <a href="/product/list">SOPOOM</a>에서 확인하실 수 있습니다.
								</b><br>(거래완료는 포인트 적립 완료로 확인 가능 / 세금납부는 취소요청 불가함)
							</p>
						</div>
					</div>
					<div class="seller_item">
						<div class="inner">
							<span class="seller">SOPOOM</span> <span class="tel">021234567</span>
							<c:choose>
								<c:when test="${list.status == '주문 완료'}">
									<button onclick="orderCancle('${list.shipID}')" style="cursor: pointer" class="state_button qna">주문취소</button>
								</c:when>
								<c:when test="${list.status == '주문취소'}">
									<button class="state_button qna" onclick="alert('결제가 진행된 이후에는 취소할 수 없습니다.')">주문취소</button>
								</c:when>
							</c:choose>
						</div>
					</div>
				</li>
			</div>

		</c:forEach>
	</c:if>
	<br>
	<br>
	<br>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>