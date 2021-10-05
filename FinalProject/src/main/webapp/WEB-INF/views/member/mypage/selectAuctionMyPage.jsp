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
                                    <a class="nav-item nav-link active" id="nav-bid-tab" data-toggle="tab" href="#nav-bid" role="tab" aria-controls="nav-bid" aria-selected="true"><b>입찰 중인 경매 상품</b></a>
                                    <a class="nav-item nav-link" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true"><b>낙찰된 경매 상품</b></a>
                                    <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-contact" role="tab" aria-controls="nav-contact" aria-selected="false"><b>판매 완료 경매 상품</b></a>
                                    <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false"><b>판매 중인 경매 상품</b></a>
                                    <a class="nav-item nav-link" id="nav-last-tab" data-toggle="tab" href="#nav-last" role="tab" aria-controls="nav-last" aria-selected="true"><b>구매한 중고 경매 상품</b></a>
                                    <a class="nav-item nav-link" id="nav-nav-Sport-tab" data-toggle="tab" href="#nav-nav-Sport" role="tab" aria-controls="nav-nav-Sport" aria-selected="false"><b>내 경매 후기</b></a>
                                    <a class="nav-item nav-link " id="nav-techno-tab" data-toggle="tab" href="#nav-techno" role="tab" aria-controls="nav-techno" aria-selected="false"><b>찜한 경매 상품</b></a>
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
	                        <div class="tab-pane fade show active" id="nav-bid" role="tabpanel" aria-labelledby="nav-bid-tab" style="background-color: #fff;">           
	                                <div class="whats-news-caption">
	                                    <div class="row">
			     					 	<c:forEach var="biddingAuction" items="${biddingAuction}" varStatus="status">
	                                        <div class="col-lg-6 col-md-6">
		                                         <div class="rp-item">
				                                    <div class="rp-text">
				                                        <h6><a style="font-size : 20px;;color: #000;font-weight: 600;" href="#">${biddingAuction.auctionProductName}</a></h6>
				                                        <span><b>현재가 </b>: ${biddingAuction.priceNowWithComma}</span><br>
				                                        <span><b>시작일 </b>: ${biddingAuction.startDateWithComma}</span><br>
				                                        <span><b>종료일 </b>: ${biddingAuction.endDateWithComma}</span><br>
				                                        <span><b>즉구가 </b>: ${biddingAuction.priceMaxWithComma}</span><br>
				                                    </div>
				                                </div>
	                                        </div>
			                              </c:forEach>
	                                    </div>
	                                </div>
							</div>
	                        <div class="tab-pane fade show" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab" style="background-color: #fff;">           
	                                <div class="whats-news-caption">
	                                    <div class="row">
	                                         <div class="col-lg-6 col-md-6">
		                                         <div class="rp-item">
				                                    <div class="rp-text">
				                                        <h6><a style="font-size : 20px;;color: #000;font-weight: 600;" href="#">스타워즈 포 다메론 엑스윙 파이터 외 1종</a></h6>
				                                        <span><b>현재가 </b>: 93,000</span><br>
				                                        <span><b>시작일 </b>: 2021-10-01 22:36:15</span><br>
				                                        <span><b>종료일 </b>: 2021-10-02 08:00:00</span><br>
				                                        <span><b>낙찰가 </b>: 93,000</span><br>
				                                        <span><b>배송상태 </b>: 배송 준비중</span><br>
				                                    </div>
				                                </div>
	                                        </div>
	                                    </div>
	                                </div>
							</div>
							
							<div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab" style="background-color: #fff;">
                                <div class="whats-news-caption">
                                    <div class="row">
                                    <c:forEach var="sellingAuction" items="${sellingAuction}" varStatus="status">
                                        <div class="col-lg-6 col-md-6">
	                            			<div class="rp-item">
			                                    <div class="rp-pic">
			                                        <img src="img/blog/rp-1.jpg" alt="">
			                                    </div>
			                                    <div class="rp-text">
			                                        <h6><a href="#">${sellingAuction.auctionProductName}</a></h6>
			                                        <span>Seb 24, 2019</span>
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
                                       <c:forEach var="selledAuction" items="${selledAuction}" varStatus="status">
	                                        <div class="col-lg-6 col-md-6">
		                                        <div class="rp-item">
				                                    <div class="rp-pic">
				                                        <img src="img/blog/rp-1.jpg" alt="">
				                                    </div>
				                                    <div class="rp-text">
				                                        <h6><a href="#">${selledAuction.auctionProduct.auctionProductName}</a></h6>
				                                        <span>Seb 24, 2019</span>
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
                                     <c:forEach var="buyedAuction" items="${buyedAuction}" varStatus="status">
                                        <div class="col-lg-6 col-md-6">
                                         		<div class="rp-item">
				                                    <div class="rp-pic">
				                                        <img src="img/blog/rp-1.jpg" alt="">
				                                    </div>
				                                    <div class="rp-text">
				                                        <h6><a href="#">${buyedAuction.auctionProduct.auctionProductName}</a></h6>
				                                        <span>Seb 24, 2019</span>
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
                                        <div class="col-lg-6 col-md-6">
                                            <div class="single-what-news mb-100">
                                                <div class="what-cap" style="padding : 0px">
                                                    <span class="color1">경매 party</span>
                                                    <h4><a href="#">Welcome To The Best Model  Winner Contest</a></h4>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6">
                                            <div class="single-what-news mb-100">
                                                <div class="what-img">
                                                    <img src="assets/img/news/whatNews2.jpg" alt="">
                                                </div>
                                                <div class="what-cap">
                                                    <span class="color1">Night party</span>
                                                    <h4><a href="#">Welcome To The Best Model  Winner Contest</a></h4>
                                                </div>
                                            </div>
                                        </div> 
                                        <div class="col-lg-6 col-md-6">
                                            <div class="single-what-news mb-100">
                                                <div class="what-img">
                                                    <img src="assets/img/news/whatNews3.jpg" alt="">
                                                </div>
                                                <div class="what-cap" style="padding : 0px">
                                                    <span class="color1">Night party</span>
                                                    <h4><a href="#">Welcome To The Best Model  Winner Contest</a></h4>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6">
                                            <div class="single-what-news mb-100">
                                                <div class="what-img">
                                                    <img src="assets/img/news/whatNews4.jpg" alt="">
                                                </div>
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
                            <div class="tab-pane fade" id="nav-techno" role="tabpanel" aria-labelledby="nav-technology" style="background-color: #fff;">
                                <div class="whats-news-caption">
                                    <div class="row">
                                        <div class="col-lg-6 col-md-6">
                                            <div class="single-what-news mb-100">
                                                <div class="what-img">
                                                    <img src="assets/img/news/whatNews1.jpg" alt="">
                                                </div>
                                                <div class="what-cap" style="padding : 0px">
                                                    <span class="color1">Night party</span>
                                                    <h4><a href="#">Welcome To The Best Model  Winner Contest</a></h4>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6">
                                            <div class="single-what-news mb-100">
                                                <div class="what-img">
                                                    <img src="assets/img/news/whatNews2.jpg" alt="">
                                                </div>
                                                <div class="what-cap" style="padding : 0px">
                                                    <span class="color1">Night party</span>
                                                    <h4><a href="#">Welcome To The Best Model  Winner Contest</a></h4>
                                                </div>
                                            </div>
                                        </div> 
                                        <div class="col-lg-6 col-md-6">
                                            <div class="single-what-news mb-100">
                                                <div class="what-img">
                                                    <img src="assets/img/news/whatNews3.jpg" alt="">
                                                </div>
                                                <div class="what-cap">
                                                    <span class="color1">Night party</span>
                                                    <h4><a href="#">Welcome To The Best Model  Winner Contest</a></h4>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6">
                                            <div class="single-what-news mb-100">
                                                <div class="what-img">
                                                    <img src="assets/img/news/whatNews4.jpg" alt="">
                                                </div>
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
                    <!-- End Nav Card -->
                    
                        </div>
                    <!-- End Nav Card -->
                      </div>
                    </div>