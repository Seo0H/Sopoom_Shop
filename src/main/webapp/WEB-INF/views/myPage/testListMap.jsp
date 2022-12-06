<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${orderListSize!=0}">
		<c:forEach var="list" items="${order}" varStatus="status1" >
		
			제품 이름: ${list.p_name} <br>
			총 가격: ${list.totalPrice} <br>
			파일 이름: ${list.p_fileName} <br>
			주문 날짜: ${list.orderDate} <br>
			유저 아이디: ${list.userID} <br>
			제품 아이디: ${list.p_id} <br>
			배송 아이디: ${list.shipID} <br>
			주문 상태: ${list.status} <br>
			--------------------------<br>
		</c:forEach>
	</c:if>
</body>
</html>