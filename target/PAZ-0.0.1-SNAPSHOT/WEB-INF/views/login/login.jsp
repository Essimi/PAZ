<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>

	.login-card-body {
		 padding: 50px 100px;
   		 border-radius: 100px;	
	}
	
	.login-box, .register-box {
		width: 600px;
	}

</style>


<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <a href="${cPath }"><b>PAZ   </b>login</a>
  </div>
  <!-- /.login-logo -->
  <div class="card">
    <div class="card-body login-card-body">
      <p class="login-box-msg">Sign in to start your session</p>

      <form action="${cPath }/login/loginProcess.do" method="post">
        <div class="input-group mb-3">
          <input type="text" id = "idBox" name="memId" class="form-control" placeholder="Id">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-user"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input type="password" id = "passBox" name="memPass" class="form-control" placeholder="Password">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-8">
            <div class="icheck-primary">
              <input type="checkbox" name="remember-Me" id="remember">
              <label for="remember">
               	자동로그인
              </label>
            </div>
          </div>
          <!-- /.col -->
          <div class="col-4">
            <button type="submit" class="btn btn-primary btn-block">Login</button>
          </div>
          <!-- /.col -->
        </div>
      </form>
	           
	    <font color="red">
            ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
			<!-- 회원가입 서버오류로 실패시 메세지-->
            ${message }
             <!-- LoginFailureHandler 오류 메세지 -->
            ${sessionScope["errorMsg"]}
	        <c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
	        <c:remove var="errorMsg" scope="session"/>
	    </font>

      <div class="social-auth-links text-center mb-3">
        <p>- OR -</p>
        <a href="javascript:void(0)" class="btn btn-block btn-warning" id="kakaoLogin">
          <i class="fas fa-comments"></i> 카카오톡으로 로그인
        </a>
        
      </div>
      
      <!-- /.social-auth-links -->

      <p class="mb-1">
        <a href="${cPath }/login/find/pass.do">비밀번호 찾기</a>
      </p>
      <p class="mb-0">
        <a href="${cPath }/login/join.do" class="text-center">회원가입</a>
      </p>
      
      
    </div>
    <!-- /.login-card-body -->
   
  </div>
   <button class = "btn btn-info" id = "PLLogin" value = "PE">PL</button>
   <button class = "btn btn-info" id = "PELogin" value = "PL">PE</button>
   <button class = "btn btn-info" id = "adminLogin" value = "admin">ADMIN</button>
</div>
<!-- /.login-box -->

<!-- 카카오 스크립트 -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
Kakao.init('5b19c6ec8a98478119e4e1697a8f9b59'); //발급받은 키 중 javascript키를 사용해준다.
console.log("sdk초기화여부 : " + Kakao.isInitialized()); // sdk초기화여부판단

$("#kakaoLogin").on("click", function(){
	location.href="${cPath}/login/requestKakaoAuth.do"
})


// PL 로그인 버튼입니다.
$('#PLLogin').on('click', function(){
	
	$('#idBox').val("aa002")
	$('#passBox').val("java")
})

// PE 로그인 버튼입니다.
$('#PELogin').on('click', function(){
	
	$('#idBox').val("aa004")
	$('#passBox').val("java")
})

// admin 로그인 버튼입니다.
$('#adminLogin').on('click', function(){
	
	$('#idBox').val("admin")
	$('#passBox').val("admin")
})


</script>

</body>
