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
  <link href="${pageContext.request.contextPath}/resources/chat/chatting.css" rel="stylesheet" />
<body>
	 <jsp:include page="../common/header.jsp" />
 
   <section class="blog-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="blog-item-list">
                        <div class="blog-item large-blog">
                            <div class="bi-pic">
                                <img src="img/blog/blog-1.jpg" alt="">
                            </div>
                            <div class="bi-text">
                                <h3 style="font-weight:600;">${member.name} 님이 보유한 계좌 리스트</h3>
                            </div>
                        </div>
                          <c:forEach var="accounts" items="${accounts}" varStatus="status">
	                        <div class="blog-item">
	                            <div class="bi-pic">
	                                <img src="img/blog/blog-2.jpg" alt="">
	                            </div>
	                            <div class="bi-text" >
	                                <h5 style="font-weight : 500;">은행 계좌 : ${accounts.bankCdName}</h5>
	                                <h5 style="font-weight : 500;">계좌 번호 : ${accounts.accountNumber}</h5>
	                                <h5 style="font-weight : 500;">계좌 잔액 :  ${accounts.changeWithComma}</h5>
	                              <%--   <ul>
	                                    <input type="hidden" value="${accounts.accountSq}">
	                                    <li>${accounts.bankCdName}</li>
	                                    <li> ${accounts.accountNumber}</li>
	                                    <li> ${accounts.changeWithComma}</li>
	                                </ul> --%>
	                                <form>
	                                <a style="float:right;"href="${pageContext.request.contextPath}/member/addMemberAccount?accountSq=${accounts.accountSq}" class="read-more">해당 계좌 선택하기<span class="arrow_right"></span></a>
	                                </form>
	                            </div>
	                        </div>
                        </c:forEach>
                      
                    </div>
                </div>
            </div>
        </div>
    </section>
   
    

 	<jsp:include page="../common/footer.jsp" />
</html>