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
	        var status = 'GD';
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
	        }else if(data == null){
	        	status = '배송 정보 없음';
	        }
	        
	        var str = "<span>"+status+"</span>"
	        $('#statusOfDelivery').after(str);
	        
	     /*    if(data == 'ED'){
	        var str2="<div class='col-lg-6'> <div class='about-text'><div class='at-title'><h3><b>물건은 안전하게 받으셨나요?</b></h3><p><b>물건의 상태를 확인 후 구매 확정 버튼을 눌러주세요 </b></p></div></div> <div class='profile-agent-content' style='padding :0px;border:0px;'> <div class='profile-agent-newslatter'> 
	        <form action='#'> 
	        <input type='text' name='productTransactionSq' value='${product.productTransactions[0].productTransactionSq}''>
	        <button style='position : static; margin: 10px;width: 100%;float: left;' type='button' onclick='location.href='${pageContext.request.contextPath}/member/securePaymentClose''>
	        <b>구매 확정 하기</b> </button> 
	        </form> </div></div> 
	        <div class='profile-agent-content' style='padding :0px;border:0px;'> <div class='profile-agent-newslatter'> <form action='#'> <button style='position : static; margin: 10px;width: 100%;float: left;' type='button' onclick='#'><b>반품하기</b></button></form> </div></div></div> "
	        }
	        	 */	
	        		
	        		$('#chkBtnDelivery').after(str2);
	    }
	    , error : function (xhr, statusText, errorThrown) { 
	        console.log("error status :: " + xhr.status + " || statusText :: " + xhr.responseText + " || errorThrown :: " + errorThrown);
	        
	        
	      }
	  });



	
  /* 	$(document).ready(function(){
	  	  var request = $.ajax({
	  		url:"http://localhost:8081/Mission-Spring/getDeliveryInformation",
	  		type:"GET",
	  		data: {"unsongjang" :${product.productTransactions[0].unsongjang} },
	  		dataType:"JSON",
	  		contentType:false,
	  		processData:false
	  	});

	  	request.done(function(obj){
	  		console.log(obj);
	  	});
  	
  	}); */
  </script>
  
    <section class="breadcrumb-section spad set-bg" data-setbg="${pageContext.request.contextPath}/resources/member/img/breadcrumb-bg.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb-text">
                        <h4>구매 진행중인 상품</h4>
                        <div class="bt-option">
                            <a href="./index.html"><i class="fa fa-home"></i> 마이페이지</a>
                            <span>구매 진행중인 상품</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <%-- 
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
                 --%>

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
                            <h3><b>구매 진행 중인 고객님의 상품입니다.</b></h3>
                            <p><b>고객님의 상품이 안전하게 이동중입니다.
                            <br>안전거래 상태 : ${product.productTransactions[0].transactionTypeInKor}
                              <c:if test="${not empty product.productTransactions[0].unsongjang}" >
	                            	 <br><span>운송장 번호 : ${product.productTransactions[0].unsongjang} </span> 
	                            </c:if>
                            <br><span id="statusOfDelivery">배송 상태 : </span> 
                            <br>
                            </b></p>
                        </div>
                    </div>
                </div> 
                <div class="col-lg-6" id="chkBtnDelivery">
                    <div class="about-text">
                        <div class="at-feature">
                            <div class="af-item">
                                <div class="af-icon">
                                    <img src="${pageContext.request.contextPath}/resources/member/img/chooseus/chooseus-icon-1.png" alt="">
                                </div>
                                <div class="af-text">
                                    <h6>상품명 : </h6>
                                    <p><b>${product.productName}</b></p>
                                </div>
                            </div>
                            <div class="af-item">
                                <div class="af-icon">
                                    <img src="${pageContext.request.contextPath}/resources/member/img/chooseus/chooseus-icon-2.png" alt="">
                                </div>
                                <div class="af-text">
                                    <h6>거래 날짜 : </h6>
                                    <p><b>${product.productTransactions[0].transactionDateWithComma}</b></p>
                                </div>
                            </div>
                            <div class="af-item">
                                <div class="af-icon">
                                    <img src="${pageContext.request.contextPath}/resources/member/img/chooseus/chooseus-icon-3.png" alt="">
                                </div>
                                <div class="af-text">
                                    <h6>배송 주소</h6>
                                    <p><b>${product.productTransactions[0].address}</b></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
              <c:if test="${not empty product.productTransactions[0].unsongjang}" ></c:if>
                 <div class="col-lg-6">
	                 <div class="about-text">
	                        <div class="at-title">
	                            <h3><b>물건은 안전하게 받으셨나요?</b></h3>
	                            <p><b>물건의 상태를 확인 후 구매 확정 버튼을 눌러주세요
	                            </b></p>
	                        </div>
	                    </div>
                   <div class="profile-agent-content" style="padding :0px;border:0px;">
                            <div class="profile-agent-newslatter">
                                <form action="${pageContext.request.contextPath}/member/securePaymentClose" method="post">
                                <input type="hidden" value="${product.productTransactions[0].productTransactionSq}" name="productTransactionSq">
                                    <button style="position : static; margin: 10px;width: 100%;float: left;" type="submit" >
                                    	<b>구매 확정 하기</b>
                                    </button>
                                </form>
		                       </div>
		                    </div>
                    
                    <div class="profile-agent-content" style="padding :0px;border:0px;">
                            <div class="profile-agent-newslatter">
                                <form action="#">
                                    <button style="position : static; margin: 10px;width: 100%;float: left;" type="button" >
                                    	<b>반품하기</b>
                                    </button>
                                </form>
                       </div>
                    </div>
               	</div>
               	
           </div>
       </div>
   </section>
    
        <!-- About Section Begin -->
    <section class="about-section spad">
        <div class="container">
            <div class="row">
             
            </div>
        </div>
    </section>
   
 
  
	<jsp:include page="../common/footer.jsp" />
</body>




</html>