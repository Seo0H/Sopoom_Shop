<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@page import="java.text.DecimalFormat"%>

<!DOCTYPE html>
<html>
<meta charset="UTF-8">

<head>

<link rel="stylesheet" href="/resources/css/index_style.css">
<title>소품샵프로젝트</title>
</head>

<body>
	<%@include file="/WEB-INF/views/top.jsp"%>
	<div class="body">
		<div class="content" align="center">

			<div class="w3-content slideContent">
				<img class="mySlides" src="/resources/img/Frame51.png"> <img class="mySlides" src="/resources/img/Frame52.png"> <img class="mySlides" src="/resources/img/Frame53.png">
			</div>

			<div class="products">

				<div class="section">
					<c:forEach items="${list}" var="list">
						<a href="/Category/product?id=${list.p_id}"> <img src="/resources/upload/${list.p_fileName}"><br> <b><span id="productName">${list.p_name}</span></b><br> <br> <b><span id="productPrice">${list.p_unitPrice}원</span></b>
						</a>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

	<%@include file="/WEB-INF/views/footer.jsp"%>

	<script>
		var myIndex = 0;
		carousel();

		function carousel() {
			var i;
			var x = document.getElementsByClassName("mySlides");
			for (i = 0; i < x.length; i++) {
				x[i].setAttribute("style", "display:none");
			}
			myIndex++;
			if (myIndex > x.length) {
				myIndex = 1
			}
			x[myIndex - 1].setAttribute("style", "display:block");
			setTimeout(carousel, 2000); // Change image every 2 seconds
		}
	</script>
</body>
</html>