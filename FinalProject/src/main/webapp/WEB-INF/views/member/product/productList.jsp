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
    <title>HANA | USED PRODUCT</title>
  
</head>

<body>
	 <jsp:include page="../common/header.jsp" />
 <!-- Breadcrumb Section Begin -->
<%--     <section class="breadcrumb-section spad set-bg" data-setbg="${pageContext.request.contextPath}/resources/member/img/breadcrumb-bg.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb-text">
                        <h4>중고 상품 리스트</h4>
                        <div class="bt-option">
                            <a href="./index.html"><i class="fa fa-home"></i> Home</a>
                            <span>중고 상품 리스트</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section> --%>
    <!-- Breadcrumb Section End -->

      
    <section class="team-section spad">
        <div class="container">
            <div class="row" >
                    <div class="ts-item" style="cursor:pointer;" onclick="location.href='${pageContext.request.contextPath}/member/productListByCategory?productCategorySq=1'" >
                        <div class="ts-text">
                            <div style="float: left;margin-right: 30px;margin-bottom:10px;margin-top:7px;width:100%;">
                                <i class="fas fa-tshirt" style="font-size: 30px;"></i>
                            </div>
                            <h6 ><b>패션의류</b></h6>
                        </div>
                    </div>
                    <div class="ts-item" style="cursor:pointer;" onclick="location.href='${pageContext.request.contextPath}/member/productListByCategory?productCategorySq=2'" >
                        <div class="ts-text">
                            <div style="float: left;margin-right: 30px;margin-bottom:10px;margin-top:7px;width:100%;">
                                <i class="fab fa-keybase" style="font-size: 30px;"></i>
                            </div>
                            <h6><b>뷰티잡화</b></h6>
                            
                        </div>
                    </div>
                    <div class="ts-item" style="cursor:pointer;" onclick="location.href='${pageContext.request.contextPath}/member/productListByCategory?productCategorySq=3'">
                        <div class="ts-text">
                            <div style="float: left;margin-right: 30px;margin-bottom:10px;margin-top:7px;width:100%;">
                                <i class="fas fa-baby" style="font-size: 30px;"></i>
                            </div>
                            <h6><b>유아용품</b></h6> 
                        </div>
                    </div>
                    <div class="ts-item" style="cursor:pointer;" onclick="location.href='${pageContext.request.contextPath}/member/productListByCategory?productCategorySq=4'">
                        <div class="ts-text">
                            <div style="float: left;margin-right: 30px;margin-bottom:10px;margin-top:7px;width:100%;">
                                <i class="fa fa-home" style="font-size: 30px;"></i>
                            </div>
                            <h6><b>가구생활</b></h6>
                        </div>
                    </div>
                    <div class="ts-item" style="cursor:pointer;" onclick="location.href='${pageContext.request.contextPath}/member/productListByCategory?productCategorySq=5'">
                        <div class="ts-text">
                            <div style="float: left;margin-right: 30px;margin-bottom:10px;margin-top:7px;width:100%;">
                                <i class="fas fa-chess" style="font-size: 30px;"></i>
                            </div>
                            <h6><b>취미컬렉션</b></h6>
                        </div>
                    </div>
                    <div class="ts-item" style="cursor:pointer;" onclick="location.href='${pageContext.request.contextPath}/member/productListByCategory?productCategorySq=6'">
                        <div class="ts-text">
                            <div style="float: left;margin-right: 30px;margin-bottom:10px;margin-top:7px;width:100%;">
                                <i class="fas fa-mobile" style="font-size: 30px;"></i>
                            </div>
                            <h6><b>디지털</b></h6> 
                        </div>
                    </div>
                    <div class="ts-item" style="cursor:pointer;" onclick="location.href='${pageContext.request.contextPath}/member/productListByCategory?productCategorySq=7'">
                        <div class="ts-text">
                            <div style="float: left;margin-right: 30px;margin-bottom:10px;margin-top:7px;width:100%;">
                                <i class="fas fa-tv" style="font-size: 30px;"></i>
                            </div>
                            <h6><b>컴퓨터</b></h6>
                        </div>
                    </div>
                    <div class="ts-item" style="cursor:pointer;" onclick="location.href='${pageContext.request.contextPath}/member/productListByCategory?productCategorySq=8'">
                        <div class="ts-text">
                            <div style="float: left;margin-right: 30px;margin-bottom:10px;margin-top:7px;width:100%;">
                                <i class="fa fa-futbol-o" style="font-size: 30px;"></i>
                            </div>
                            <h6><b>스포츠레저</b></h6>
                            
                        </div>
                    </div>
                    <div class="ts-item" style="cursor:pointer;" onclick="location.href='${pageContext.request.contextPath}/member/productListByCategory?productCategorySq=9'">
                        <div class="ts-text">
                            <div style="float: left;margin-right: 30px;margin-bottom:10px;margin-top:7px;width:100%;">
                                <i class="fas fa-book" style="font-size: 30px;"></i>
                            </div>
                            <h6><b>도서</b></h6> 
                        </div>
                    </div>
                    <div class="ts-item" style="cursor:pointer;" onclick="location.href='${pageContext.request.contextPath}/member/productListByCategory?productCategorySq=10'">
                        <div class="ts-text">
                            <div style="float: left;margin-right: 30px;margin-bottom:10px;margin-top:7px;width:100%;">
                                <i class="fas fa-couch" style="font-size: 30px;"></i>
                            </div>
                            <h6><b>생활가전</b></h6>
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
                        <h4>상품리스트</h4>
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
                <c:forEach var="productList" items="${product}" varStatus="status">
               <div class="col-lg-3 col-md-6">
                    <div class="property-item">
                        <div style="cursor:pointer;" onclick="location.href='${pageContext.request.contextPath}/member/productDetail?productSq=${productList.productSq}'" class="pi-pic set-bg" 
                        data-setbg="${pageContext.request.contextPath}/photo/${productList.productImgs[0].fileSq}">
                        </div>
                        <div class="pi-text">
                            <a href="#" class="heart-icon"><span class="icon_heart_alt"></span></a>
                            <div class="pt-price">${productList.priceWithComma}<span>/원</span></div>
                            <h5><a href="${pageContext.request.contextPath}/member/productDetail?productSq=${productList.productSq}" style="display: inline-block;text-overflow: ellipsis;white-space: nowrap;overflow: hidden;width: 100%;">${productList.productName}</a></h5>
                          <%--   <p><span class="icon_pin_alt"></span> ${productList.region}</p> --%>
                             <ul>
                               <!--  <li><i class="fa fa-object-group"></i> 좋아요 수 출력 예정</li> -->
                                <li><i class="fa fa-eye"></i>${productList.viewCnt}회</li>
                                <li><i class="fa fa-handshake-o"></i>${productList.barginStatus}</li>
                                <li><i class="fa fa-cube"></i>${productList.shippingStatus}</li>
                                <li><i class="fa fa-reply"></i>${productList.exchangeStatus}</li>
                            </ul>
                            <div class="pi-agent">
                                <div class="pa-item">
                                    <div class="pa-info">
                                        <%-- <img src="${pageContext.request.contextPath}/resources/member/img/property/posted-by/pb-1.jpg" alt=""> --%>
                                        <h6>${productList.member.name}</h6>
                                    </div>
                                    <!-- <div class="pa-text">
                                        123-455-688
                                    </div> -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div> 
                
               <%--  <div class="blog-item-list">
                        <div class="blog-item large-blog">
                            <div class="bi-pic">
                                <img width = "200px;"src="${pageContext.request.contextPath}/photo/${productList.productImgs[0].fileSq}" alt="">
                            </div>
                            <div class="bi-text">
                                <h4><a href="${pageContext.request.contextPath}/member/productDetail?productSq=${productList.productSq}">${productList.productName}</a></h4>
                                <ul>
                                    <li>by <span>Jonathan Doe</span></li>
                                    <li>Seb 24, 2019</li>
                                    <li>12 Comment</li>
                                </ul>
                                <p>Lorem Ipsum has been the industry’s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book sentially unchanged...</p>
                                <a href="#" class="read-more">Read more <span class="arrow_right"></span></a>
                            </div>
                        </div>
                    </div> --%>
                
                </c:forEach>
                ${pagination}
            </div>
        </div>
    </section>
  
<jsp:include page="../common/footer.jsp" />
</body>




</html>