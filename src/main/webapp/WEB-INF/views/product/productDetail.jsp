<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>

<head>
<meta charset="UTF-8">

<title>상품 상세 정보</title>
<link rel="stylesheet" href="/resources/css/product_style.css">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">

<%
String session_id = (String) session.getAttribute("userID"); 
%>

	
	$(document).ready(function(){
		
		let userId = $("#userid").val();
		let p_id = $("#productID").val();
		
		console.log(p_id);
		
		$("#btn_order").click(function(e) {
			
			if(userId == ""|| userid == 'null'){
				alert("로그인이 필요한 서비스입니다.");
				location.href = "/login/login";
			} else {
				location.href="/Purchase/purchaseNow?id=" + p_id;
			}
		});
		
		$("#btn_bucket").click(function(e) {
			if(userId == "" || userid == 'null'){
				alert("로그인이 필요한 서비스입니다.");
				location.href = "/login/login";
			}else {
				if (confirm("상품을 장바구니에 추가하시겠습니까?")) {
					location.href="/ShopC/addCart?id="+ p_id;
				} 
				
			}
		});
		
		$("#btn_like").click(function(){
			console.log($("#p_id").val());
			$.ajax({
				url : "/ShopC/addLike",
				type : "post",
				dataType : "json",
				data : {"p_id" : $("#p_id").val()},
				success : function(data){
					message = data;
					console.log("message = " + message);
					
					if(message == "empty"){
						$("#btn_like").attr("src", "/resources/img/beforeDibs.png");
					}
					else if(message == "full"){
						$("#btn_like").attr("src", "/resources/img/afterDibs.png");
					}
				} ,
				complete: function(){
					document.location.href = '/product/productDetail?id='+ $("#p_id").val();
				}
				
			});
		});
	});

	
	function purchaseNow2() {
		document.location.href = ''
	}

	function addToCart() {
		if (confirm("상품을 장바구니에 추가하시겠습니까?")) {
			document.addForm.submit();
		} else {
			document.addForm.reset();
		}
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
</script>

</head>

<body>

	<jsp:include page="/WEB-INF/views/top.jsp" />
	
	<input type="hidden" id="userid" value = "<%=session_id%>">

	<div class="content" align="center">
		<div class="product_view" align="center">
			<h2 style="display: inline-block">${product.p_name}</h2>
			<img style='vertical-align: bottom; margin-left: 10px; padding-bottom: 5px;' id="btn_like" name="btn_like" src="${btn_src}" alt="heart">
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
						<td class="price"><b><fmt:formatNumber value="${product.p_unitPrice}" pattern="###,###,###" /></b>원</td>
					</tr>
				</tbody>
			</table>
			<input type="hidden" id="p_id" value="${product.p_id}" />
			<div class="img">
				<img src="/resources/upload/${product.p_fileName}" alt="" />
			</div>


			<div>
				<input type="button" id="btn_order" class=" btn_order" value="상품주문" />
					<INPUT type="hidden" ID="productID" NAME="Submit" VALUE='${product.p_id}'>
				<input type="button" id="btn_bucket" class="btn_bucket" value="장바구니" />
			</div>
		</div>
	</div>
	</div>

	<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>