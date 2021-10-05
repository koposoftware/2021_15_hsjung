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
  
  
    <!--     Fonts and icons     -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
  <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
  <!-- Nucleo Icons -->
  <link href="${pageContext.request.contextPath}/resources/argon/assets/css/nucleo-icons.css" rel="stylesheet" />
  <link href="${pageContext.request.contextPath}/resources/argon/assets/css/nucleo-svg.css" rel="stylesheet" />
  <!-- Font Awesome Icons -->
  <link href="${pageContext.request.contextPath}/resources/argon/assets/css/font-awesome.css" rel="stylesheet" />
  <link href="${pageContext.request.contextPath}/resources/argon/assets/css/nucleo-svg.css" rel="stylesheet" />
  <!-- CSS Files -->
  <link href="${pageContext.request.contextPath}/resources/argon/assets/css/argon-design-system.css?v=1.2.2" rel="stylesheet" />
  
   <style type="text/css">
        * {
        margin: 0px;
        padding: 0px;
        }
        .login {
        background: linear-gradient(to bottom, #00C89E 0%, #fff 100%);
        height: 70%;
        width: 100%;
        justify-content: center;
        align-items: center;
        display: flex;
        }
        .account-login {
        width: 500px;
        }
        .form-control:focus {
        box-shadow: none;z
        }
        p a {
        padding-left: 2px;
        }
        .account-login h1 {
        font-size: 25px;
        text-align: left;
        color: #fff;
        text-transform: uppercase;
        font-weight: bold;
        border-radius: 5px;
        }
        .login-form input {
        width: 100%;
        position: relative;
        border-bottom: 1px solid #a39e9e;
        padding: 0;
        border-top: 0px;
        border-left: 0px;
        border-right: 0px;
        box-shadow: none;
        height: 63px;
        border-radius: 0px;
        }
        .login-form {
        background: #fff;
        float: left;
        width: 100%;
        padding: 40px;
        border-radius: 5px;
        }
        button.btn {
        width: 100%;
        background: #00C89E;
        font-size: 20px;
        padding: 11px;
        color: #fff;
        border: 0px;
        margin: 10px 0px 20px;
        }
        .btn:hover{
            color: #fff;
            opacity: 0.8;
        }
        p {
        float: left;
        width: 100%;
        text-align: center;
        font-size: 14px;
        }
        .remember {
        float: left;
        width: 100%;
        margin: 10px 0 0;
        }
        /* Customize the label (the container) */
        .custom-checkbox {
        display: block;
        position: relative;
        padding-left: 27px;
        margin-bottom: 12px;
        cursor: pointer;
        font-size: 13px;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
        font-weight: normal;
        padding-top: 2px;
        float: left;
        }
        /* Hide the browser's default checkbox */
        .custom-checkbox input {
        position: absolute;
        opacity: 0;
        cursor: pointer;
        height: 0;
        width: 0;
        }
        /* Create a custom checkbox */
        .custom-checkbox .checkmark {
        position: absolute;
        top: 0;
        left: 0;
        height: 20px;
        width: 20px;
        background-color: #bfbcbc;
        }
        /* On mouse-over, add a grey background color */
        .custom-checkbox:hover input ~ .checkmark {
        background-color: #747474;
        }
        /* When the checkbox is checked, add a blue background */
        .custom-checkbox input:checked ~ .checkmark {
        background-color: #2196F3;
        }
        /* Create the checkmark/indicator (hidden when not checked) */
        .checkmark:after {
        content: "";
        position: absolute;
        display: none;
        }
        /* Show the checkmark when checked */
        .custom-checkbox input:checked ~ .checkmark:after {
        display: block;
        }
        a:hover{

        }
        /* Style the checkmark/indicator */
        .custom-checkbox .checkmark:after {
        left: 9px;
        top: 5px;
        width: 5px;
        height: 10px;
        border: solid white;
        border-width: 0 3px 3px 0;
        -webkit-transform: rotate(45deg);
        -ms-transform: rotate(45deg);
        transform: rotate(45deg);
        }
        @media (max-width: 767px){
        .account-login {
            width: 90%;
          }
        }
        </style>
        <script>
	
	if('${msg}')
		alert('${msg}')

	function checkForm(){
		let f = document.loginForm
		
		if(isNull(f.id,'아이디를입력하세요')){
			return false
		}
		if(isNull(f.password,'비밀번호를입력하세요')){
			return false
		}
		
		return true
	}
	
</script>
</head>

<body>
	 <jsp:include page="../common/header.jsp" />
  <div class="login">
    <div class="account-login">
       <h1>하나 Market LOGIN</h1>
			
       <form method="post" name="loginForm" <%-- DB접근을 할경우 .do로 설정 --%>
			 class="login-form" onsubmit="return checkForm()">
          <div class="form-group">
             <input type="text" name="id" placeholder="사용자 아이디" class="form-control">
          </div>
          <div class="form-group">
             <input type="password" name="pwd" placeholder="사용자 비밀번호"  class="form-control">
          </div>
          <div class="remember">
             <label class="custom-checkbox">비밀번호 기억하기
             <input type="checkbox">
             <span class="checkmark"></span>
             </label>
             <a href="#" class="pull-right">비밀번호를 분실하셨나요?</a>
          </div>
          <button class="btn">Login</button>
          <p>회원이 아니신가요?<a href="#">회원가입</a></p>
       </form>
    </div>
</div>

<%--     
   <section class="section section-shaped section-lg">
    <div class="shape shape-style-1 bg-gradient-default">
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      <span></span>
    </div>
    <div class="container pt-lg-7">
      <div class="row justify-content-center">
        <div class="col-lg-5">
          <div class="card bg-secondary shadow border-0">
            <div class="card-header bg-white pb-5">
              <div class="text-muted text-center mb-3"><small>Sign in with</small></div>
              <div class="btn-wrapper text-center">
                <a href="#" class="btn btn-neutral btn-icon">
                  <span class="btn-inner--icon"><img src="${pageContext.request.contextPath}/resources/argon/assets/img/icons/common/github.svg"></span>
                  <span class="btn-inner--text">Github</span>
                </a>
                <a href="#" class="btn btn-neutral btn-icon">
                  <span class="btn-inner--icon"><img src="${pageContext.request.contextPath}/resources/argon/assets/img/icons/common/google.svg"></span>
                  <span class="btn-inner--text">Google</span>
                </a>
              </div>
            </div>
            <div class="card-body px-lg-5 py-lg-5">
              <div class="text-center text-muted mb-4">
                <small>Or sign in with credentials</small>
              </div>
              <form role="form" method="post" name="loginForm" DB접근을 할경우 .do로 설정
			 class="login-form" onsubmit="return checkForm()">
                <div class="form-group mb-3">
                  <div class="input-group input-group-alternative">
                    <div class="input-group-prepend">
                      <span class="input-group-text"><i class="ni ni-email-83"></i></span>
                    </div>
                    <input class="form-control"  name="id" placeholder="id" type="id">
                  </div>
                </div>
                <div class="form-group focused">
                  <div class="input-group input-group-alternative">
                    <div class="input-group-prepend">
                      <span class="input-group-text"><i class="ni ni-lock-circle-open"></i></span>
                    </div>
                    <input class="form-control" name="pwd" placeholder="사용자 비밀번호" type="password">
                  </div>
                </div>
                <div class="custom-control custom-control-alternative custom-checkbox">
                  <input class="custom-control-input" id=" customCheckLogin" type="checkbox">
                  <label class="custom-control-label" for=" customCheckLogin"><span>Remember me</span></label>
                </div>
                <div class="text-center">
                  <button type="button" class="btn btn-primary my-4">Sign in</button>
                </div>
              </form>
            </div>
          </div>
          <div class="row mt-3">
            <div class="col-6">
              <a href="#" class="text-light"><small>Forgot password?</small></a>
            </div>
            <div class="col-6 text-right">
              <a href="#" class="text-light"><small>Create new account</small></a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section> --%>
  
	<jsp:include page="../common/footer.jsp" />
</body>


  <script src="${pageContext.request.contextPath}/resources/argon/assets/js/core/popper.min.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/resources/argon/assets/js/core/bootstrap.min.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/resources/argon/assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
  <!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
  <script src="${pageContext.request.contextPath}/resources/argon/assets/js/plugins/bootstrap-switch.js"></script>
  <!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
  <script src="${pageContext.request.contextPath}/resources/argon/assets/js/plugins/nouislider.min.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/resources/argon/assets/js/plugins/moment.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/argon/assets/js/plugins/datetimepicker.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/resources/argon/assets/js/plugins/bootstrap-datepicker.min.js"></script>
  <!-- Control Center for Argon UI Kit: parallax effects, scripts for the example pages etc -->
  <!--  Google Maps Plugin    -->
  <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
  <script src="${pageContext.request.contextPath}/resources/argon/assets/js/argon-design-system.min.js?v=1.2.2" type="text/javascript"></script>
  <script src="https://cdn.trackjs.com/agent/v3/latest/t.js"></script>
  <script>
    window.TrackJS &&
      TrackJS.install({
        token: "ee6fab19c5a04ac1a32a645abde4613a",
        application: "argon-design-system-pro"
      });
  </script>
  
</html>