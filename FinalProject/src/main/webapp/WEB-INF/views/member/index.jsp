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
    <title>HANA | MAIN</title>


</head>

<body>
	 <jsp:include page="common/header.jsp" />
  <!--  <section class="search-section spad" style="background:#ffffff; padding : 0px; margin-top : 20px; ">
        <div class="container">
            <div class="row">
            </div>
            <div class="search-form-content" style="margin:auto; width:50%;">
                <form action="#" class="filter-form">
                    <div class="input">
                        <input type="text" id="search-text" style="width: 70%; display: inline-block;" placeholder="상품검색">
                        <button type="button" style="display: inline-block; width: 19%;" class="search-btn sm-width">검색</button>
                    </div>
                </form>
            </div>
        </div>
	</section>  -->
	
    <section class="property-section latest-property-section spad">
        <div class="container">
        <div class="row">
        			<div class="col-lg-12 p-0">
	       				 <div class="section-title">
	                        <h5>오늘의 중고 상품</h5>
	                    </div>
                    </div>
                <c:forEach var="todayRecommendList" items="${todayRecommendList}" varStatus="status">
               <div class="col-lg-3 col-md-6">
                    <div class="property-item">
                        <div style="cursor:pointer;" onclick="location.href='${pageContext.request.contextPath}/member/productDetail?productSq=${todayRecommendList.productSq}'" class="pi-pic set-bg" 
                        data-setbg="${pageContext.request.contextPath}/photo/${todayRecommendList.productImgs[0].fileSq}">
                        </div>
                        <div class="pi-text">
                            <a href="#" class="heart-icon"><span class="icon_heart_alt"></span></a>
                            <div class="pt-price">${todayRecommendList.priceWithComma}<span>/원</span></div>
                            <h5><a href="${pageContext.request.contextPath}/member/productDetail?productSq=${todayRecommendList.productSq}" style="display: inline-block;text-overflow: ellipsis;white-space: nowrap;overflow: hidden;width: 100%;">${todayRecommendList.productName}</a></h5>
                          <%--   <p><span class="icon_pin_alt"></span> ${productList.region}</p> --%>
                             <ul>
                               <!--  <li><i class="fa fa-object-group"></i> 좋아요 수 출력 예정</li> -->
                                <li><i class="fa fa-eye"></i>${todayRecommendList.viewCnt}회</li>
                                <li><i class="fa fa-handshake-o"></i>${todayRecommendList.barginStatus}</li>
                                <li><i class="fa fa-cube"></i>${todayRecommendList.shippingStatus}</li>
                                <li><i class="fa fa-reply"></i>${todayRecommendList.exchangeStatus}</li>
                            </ul>
                        </div>
                    </div>
                </div> 
                </c:forEach>
            </div>
            <div class="row">
              <div class="col-lg-6 p-0">
                    <div class="section-title">
                        <h5>${member.name}님 맞춤형 경매상품</h5>
                    </div>
                       <div class="col-lg-12 m-auto p-0">
                    <div class="blog-details-content">
                        <div class="bc-widget">
                           <!--  <h4>Related posts</h4> -->
                            <div class="related-post">
                                <div class="row">
                                
	                               		<c:forEach var="auctionList" items="${auctionList}" varStatus="status">
		                                    <div class="col-md-4 col-sm-6">
		                                        <div class="related-item" style="cursor:pointer; "onclick="location.href='${pageContext.request.contextPath}/member/auctionDetail?auctionProductSq=${auctionList.auctionProductSq}'">
		                                            <div class="ri-pic">
		                                                <img style=" width:240px; height:160 " src="${pageContext.request.contextPath}/photo/img/${auctionList.auctionProductImgs[0].fileSq}" alt="">
		                                            </div>
		                                            <div class="ri-text">
		                                                <h6 style="display: inline-block;text-overflow: ellipsis;white-space: nowrap;overflow: hidden;width: 100%;">${auctionList.auctionProductName}</h6>
		                                                <span><b style="color:#000;font-size:15px;">현재가 : ${auctionList.priceNowWithComma}</b></span>
		                                            </div>
		                                        </div>
		                                    </div>
	                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                       
                    </div>
                </div>
                          <div class="row">
	                <div class="col-lg-12">
	                    <div class="loadmore-btn">
	                        <a href="${pageContext.request.contextPath}/member/auctionList">더 많은 경매 상품 보러가기</a>
	                    </div>
	                </div>
                </div>
                </div>
              
                 <div class="col-lg-6" >
                    <div class="blog-sidebar">
                        <div class="feature-post">
                             <div class="row">
				                <div class="col-lg-5">
				                    <div class="section-title">
				                        <h5>이런상품 어떠세요?</h5>
				                    </div>
				                </div>
				            </div>
                            <div class="recent-post" style="padding: 0px 20px 0px 0px;">
                             	
                             	<c:forEach var="productList" items="${productList}" varStatus="status">
                             	<div class="rp-item">
                                    <div class="rp-pic" style="cursor:pointer;" onclick="location.href='${pageContext.request.contextPath}/member/productDetail?productSq=${productList.productSq}'">
                                        <img style="width : 105pz; height:80px;" src="${pageContext.request.contextPath}/photo/img/${productList.productImgs[0].fileSq}" alt="">
                                    </div>
                                    <div class="rp-text">
                                        <h6 style="display: inline-block;text-overflow: ellipsis;white-space: nowrap;overflow: hidden;width: 80%;">
                                        	<a href="${pageContext.request.contextPath}/member/productDetail?productSq=${productList.productSq}">${productList.productName}</a></h6>
                                        <span style="font-size:15px;color:#000;"><b>가격 : ${productList.priceWithComma}</b></span>
                                        <span style="font-size:15px;color:#000;"><b>등록날짜 : ${productList.inputDateWithComma}</b></span>
                                    </div>
                                </div>
                                </c:forEach>
                                 <div class="col-lg-12">
				                    <div class="loadmore-btn">
				                        <a href="${pageContext.request.contextPath}/member/productList">더 많은 중고 상품 보러하기</a>
				                    </div>
				                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>



<jsp:include page="common/footer.jsp" />
</body>




</html>