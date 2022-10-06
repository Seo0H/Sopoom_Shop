<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<head>
<script src="http://code.jquery.com/jquery-1.11.3.js"></script>
<title>회원목록</title>
<link href="https://fonts.googleapis.com/css?family=Inter&display=swap"
	rel="stylesheet" />
<link rel="stylesheet" href="/resources/css/member.css">
</head>

<body>
	<%@include file="/WEB-INF/views/top.jsp"%>
	<%
	int idx = 1;
	%>


	<br>
	<h1 class="memberTitle">회원목록</h1>
	<hr>

	<div class="tableDiv">
		<table class="InfoTable">
			<tr>
				<th>INDEX</th>
				<th>USER ID</th>
				<th>USER NAME</th>
				<th class="thEmail">E-MAIL</th>
			</tr>

			<tbody>
				<c:forEach items="${allMemberInfoView}" var="allMemberInfoView">
				<tr>
					<td class="tdIndex"><%=idx++%></td>
					<td class="tdId"><a id="hypertext"
						href="/Admin/Member/edit_memberInfo.jsp?userID=${allMemberInfoView.userID}"
						onMouseover='this.style.textDecoration="underline"'
						onmouseout="this.style.textDecoration='none';">${allMemberInfoView.userID}</a></td>
					<td class="tdName">${allMemberInfoView.username}</td>
					<td class="tdEmail">${allMemberInfoView.email}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<div>
			<!-- 페이지 -->
		</div>
	</div>
	<br>
	<div class="search">
		<select id="searchType" name="searchType">
			<option value="userID">회원아이디</option>
			<option value="username">회원명</option>
			<option value="telno">전화번호</option>
			<option value="username_telno">이름+번호</option>

		</select> <input type="text" id="keyword" name="keyword" />
		<button type="button" class="searchBtn" onclick="search()">검색</button>

		<br>
		<div class="pageList">
			<!-- page 임의로 삭제 후에 추가하기! -->
		</div>
	</div>
	<br>
	<br>

	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>
