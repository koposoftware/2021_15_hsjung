<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
<!DOCTYPE html>
<html lang="UTF-8">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Aler Template">
    <meta name="keywords" content="Aler, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>HANA | AUCTION PRODUCT</title>
  <script src="${socketPort}socket.io/socket.io.js"></script>  
  
  <link href="${pageContext.request.contextPath}/resources/chat/chatting.css" rel="stylesheet" />
  <style>
  
nav > .nav.nav-tabs{

  border: none;
    color:#fff;
    background:#fff;
    border-radius:0;

}
nav > div a.nav-item.nav-link,
nav > div a.nav-item.nav-link.active
{
    padding: 20px 10px 20px 10px;
    color:#000;
    border-radius:0;
    border : 1px solid #e1e1e1;
    margin : auto;
}

nav > div a.nav-item.nav-link.active:after
 {
  content: "";
  position: relative;
  bottom: -60px;
  left: -10%;
  border: 15px solid transparent;
  border-top-color: #00C89E ;
}
.tab-content{
  	background: #fdfdfd;
    line-height: 25px;
    padding:30px 25px;
}

nav > div a.nav-item.nav-link:hover,
nav > div a.nav-item.nav-link:focus
{
 	border: none;
    background: #00C89E;
    color:#fff;
    border-radius:0;
    transition:background 0.20s linear;
}
</style>
</head>

<body>
	 <jsp:include page="../common/header.jsp" />
     <div id="chatArea">
	</div>

      

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section spad set-bg" data-setbg="${pageContext.request.contextPath}/resources/member/img/breadcrumb-bg.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb-text">
                        <h4>마이페이지</h4>
                        <div class="bt-option">
                            <a href="./index.html"><i class="fa fa-home"></i> Home</a>
                            <span>마이페이지</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->
     <section class="profile-section spad"> 
        <div class="container">
            <div class="profile-agent-content" style="padding :0px;border:0px;">
                        <div class="col-lg-12">
                            <div class="profile-agent-newslatter">
                                <form action="#">
                                    <button style="position : static; margin: 4px;width: 46%;float: left;" type="button" onclick="location.href='${pageContext.request.contextPath}/member/productAdd'">
                                    	<b style="font-size : 15px">중고 상품 등록하기</b>
                                    </button>
                                    <button style="position : static;  margin: 4px;width: 46%;" type="button" onclick="location.href='${pageContext.request.contextPath}/member/auctionAdd'">
                                    	<b style="font-size : 15px">경매 상품 등록하기</b>
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Profile Section Begin -->
    <section class="profile-section spad">
        <div class="container">
            <div class="profile-agent-content">
                <div class="row" style="margin-bottom: 60px;">
	                    <div class="col-lg-4">
	                        <div class="profile-agent-info">
	                        
	                            <div class="pi-text" style="margin-left : 20px;display:inline-block;">
	                                <h3 style="font-weight: 700">${member.name}</h3>
	                            </div>
	                        	<div class="pi-pic"  style="float : right;">
	                           		 <div class="profile-agent-newslatter">
		                                <form action="#">
		                                    <button type="button" style="width: 80%; height: 90px;border-radius: 50%;" type="submit"  data-toggle="modal" data-target="#exampleModal">
		                                    	<b>쪽지함</b>
		                                    </button>
	                                    </form>
                                    </div>
	                                <div class="rating-point" style="background: #ff0000;">
	                                    ${countPost}
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="col-lg-4">
	                        <div class="profile-agent-widget">
	                            <ul>
	                                <li>구매 횟수 <span>${countBuy}</span></li>
	                                <li>판매 횟수 <span>${countSell}</span></li>
	                            </ul>
	                        </div>
	                    </div>
	                        <c:forEach var="accounts" items="${accounts}" varStatus="status">
			                    <div class="col-lg-4" style="margin-top: 10px;">
			                        <div class="property-item">
			                            <div class="pi-text">
			                                <h5><a href="#">연동 계좌 </a></h5>
			                                <p>${accounts.bankCdName}</p>
			                                <h6 >계좌 번호 : ${accounts.accountNumber}</h6>
			                              <%--   <div class="pt-price"> ${accounts.changeWithComma}<span>원</span></div> --%>
			                           
			                            </div>
			                        </div>
			                    </div>
	                    </c:forEach>
                    </div>
                    <div class="col-lg-12" style="margin-top: 40px;">
                        <div class="property-item">
                            <div class="pi-text">
                                <ul >
                                </ul>
                               <!-- 잔액, 은행, -->
                            </div>
                        </div>
                    </div>
                    </div>
        </div>
    </section>

     <section class="profile-section spad"> 
        <div class="container">
            <div class="profile-agent-content" style="padding :0px;border:0px;">
                        <div class="col-lg-12">
                            <div class="pf-summernote">
                                <ul class="nav nav-tabs" role="tablist">
                                    <li class="nav-item">
                                        <a class="nav-link  active" data-toggle="tab" href="#tabs-1" role="tab" id="productListButton" href="javascript:void(0);" style="font-size: 30px;color: #000;font-weight: 600;" onclick="tab1Function();">중고 상품 조회</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab" id="auctionListButton" href="javascript:void(0);"style="font-size: 30px;color: #000;font-weight: 600;" onclick="tab2Function();">경매 상품 조회</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
               </div>
    </section>
  
