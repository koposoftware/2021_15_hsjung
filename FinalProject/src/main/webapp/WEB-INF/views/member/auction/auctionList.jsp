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
  
</head>

<body>
	 <jsp:include page="../common/header.jsp" />

    <!-- Breadcrumb Section Begin -->
  
    <!-- Breadcrumb Section End -->

    <section class="team-section spad">
        <div class="container">
            <div class="row" >
                    <div class="ts-item" style="cursor:pointer;" onclick="location.href='${pageContext.request.contextPath}/member/auctionListByCategory?productCategorySq=11'" >
                        <div class="ts-text">
                            <div style="float: left;margin-right: 30px;margin-bottom:10px;margin-top:7px;width:100%;">
                                <i class="fas fa-palette" style="font-size: 30px;"></i>
                            </div>
                            <h6 ><b>수집품 /<br>예술품</b></h6>
                        </div>
                    </div>
                    <div class="ts-item" style="cursor:pointer;" onclick="location.href='${pageContext.request.contextPath}/member/auctionListByCategory?productCategorySq=12'" >
                        <div class="ts-text">
                            <div style="float: left;margin-right: 30px;margin-bottom:10px;margin-top:7px;width:100%;">
                                <i class="fas fa-plug" style="font-size: 30px;"></i>
                            </div>
                            <h6 ><b>전자제품</b></h6>
                        </div>
                    </div>
                    <div class="ts-item" style="cursor:pointer;" onclick="location.href='${pageContext.request.contextPath}/member/auctionListByCategory?productCategorySq=13'">
                        <div class="ts-text">
                            <div style="float: left;margin-right: 30px;margin-bottom:10px;margin-top:7px;width:100%;">
                                <i class="fas fa-tshirt" style="font-size: 30px;"></i>
                            </div>
                            <h6><b>패션</b></h6> 
                        </div>
                    </div>
                    <div class="ts-item" style="cursor:pointer;" onclick="location.href='${pageContext.request.contextPath}/member/auctionListByCategory?productCategorySq=14'">
                        <div class="ts-text">
                            <div style="float: left;margin-right: 30px;margin-bottom:10px;margin-top:7px;width:100%;">
                                <i class="fa fa-drum" style="font-size: 30px;"></i>
                            </div>
                            <h6><b>악기/장비</b></h6>
                        </div>
                    </div>
                    <div class="ts-item" style="cursor:pointer;" onclick="location.href='${pageContext.request.contextPath}/member/auctionListByCategory?productCategorySq=15'">
                        <div class="ts-text">
                            <div style="float: left;margin-right: 30px;margin-bottom:10px;margin-top:7px;width:100%;">
                                <i class="fas fa-car-battery" style="font-size: 30px;"></i>
                            </div>
                            <h6><b>자동차 부품 및 악세사리</b></h6>
                        </div>
                    </div>
                    <div class="ts-item" style="cursor:pointer;" onclick="location.href='${pageContext.request.contextPath}/member/auctionListByCategory?productCategorySq=16'">
                        <div class="ts-text">
                            <div style="float: left;margin-right: 30px;margin-bottom:10px;margin-top:7px;width:100%;">
                                <i class="fas fa-baseball-ball" style="font-size: 30px;"></i>
                            </div>
                            <h6><b>스포츠용품</b></h6> 
                        </div>
                    </div>
                    <div class="ts-item" style="cursor:pointer;" onclick="location.href='${pageContext.request.contextPath}/member/auctionListByCategory?productCategorySq=17'">
                        <div class="ts-text">
                            <div style="float: left;margin-right: 30px;margin-bottom:10px;margin-top:7px;width:100%;">
                                <i class="fas fa-chess" style="font-size: 30px;"></i>
                            </div>
                            <h6><b>장난감 및 취미</b></h6>
                        </div>
                    </div>
                    <div class="ts-item" style="cursor:pointer;" onclick="location.href='${pageContext.request.contextPath}/member/auctionListByCategory?productCategorySq=18'">
                        <div class="ts-text">
                            <div style="float: left;margin-right: 30px;margin-bottom:10px;margin-top:7px;width:100%;">
                                <i class="fa fa-couch" style="font-size: 30px;"></i>
                            </div>
                            <h6><b>가구</b></h6>
                            
                        </div>
                    </div>
                    <div class="ts-item" style="cursor:pointer;" onclick="location.href='${pageContext.request.contextPath}/member/auctionListByCategory?productCategorySq=19'">
                        <div class="ts-text">
                            <div style="float: left;margin-right: 30px;margin-bottom:10px;margin-top:7px;width:100%;">
                                <i class="fas fa-book" style="font-size: 30px;"></i>
                            </div>
                            <h6><b>책 영화 및<br> 음악</b></h6> 
                        </div>
                    </div>
                    <div class="ts-item" style="cursor:pointer;" onclick="location.href='${pageContext.request.contextPath}/member/auctionListByCategory?productCategorySq=20'">
                        <div class="ts-text">
                            <div style="float: left;margin-right: 30px;margin-bottom:10px;margin-top:7px;width:100%;">
                                <i class="fas fa-plus" style="font-size: 30px;"></i>
                            </div>
                            <h6><b>기타 <br>카테고리</b></h6>
                        </div>
                    </div>
            </div>
        </div>
    </section>
  <section class="breadcrumb-section spad set-bg" data-setbg="${pageContext.request.contextPath}/resources/member/img/breadcrumb-bg.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb-text">
                        <h4>경매 상품 조회</h4>
                        <div class="bt-option">
                            <a href="./index.html"><i class="fa fa-home"></i> Home</a>
                            <span>경매 상품 조회</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="property-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-5">
                    <div class="section-title">
                        <h4>경매 상품 리스트</h4>
                    </div>
                </div>
                <div class="col-lg-7">
                    <div class="property-controls">
                        <ul>
                            <li data-filter="all">전체</li>
                            <li data-filter=".apart">업로드 순</li>
                            <li data-filter=".house">좋아요 순</li>
                            <li data-filter=".office">가격순</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="row">
             	<c:forEach var="auctionList" items="${auction}" varStatus="status">
	                <div class="col-lg-3 col-md-6">
	                    <div class="property-item">
	                        <div class="pi-pic set-bg" data-setbg="${pageContext.request.contextPath}/photo/${auctionList.auctionProductImgs[0].fileSq}">
	                          <!--   <div class="label c-red">LIVE</div> -->
	                        </div>
	                        <div class="pi-text">
	                            <a href="#" class="heart-icon"><span class="icon_heart_alt"></span></a>
	                            <div class="pt-price">현재가 : ${auctionList.priceNowWithComma}<span>원</span></div>
	                            <h5><a style="display: inline-block;text-overflow: ellipsis;white-space: nowrap;overflow: hidden;width: 100%;" href="${pageContext.request.contextPath}/member/auctionDetail?auctionProductSq=${auctionList.auctionProductSq}">${auctionList.auctionProductName}</a></h5>
	                            <ul>
	                              <li><i class="fa fa-eye"></i>${auctionList.viewCnt}회</li>
	                                <li><i class="fa fa-cube"></i>${auctionList.shippingStatus}</li>
	                                <li><i class="fa fa-reply"></i>${auctionList.exchangeStatus}</li>
                                
	                               <!--  <li><i class="fa fa-object-group"></i> 2, 283</li>
	                                <li><i class="fa fa-bathtub"></i> 123</li>
	                                <li><i class="fa fa-bed"></i> 05</li>
	                                <li><i class="fa fa-automobile"></i> 01</li> -->
	                            </ul>
	                            <div class="pi-agent">
	                                <div class="pa-item">
	                                    <div class="pa-info">
	                                     <%--    <img src="${pageContext.request.contextPath}/resources/member/img/property/posted-by/pb-1.jpg" alt=""> --%>
	                                        <h6>${auctionList.member.name}</h6>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
                </c:forEach>
                ${pagination}
            </div>
        </div>
    </section>
   
  
	<jsp:include page="../common/footer.jsp" />
</body>




</html>