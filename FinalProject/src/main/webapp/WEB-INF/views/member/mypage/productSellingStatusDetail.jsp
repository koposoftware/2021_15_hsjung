<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="UTF-8">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Aler Template">
    <meta name="keywords" content="Aler, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>HANA | AUCTION PRODUCT</title>
  
  
</head>

<body>
	 <jsp:include page="../common/header.jsp" />
 <script>
	 
	 $.ajax({

	      url : "http://localhost:8080/Mission-Spring/getDeliveryInformation"
	    , async : true
	    , type : "GET"
	    , cache:false
	    , timeout : 30000 
	    , data : {"unsongjang": "${product.productTransactions[0].unsongjang}" }
	    , dataType : "json"
	    , xhrFields: {
	            withCredentials: false
	      }
	    , beforeSend: function (xhr) {
	        xhr.setRequestHeader("Accept", "application/json");
	      }
	    , success : function (data, statusText, xhr) { 
	        console.log("success status :: " + xhr.status + " || statusText :: " + statusText);
	      
	        if(data == 'AD') {
	        	status = "배송지 도착";
	        }else if (data == 'SD') {
	        	status = '배송 출발';
	        }else if (data == 'ED') {
	        	status = '배송 도착';
	        }else if (data == 'MD') {
	        	status = '상품이동중';
	        }else if (data == 'GD') {
	        	status = '배송 접수';
	        }
	        
	        var str = "<span>"+status+"</span>"
	        $('#statusOfDelivery').after(str);
	      }
	    , error : function (xhr, statusText, errorThrown) { 
	        console.log("error status :: " + xhr.status + " || statusText :: " + xhr.responseText + " || errorThrown :: " + errorThrown);
	      }
	  });
  
	 </script>
        <section class="breadcrumb-section spad set-bg" data-setbg="${pageContext.request.contextPath}/resources/member/img/breadcrumb-bg.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb-text">
                        <h4>판매 진행중인 상품</h4>
                        <div class="bt-option">
                            <a href="./index.html"><i class="fa fa-home"></i> 마이페이지</a>
                            <span>판매 진행중인 상품</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
   
     		    <c:if test="${empty product.productTransactions[0].unsongjang}" >
	                 <div class="col-lg-8" style="margin:auto;">
	                    <div class="blog-sidebar">
	                        <div class="subscribe-form">
	                            <div class="section-title sidebar-title-b">
	                                <h4>운송장 번호 입력</h4>
	                            </div>
	                            <p>하나 마켓은 현석택배와 함께합니다!</p>
	                            <form action="${pageContext.request.contextPath}/member/addUnsongjang" method="post">
	                            	<input type="hidden" name="productTransactionSq" value="${product.productTransactions[0].productTransactionSq}">
	                                <input type="text" name="unsongjang" placeholder="운송장 번호 입력">
	                                <button type="submit" class="site-btn">입력하기</button>
	                            </form>
	                        </div>
	                    </div>
	                </div>
                </c:if>
                
    <!-- Blog Section Begin -->
    <section class="blog-section spad">
        <div class="container">
            <div class="row">
            	<div class="col-lg-6">
		           <div class="bi-pic">
		            	<img src="${pageContext.request.contextPath}/resources/member/baesong.png" style="width:100%;"alt="">
		           </div>
		           </div>
                <div class="col-lg-6">
                
                 <div class="about-text">
                        <div class="at-title">
                            <h3>현재 판매 진행 중인 고객님의 상품입니다.</h3>
                            <p><b>고객님이 판매한 상품이 안전하게 이동중입니다.
                            <br> 현재 상태 : ${product.productTransactions[0].transactionTypeInKor}
	                             <c:if test="${not empty product.productTransactions[0].unsongjang}" >
	                            	 <br><span>운송장 번호 : ${product.productTransactions[0].unsongjang} </span> 
	                            </c:if>
                            <br><span id="statusOfDelivery">배송 상태 : </span> 
                           	<br>
                            </b></p>
                        </div>
                        <div class="at-feature">
                            <div class="af-item">
                                <div class="af-icon">
                                    <img src="${pageContext.request.contextPath}/resources/member/img/chooseus/chooseus-icon-1.png" alt="">
                                </div>
                                <div class="af-text">
                                    <h6>상품명 : </h6>
                                    <p>${product.productName}</p>
                                </div>
                            </div>
                            <div class="af-item">
                                <div class="af-icon">
                                    <img src="${pageContext.request.contextPath}/resources/member/img/chooseus/chooseus-icon-2.png" alt="">
                                </div>
                                <div class="af-text">
                                    <h6>거래 날짜 : </h6>
                                    <p>${product.productTransactions[0].transactionDateWithComma}</p>
                                </div>
                            </div>
                            <div class="af-item">
                                <div class="af-icon">
                                    <img src="${pageContext.request.contextPath}/resources/member/img/chooseus/chooseus-icon-3.png" alt="">
                                </div>
                                <div class="af-text">
                                    <h6>배송 주소</h6>
                                    <p>${product.productTransactions[0].address}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
             <%--   <c:if test="${empty product.productTransactions[0].unsongjang}" >
	                <div class="col-lg-12">
	                    <div class="blog-sidebar">
	                        <div class="subscribe-form">
	                            <div class="section-title sidebar-title-b">
	                                <h4>운송장 번호 입력</h4>
	                            </div>
	                            <p>하나 마켓은 현석택배와 함께합니다!</p>
	                            <form action="${pageContext.request.contextPath}/member/addUnsongjang" method="post">
	                            	<input type="hidden" name="productTransactionSq" value="${product.productTransactions[0].productTransactionSq}">
	                                <input type="text" name="unsongjang" placeholder="운송장 번호 입력">
	                                <button type="submit" class="site-btn">입력하기</button>
	                            </form>
	                        </div>
	                    </div>
	                </div>
                </c:if> --%>
            </div>
        </div>
    </section>
  
	<jsp:include page="../common/footer.jsp" />
</body>




</html>