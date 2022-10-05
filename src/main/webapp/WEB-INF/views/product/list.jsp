<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@page import="java.text.DecimalFormat"%>

<!DOCTYPE html>
<html>
<meta charset="UTF-8">

<head>
<!-- 경로 맞춰서 다시 적용하기 -->
<!-- <link rel="stylesheet" href="css/index_style.css"> -->
<title>소품샵프로젝트</title>
<style>
.mySlides {
	display: none;
	width: 1200px;
	height: 417.81px;
}

.w3-content slideContent {
	width: 1887px !important;
	height: 657px;
	margin: auto;
}

.products {
	width: 960px;
	height: auto;
}

.section {
	width: 280px;
	margin: auto;
	margin-left: 40px !important;
	float: left;
}

.section img {
	width: 280px;
	height: 385px;
}

.section img:hover {
	filter: opacity(0.8);
}

.section a {
	text-decoration-line: none;
	color: inherit;
}

.section a:hover {
	cursor: pointer;
}

#productName {
	margin-top: 1.2em;
	color: #555555;
	font-family: Pretendard;
	font-weight: 600;
	letter-spacing: -0.05em;
	white-space: nowrap;
}

#productPrice {
	color: #747474;
	font-size: 12px;
	font-family: Pretendard;
	font-weight: 700t;
	letter-spacing: 0em;
}
</style>

</head>

<body>
	<%@include file="top.jsp"%>
	<div class="body">
		<div class="content" align="center">

			<div class="w3-content slideContent">
				<img class="mySlides" src="/resources/img/Frame51.png"> <img
					class="mySlides" src="/resources/img/Frame52.png"> <img
					class="mySlides" src="/resources/img/Frame53.png">
			</div>

			<div class="products">

				<div class="section">
					<c:forEach items="${list}" var="list">
						<a href="/Category/product.jsp?id=${list.p_id}"> <img
							src="/resources/upload/${list.p_fileName}"><br> <b><span
								id="productName">${list.p_name}</span></b><br> <br> <b><span
								id="productPrice">${list.p_unitPrice}원</span></b>
						</a>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

	<%@include file="./footer.jsp"%>

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