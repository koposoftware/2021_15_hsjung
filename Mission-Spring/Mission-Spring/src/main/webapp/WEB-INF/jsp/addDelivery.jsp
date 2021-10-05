<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="UTF-8" dir="ltr">

  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <!-- ===============================================-->
    <!--    Document Title-->
    <!-- ===============================================-->
    <title>traffico | Landing, Responsive &amp; Business Templatee</title>


    <!-- ===============================================-->
    <!--    Favicons-->
    <!-- ===============================================-->
    <link rel="apple-touch-icon" sizes="180x180" href="${pageContext.request.contextPath}/resources/assets/img/favicons/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="${pageContext.request.contextPath}/resources/assets/img/favicons/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/resources/assets/img/favicons/favicon-16x16.png">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/assets/img/favicons/favicon.ico">
    <link rel="manifest" href="assets/img/favicons/manifest.json">
    <meta name="msapplication-TileImage" content="${pageContext.request.contextPath}/resources/assets/img/favicons/mstile-150x150.png">
    <meta name="theme-color" content="#ffffff">


    <!-- ===============================================-->
    <!--    Stylesheets-->
    <!-- ===============================================-->
    <link href="${pageContext.request.contextPath}/resources/assets/css/theme.css" rel="stylesheet" />

  </head>


  <body>

    <!-- ===============================================-->
    <!--    Main Content-->
    <!-- ===============================================-->
    <main class="main" id="top">
      <nav class="navbar navbar-expand-lg navbar-dark fixed-top py-4 d-block" data-navbar-on-scroll="data-navbar-on-scroll">
        <div class="container"><a class="navbar-brand" href="index.html"><img src="${pageContext.request.contextPath}/resources/assets/img/gallery/logo.png" height="24" alt="..." /></a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"> </span></button>
          <div class="collapse navbar-collapse border-top border-lg-0 mt-4 mt-lg-0" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto pt-2 pt-lg-0 font-base">
              <li class="nav-item px-2" data-anchor="data-anchor"><a class="nav-link fw-medium active" aria-current="page" href="${pageContext.request.contextPath}/">Home</a></li>
            </ul>
            <form class="ps-lg-5"><a class="btn btn-primary order-1 order-lg-0" href="${pageContext.request.contextPath}/modifyDelivery">배송상태 변경</a></form>
             <form class="ps-lg-5"><a class="btn btn-primary order-1 order-lg-0" href="${pageContext.request.contextPath}/addDelivery">상품 추가</a></form>
          </div>
        </div>
      </nav>
     
      <section class="bg-primary-gradient" id="faq">
        <div class="bg-holder" style="background-image:url(assets/img/gallery/faq-bg.png);background-position:right;background-size:contain;">
        </div>
        <!--/.bg-holder-->



      <section>
        <div class="bg-holder" style="background-image:url(${pageContext.request.contextPath}/resources/assets/img/gallery/footer-bg.png);background-position:left;background-size:contain;padding:5px 3px;">
        </div>
        <!--/.bg-holder-->

        <div class="container" id="addStatus">
          <div class="row min-vh-lg-50 min-vh-xl-75">
            <div class="col-lg-6 col-xl-5 my-2 py-9 d-none d-lg-block">
              <div class="card card-span bg-transparent border-start border-primary border-5 mt-3">
                <div class="card-body">
                  <p class="text-light fs-2 lh-lg px-lg-3">주문 접수 받자 마자 슥- <br>도착하는 현-슥택배</p>
                </div>
              </div>
            </div>
            <div class="col-lg-6 col-xl-5 mb-3">
              <div class="card card-span shadow py-4 px-5">
                <div class="card-body"> 
                  <form class="row g-3 align-items-center" action="${pageContext.request.contextPath}/addDelivery" method="post">
                    <div class="mb-3">
                      <label class="form-label" for="formGroupExampleInput2"><b>운송장번호</b></label>
                      <input class="form-control form-traffico-control" name="unsongjang" id="formGroupExampleInput2" type="text" placeholder="운송장 번호를 입력해 주세요" />
                      <label class="form-label" for="formGroupExampleInput2"><b>상품이름</b></label>
                      <input class="form-control form-traffico-control" name="productName" id="formGroupExampleInput2" type="text" placeholder="상품이름 번호를 입력해 주세요" />
                    </div>
                    <div class="col-12">
                      <button class="btn btn-primary" type="submit">택배 부치기
                        <svg class="bi bi-arrow-right ms-2" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" viewBox="0 0 16 16">
                          <path fill-rule="evenodd" d="M1 8a.5.5 0 0 1 .5-.5h11.793l-3.147-3.146a.5.5 0 0 1 .708-.708l4 4a.5.5 0 0 1 0 .708l-4 4a.5.5 0 0 1-.708-.708L13.293 8.5H1.5A.5.5 0 0 1 1 8z"></path>
                        </svg>
                      </button>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>


      <section class="py-5">
        <div class="container">
          <div class="row flex-center">
            <div class="col-md-6 col-xl-8 order-0">
              <p class="text-center text-md-start">All rights Reserved &copy; 괴도 J</p>
            </div>
            <div class="col-md-6 col-xl-3 order-1">
              <p class="text-center text-md-end text-xl-start">Made with&nbsp;
                </svg>&nbsp;by&nbsp;<a class="text-1000 fw-bold" href="https://themewagon.com/" target="_blank">Jung Hyun Seok </a>
              </p>
            </div>
          </div>
        </div>
      </section>
    </main>
    <script src="${pageContext.request.contextPath}/resources/vendors/@popperjs/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendors/bootstrap/bootstrap.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/resources/vendors/is/is.min.js"></script>
    <script src="https://polyfill.io/v3/polyfill.min.js?features=window.scroll"></script>
    <script src="${pageContext.request.contextPath}/resources/vendors/fontawesome/all.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/theme.js"></script>

    <link href="https://fonts.googleapis.com/css2?family=DM+Serif+Display&amp;family=Rubik:wght@300;400;500;600;700;800&amp;display=swap" rel="stylesheet">
  </body>

</html>