<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Registration Page</title>

<script type="text/javascript">
	
	function inputIdCheck(){
		$("input[name='idDuplication']").val("UNCHECK");
	}
	
	$(function(){
		const idRegExp = /^[a-z]{1}[a-z0-9_-]{4,20}$/
		const passRegExp = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,16}/
		const emailRegExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		const telRegExp = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/;

		var idDuplication = $("input[name='idDuplication']");
		var idMsg = $("#idMsg");
		
		// 아이디 정규식 체크
		var inputIdTag = $("#inputMemId").on("keyup", function(){
			var inputId = inputIdTag.val();
			
			if(idRegExp.test(inputId)){
					$.ajax({
						url : "${cPath}/login/idCheck.do",
						data : {memId : inputId},
						method : "post",
						dataType : "json",
						success : function(resp) {
							idMsg.text(resp.message).css("color", resp.color);
							if(resp.status == "OK"){
								idDuplication.val("CHECK");
								inputIdTag.removeClass("is-invalid");
								inputIdTag.addClass("is-valid");
							}else{
								idDuplication.val("UNCHECK");
								inputIdTag.removeClass("is-valid");
								inputIdTag.addClass("is-invalid");
							}
							
						},
						error : function(xhr, errorResp, error) {
							console.log(xhr);
							console.log(errorResp);
							console.log(error);
						}
					})
			}else{
				idMsg.text("5 ~ 20 자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능").css("color", "red");
				inputIdTag.removeClass("is-valid");
				inputIdTag.addClass("is-invalid");
			}
		});
		
		// 비밀번호 정규식 체크
		var inputPass = $("#inputMemPass").on("keyup", function(){
			var passMsg = $("#passMsg");
			
			if(passRegExp.test(inputPass.val())){
				inputPass.removeClass("is-invalid");
				inputPass.addClass("is-valid");
				passMsg.empty();
			}else{
				passMsg.text("8 ~ 16자 영문 대 소문자, 숫자, 특수문자를 사용 가능");
				inputPass.removeClass("is-valid");
				inputPass.addClass("is-invalid");
			}
		});
		
		// 비밀번호 재확인 체크
		var retypePass = $("#inputRetypePass").focusout(function(){
			var retypePassMsg = $("#passRetypeMsg");
			
			if(retypePass.val() != ""){
				if(inputPass.val() == retypePass.val()){
					retypePass.removeClass("is-invalid");
					retypePass.addClass("is-valid");
					retypePassMsg.empty();
				}else{
					retypePassMsg.text("비밀번호가 일치하지 않습니다.").css("color", "red");
					retypePass.removeClass("is-valid");
					retypePass.addClass("is-invalid");
				}
			}else{
				retypePassMsg.text("필수 정보입니다.").css("color", "red");
			}
		});
		
		// 메일 정규식 체크
		var inputEmail = $("#inputEmail").focusout(function(){
			var mailMsg = $("#mailMsg");
			
			if(inputEmail.val() != ""){
				if(emailRegExp.test(inputEmail.val())){
					inputEmail.removeClass("is-invalid");
					inputEmail.addClass("is-valid");
					mailMsg.empty();
				}else{
					mailMsg.text("이메일주소를 다시 확인해주세요.").css("color", "red");
					inputEmail.removeClass("is-valid");
					inputEmail.addClass("is-invalid");
				}
			}else{
				mailMsg.text("필수 정보입니다.").css("color", "red");
			}
		});
		
		// 메일 인증
		$("#emailAuth").on("click", function(){
			var mailAddress = $("#inputEmail").val();
			var mailMsg = $("#mailMsg");
			
			// 메일입력창이 입력이 되어있고 에러메시지 창에 아무것도 없을 경우 이메일전송
			if(mailAddress != "" && mailMsg.text() == ""){
				$.ajax({
					url : "${cPath}/login/emailCheck",
					data : {memMail : mailAddress},
					method : "post",
					success : function(resp) {
						if(resp == "OK"){
							mailMsg.text("입력한 이메일에서 인증해주세요").css("color", "green");
						}else{
							mailMsg.text("이미 등록된 이메일입니다.").css("color", "red");
						}
					},
					error : function(xhr, errorResp, error) {
						console.log(xhr);
						console.log(errorResp);
						console.log(error);
					}
				})
			}else{
				mailMsg.text("이메일 주소를 확인해주세요.").css("color", "red");
			}
			
		})
		
		// 핸드폰번호 정규식 체크
		var inputTel = $("#inputTel").focusout(function(){
			var telMsg = $("#telMsg");
			
			if(inputTel.val() != ""){
				if(telRegExp.test(inputTel.val())){
					inputTel.removeClass("is-invalid");
					inputTel.addClass("is-valid");
					telMsg.empty();
				}else{
					telMsg.text("ex) 010-111-1111 형식으로 입력").css("color", "red");
					inputTel.removeClass("is-valid");
					inputTel.addClass("is-invalid");
				}
			}else{
				telMsg.text("필수 정보입니다.").css("color", "red");
			}
		});
		
		$(".btn-group").on("click", function(){
			var gender = $("input[name=memGender]:checked").val();
			console.log("성별 : " + gender);
		})
		
	})
	