<script> 

	function tab1Function() { 
	
		document.getElementById("tabs-2").style.display = "none"; 
		document.getElementById("tabs-1").style.display = "block"; 
	} 
	
	function tab2Function() { 
		
		document.getElementById("tabs-2").style.display = "block"; 
		document.getElementById("tabs-1").style.display = "none"; 
	} 
	
</script>

						
    <section class="whats-news-area pt-50 pb-20 tab-content tab-pane fade show active" style="padding:0px;" id="tabs-1" role="tabpanel" aria-labelledby="tabs-1-tab">
        <div class="container">
            <div class="row">
            <div class="col-lg-12" id="productAuctionArea" >
           	 <div class="detailList" style="width:100%">
                <div class="row d-flex justify-content-between">
                    <div class="col-lg-12 col-md-9">
                        <div class="properties__button">
                            <!--Nav Button  -->                                            
                            <nav>                                                                     
                                <div class="nav nav-tabs" id="nav-tab" role="tablist">
                                    <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true"><b>구매 진행 중인 상품</b></a>
                                    <a class="nav-item nav-link" id="nav-buy-tab" data-toggle="tab" href="#nav-buy" role="tab" aria-controls="nav-buy" aria-selected="true"><b>판매 진행 중인 상품</b></a>
                                    <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false"><b>판매 중인 상품</b></a>
                                    <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-contact" role="tab" aria-controls="nav-contact" aria-selected="false"><b>판매 완료 상품</b></a>
                                    <a class="nav-item nav-link" id="nav-last-tab" data-toggle="tab" href="#nav-last" role="tab" aria-controls="nav-last" aria-selected="true"><b>구매한 중고 상품</b></a>
                                    <a class="nav-item nav-link" id="nav-nav-Sport-tab" data-toggle="tab" href="#nav-nav-Sport" role="tab" aria-controls="nav-nav-Sport" aria-selected="false"><b>내 상품 후기</b></a>
                                    <a class="nav-item nav-link " id="nav-techno-tab" data-toggle="tab" href="#nav-techno" role="tab" aria-controls="nav-techno" aria-selected="false"><b>내가 찜한 상품</b></a>
                                </div>
                            </nav>
                            <!--End Nav Button  -->
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <!-- Nav Card -->
                        <div class="tab-content" id="nav-tabContent">
	                        <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab" style="background-color: #fff;">           
	                                <div class="whats-news-caption">
	                                    <div class="row">
			     					 	<c:forEach var="processingProduct" items="${processingProduct}" varStatus="status">
				     					 	 <div class="col-lg-6 col-md-6">
			                                         <div class="rp-item">
					                                    <div class="rp-pic">
					                                        <img src="img/blog/rp-1.jpg" alt="">
					                                    </div>
					                                    <div class="rp-text">
					                                    	<h6>
						                                     	<a style="color: #000;font-weight: 600;" href="${pageContext.request.contextPath}/member/productbuyingStatusDetail?productSq=${processingProduct.product.productSq}">
		                                                    	 	${processingProduct.product.productName}
			                                                    </a>
		                                                    </h6>
					                                        <span> ${processingProduct.transactionTypeInKor}</span><br>
					                                        <span> ${processingProduct.transactionDateWithComma}</span>
					                                    </div>
					                                </div>
		                                        </div>
			                              </c:forEach>
	                                    </div>
	                                </div>
							</div>
							
							<div class="tab-pane fade" id="nav-buy" role="tabpanel" aria-labelledby="nav-buy-tab" style="background-color: #fff;">           
	                                <div class="whats-news-caption">
	                                    <div class="row">
			     					 	<c:forEach var="processingSellingProduct" items="${processingSellingProduct}" varStatus="status">
				     					 	 <div class="col-lg-6 col-md-6">
			                                         <div class="rp-item">
					                                    <div class="rp-pic">
					                                        <img src="img/blog/rp-1.jpg" alt="">
					                                    </div>
					                                    <div class="rp-text">
					                                     	<a style="color: #000;font-weight: 600;" href="${pageContext.request.contextPath}/member/productSellingStatusDetail?productSq=${processingSellingProduct.product.productSq}">
	                                                    	 	${processingSellingProduct.product.productName}
		                                                    </a>
					                                        <span> ${processingSellingProduct.transactionTypeInKor}</span><br>
					                                        <span> ${processingSellingProduct.transactionDateWithComma}</span>
					                                    </div>
					                                </div>
		                                        </div>
			                              </c:forEach>
	                                    </div>
	                                </div>
							</div>
							
							<div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab" style="background-color: #fff;">
                                <div class="whats-news-caption">
                                    <div class="row">
                                    <c:forEach var="sellingProduct" items="${sellingProduct}" varStatus="status">
                                    
                                     			<div class="col-lg-6 col-md-6">
			                                         <div class="rp-item">
					                                    <div class="rp-text">
					                                     	<a style="color: #000;font-weight: 600;" href="${pageContext.request.contextPath}/member/productDetail?productSq=${sellingProduct.productSq}">
	                                                    	 	${sellingProduct.productName}
		                                                    </a><br>
					                                        <span> 등록일 : ${sellingProduct.inputDateWithComma}</span><br>
					                                        <span> ${sellingProduct.priceWithComma}원</span>
					                                    </div>
					                                </div>
		                                        </div>
                                       </c:forEach>
                                    </div>
                                </div>
                            </div>
                            <!-- Card three -->
                            <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab" style="background-color: #fff;">
                                <div class="whats-news-caption">
                                    <div class="row">
                                       <c:forEach var="selledProduct" items="${selledProduct}" varStatus="status">
	                                       <!--  <div class="col-lg-6 col-md-6">
	                                            <div class="single-what-news mb-100">
	                                                <div class="what-cap" style="padding : 0px">
	                                                    <span class="color1">Night party</span>
	                                                    <h4><a href="#"></a></h4>
	                                                </div>
	                                            </div>
	                                        </div> -->
	                                        
	                                         <div class="col-lg-6 col-md-6">
			                                         <div class="rp-item">
					                                    <div class="rp-text">
					                                     	<a style="color: #000;font-weight: 600;" href="#">${selledProduct.product.productName}</a>
					                                        <span> ${selledProduct.transactionType}</span>
					                                        <span> ${selledProduct.transactionDate}</span>
					                                    </div>
					                                </div>
		                                        </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                            <!-- card fure -->
                            <div class="tab-pane fade" id="nav-last" role="tabpanel" aria-labelledby="nav-last-tab" style="background-color: #fff;">
                                <div class="whats-news-caption">
                                    <div class="row">
                                     <c:forEach var="buyedProduct" items="${buyedProduct}" varStatus="status">
                                         <div class="col-lg-6 col-md-6">
			                                         <div class="rp-item">
					                                    <div class="rp-pic">
					                                        <img src="img/blog/rp-1.jpg" alt="">
					                                    </div>
					                                    <div class="rp-text">
					                                     	<a style="color: #000;font-weight: 600;" href="#">${buyedProduct.product.productName}</a>
					                                        <span> ${buyedProduct.transactionType}</span>
					                                        <span> ${buyedProduct.transactionDate}</span>
					                                    </div>
					                                </div>
		                                        </div>
		                                        
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                            <!-- card Five -->
                            <div class="tab-pane fade" id="nav-nav-Sport" role="tabpanel" aria-labelledby="nav-Sports" style="background-color: #fff;">
                                <div class="whats-news-caption">
                                    <div class="row">
                                         <c:forEach var="ripple" items="${ripple}" varStatus="status">
                                         <div class="col-lg-6 col-md-6">
			                                         <div class="rp-item">
					                                    <div class="rp-pic">
					                                        <img src="img/blog/rp-1.jpg" alt="">
					                                    </div>
					                                    <div class="rp-text">
					                                     	<a style="color: #000;font-weight: 600;" href="#">${ripple.product.productName}</a>
					                                        <span> ${ripple.inputDate}</span>
					                                    </div>
					                                </div>
		                                        </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                            <!-- card Six -->
                            <div class="tab-pane fade" id="nav-techno" role="tabpanel" aria-labelledby="nav-technology" style="background-color: #fff;">
                                <div class="whats-news-caption">
                                    <div class="row">
                                        <c:forEach var="zzim" items="${zzim}" varStatus="status">
                                         <div class="col-lg-6 col-md-6">
			                                         <div class="rp-item">
					                                    <div class="rp-pic">
					                                        <img src="img/blog/rp-1.jpg" alt="">
					                                    </div>
					                                    <div class="rp-text">
					                                     	<a style="color: #000;font-weight: 600;" href="#">${zzim.product.productName}</a>
					                                    </div>
					                                </div>
		                                        </div>
		                                        
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                          </div>
                      </div>
                    </div>
                </div>
            </div>
           </div>
        </div>
    </section>
    <jsp:include page="../common/footer.jsp" />
    
    
      <div class="modal fade bd-example-modal-lg" id="exampleModal" style="margin-left: 25px;width: 360px;"tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true"> 
		<!-- <div class="modal fade " id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true"> -->
 		    <div class="modal-dialog modal-lg" role="document"> 
		 <!--    <div class="modal-dialog" role="document"> -->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		            <span aria-hidden="true">&times;</span>
		          </button>
		        </div>
		        <div class="modal-body">
			      <c:forEach var="postItList" items="${postItList}" varStatus="status">
			      	 <c:choose>
	                        <c:when test="${ postItList.isRead eq 'N' }">
	                       <div class="row">
		                    <div class="col-lg-8" >
		                        <div class="property-item" style="margin-bottom: 0px;">
		                            <div class="pi-text">
		                                <p>관련 상품명 : ${postItList.product.productName}</p>
		                                <h5><a href="#" style="display: inline-block;text-overflow: ellipsis;white-space: nowrap;overflow: hidden;width: 100%;">${postItList.postItContents}</a></h5>
		                                
		                            </div>
		                        </div>
		                    </div>
		                    <div class="col-lg-4" >
		                         <div class="profile-agent-content" style="padding:0px;border: 0px;">
	                               		<div class="profile-agent-newslatter">
			                                <form action="#">
			                                    <button type="button" style="width: 80%;position:static;" onclick="chattingEnter(${postItList.postItPk})">
