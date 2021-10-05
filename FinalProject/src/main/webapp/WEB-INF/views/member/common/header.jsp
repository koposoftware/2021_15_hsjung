<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700,800,900&display=swap"
        rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,900&display=swap" rel="stylesheet">

    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.min.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/member/css/richtext.min.css" type="text/css">
    <!-- Css Styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/member/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/member/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/member/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/member/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/member/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/member/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/member/css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/member/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/member/css/style.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/member/css/image-uploader.min.css" type="text/css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
    <link href="${pageContext.request.contextPath}/resources/member/css/checkbox.css" rel="stylesheet" />
    <style>

        #search-text{
            clear: none;
            margin-right: 20px;
            height: 46px;
            background: #ffffff;
            border-radius: 0;
            border: 1px solid #e1e1e1;
            line-height: 43px;
            margin-bottom: 20px;
            width: 100%;
            padding-left: 15px;
        }
        #search-text::placeholder{
            font-size: 13px;
            color: #666666;
            font-weight: 500;
        }
    </style>
   
</head>
<body>
 <div class="offcanvas-menu-overlay"></div>
    <div class="offcanvas-menu-wrapper">
        <div class="canvas-close">
            <span class="icon_close"></span>
        </div>
        <div class="logo">
            <a href="./index.html">
                <img src="${pageContext.request.contextPath}/index"><img src="${pageContext.request.contextPath}/resources/member/img/Optimized-h-logo.png" alt="">
            </a>
        </div>
        <div id="mobile-menu-wrap"></div>
        <div class="om-widget">
           <!--  <ul>
                <li><i class="icon_mail_alt"></i> Aler.support@gmail.com</li>
                <li><i class="fa fa-mobile-phone"></i> 125-711-811 <span>125-668-886</span></li>
            </ul> -->
		        <c:choose>
		        <c:when test="${ member != null }">
		                 <li><i class="fa fa-user"></i> ${ member.name }님 환영합니다.</li>
		                 <a href="${pageContext.request.contextPath}/index/logout" style="padding: 14px 25px;" class="hw-btn">로그아웃</a>
		                 <a href="${pageContext.request.contextPath}/member/mypage" class="hw-btn" style="padding: 14px 25px;">마이페이지</a>
			    </c:when>
			    <c:otherwise>
			          <a href="#" class="hw-btn" style="padding: 14px 25px;">회원가입</a>
		                   		  <a href="${pageContext.request.contextPath}/index/login" style="padding: 14px 25px;" class="hw-btn">로그인</a>
			    </c:otherwise>
			</c:choose>
        </div>
       <!--  <div class="om-social">
            <a href="#"><i class="fa fa-facebook"></i></a>
            <a href="#"><i class="fa fa-twitter"></i></a>
            <a href="#"><i class="fa fa-youtube-play"></i></a>
            <a href="#"><i class="fa fa-instagram"></i></a>
            <a href="#"><i class="fa fa-pinterest-p"></i></a>
        </div> -->
    </div>
<header class="header-section">
    <div class="hs-top">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="logo">
                        <a href="${pageContext.request.contextPath}/index"><img src="${pageContext.request.contextPath}/resources/member/img/Optimized-h-logo.png" style="width: 230px;" alt=""></a>
                    </div>
                </div>
                
                <div class="col-lg-4">
                 <section class="search-section spad" style="background:#ffffff; padding : 0px; margin-top : 20px; ">
			        <div class="container">
			            <div class="row">
			            </div>
			            <div class="search-form-content">
			                <form action="#" class="filter-form">
			                    <div class="input">
			                        <input type="text" id="search-text" style="width: 70%; display: inline-block;" placeholder="상품검색">
			                        <button type="button" style="display: inline-block; width: 19%;" class="search-btn sm-width">검색</button>
			                    </div>
			                </form>
			            </div>
			        </div>
			    </section>
			    	
                </div>
               
                <div class="col-lg-5">
                    <div class="ht-widget">
                        <ul>                       
                        <c:choose>
	                        <c:when test="${ member != null }">
	                        <li><i class="fa fa-user"></i> ${ member.name }님 환영합니다.</li>
	                           <a href="${pageContext.request.contextPath}/index/logout" style="padding: 14px 25px;" class="hw-btn">로그아웃</a>
	                           <a href="${pageContext.request.contextPath}/member/mypage" class="hw-btn" style="padding: 14px 25px;">마이페이지</a>
						    </c:when>
						    <c:otherwise>
						          <a href="#" class="hw-btn" style="padding: 14px 25px;">회원가입</a>
	                       		  <a href="${pageContext.request.contextPath}/index/login" style="padding: 14px 25px;" class="hw-btn">로그인</a>
						    </c:otherwise>
						</c:choose>
						</ul>
                    </div>
                </div>
            </div>
           <!--   <div class="col-lg-12">
			    	<div class="trending-tittle" style="padding :0px; ">
                        <strong style="background-color: #00C89E"><b style="color:#ffffff;">새로운 소식</b></strong>
                        <p>Rem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                        <div class="trending-animated">
                            <ul id="js-news" class="js-hidden">
                                <li class="news-item">하나 MARKET OPEN!!</li>
                                <li class="news-item">Spondon IT sit amet, consectetur.......</li>
                                <li class="news-item">아주 긴 문장 Rem ipsum dolor sit amet, consectetur adipisicing elit.em ipsum dolor sit a amet, consectetur adipisicing elit.em ipsum dolor sit a amet, consectetur adipisicing elit.em ipsum dolor sit amet, consectetur adipisicing elit.</li>
                            </ul>
                        </div>
                        
                    </div>
                </div> -->
            <div class="canvas-open">
                <span class="icon_menu"></span>
            </div>
        </div>
    </div>
<%--     <div class="hs-nav">
        <div class="container">
            <div class="row">
                <div class="col-lg-9">
                    <nav class="nav-menu"  style="margin-top: 10px;">
                        <ul>
                            <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                            <li><a href="#">플랫폼 소개</a></li>
                            <li>
                            	<a href="${pageContext.request.contextPath}/member/productList">중고 상품</a>
                            </li>
                            <li>
                            	<a href="${pageContext.request.contextPath}/member/auctionList">중고 경매</a>
                            </li>
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3">
                    <div class="hs-top">
                        <div class="ht-widget" style="float: right;">
                            <a href="${pageContext.request.contextPath}/member/productAdd" class="hw-btn">상품등록하기</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> --%>
</header>
</body>