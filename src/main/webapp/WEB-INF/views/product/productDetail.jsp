<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>

<head>
<meta charset="UTF-8">

<title>상품 상세 정보</title>
<link rel="stylesheet" href="/resources/css/product_style.css">
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#btn_like")
								.click(
										function() {
											console.log($("#p_id").val());
											$
													.ajax({
														url : "/ShopC/addLike",
														type : "post",
														dataType : "json",
														data : {
															"p_id" : $("#p_id")
																	.val()
														},
														success : function(data) {
															message = data;
															console
																	.log("message = "
																			+ message);

															if (message == "empty") {
																$("#btn_like")
																		.attr(
																				"src",
																				"/resources/img/beforeDibs.png");
															} else if (message == "full") {
																$("#btn_like")
																		.attr(
																				"src",
																				"/resources/img/afterDibs.png");
															}
														},
														error : function(map) {
															alert("서버오류 문제로 찜 등록이 실패 했습니다. 잠시 후 다시 시도해주시기 바랍니다.");
															return false;
														}

													});
										});
					});

	function purchaseNow2() {
		document.addForm.submit();
	}

	
	
	function click() {
		const id = <c:out value="${product.p_id}"/>;
		location.href="/Purchase/purchaseNow?id=" + id ;
	}

	/* 	 async function addToDibs(uid) {
	 if(uid != "null") {
	 //찜목록에 저장
	 await showConfirm();
	 // document.dibsAddForm.submit();
	 document.getElementById("emptyHeart").src = "/img/afterDibs.png";
	 }
	 else {	
	 alert("로그인이 필요한 서비스입니다."); 
	 location.href = "/Login/login.jsp";
	 }
	 }
	
	 //새로고침 안해도 바로 반영되게 수정!
	 function deleteToDibs() {
	 console.log("uncheck");
	 document.getElementById("fullHeart").src = "/img/beforeDibs.png";
	 document.dibsDeleteForm.submit();
	 }
	
	 function sleep(delay) {
	 var start = new Date().getTime();
	 while (new Date().getTime() < start + delay);
	 }
	
	 function showConfirm(){
	 document.dibsAddForm.submit();
	 } */
	 
	 function addToCart() {
			if (confirm("상품을 장바구니에 추가하시겠습니까?")) {
				const id = <c:out value="${product.p_id}"/>;
				location.href="/ShopC/addCart?id=" + id ;
				}
		}
</script>

<style>
#btn_order {
	display: inline-block;
	width: 140px;
	height: 50px;
	font-size: 18px;
	color: black;
	border-radius: 50px;
	line-height: 50px;
	text-decoration-line: none;
	color: #FFFFFF !important;
	background-color: #313131 !important;
}
</style>
</head>

<body>

	<jsp:include page="/WEB-INF/views/top.jsp" />

	<div class="content" align="center">
		<div class="product_view" align="center">
			<h2 style="display: inline-block">${product.p_name}</h2>
			<div style="display: inline-block"></div>
			<hr>
			<table>
				<colgroup>
					<col style="width: 180px;">
					<col>
				</colgroup>
				<tbody>
					<tr>
						<th>상품 코드</th>
						<td>${product.p_id}</td>
					</tr>
					<tr>
						<th>제조사/공급사</th>
						<td>${product.p_manufacturer}</td>
					</tr>
					<tr>
						<th>설명</th>
						<td>${product.p_description}</td>
					</tr>
					<tr>
						<th>판매가</th>
						<td class="price"><b><fmt:formatNumber
									value="${product.p_unitPrice}" pattern="###,###,###" /></b>원</td>
					</tr>
				</tbody>
			</table>
			<input type="hidden" id="p_id" value="${product.p_id}" />
			<div class="img">
				<img
					src="${pageContext.request.contextPath}/resources/upload/${product.p_fileName}"
					alt="" />
			</div>
			<img id="btn_like" name="btn_like" src="${btn_src}" alt="heart">

			<div>
				<a href="/Purchase/purchaseNow?id=${product.p_id}" id="btn_order" class="btn_order">상품주문</a>
				<input type="hidden" ID="productID" NAME="Submit"	VALUE='${product.p_id}'> 
				<button class="btn_bucket" onclick="addToCart()">장바구니</button>
			</div>
		</div>
	</div>
	</div>

	<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>