</script>
</head>
<body class="hold-transition register-page">
<div class="register-box">
  <div class="register-logo">
    <a href="../../index2.html"><b></b>회원가입</a>
  </div>
  
  <div class="card">
    <div class="card-body register-card-body">
      <p class="login-box-msg">Register a new membership</p>

<!-- class="form-control is-valid" -->
<!-- class="form-control is-invalid" -->
      <form:form commandName="member" action="${cPath }/login/join.do" method="post">
        <div class="input-group mb-3">
          <input type="text" id="inputMemId" name="memId" class="form-control" placeholder="Id" 
          autocomplete="off" onkeydown="inputIdCheck()">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-user"></span>
            </div>
          </div>
        </div>
        <!-- 아이디가 중복체크 되었는지 확인 -->
        <input type="hidden" name="idDuplication" value="UNCHECK">
        <!-- 아이디 경고 메시지 -->
        <p id="idMsg" class="login-box-msg"><form:errors path="memId" element="span" cssClass="error" /></p>
        <div class="input-group mb-3">
          <input type="password" id="inputMemPass" name="memPass" class="form-control" placeholder="Password">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        <!-- 비밀번호 경고 메시지 -->
        <p id="passMsg" class="login-box-msg"><form:errors path="memPass" element="span" cssClass="error" /></p>
        <div class="input-group mb-3">
          <input type="password" id="inputRetypePass" class="form-control" placeholder="Retype password">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
         <!-- 비밀번호재확인 경고 메시지 -->
        <p id="passRetypeMsg" class="login-box-msg"></p>
        <div class="input-group mb-3">
          <input type="text" name="memNickname" class="form-control" placeholder="Nickname">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-address-card"></span>
            </div>
          </div>
        </div>
         <!-- 닉네임 경고 메시지 -->
        <p id="memNicknameMsg" class="login-box-msg"></p>
         <div class="input-group mb-3">
          <input type="email" id="inputEmail" name="memMail" class="form-control" placeholder="Email">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-envelope"></span>
            </div>
          </div>
          <input id="emailAuth" type="button">
        </div>
        <!-- 이메일 경고 메시지 -->
        <p id="mailMsg" class="login-box-msg">
        ${message } <c:remove var="message"/>
        <form:errors path="memMail" element="span" cssClass="error" />
        </p>
        <div class="input-group mb-3">
          <input type="text" id="inputTel" name="memTel" class="form-control" placeholder="TelNumber">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-phone"></span>
            </div>
          </div>
        </div>
        <!-- 핸드폰 경고 메시지 -->
        <p id="telMsg" class="login-box-msg"><form:errors path="memTel" element="span" cssClass="error" /></p>
        <label>생년월일</label>
        <div class="input-group mb-3">
          <input type="date" name="memBirth" class="form-control" placeholder="Date of birth">
          <div class="input-group-append">
            <div class="input-group-text">
<!--               <span class="fas fa-user"></span> -->
            </div>
          </div>
        </div>
        <label>소속</label>
        <div class="input-group mb-3">
	       <select name="memCompany" class="form-control">
	         <option>소속</option>
	         <option value="기업">기업</option>
	         <option value="기관">기관</option>
	         <option value="개인">개인</option>
	         <option value="단체">단체</option>
	         <option value="기타">기타</option>
	       </select>
        </div>
        
        <div class="btn-group btn-group-toggle" data-toggle="buttons">
           <label class="btn btn-secondary active">
             <input type="radio" name="memGender" id="option_a1" autocomplete="off" value="0"> 남자
           </label>
           <label class="btn btn-secondary">
             <input type="radio" name="memGender" id="option_a2" autocomplete="off" value="1"> 여자
           </label>
         </div>
         <br><br>
       
        
        <div class="row">
          <div class="col-8">
            <div class="icheck-primary">
              <input type="checkbox" id="agreeTerms" name="terms" value="agree">
              <label for="agreeTerms">
               I agree to the <a href="#">terms</a>
              </label>
            </div>
          </div>
          <!-- /.col -->
          <div class="col-4">
            <button type="submit" class="btn btn-primary btn-block">회원가입</button>
          </div>
          <!-- /.col -->
        </div>
      </form:form>

      <div class="social-auth-links text-center">
        <p>- OR -</p>
        <a href="#" class="btn btn-block btn-warning">
          <i class="fas fa-comments"></i>
          	카카오톡으로 회원가입
        </a>
      </div>

      <a href="${cPath}/login/login.do" class="text-center">로그인</a>
    </div>
    <!-- /.form-box -->
  </div><!-- /.card -->
</div>
<!-- /.register-box -->




</body>
</html>
