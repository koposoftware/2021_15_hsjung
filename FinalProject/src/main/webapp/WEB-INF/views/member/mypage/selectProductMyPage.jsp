<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
    
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
					                                    <div class="rp-pic">
					                                        <img src="img/blog/rp-1.jpg" alt="">
					                                    </div>
					                                    <div class="rp-text">
					                                     	<a style="color: #000;font-weight: 600;" href="${pageContext.request.contextPath}/member/productDetail?productSq=${sellingProduct.productSq}">
	                                                    	 	${sellingProduct.productName}
		                                                    </a><br>
					                                        <span>  등록일 : ${sellingProduct.inputDateWithComma}</span><br>
					                                        <span> ${sellingProduct.priceWithComma}원</span>
					                                    </div>
					                                </div>
		                                        </div>
                                       </c:forEach>
                                    </div>
                                </div>
                            </div>
                            <!-- Card three -->
                            <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">
                                <div class="whats-news-caption">
                                    <div class="row">
                                       <c:forEach var="selledProduct" items="${selledProduct}" varStatus="status">
	                                         <div class="col-lg-6 col-md-6">
			                                         <div class="rp-item">
					                                    <div class="rp-pic">
					                                        <img src="img/blog/rp-1.jpg" alt="">
					                                    </div>
					                                    <div class="rp-text">
					                                     	<a href="#">${selledProduct.product.productName}</a>
					                                        <span> ${selledProduct.transactionType}</span><br>
					                                        <span> ${selledProduct.transactionDate}</span>
					                                    </div>
					                                </div>
		                                        </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                            <!-- card fure -->
                            <div class="tab-pane fade" id="nav-last" role="tabpanel" aria-labelledby="nav-last-tab">
                                <div class="whats-news-caption">
                                    <div class="row">
                                     <c:forEach var="buyedProduct" items="${buyedProduct}" varStatus="status">
                                         <div class="col-lg-6 col-md-6">
			                                         <div class="rp-item">
					                                    <div class="rp-pic">
					                                        <img src="img/blog/rp-1.jpg" alt="">
					                                    </div>
					                                    <div class="rp-text">
					                                     	<a href="#">${buyedProduct.product.productName}</a>
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
                            <div class="tab-pane fade" id="nav-nav-Sport" role="tabpanel" aria-labelledby="nav-Sports">
                                <div class="whats-news-caption">
                                    <div class="row">
                                        <div class="col-lg-6 col-md-6">
                                            <div class="single-what-news mb-100">
                                                <div class="what-cap" style="padding : 0px">
                                                    <span class="color1">Night party</span>
                                                    <h4><a href="#">Welcome To The Best Model  Winner Contest</a></h4>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6">
                                            <div class="single-what-news mb-100">
                                                <div class="what-cap">
                                                    <span class="color1">Night party</span>
                                                    <h4><a href="#">Welcome To The Best Model  Winner Contest</a></h4>
                                                </div>
                                            </div>
                                        </div> 
                                        <div class="col-lg-6 col-md-6">
                                            <div class="single-what-news mb-100">
                                                <div class="what-cap" style="padding : 0px">
                                                    <span class="color1">Night party</span>
                                                    <h4><a href="#">Welcome To The Best Model  Winner Contest</a></h4>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6">
                                            <div class="single-what-news mb-100">
                                                <div class="what-cap" style="padding : 0px">
                                                    <span class="color1">Night party</span>
                                                    <h4><a href="#">Welcome To The Best Model  Winner Contest</a></h4>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- card Six -->
                            <div class="tab-pane fade" id="nav-techno" role="tabpanel" aria-labelledby="nav-technology">
                                <div class="whats-news-caption">
                                    <div class="row">
                                        <div class="col-lg-6 col-md-6">
                                            <div class="single-what-news mb-100">
                                                <div class="what-cap" style="padding : 0px">
                                                    <span class="color1">Night party</span>
                                                    <h4><a href="#">Welcome To The Best Model  Winner Contest</a></h4>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6">
                                            <div class="single-what-news mb-100">
                                                <div class="what-cap" style="padding : 0px">
                                                    <span class="color1">Night party</span>
                                                    <h4><a href="#">Welcome To The Best Model  Winner Contest</a></h4>
                                                </div>
                                            </div>
                                        </div> 
                                        <div class="col-lg-6 col-md-6">
                                            <div class="single-what-news mb-100">
                                                <div class="what-cap">
                                                    <span class="color1">Night party</span>
                                                    <h4><a href="#">Welcome To The Best Model  Winner Contest</a></h4>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6">
                                            <div class="single-what-news mb-100">
                                                <div class="what-cap">
                                                    <span class="color1">Night party</span>
                                                    <h4><a href="#">Welcome To The Best Model  Winner Contest</a></h4>
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
  