<%-- 			                                    <button type="button" style="width: 80%;" id="chattingEnter${postItList.postItPk}"> --%>
			                                    	<b>구매자와 채팅하기</b>
			                                    </button>
		                                    </form>
	                                   </div>
	                              </div>
		                    </div>
	                    </div>
						    </c:when>
						    <c:when test="${ postItList.isRead eq 'I' }">
						          <div class="row">
		                    <div class="col-lg-8" >
		                        <div class="property-item">
		                            <div class="pi-text">
		                                <p>관련 상품명 : ${postItList.product.productName}</p>
		                                <h5><a href="#" style="display: inline-block;text-overflow: ellipsis;white-space: nowrap;overflow: hidden;width: 100%;">${postItList.postItContents}</a></h5>
		                                
		                            </div>
		                        </div>
		                    </div>
		                    <div class="col-lg-4" >
		                         <div class="profile-agent-content" style="padding:0px;border: 0px;">
	                               		<div class="profile-agent-newslatter">
			                                <form action="#">
<!-- 			                                    <button type="button" style="width: 80%;" id="chattingOn"> -->
			                                    <button type="button" style="width: 80%;position:static;" onclick="chattingOn(${postItList.postItPk})">
			                                    	<b>판매자와 채팅하기</b>
			                                    </button>
		                                    </form>
	                                   </div>
	                              </div>
		                    </div>
	                    </div>
						    </c:when>
						    <c:otherwise></c:otherwise>
						</c:choose>
			      	
			      	 
                    </c:forEach>
                  
	                    
	   			</div>
				</div>
			</div>
	</div>
	 
		     <div class="modal fade bd-example-modal-lg" id="exampleModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel3" aria-hidden="true"> 
		<!-- <div class="modal fade " id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true"> -->
 		    <div class="modal-dialog modal-lg" role="document"> 
		 <!--    <div class="modal-dialog" role="document"> -->
		      <div class="modal-content">
		        <div class="modal-header">
		          <h5 class="modal-title" id="exampleModalLabel"><b>후기 작성하기</b></h5>
		          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		            <span aria-hidden="true">&times;</span>
		          </button>
		        </div>
		        <div class="modal-body">
		       
			         <section class="property-submit-section spad" style="padding : 0px;">
				        <div class="container">
				            <div class="row">
				                <div class="col-lg-12">
				                    <div class="property-submit-form">
				                        <form action="${pageContext.request.contextPath}/member/sendPostIt" method="POST">
				                            <div class="pf-location">
				                                <h4>내용</h4>
				                                <div class="location-inputs">
				                                    <input type="text"placeholder="판매자에게 보낼 메세지를 적어주세요" name="postItContents" class="text" style="width: 100%;" /><br>
				                                </div>
				                            </div>
								    		<section class="contact-section" style="height: auto;">
							                   	 <div class="modal-footer">
							                   	 <input type="hidden" name="productSq" id="productSq">
							                   	 <input type="hidden" name="receiverMemberPk" id="receiverMemberPk">
									              <button style="width:100%" type="submit" class="btn btn-danger" >쪽지 전송하기</button>
									            </div>
								 		    </section> 
				                        </form>
				                    </div>
				                </div>
				            </div>
				        </div>
		   		 </section>
	   			</div>
				</div>
			</div>
	</div>
