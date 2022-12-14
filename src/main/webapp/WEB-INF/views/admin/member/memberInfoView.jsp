<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<title>회원정보 변경</title>

<link href="https://fonts.googleapis.com/css?family=Inter&display=swap"
	rel="stylesheet" />
<link rel="stylesheet" href="/resources/css/userMain.css">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script>

function modifyForm(){
	$("#ModifyForm").attr("action", "/admin/member/modifyMember").submit();
	}
	
function deleteMember(){
	if(confirm('탈퇴처리하시겠습니까?')==true){
		document.location.href = '/admin/member/deleteMember?userID=${memberInfoView.userID}';
	}
}
</script>

<script type="text/javascript"> 
function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
               // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수
               //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }
               // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("extraAddress").value = extraAddr;
               } else {
                    document.getElementById("extraAddress").value = '';
                }
               // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("detailAddress").focus();
            }
        }).open();
       }
</script>

</head>
<body>
	<%@include file="/WEB-INF/views/top.jsp"%>

	<div id="display-canvas">
		<div class="mypage">

			<div class="container">

				<div class="head-title">
					<div class="heade-title-container">
						<h1 class="mainTitle">회원 정보</h1>
					</div>
				</div>

				<form id="ModifyForm" class="ModifyForm" method="POST">
					<div class="left-container">
						<div class="row">
							<label class="title">이름</label> <input type="text"
								name="username" id="username" class="field"
								value="${memberInfoView.username}">
						</div>
						<div class="row">
							<label class="title">로그인 아이디</label> <input type="text"
								name="userID" id="userID" class="field" readonly="readonly"
								value="${memberInfoView.userID}">
						</div>
						<div class="row">
							<label class="title">회원 이메일</label> <input type="text"
								name="email" id="email" class="field" value="${memberInfoView.email}">
						</div>
			
						<div class="row">
							<label class="title">휴대폰 번호</label> <input type="text"
								name="telno" id="telno" class="field" value="${memberInfoView.telno}">
						</div>
					</div>

					<div class="right-container">
				
						<div class="row">
							<label class="title" id="postcodeTitle">우편 번호</label> 
							<input type="button" id="btn_address" onclick="execDaumPostcode()" value="우편번호 찾기">
							<input type="text"
								name="postcode" id="postcode" class="field"
								value="${memberInfoView.postcode}">
								
						</div>
						<div class="row">
							<label class="title">주소</label> <input type="text" name="address"
								id="address" class="field " value="${memberInfoView.address}">
						</div>
						<div class="row">
							<label class="title">세부 주소</label> <input type="text"
								name="detailAddress" id="detailAddress" class="field"
								value="${memberInfoView.detailAddress}">
						</div>
						<div class="row">
							<label class="title">추가 주소</label> <input type="text"
								name="extraAddress" id="extraAddress" class="field"
								value="${memberInfoView.extraAddress}">
						</div>
					</div>

				</form>

			</div>

		</div>
		
			<div style="text-align: center; width: 960px; margin:auto;">
				<input type=button id="btn_modify" class="button" onclick="modifyForm()" value="수정">
				<input type=button id="btn_delete" class="button" value="탈퇴"
					onclick="deleteMember()">
				<br>
				<button id="btn_list" class="button" id="btn_list"
					onclick="location.href='/admin/member/allMemberInfoView?page=1'">목록</button>
			</div>		
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>