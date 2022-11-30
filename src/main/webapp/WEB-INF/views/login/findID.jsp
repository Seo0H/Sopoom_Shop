<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>

	$(document).ready(function(){
				
		$("#btn_register").click(function(){
			//이름
			if($("#username").val() == '') { $("#msg_name").css('display', 'block'); $("#username").focus(); return false; }
			else{	$("#msg_name").css('display', 'none');}
			
			//이메일
		 	var eMail = $("#email").val();
		 	var regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
		 	
		 	if($("#email").val() == '') {
		 		$("#msg_email").text("이메일주소를 입력해주세요."); 
		 		$("#msg_email").css('display', 'block'); 
		 		$("#email").focus();
		 		return false;
		 	}
		 	
		 	else if (!regEmail.test(eMail)) {
		 		$("#msg_email").text("이메일 형식이 올바르지 않습니다.");
		 		$("#msg_email").css('display', 'block');
		 		$("#email").focus();
		 		return false;
		      }
		 	else{
		 		$("#msg_email").css('display', 'none');
		 		}
		 	
			$("#findIDForm").attr("action","/login/findID").submit();	
		});
	});	
</script>

<style>
#findIDForm{
	margin : auto;
	min-width : 700px;
}

#innerForm{
	margin : auto;
	width : 400px;
}
h3{
	text-align :left;
	margin : 30px 5px;
}

.title{
	display : block;
	margin-bottom : 12px;
	line-height : 17px;
	letter-spacing : -0.1em;
}

.field{
	font-size : 14px;
	line-height:23px;
	width : 100%;
	border : 1px solid #BFBFBF;
	padding : 10px 15px;
	box-sizing : border-box;
}

input:focus{
    outline: none;
}

.row{
	margin : 0px 5px;
	font-size : 14px;
	line-height : 17px;
	margin-bottom : 20px;
}

.button{
	padding: 5px;
	margin : auto;
	cursor : pointer;
	border-radius : 50px;
	width : 100%;
	max-width : 240px;
	min-width : 160px;
	height : 54px ! important;
	min-height : 54px;
	font-size : 14px !important;
	font-weight : 700;
}

#btn_register{
	color: #FFFFFF !important;
    background-color: #313131 !important;
    border-color: #313131 !important;
    border-width : 1px;
    transition-duration: 0.4s;
}


#btn_register:hover{
 	opacity : 0.7;
}

.msg{
	font-size:12px;
}

#msg_email, #msg_name{
	display : none;
	color: red;
}


</style>
<head>
<meta charset="UTF-8">
<title>JSP미니 프로젝트</title>
</head>
<body>
	<%@include file="/WEB-INF/views/top.jsp"%>
	<form name="findIDForm" id="findIDForm" method="post"> 
	<div id="innerForm">
	<h3>아이디 찾기</h3>
	<div class="row">
		<label class="title">이름</label>
		<input type="text" class="field" id="username" name="username" maxlength="50" autoComplete="off">
		<div id="msg_name" class="msg">이름을 입력해주세요.</div>
	</div>
	<div class="row">
		<label class="title">이메일</label>
		<input type="text" class="field" id="email" name="email" autoComplete="off" />
				<div id="msg_email" class="msg"></div>
	</div>
	<br>
	<c:if test="${msg == 'USER_NOT_FOUND' }">
         		<p style="color:red;text-align:center;">정보에 일치하는 회원이 존재하지 않습니다.</p> 
    </c:if>
	</div>
	</form>
	<div align="center">
		<input type="button" id="btn_register" class="button" value="아이디 찾기">
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>