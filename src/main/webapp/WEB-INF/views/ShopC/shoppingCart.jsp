<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.lang.Integer"%>

<%@page import="java.text.DecimalFormat"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<%
//String userid = (String)session.getAttribute("userID");
String userid = "sss1";
int totalCount = (Integer)request.getAttribute("totalCount");
%>


<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css" integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" as="style" crossorigin href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.5/dist/web/static/pretendard.css" />
<link rel="stylesheet" href="/resources/css/shoppingCart.css">
<title>장바구니</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
<%@include file="/WEB-INF/views/top.jsp"%>
<%DecimalFormat df = new DecimalFormat("###,###");
	 if (userid == null) { %>
	<script>
		alert("로그인이 필요한 서비스입니다.");
		location.href = "/login.jsp";
	</script>
	<%}%>
	
	<div class="mypage">
		<div class="mypage">
            <div class="head-title">
                <div class="heade-title-container">
                    <span class="mainTitle">장바구니</span>
                </div>
            </div>
	<!-- 있으면 목록 출력, 없으면 비어있음 표시 -->
	<%
   if (totalCount == 0) {
   %>
	<div class="emty">
		<a>장바구니가 비어 있습니다.</a>
	</div>
	<%
   } else {
   %>
	<form id="cartForm" class="cartTable" method="post" action="/Purchase/purchase.jsp">
		<table class="cart-table-container">
                <tr>
                    <th><input type="checkbox" id="allCheck" name="allcheck" checked class="checkabox-container" style="text-align: left; transform : scale(1.5);" > </th>
                    <!-- <th style="text-align: left"></th> -->
                    <th style="text-align: center;" colspan="2">상품 정보</th>
                    <th>수량</th>
                    <th>개별 가격</th>
                    <th>전체 가격</th>
                </tr>

            <c:forEach items="${productVO}" var="cartProductInfo" varStatus="status" >
            
<%--            <c:set var="p_id" value="${cartList.get(i).getP_id()}" /> --%>
<%--             <c:set var="P_fileName" value="${cartProductInfo.get(i).getP_fileName()}" /> --%>
<%--             <c:set var="p_name" value="${cartProductInfo.get(i).getp_name()}" /> --%>
<%--             <c:set var="p_price" value="${cartProductInfo.get(i).getP_price()}" /> --%>
<%--             <c:set var="quantity" value="${cartProductInfo.get(i).getQuantity()}" /> --%>
                <tbody>
                <tr>
                    <td class="tdId checkabox-container">
                        <input type="checkbox" class="checkP" name="checkP${status.index}" value="${status.current.getP_id()}" class="check" checked>
                   		<input type="hidden" name="p_id" value="${status.current.getP_id()}">
                    </td>
                    <td class="tdId img"  style="cursor: pointer;">
                    	<!-- 사진 누르면 상품 넘어가기 구현  -->
                   		<%-- <a href="/product.jsp?id=<%=cartList.get(i).getP_id()%>"> --%>
                        <input type="image" src=" /resources/upload/${status.current.p_fileName}" width="100px" alt="어디갔니..."/>
                        <input type="hidden" name="fileName" id="fileName" value="${status.current.getP_fileName()}" width="100px" />	
                    </td>
                    <td class="tdId Pname" >
                        <a class="name" name="pname" value="${status.current.getP_name()}" 
                        readonly="readonly" href="/product.jsp?id=${p_id}"> ${status.current.getP_name()} </a>
                        <input type="hidden" id="name${status.index} " class="name" name="pname" value="${status.current.getP_name()}" >
                    </td>
                    <td class="tdId quantity" id="quantity${status.index}" class="quantity">
                        <div class="count-box">
                            <div class="btn"> <button type="button" name="countBtn" class="upBtn">
                            <img src="/resources/img/+btn.png" width="30px"></button> </div>
                            <div class="btn"><input class="countInput" type="text" class="countInput" id="quantity" name="countInput" value="${cartVO[status.index].getquantity()}" 
                            	readonly="readonly" style="margin-top: 7px"></div>
                            <div class="btn"><button type="button" name="countBtn" class="downBtn">
                            <img src="/resources/img/-btn.png" width="30px"> </button></div>
                        </div>
                    </td>
                    <td class="tdId P-one-price">
                        <input id="vis_price${status.index}" class="price" name="vis_price" value="${status.current.getP_unitPrice()}" readonly="readonly"> 
                        <input type="hidden" id="price${status.index}" class="price" name="price" value="${status.current.getP_unitPrice()}" readonly="readonly">
                    </td>
                    <td class="tdId  P-price">
                     	<input id="vis_total${status.index}" class="total" name="vis_total" value="${status.current.getP_unitPrice() * cartVO[status.index].getquantity()}" readonly="readonly">
                        <input type="hidden" id="total${status.index}" class="total" value="${status.current.getP_unitPrice() * cartVO[status.index].getquantity()}" name="total" readonly="readonly">
                    </td>
                    </tr>
                </tbody>
            </c:forEach>
            </table>
          
          
          <div class="title-container">
                <div>
                    <button type="button" id="removeSelectBtn" class="check-remove-btn">선택상품 삭제</button>
                    <button type="button" id="removeAllBtn" class="all-remove-btn">장바구니 비우기</button>
                </div>

                <div class="title"> 결제예정금액 :
                	<div> </div>
                    <input type="hidden" class="title-price" id="selectedTotal" name="selectedTotal" readonly="readonly" value="">
                    <input class="title-price" id="vis_selectedTotal" name="vis_selectedTotal" readonly="readonly" value=""> 원<br>
                    <input type="submit" id="submitAllBin" class="submit-btn" value="주문하기">
                </div>
            </div>

            <div class="btn-container">

            </div>
		</form>
        </div>
        <%} %>
          
