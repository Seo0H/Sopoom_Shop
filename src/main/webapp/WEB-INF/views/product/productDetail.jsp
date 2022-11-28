<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>

<head>
<meta charset="UTF-8">

<title>상품 상세 정보</title>
<link rel="stylesheet" href="/resources/css/product_style.css">

<%-- <script src="${pageContext.request.contextPath}/css/product_style.css"></script> --%>
<script type="text/javascript">

   function purchaseNow2() {
         document.addForm.submit();
   }
   
   function addToCart() {
      if (confirm("상품을 장바구니에 추가하시겠습니까?")) {
         document.addForm.submit();
      } else {
         document.addForm.reset();
      }
   }
   
   async function addToDibs(uid) {
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
   }
   
   
</script>

</head>

<body>

	<jsp:include page="/WEB-INF/views/top.jsp" />

	<div class="content" align="center">
		<div class="product_view" align="center">
			<h2 style="display:inline-block">${product.p_name}</h2>
			<div style="display:inline-block">
			</div>
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
						<td class="price"><b><fmt:formatNumber value="${product.p_unitPrice}" pattern="###,###,###" /></b>원</td>
					</tr>
				</tbody>
			</table>
			<div class="img">
				<img src="${pageContext.request.contextPath}/resources/upload/${product.p_fileName}" alt="" />
			</div>
			<div>
				<form name="addForm" id="addForm" class="btns" method="post"
					action="/ShopC/addCart?id=${product.p_id}">
					<a href="/Purchase/purchase_now?id=${product.p_id} class="btn_order"
						onclick="purchaseNow2()">상품주문</a> <INPUT type="hidden"
						ID="productID" NAME="Submit" VALUE='${product.p_id}'>
					<a href="/ShopC/addCart?id=${product.p_id}" class="btn_bucket"
						onclick="addToCart()">장바구니</a>
				</form>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>