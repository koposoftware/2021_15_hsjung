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
	          		
          	$("input[name=bargin]:checked").each(function() {
              	if(bSize == ""){
              		bSize = $(this).val();
    	          	} else {
    	          		bSize = bSize + "," + $(this).val();
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
          
          	data.append("memberSq",$("input[name=memberSq]").val());
          	data.append("productName",$("input[name=name]").val());
       		data.append("description",$("textarea[name=description]").val());
        	//data.append("region", $("input[name=region]").val() + $("input[name=productRegionDetail]").val());
          	data.append("price",$("input[name=price]").val());
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
			url:"${pageContext.request.contextPath}/member/productAdd",
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
                        <h4>상품등록</h4>
                        <div class="bt-option">
                            <a href="${pageContext.request.contextPath}/index/"><i class="fa fa-home"></i> Home</a>
                            <span>상품등록</span>
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
                                <input type="text" name="name" placeholder="상품이름을 적어주세요">
                            </div>
                            <div class="pf-feature">
                                <h4>카테고리</h4>
                                <div class="features-list">
                                    <div class="feature-item">
                                        <label for="fashion">패션의류
                                            <input type="checkbox" name ="productCategory" value="1" id="fashion">
                                            <span class="checkbox"></span>
                                        </label>
                                        <label for="beauty">뷰티잡화
                                            <input type="checkbox" name ="productCategory" value="2" id="beauty">
                                            <span class="checkbox"></span>
                                        </label>
                                        <label for="baby">유아용품
                                            <input type="checkbox" name ="productCategory" value="3" id="baby">
                                            <span class="checkbox"></span>
                                        </label>
                                    </div>
                                    <div class="feature-item">
                                        <label for="hobby">취미컬렉션
                                            <input type="checkbox" name ="productCategory" value="5" id="hobby">
                                            <span class="checkbox"></span>
                                        </label>
                                        <label for="digital">디지털
                                            <input type="checkbox" name ="productCategory" value="6" id="digital">
                                            <span class="checkbox"></span>
                                        </label>
                                        <label for="computer">컴퓨터
                                            <input type="checkbox" name ="productCategory" value="7" id="computer">
                                            <span class="checkbox"></span>
                                        </label>
                                    </div>
                                    <div class="feature-item">
                                        <label for="sports">스포츠레져
                                            <input type="checkbox" name ="productCategory" value="8" id="sports">
                                            <span class="checkbox"></span>
                                        </label>
                                        <label for="books">도서
                                            <input type="checkbox" name ="productCategory" value="9" id="books">
                                            <span class="checkbox"></span>
                                        </label>
                                       
                                    </div>
                                    <div class="feature-item">
                                        <label for="furniture">가구생활
                                            <input type="checkbox" name ="productCategory" value="4" id="furniture">
                                            <span class="checkbox"></span>
                                        </label>
                                        <label for="appliances">생활가전
                                            <input type="checkbox" name ="productCategory" value="10" id="appliances">
                                            <span class="checkbox"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="pf-summernote">
                                <h4>상세내용</h4>
                                <textarea class="texteditor-content" name="description"></textarea>
                            </div>
                            <!-- <div class="pf-map">
                                <h4>거래 위치</h4>
                                <div class="row">
                                    
                                    <div class="col-lg-4">
                                        <div class="map-inputs">
							                <input type="text" onclick="sample6_execDaumPostcode()" id="sample6_address" name="region"  placeholder="주소" title="주소" class="text full" />
							                <input type="text" id="sample6_detailAddress" name="productRegionDetail" placeholder="상세주소" title="상세주소" class="text" />
                                        </div>
                                    </div>
                                    <div class="col-lg-8">
                                        <div class="g-map">
                                            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d735515.5813275519!2d-80.41163541934742!3d43.93644386501528!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x882a55bbf3de23d7%3A0x3ada5af229b47375!2sMono%2C%20ON%2C%20Canada!5e0!3m2!1sen!2sbd!4v1583262687289!5m2!1sen!2sbd" height="245" style="border:0;" allowfullscreen=""></iframe>
                                        </div>
                                    </div>
                                </div>
                            </div> -->
                              <div class="pf-title">
                                <h4>상품가격</h4>
                                <input type="text" name="price" placeholder="상품가격을 적어주세요">
                            </div>
                             <div class="pf-feature">
                                <h4>기타 설정</h4>
                                <div class="features-list">
                                    <div class="feature-item">
                                        <label for="bargin">흥정가능여부
                                            <input type="checkbox" name="bargin" value="1" id="bargin">
                                            <span class="checkbox"></span>
                                        </label>
                                    </div>
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