</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>

	<script>
	
	//숫자 3자리마다 콤마 넣는 함수
	function commaInsurt(I) {
	str = String(I);
    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');	
	}
	
   $(function(){
		
	   //시작하자마자 제품 가격 띄워주는 부분
	   const totalCount = <c:out value="${totalCount}"/>;
	   for (let i=0;i<totalCount; i++){
	   var vis_price_location = document.getElementById("vis_price"+i);
	   var hidden_price = document.getElementById("price"+i).value;
	  	$("#vis_price"+i).val(commaInsurt(hidden_price));
	   
	   //시작하자마자 제품 가격 x 수량 띄워주는 부분 
	   var vis_total_location = document.getElementById("vis_total"+i);
	   var hidden_total = document.getElementById("total"+i).value;
	   $("#vis_total"+i).val(commaInsurt(hidden_total));
	   }
	   
	   //시작하자마자 전체 가격 띄워주는 부분
      var total= 0;

        for(let j=0;j<totalCount;j++){
         total += parseInt(document.getElementById("total"+j).value);
        }
        
        $("#selectedTotal").val(total);
        $("#vis_selectedTotal").val(commaInsurt(total));
        
      //수량 증가-감소 버튼
      $(document).on('click','button[name="countBtn"]',function(e){
         e.stopPropagation();
         e.preventDefault(); //버블 방지
         
         let countBox = $(this).closest('.count-box'); //가장 가까운 (위에서 아래로) 체크박스
         let row = countBox.closest('tr');//가장 가까운 (위에서 아래로) tr(row)
         let countInput = countBox.find('input[name=countInput]');//가장 가까운 체크박스를 찾은 곳에서 name이 countInput인 값을 찾아라
         let count = parseInt(countInput.val());
         let price = row.find('input[name=price]').val();
         let totalInput = row.find('input[name=total]');
         
         let vis_totalLocation = row.find('input[name=vis_total]');
         
         //upBtn 일 경우
         if($(this).hasClass("upBtn")){
            count++
         //downBtn 일 경우
         } else{
            count--;
            if (count < 1) return;
         }
         
         //변경 수량 적용
         countInput.val(count);
         
         //변경 수량*가격 변수
         let totalinput_mul = count * price;
         
         //전체 가격 수정
         totalInput.val(totalinput_mul);
         
         //제품 수량 X 가격 수정
         vis_totalLocation.val(commaInsurt(totalinput_mul));
         
         var total = Number(0);
         
         for(let j=0; j<totalCount; j++){
            var checkItem = $("input[name=checkP]"+j);
            if(checkItem.prop("checked")){
               total += Number(document.getElementsByName("total")[j].value);
            }
         }
         
         $('#selectedTotal').val(total);
         $('#vis_selectedTotal').val(commaInsurt(total)+"");
      });
      
         //전체 체크
         $(document).on('change', '#allCheck', function(e) {
            if($(this).prop("checked")) {
               for(let i=0; i<totalCount; i++){
                  var checkItem = $("input[name=checkP]"+i);
                  checkItem.prop("checked",true);
                  totalPrice += parseInt(document.getElementById("total"+i).value);
               }
            } else {
               for(let i=0; i<totalCount; i++){
               var checkItem = $("input[name=checkP]"+i);
               checkItem.prop("checked",false);
               totalPrice = 0;
            	}
            }
            
            console.log("totalPrice : " + totalPrice);
            console.log("vis_selectedTotal : " + commaInsurt(totalPrice));
            
          //바뀐 금액으로 결제 예정 금액 변경
            $('#vis_selectedTotal').val(commaInsurt(totalPrice));
            $('#selectedTotal').val(totalPrice); 
            
         });
      //개별 체크
      //체크박스가 선택되어 있는 부분의 전체 가격의 합계
      console.log($("input:checkbox[name^=checkP]:checked").length)
      
      for(let i=0; i<($("input:checkbox[name^=checkP]:checked").length); i++){
    	  let checkItemBox = $("input:checkbox[name=checkP]"+i);
    	  
    	  $(document).on("change","input:checkbox[name=checkP]",function(e){
      	  	let totalPrice = parseInt(document.getElementById("selectedTotal").value);
      	  	let stockPrice = parseInt(document.getElementById("total"+i).value);
      	  	
            console.log("original totalPrice : " + totalPrice);
            console.log("stockPrice : " + stockPrice);
            
            if($(this).prop("checked")) {
            	totalPrice += stockPrice;
            	console.log("체크됨 : " + totalPrice);
            } else {
                totalPrice -= stockPrice;
           		console.log("체크풀림 : " + totalPrice);
            }
            
            //document.getElementById("sum").value = totalPrice;
            //totalPrice.empty();
            //totalPrice.html(p_totalPrice);
            //console.log("changed totalPrice : " + totalPrice + "\n");

            
            $('#vis_selectedTotal').val(commaInsurt(totalPrice));
            $('#selectedTotal').val(totalPrice); //바뀐 금액으로 결제 예정 금액 변경
         });
      }
         //개별 선택 삭제
          $("#removeSelectBtn").click(function(e) {
         	  e.stopPropagation();
              e.preventDefault();
			  let checkp_id = [] ;
			  for(let i=0; i<totalCount; i++){
            	if (checkItemBox.is(':checked')) {
            		checkp_id[i]= document.getElementsByName('checkP'+i)[0].value;
            		}
			  	}
               if(window.confirm("선택 상품을 삭제하시겠습니까?")) {
                  location.href="cart_delete.jsp?p_id="+checkp_id;
               }
		});
         //전체 삭제
          $("#removeAllBtn").click(function() {
               if(window.confirm("장바구니를 비우시겠습니까?")) {
                  location.href="cart_clear.jsp";
               }
         });
      });
</script>
</body>
</html>