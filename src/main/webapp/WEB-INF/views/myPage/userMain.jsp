<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>유저 정보 - 메인 페이지</title>

<link rel="stylesheet" as="style" crossorigin href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.5/dist/web/static/pretendard.css" />
<link rel="stylesheet" href="/resources/css/userMain.css">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
	<script>
		function pwConfig() {
			var btn = document.getElementById('password').value;

			if (btn == "") {
				alert("패스워드를 입력하세요.");
				return false;
			
			} else {
				document.userbasic.action = "/myPage/pwCheck";
				document.userbasic.action.submit;
			}

		}

		function press() {
			if (event.keyCode == 13) {
				pwConfig();
			} //13은 엔터
		}
	</script>


	<%
		String userid = (String)session.getAttribute("userID");

	if (userid == null) {
	%>
	<script>
	alert("로그인이 필요한 서비스입니다."); location.href = "./login.jsp";
	</script>
	<%
	}
	%>

	<%@include file="/WEB-INF/views/top.jsp"%>
	
	<!-- 회원 정보 네비게이션 바 -->
	<div id="display-canvas">
		<div class="mypage">

			<div class="container">

				<div class="head-title">
					<div class="heade-title-container">
						<span class="mainTitle">회원 정보</span>
					</div>
				</div>

				<div class="left-container">
					<div class="row">
						<label class="title">로그인 아이디</label>
						<input type="text" class="field" readonly="readonly" value="${memberVO.getUserID()}">
					</div>
					<div class="row">
						<label class="title">회원 이메일</label>
						<input type="text" class="field" readonly="readonly" value="${memberVO.getEmail()}">
					</div>
					<div class="row">
						<label class="title">비밀번호</label>
						<input type="text" class="field" readonly="readonly" value="********">
					</div>
					<div class="row">
						<label class="title">휴대폰 번호</label>
						<input type="text" class="field" readonly="readonly" value="${memberVO.getTelno()}">
					</div>

					<div class="row">
						<button class="field shipping-conf-btn" onclick="location.href='/myPage/myOrder?userID=${memberVO.getUserID()}'">배송 정보</button>
						<button class="field shipping-conf-btn" onclick="location.href='/ShopC/dibList?userID=${memberVO.getUserID()}'">찜목록</button>
					</div>
				</div>


				<form name=userbasic id=userbasic method="post">
					<div class="right-container">
						<div class="row">
							<label class="title">이름</label>
							<input type="text" class="field" readonly="readonly" value="${memberVO.getUsername()}">
						</div>
						<div class="row">
							<label class="title">우편 번호</label>
							<input type="text" class="field" readonly="readonly" value="${memberVO.getPostcode()}">
						</div>
						<div class="row">
							<label class="title">주소</label>
							<input type="text" class="field " readonly="readonly" value="${memberVO.getAddress()}">
							<input type="text" class="field" readonly="readonly" value="${memberVO.getDetailAddress()}">
							<input type="text" class="field" readonly="readonly" value="${memberVO.getExtraAddress()}">
						</div>
						<div class="row" id="pw-check">
							<input type="password" name="password" id="password" class="field" placeholder="개인정보를 변경하려면 비밀번호를 입력해주세요" value="" onkeydown="press()">
							<c:if test="${msg == 'PASSWORD_NOT_FOUND' }">
							<div id="msg_id" class="msg"> 비밀번호가 일치하지 않습니다.</div>
							</c:if>
						</div>
						<div class="row">
							<input type="submit" id="pwconfigBtn" class="field user-info-modify-btn" onclick="pwConfig()" value="비밀번호 확인">
						</div>
					</div>
			</form>	
			</div>
		</div>
	</div>

	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>