</body>
    	
 <script>  //SCRIPT :: 중고상품 정보 출력 (기존 정보 삭제)
  	$("#productListButton").click(function(){//클릭한 id의 부모는 tr

		var detailList = $(".detailList").length;
		var location=$(this);
		
		 $(".detailList").remove();//리스트 조회 없애기
		  $.ajax({
		  			url : '${pageContext.request.contextPath}/member/selectProductMyPage',
		  			type : 'post',
		  			dataType: "html",
		  			data : {"memberSq" :${member.memberSq}, "transactionType" : "SE"},
		  			success : function(data){
		  					$("#productAuctionArea").after(data);
		  			}, error : function(){
		  			}
		  		}); 
		});
</script>  
 <script>  //SCRIPT :: 경매 정보 출력 (기존 정보 삭제)
  	$("#auctionListButton").click(function(){//클릭한 id의 부모는 tr

		var detailList = $(".detailList").length;
		var location=$(this);
		
		 $(".detailList").remove();//리스트 조회 없애기
		  $.ajax({
		  			url : '${pageContext.request.contextPath}/member/selectAuctionMyPage',
		  			type : 'post',
		  			dataType: "html",
		  			data : {"memberSq" :${member.memberSq}},
		  			success : function(data){
		  					$("#productAuctionArea").after(data);
		  			}, error : function(){
		  			}
		  		}); 
		});
</script>  
    		

<script>  //SCRIPT :: 경매 정보 출력 (기존 정보 삭제)
  
	function chattingOn(postItPk){//클릭한 id의 부모는 tr
   		$('#exampleModal').modal("hide");
		  $.ajax({
		  			url : '${pageContext.request.contextPath}/socket/guest/'+postItPk,
		  			type : 'post',
		  			dataType: "html",
		  			success : function(data){
		  					$("#chatArea").after(data);
		  			}, error : function(){
		  			}
		  		}); 
		}
		 
 	function chattingEnter(postItPk){//클릭한 id의 부모는 tr
 		$('#exampleModal').modal("hide");
		  $.ajax({
		  			url : '${pageContext.request.contextPath}/socket/host/'+postItPk,
		  			type : 'post',
		  			dataType: "html",
		  			success : function(data){
		  					$("#chatArea").after(data);
		  			}, error : function(){
		  			}
		  		}); 
		}
	 
  	function removeArea() {
  		$(".removeArea").remove();
	} 
  	
</script>  


</html>