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

<script>
function search(){
	
	var searchType = $("#searchType").val();
	var keyword =  $("#keyword").val();
	location.href = '/admin/member/allMemberInfoView?page=1&searchType=' + searchType + '&keyword=' + encodeURI(keyword);
}
</script>

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
						href="/admin/member/memberInfoView?userID=${allMemberInfoView.userID}"
						onMouseover='this.style.textDecoration="underline"'
						onmouseout="this.style.textDecoration='none';">${allMemberInfoView.userID}</a></td>
					<td class="tdName">${allMemberInfoView.username}</td>
					<td class="tdEmail">${allMemberInfoView.email}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
	</div>
	<br>
	<div class="search">
		<select id="searchType" name="searchType">
			<option value="userID">회원아이디</option>
			<option value="username">회원명</option>
			<option value="telno">전화번호</option>
			</select>
			
		<input type="text" id="keyword" name="keyword" />
		<button type="button" class="searchBtn" onclick="search()">검색</button>

		<br>
		
		<div class="pageList">
		${pageListView}
		</div>
	</div>
<br><br>
	<div class="bottom_menu">
		<a href="/admin/member/allMemberInfoView?page=1">처음으로</a>&nbsp;&nbsp;
	</div>
	
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>
