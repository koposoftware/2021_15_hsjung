<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="UTF-8">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Aler Template">
    <meta name="keywords" content="Aler, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>HANA | USED PRODUCT</title>
    
 	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
   	<script type="text/javascript">
     $(document).ready(function() {   //radio버튼처럼 checkbox name값 설정
           $('input[type="checkbox"][name="productCategory"]').click(function(){
                //checkbox 전체를 checked 해제후 click한 요소만 true지정
                //checked를 확인후 여러개가 선택되었을 경우 check 해제
                 if ($(this).prop('checked')) {
                  	  $('input[type="checkbox"][name="productCategory"]').prop('checked',false);
                      $(this).prop('checked', true);
                    }
               });
     });
    </script>
    
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

    <script language="Javascript">
function submit_it()
{
		var bargin = 0;
		var shipping = 0;
		var exchange = 0;
		var data = new FormData();
		var pSize = "";
		var bSize = "";
		var sSize = "";
		var eSize = "";
		
			$("input[name=productCategory]:checked").each(function() {
	          	if(pSize == ""){
	          		pSize = $(this).val();
		          	} else {
		          		pSize = pSize + "," + $(this).val();
		          	}
	          	});
	     
          	$("input[name=shipping]:checked").each(function() {
              	if(sSize == ""){
              		sSize = $(this).val();
    	          	} else {
    	          		sSize = sSize + "," + $(this).val();
    	          	}
              	});
          	$("input[name=exchange]:checked").each(function() {
              	if(eSize == ""){
              		eSize = $(this).val();
    	          	} else {
    	          		eSize = eSize + "," + $(this).val();
    	          	}
              	});
          	
          	 if($('input[name=fileNameI]')[0].files[0] != null){
                 $.each($('input[name=fileNameI')[0].files, function(i, file) {          
                      data.append('fileNameI['+i+']', file);
                   });	
              }//추가되는 이미지 첨부파일
          
       		var inputDate= $("input[name=inputDate]").val().split('-').join("");
       	//	var inputTime= $("input[name=inputTime]").val().split(':').join("");
              
          	data.append("memberSq",$("input[name=memberSq]").val());
          	data.append("auctionProductName",$("input[name=auctionProductName]").val());
       		data.append("detail",$("textarea[name=detail]").val());
       		data.append("endDate",inputDate+"000000");
       		
       		var minNumber = $("input[name=priceMin]").val();
       		var maxNumber = $("input[name=priceMax]").val();
       		var minPrice= minNumber.split(',').join("");
       		var maxPrice= maxNumber.split(',').join("");
       		
          	data.append("priceMin",minPrice);
          	data.append("priceMax",maxPrice);
          	if(pSize != "") {
	          	data.append("productCategorySq",pSize);
          	}
          	if(bSize != "") {
	          	data.append("bargin",bSize);
          	}
          	if(sSize != "") {
	          	data .append("shipping",sSize);
          	}
          	if(eSize != "") {
	          	data.append("exchange",eSize);
          	}          	
          	data.append("tag",$("input[name=tag]").val());
        	 
        var request = $.ajax({
			url:"${pageContext.request.contextPath}/member/auctionAdd",
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
                        <h4>경매상품등록</h4>
                        <div class="bt-option">
                            <a href="${pageContext.request.contextPath}/index/"><i class="fa fa-home"></i> Home</a>
                            <span>경매상품등록</span>
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
                        <form action="${pageContext.request.contextPath}/member/productAdd" method="post">
                       		<input type="hidden" name="memberSq" value ="${member.memberSq}">
                            <div class="pf-feature-image">
                                <h4>상품 이미지</h4>
                                <div class="feature-image-content"></div>
                            </div>
                            <div class="pf-title">
                                <h4>상품 이름</h4>
                                <input type="text" name="auctionProductName" placeholder="상품이름을 적어주세요">
                            </div>
                            <div class="pf-feature">
                                <h4>카테고리</h4>
                                <div class="features-list">
                                    <div class="feature-item">
                                        <label for="fashion">수집품/예술품
                                            <input type="checkbox" name ="productCategory" value="11" id="fashion">
                                            <span class="checkbox"></span>
                                        </label>
                                        <label for="beauty">전자제품
                                            <input type="checkbox" name ="productCategory" value="12" id="beauty">
                                            <span class="checkbox"></span>
                                        </label>
                                        <label for="baby">패션
                                            <input type="checkbox" name ="productCategory" value="13" id="baby">
                                            <span class="checkbox"></span>
                                        </label>
                                    </div>
                                    <div class="feature-item">
                                        <label for="hobby">악기/장비
                                            <input type="checkbox" name ="productCategory" value="14" id="hobby">
                                            <span class="checkbox"></span>
                                        </label>
                                        <label for="digital">자동차 부품 및 악세사리
                                            <input type="checkbox" name ="productCategory" value="15" id="digital">
                                            <span class="checkbox"></span>
                                        </label>
                                        <label for="computer">스포츠 용품
                                            <input type="checkbox" name ="productCategory" value="16" id="computer">
                                            <span class="checkbox"></span>
                                        </label>
                                    </div>
                                    <div class="feature-item">
                                        <label for="sports">가구
                                            <input type="checkbox" name ="productCategory" value="18" id="sports">
                                            <span class="checkbox"></span>
                                        </label>
                                        <label for="books">책 영화 및 음악
                                            <input type="checkbox" name ="productCategory" value="19" id="books">
                                            <span class="checkbox"></span>
                                        </label>
                                       
                                    </div>
                                    <div class="feature-item">
                                        <label for="furniture">장난감 및 취미
                                            <input type="checkbox" name ="productCategory" value="17" id="furniture">
                                            <span class="checkbox"></span>
                                        </label>
                                        <label for="appliances">기타
                                            <input type="checkbox" name ="productCategory" value="20" id="appliances">
                                            <span class="checkbox"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                             <div class="pf-title">
                                <h4>종료시간</h4>
                                <input type="date" name="inputDate" style="width:100%;">
                            </div>
                            <div class="pf-summernote">
                                <h4>상세내용</h4>
                                <textarea class="texteditor-content" name="detail"></textarea>
                            </div>
                              <div class="pf-feature">
                                <h4>상품가격</h4>
                                <input type="text" name="priceMin" style="width: 48%;"  onkeyup="commas(this)" placeholder="시작가격">
                              	<span style="font-size: 30px; "> ~ </span>
                                <input type="text" name="priceMax"  onkeyup="commas(this)" style="width: 48%;" placeholder="최대 금액">
                            </div>
                           
                             <div class="pf-feature">
                                <h4>기타 설정</h4>
                                <div class="features-list">
                                    <div class="feature-item">
                                        <label for="shipping">착불
                                            <input type="checkbox" name="shipping" value="1" id="shipping">
                                            <span class="checkbox"></span>
                                        </label>
                                    </div>
                                    <div class="feature-item">
                                        <label for="exchange">교환 가능 여부
                                            <input type="checkbox" name="exchange" value="1" id="exchange">
                                            <span class="checkbox"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                           
                            <div class="pf-title">
                                <h4>태그</h4>
                                <input type="text" name="tag" placeholder=",로 구분 ">
                            </div>
                            <div class="pf-property-details">
                               <button  onclick="submit_it()" type="button" class="site-btn">상품 등록하기</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
  
	<jsp:include page="../common/footer.jsp" />
</body>


<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="${pageContext.request.contextPath}/resources/member/js/address.js"></script>
</html>