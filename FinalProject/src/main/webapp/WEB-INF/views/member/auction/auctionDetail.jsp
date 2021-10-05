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
    <script>
    function commas(t) {
    	// 콤마 빼고 
    	var x = t.value;			
    	x = x.replace(/,/gi, '');
            // 숫자 정규식 확인
    	var regexp = /^[0-9]*$/;
    	if(!regexp.test(x)){ 
    		$(t).val(""); 
    	} else {
    		x = x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");			
    		$(t).val(x);			
    	}
    }
    </script>
    <script>
                       
      var dday = new Date('${auctionProduct.endDateByTraceDateTime}').getTime();

      setInterval(function() {
        var today = new Date().getTime();
        var gap = dday - today;
        var day = Math.ceil(gap / (1000 * 60 * 60 * 24)) -1;
        var hour = Math.ceil((gap % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
        var min = Math.ceil((gap % (1000 * 60 * 60)) / (1000 * 60));
        var sec = Math.ceil((gap % (1000 * 60)) / 1000);

        document.getElementById("count").innerHTML = day + "일 " + hour + "시간 " + min + "분 " + sec + "초";
      }, 1000);
      </script>
                
<script language="Javascript">

//임의로 입력했을 때의 입찰 함수
function custom_bid_it()
{
		
		var modifyPrice = $("input[name=modifyPrice]").val()
		
        var mod= modifyPrice.split(',').join("");
		bid_it(mod)
}

//빠른 입찰 버튼 눌렀을 때 구현되는 버튼
function bid_it(modifyPrice)
{
		
		var data = new FormData();
		
      	data.append("modifyPrice",modifyPrice);
		data.append("memberSq",${member.memberSq})   		
		data.append("auctionProductSq",${auctionProduct.auctionProductSq})   		
		
       var request = $.ajax({
		url:"${pageContext.request.contextPath}/member/bidAuctionProduct",
		type:"POST",
		data: data,
		dataType:"JSON",
		contentType:false,
		processData:false
	});

	request.done(function(obj){
		
		if(obj.resultCode == 1) {
			
			location.reload();
		} else {
			alert(data.resultMessage);
			
		}
	});
		
}

</script>
       
       
<script language="Javascript">
	function submit_it()
	{
		var data = new FormData();
		
	  //	data.append("address",$("input[name=region]").val()+$("input[name=productRegionDetail]").val());
      	data.append("accountSq",$("input[name=accountSeq]").val());
       	data.append("auctionProductSq", ${auctionProduct.auctionProductSq});
       	data.append("sellerMemberSq", ${auctionProduct.member.memberSq});
       	data.append("buyerMemberSq", ${member.memberSq});
       	data.append("priceMax", ${auctionProduct.priceMax});
       	data.append("maxFee",${auctionProduct.maxFee});
       	
	        var request = $.ajax({
				url:"${pageContext.request.contextPath}/member/orderAuctionMaxPriceProduct",
				type:"POST",
				data: data,
				dataType:"JSON",
				contentType:false,
				processData:false
			});
		
			request.done(function(obj){
				
				if(obj.resultCode == 1) {
					
					document.location.href = "${pageContext.request.contextPath}/index";
				} else {
					alert(data.resultMessage);
				}
			});
	}

</script>
		
</head>

<body>
	 <jsp:include page="../common/header.jsp" />

    
<section class="breadcrumb-section spad set-bg" data-setbg="${pageContext.request.contextPath}/resources/member/img/breadcrumb-bg.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb-text">
                        <h4>중고 경매 상품 상세 조회</h4>
                        <div class="bt-option">
                            <a href="./index.html"><i class="fa fa-home"></i> Home</a>
                            <a href="./index.html"> 중고 경매 상품 리스트</a>
                            <span> 중고 경매 상품 상세조회</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
<section class="property-details-section" style="margin-top:30px;">
        <div class="container">
  			<div class="row">
               <div class="col-lg-8 p-0">
                   <div class="fp-slider owl-carousel">
                    <c:forEach var="auctionList" items="${auctionProduct.auctionProductImgs}" varStatus="status">
                        <div class="fp-item set-bg" data-setbg="${pageContext.request.contextPath}/photo/img/${auctionList.fileSq}">
                          
                        </div>
                        </c:forEach>
                   </div>
               </div>
               <div class="col-lg-4 p-0">
                   <div class="feature-property-left">
                       <div class="section-title">
                           <h4>${auctionProduct.auctionProductName}</h4>
                       </div>
                       <div style="margin:auto;">
                       <ul style="border-right:1px solid #284745;width:44%; text-align : center; display:inline-block; margin-bottom : 20px;">
                           <li><b>카테고리</b></li>
                           <li><b>시작금액</b></li>
                           <li><b>현재금액</b></li>
                           <li><b>즉시 입찰 가능 금액</b></li>
                           <li><b>시작일</b></li> 
                           <li><b>종료일</b></li> 
                           <li><b>배송비</b></li>
                       </ul>
                     
                        <ul style="width:52%; text-align : center;display:inline-block;margin-bottom : 20px;">
                           <li>${auctionProduct.productCategory.productCategory}</li>
                           <li>${auctionProduct.priceMinWithComma}</li>
                           <li>${auctionProduct.priceNowWithComma}</li>
                           <li>${auctionProduct.priceMaxWithComma}</li>
                           <li>${auctionProduct.startDateWithComma}</li>
                           <li id="count"></li>
                           <li>${auctionProduct.shippingStatus}</li>
                       </ul>
                       </div>
					 <a type="button" data-toggle="modal" data-target="#exampleModal">즉시 구매하기</a>
                   </div>
               </div>
           </div>
            <div class="row" style="margin-top:30px;">
               <div class="col-lg-5">
                 	 <div class="pd-text" style="margin : auto">
                        <div class="pd-board">
                            <div class="tab-board">
                                <ul class="nav nav-tabs" role="tablist">
                                    <li class="nav-item">
                                        <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab">상세 정보</a>
                                    </li>
                                </ul><!-- Tab panes -->
                                <div class="tab-content">
                                    <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                    </div>
                                    <div class="tab-pane active" id="tabs-2" role="tabpanel">
                                        <div class="tab-desc">
                                           ${auctionProduct.detail}
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-7">
                  <h4 style="margin-bottom : 15px;"><b>빠른입찰</b></h4>
                     <div class="pd-widget" style="display:inline-block;width:32%;">
		                <div class="pd-agent" >
		                    <div class="agent-text">
		                        <div class="at-title">
		                            <a class="primary-btn" href="javascript:void(0);" onclick="bid_it(${auctionProduct.calcPriceMin});" style="width: 100%; text-align:center;">+ ${auctionProduct.calcPriceMinWithComma}원 입찰하기	</a>
		                        </div>
		                    </div>
		                </div>
		            </div>
		             <div class="pd-widget" style="display:inline-block;width:32%;">
		                <div class="pd-agent">
		                    <div class="agent-text">
		                        <div class="at-title">
		                            <a class="primary-btn" href="javascript:void(0);" onclick="bid_it(${auctionProduct.calcPrice});" style="width: 100%; text-align:center;">+ ${auctionProduct.calcPriceWithComma}원 입찰하기	</a>
		                        </div>
		                    </div>
		                </div>
		            </div>
		            <div class="pd-widget" style="display:inline-block;width:32%;">
		                <div class="pd-agent">
		                    <div class="agent-text">
		                        <div class="at-title">
		                            <a class="primary-btn" href="javascript:void(0);" onclick="bid_it(${auctionProduct.calcPriceMax});" style="width: 100%; text-align:center;">+ ${auctionProduct.calcPriceMaxWithComma}원 입찰하기	</a>
		                        </div>
		                    </div>
		                </div>
		            </div>
                      <section class="property-submit-section spad">
				            <div class="row">
				                <div class="col-lg-12">
				                    <div class="property-submit-form">
				                        <form action="#">
				                            <div class="pf-title">
				                                <h4 style="margin-bottom : 15px;">희망가격</h4>
				                                <input type="text" name="modifyPrice" onkeyup="commas(this)" style="width:60%;"placeholder="희망 입찰 가격 입력">
				                                 <div class="pd-widget" style="margin-left:5px;width:39%;display:inline-block;float:right;" >
									                <div class="pd-agent">
									                    <div class="agent-text">
									                        <div class="at-title">
									                            <a href="javascript:void(0);" style="width:100%; padding :12px;text-align:center;" class="primary-btn" onclick="custom_bid_it();" >입찰하기	</a>
									                        </div>
									                    </div>
									                </div>
									            </div>
				                            </div>
				                        </form>
				                    </div>
				           </div>
				       </div>
			       </section>
                </div>
               
            </div>
            
      <%--      
         
            <div class="row" style="margin-top:30px;">
                <div class="col-lg-12">
                    <div class="pd-text">
                        <div class="pd-board">
                            <div class="tab-board">
                                <ul class="nav nav-tabs" role="tablist">
                                    <li class="nav-item">
                                        <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab">상세 정보</a>
                                    </li>
                                </ul><!-- Tab panes -->
                                <div class="tab-content">
                                    <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                    </div>
                                    <div class="tab-pane active" id="tabs-2" role="tabpanel">
                                        <div class="tab-desc">
                                           ${auctionProduct.detail}
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
              
            </div> --%>
            <div class="row" style="margin-top:30px;">
                <div class="col-lg-12">
                    <div class="pd-text">
                        <div class="pd-widget">
                            <h4>판매자 정보</h4>
                            <div class="pd-agent">
                                <div class="agent-pic">
                                    <img src="img/property/details/agent.jpg" alt="">
                                </div>
                                <div class="agent-text">
                                    <div class="at-title">
                                        <h6> ${auctionProduct.member.name}</h6>
                                        <span>Founder & CEO</span>
                                        <a href="#" class="primary-btn">VIew profile</a>
                                    </div>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipis cing elit, eiusmod tempor incididunt</p>
                                    <div class="at-option">
                                        <div class="at-number">123-455-688</div>
                                        <div class="at-social">
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="pd-widget">
                            <h4>판매자의 다른 댓글 보기</h4>
                            <div class="pd-review">
                                <div class="pr-item">
                                    <div class="pr-avatar">
                                        <div class="pr-pic">
                                            <img src="img/property/details/review/review-1.jpg" alt="">
                                        </div>
                                        <div class="pr-text">
                                            <h6>Brandon Kelley</h6>
                                            <span>15 Aug 2017</span>
                                            <div class="pr-rating">
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                            </div>
                                        </div>
                                    </div>
                                    <p>Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam.</p>
                                </div>
                                <div class="pr-item">
                                    <div class="pr-avatar">
                                        <div class="pr-pic">
                                            <img src="img/property/details/review/review-2.jpg" alt="">
                                        </div>
                                        <div class="pr-text">
                                            <h6>Matthew Nelson</h6>
                                            <span>15 Aug 2017</span>
                                            <div class="pr-rating">
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                            </div>
                                        </div>
                                    </div>
                                    <p>Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
              
            </div>
        </div>

	<jsp:include page="../common/footer.jsp" />
		 <div class="modal fade bd-example-modal-lg" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true"> 
		<!-- <div class="modal fade " id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true"> -->
 		    <div class="modal-dialog modal-lg" role="document"> 
		 <!--    <div class="modal-dialog" role="document"> -->
		      <div class="modal-content">
		        <div class="modal-header">
		          <h5 class="modal-title" id="exampleModalLabel"><b> ${auctionProduct.auctionProductName}</b></h5>
		          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		            <span aria-hidden="true">&times;</span>
		          </button>
		        </div>
		        <div class="modal-body">
		        
			    <section class="property-submit-section spad">
			        <div class="container">
			            <div class="row">
			                <div class="col-lg-12">
		                        <div class="pf-location rp-item">
                                    <div class="rp-pic" style="margin">
				                        <c:forEach var="auctionImgList" items="${auctionProduct.auctionProductImgs}" varStatus="status">
		                                        <img width="30%;" src="${pageContext.request.contextPath}/photo/img/${auctionImgList.fileSq}" alt="">
		                       			</c:forEach>
                                    </div>
                              	</div>
			                </div>
			            </div>
			        </div>
			    </section>
			    <section class="property-submit-section spad">
			        <div class="container">
			            <div class="row">
			                <div class="col-lg-12">
			                    <div class="property-submit-form">
			                        <form action="#">
			                            <div class="pf-location">
			                                <h4>배송지</h4>
			                                <div class="location-inputs">
			                                 <input type="text" onclick="sample6_execDaumPostcode()" id="sample6_address" name="region"  placeholder="주소를 입력해 주세요" title="주소" class="text full"style="width: 95%;" />
										                <input type="text" id="sample6_detailAddress" name="productRegionDetail" placeholder="상세 주소 입력" title="상세주소" class="text" style="width: 95%;" />
			                                </div>
			                            </div>
			                        </form>
			                    </div>
			                </div>
			            </div>
			        </div>
			    </section>
		   <!--   <section class="property-submit-section spad" style="padding : 0px;">
		        <div class="container">
		            <div class="row">
		                <div class="col-lg-12">
		                    <div class="property-submit-form">
		                        <form action="#">
		                            <div class="pf-location">
		                                <h4>사용포인트</h4>
		                                <div class="location-inputs">
		                                    <input type="text"placeholder="사용할 포인트" class="text" style="width: 100%;" /><br>
		                                    <p>사용 가능한 포인트 : </p>
		                                </div>
		                            </div>
		                        </form>
		                    </div>
		                </div>
		            </div>
		        </div>
		    </section> -->
		    <section class="contact-section" style="height: auto;">
		        <div class="container">
		            <div class="row">
		                <div class="col-lg-6" style="border-right: 1px solid #e1e1e1;">
		                    <div class="contact-info" style="padding-top: 50px;">
		                        <div class="ci-item">
		                            <div class="ci-icon">
		                                <i class="fa fa-tag"></i>
		                            </div>
		                            <div class="ci-text">
		                                <h5>상품금액</h5>
		                                <p><b>${auctionProduct.priceMaxWithComma}</b>원</p>
		                            </div>
		                        </div>
		                        <div class="ci-item">
		                            <div class="ci-icon">
		                                <i class="fa fa-percent"></i>
		                            </div>
		                            <div class="ci-text">
		                                <h5>수수료</h5>
		                                <p><b style="color: #ff0000">${auctionProduct.feesByMaxPrice}</b>원</p>
		                            </div>
		                        </div>
		                        <div class="ci-item">
		                            <div class="ci-icon">
		                                <i class="fa fa-money"></i>
		                            </div>
		                            <div class="ci-text">
		                                <h5>결제 금액</h5>
		                                <p><b >${auctionProduct.totalMaxPrice}</b>원</p>
		                            </div>
		                        </div>
		                      <%--   <div class="ci-item">
		                            <div class="ci-icon">
		                                <i class="fa fa-plus-circle"></i>
		                            </div>
		                            <div class="ci-text">
		                                <h5>적립포인트</h5>
		                                <p><b>${auctionProduct.calMaxPricePoint}</b>P</p>
		                            </div>
		                        </div> --%>
		
		                        <div class="ci-item">
		                            <div class="ci-icon">
		                                <i class="fa fa-credit-card"></i>
		                            </div>
		                            <div class="ci-text">
		                                <h5>총 결제 금액</h5>
		                                <p><b style="color: #ff0000">${auctionProduct.totalMaxPrice}</b>원</p>
		                            </div>
		                        </div>
		                    </div>
		                </div> 
		                <div class="col-lg-6">
		                    <div class="contact-info" style="padding-top: 50px;">
		                    <div class="pf-location">
		                      <h4><b>결제할 계좌</b></h4>
		                       </div>
		                        <c:forEach var="accounts" items="${accounts}" varStatus="status">
				                    <div class="col-lg-12" style="margin-top: 40px;">
				                        <div class="property-item">
				                            <div class="pi-text" onclick="valFx('${accounts.accountSq}')">
				                                <input type="hidden" value="${accounts.accountSq}" id="${accounts.accountSq}">
				                                <p>${accounts.bankCdName}</p>
				                                <h5><a href="#">계좌 번호 : ${accounts.accountNumber}</a></h5>
				                                <div class="pt-price"> ${accounts.changeWithComma}<span>원</span></div>
				                                <ul>
				                                </ul>
				                            </div>
				                        </div>
				                    </div>
                    			</c:forEach>
		                    </div>
		                </div>
		      
		            </div>
		        </div>
		          <div class="pd-text">
		        		<div class="pd-board">
                            <div class="tab-board">
                                <ul class="nav nav-tabs" role="tablist">
                                    <li class="nav-item">
                                        <a class="nav-link active" data-toggle="tab" href="#tabs-22" role="tab">개인정보 수집 및 이용</a>
                                    </li>
                                     <li class="nav-item">
                                        <a class="nav-link" data-toggle="tab" href="#tabs-33" role="tab">개인정보 제공 및 위탁</a>
                                    </li>
                                </ul><!-- Tab panes -->
                                <div class="tab-content">
                                    <div class="tab-pane active" id="tabs-22" role="tabpanel">
                                        <div class="tab-desc">
                                          <p> 원활한 서비스 제공을 위해 판매자에게 해당 정보가 제공됩니다.</p>
                                          <p> 회원님께서는 아래 내용에 대하여 동의를 하셔야 구매를 진행하실 수 있습니다.</p>
                                          <p> 수집이용목적 수집항목 보유기간</p>
                                          <p> 상품 및 경품 배송(반품/환불/취소 등), 배송지 확인, 최근 배송지 불러오기 기능 제공 배송지 정보 회원탈퇴 시 까지</p>
                                          <p> 단, 관계 법령의 규정에 따라 보존할 의무가 있으면 해당 기간 동안 보존</p>
                                          <p> 대금 결제/환불 서비스 제공, 주문/배송/거래 내역 조회 서비스 제공, 전자상거래법 준수 등 구매자 이름, 휴대폰번호, 상품 구매정보, 상품 수취인정보(이름, 주소, 전화번호), 개인통관고유부호(선택시) 회원탈퇴 시 까지</p>
                                          <p> 단, 관계 법령의 규정에 따라 보존할 의무가 있으면 해당 기간 동안 보존</p>
                                          <p> 이용계약(이용약관)이 존속중인 탈퇴하지 않은 회원의 경우 보유기간은 보존의무기간 이상 보관할 수 있으며 이 기간이 경과된 기록에 대해서 파기요청이 있는 경우 파기함</p>
                                          <p> 결제수단에 따른 개인정보 수집.이용 항목이 상이할 수 있음</p>
                                        </div>
                                    </div>
                                    <div class="tab-pane" id="tabs-33" role="tabpanel">
                                    	<div class="tab-desc">
											<p>원활한 서비스 제공을 위해 판매자에게 해당 정보가 제공 됩니다.</p>
											<p>회원님께서는 아래 내용에 대하여 동의를 하셔야 구매를 진행하실 수 있습니다.</p>
											<p>- 제공받는 자 : ${product.member.name}</p>
											<p>- 목적 : 판매자와 구매자의 거래의 원활한 진행, 본인 의사의 확인, 고객 상담 및 불만 처리, 상품과 경품 배송을 위한 배송지 확인 등</p>
											<p>- 항목 : 구매자 이름, 휴대폰번호, 상품 구매정보, 상품 수취인정보(이름, 주소, 전화번호), 개인통관고유번호(선택시)</p>
											<p>- 보유기간 : 구매 확정후 3개월</p>
										</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                      </div>
                    </div>
                    
                           
                         <div class="checkbox" style="margin:auto">
				            <label style="font-size: 20px">
				                <input type="checkbox" value="" >
				                <span class="cr"><i class="cr-icon fa fa-check"></i></span>
				               <b> 약관에 동의합니다.</b>
				            </label>
				        </div>
                            
	                   	 <div class="modal-footer">
	                   	 <input type="hidden" name="accountSeq" id="accountSeq" value="">
			              <button style="width:100%" type="button" class="btn btn-danger" onclick="submit_it();">결제하기</button>
			            </div>
                 </div>
		    </section> 
	</body>
	<script language="Javascript">
		
			function valFx(no) {
				console.log(no)
			     var accountSq = document.getElementById("accountSeq");
			    accountSq.value = no;
			}
	</script>
 	<script>
/* 	$(document).ready(function(){
		$('#action_menu_btn').click(function(){
			$('.action_menu').toggle();
		});
			}); */
			
	</script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="${pageContext.request.contextPath}/resources/member/js/address.js"></script>


</html>