<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<head>
<script src="http://code.jquery.com/jquery-1.11.3.js"></script>

<title>배송관리</title>

<link href="https://fonts.googleapis.com/css?family=Inter&display=swap"
   rel="stylesheet" />
<link rel="stylesheet" href="/resources/css/shipping.css">
</head>

<body>
   
<%@include file="/WEB-INF/views/top.jsp"%>


<script>
function statusModify(ship_id, idx) {
	   
	   var statusSelect = document.getElementById('statusSelect'+idx).value;
	   location.href = '/admin/shipping/modifyShippingStatus?page=1&ship_id=' + ship_id + '&statusSelect=' + statusSelect;
}
</script>

<script>
function search(){
	
	var searchType = $("#searchType").val();
	var keyword =  $("#keyword").val();
	location.href = '/admin/shipping/shippingList?page=1&searchType=' + searchType + '&keyword=' + encodeURI(keyword);
}
</script>


<br>
<h1 class="shipTitle">배송관리</h1>
<hr>
 
<div class="tableDiv">

   <table class="InfoTable" id="InfoTable">
      <tr>
         <th>배송번호</th>
         <th>주문번호</th>
         <th>주문자 ID</th>
         <th>주문자 이름</th>
         <th>주문자 전화번호</th>
         <th>배송지</th>
         <th>배송상태</th>
         <th>상태변경</th>
      </tr>

	<tbody>
	
	<c:forEach items="${shippingList}" var="shippingList">
	<tr id="tr">
	   <td>${shippingList.shipID}</td>
	   <td>${shippingList.orderID}</td>
	   <td>${shippingList.userID}</td>
	   <td>${shippingList.username}</td>
	   <td>${shippingList.telno}</td>
	   <td>${shippingList.address}</td>
	   <td>
	      <form name="statusForm" id="statusForm" method="post">
	         <select id="statusSelect${shippingList.idx}" name="statusSelect"
	            class="statusSelect">
	            <option value="none" disabled selected>${shippingList.status}</option>
	            <option value="결제완료">결제완료</option>
	            <option value="배송전">배송전</option>
	            <option value="배송중">배송중</option>
	            <option value="배송완료">배송완료</option>
	            <option value="주문취소">주문취소</option>
	         </select>
	      </form>
	   </td>
	   <td><input type="button" name="statusBtn" id="statusBtn"
	      value="변경" onclick="statusModify('${shippingList.shipID}', '${shippingList.idx}')" /><td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
	<br>
<br>
<div class="search">
       <select id="searchType" name="searchType">
          <option value="orderID">주문번호</option>
          <option value="userID">주문자ID</option>
           <option value="status">배송상태</option>
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
		<a href="/admin/shipping/shippingList?page=1">처음으로</a>&nbsp;&nbsp;
	</div>
	
<%@include file="/WEB-INF/views/footer.jsp"%>

</body>
</html>