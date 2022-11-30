<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<style>
#chkIcon{
  font-variation-settings:
  'FILL' 0,
  'wght' 600,
  'GRAD' 0,
  'opsz' 48;
  font-size : xx-large;
  color : #002800;
}

.wrap{
	margin : auto;
	width : 700px;
	min-width : 700px
}

h3{
	text-align :left;
	margin : 30px 5px;
}

.resultBox{
	border: 1px solid #BFBFBF;
	margin : auto;
	margin-top : 40px;
	margin-bottom : 70px;
	min-width : 600px;
	padding : 50px;
	text-align : center;

}


#infoMsg{
	font-weight : bold;
	font-size : 16pt;
	color : blue;
}


.rowMsg{
	margin : 10px;
}

.row{
	margin-bottom : 30px;
}

.label{
	font-weight : bold;
	color : #313131;
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

#btn_home{
	color: #FFFFFF !important;
    background-color: #313131 !important;
    border-color: #313131 !important;
    border-width : 1px;
    transition-duration: 0.4s;
}

#btn_home:hover{
 	opacity : 0.7;
}

</style>

<head>
<meta charset="UTF-8">
<title>JSP미니 프로젝트</title>
</head>
<body>
	<%@include file="/WEB-INF/views/top.jsp"%>
	<div class="wrap">
	<h3>비밀번호 찾기</h3>
	<div class="resultBox">
	<div class="row"><span class='material-symbols-outlined' id="chkIcon">check</span></div>
	<div class="rowMsg">찾고계신 아이디는 </div>
	<div class="rowMsg"><span id="infoMsg">${userid}</span> 입니다.</div>
	</div>
	<div align="center">
	<br>
	<input type="button" class="button" id="btn_home" value="HOME" onClick="location.href='../'">
	<br>
	</div>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>