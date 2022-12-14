<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<head>
<link rel="stylesheet" href="/resources/css/index_style.css?after">
<title>소품샵프로젝트</title>
</head>
<body>
	<%@include file="/WEB-INF/views/top.jsp"%>
	<div class="body">
		<div class="content" align="center">
			<div class="w3-content slideContent">
				<img class="mySlides" src="/resources/img/Frame51.png"> <img
					class="mySlides" src="/resources/img/Frame52.png"> <img
					class="mySlides" src="/resources/img/Frame53.png">
			</div>
			<div class="products">
				<c:forEach items="${list}" var="list">
				<div class="section">
						<a href="/product/productDetail?id=${list.p_id}">
						<img src="/resources/upload/${list.p_fileName}"><br>
							<b><span id="productName">${list.p_name}</span></b><br><br>
							<b><span id="productPrice"><fmt:formatNumber value="${list.p_unitPrice}" pattern="###,###,###" />원</span></b>
						</a>
					</div>
				</c:forEach>

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