<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title> AdminLTE 3 | Registration Page</title>

<style>
	.register-card-body  {
		 padding: 30px 100px;
   		 border-radius: 100px;	
	}
	
	.register-box {
		width: 600px;
	}
	
	.imgEditBtn {
		text-align: center;
		margin-bottom: 20px;
	}

	.register-logo {
		margin-top: 100px;
	}

</style>



<script type="text/javascript">
	
	$(function(){
		const emailRegExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		const telRegExp = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/;

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
    <a href="${cPath }"><b>PAZ   </b>Register</a>
  </div>
  
  <div class="card" style="margin-bottom: 50px;">
    <div class="card-body register-card-body">
      <p class="login-box-msg">Register a new membership</p>
		 <div style="width:100%; margin-bottom: 20px;" class="text-center d-flex align-items-center justify-content-center">
           <img id="preview-image" class="profile-user-img img-fluid img-circle" 
           		src="${userInfo.memIkon.realName }"
           		onerror="this.src='${cPath }/resources/file/profileImage/profile.jpg'" style="width:100px">
<%--            <img class="img-circle img-bordered-sm" src="${cPath }/resources/file/proflie.jpg" alt="User Image"> --%>
<%--            <img src="${cPath }/resources/file/proflie.jpg" class="img-circle elevation-2" alt="User Image"> --%>
          </div>
		
		<div class="imgEditBtn">
			<button type="button" id="profileChange" class="btn btn-default">사진 변경</button>
		</div>
		<div style="width: 100%;">
      <form:form commandName="member" action="${cPath }/login/kakaoJoin.do" method="post" enctype="multipart/form-data">
      <input style="display: none;" type="file" id="imageFile" name="imageFile">
     
      	<input type="hidden" id="inputMemId" name="memId" value="${userInfo.memId }">
    	<input type="hidden" id="inputMemPass" name="memPass" value="${userInfo.memPass }">
        <div class="input-group mb-3">
          <input type="text" name="memNickname" class="form-control" placeholder="Nickname" 
          autocomplete='off' value="${userInfo.memNickname }">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-address-card"></span>
            </div>
          </div>
        </div>
         <!-- 닉네임 경고 메시지 -->
        <p id="memNicknameMsg" class="login-box-msg"><form:errors path="memNickname" element="span" cssClass="error" cssStyle="color: red"/></p>
         <div class="input-group mb-3">
          <input type="email" id="inputEmail" name="memMail" class="form-control" placeholder="Email" 
          autocomplete='off' value="${userInfo.memMail }">
          <div class="input-group-append">
            <div class="input-group-text">
              <span id="emailAuth" class="fas fa-envelope" style="cursor: pointer"></span>
            </div>
          </div>
<!--           <input id="emailAuth" type="button"> -->
        </div>
        <!-- 이메일 경고 메시지 -->
        <p id="mailMsg" class="login-box-msg">
        ${message } <c:remove var="message"/>
        <form:errors path="memMail" element="span" cssClass="error" cssStyle="color: red"/>
        </p>
        <div class="input-group mb-3">
          <input type="text" id="inputTel" name="memTel" class="form-control" placeholder="TelNumber" autocomplete='off'>
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-phone"></span>
            </div>
          </div>
        </div>
        <!-- 핸드폰 경고 메시지 -->
        <p id="telMsg" class="login-box-msg"><form:errors path="memTel" element="span" cssClass="error" cssStyle="color: red"/></p>
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
		
      <a href="${cPath}/login/login.do" class="text-center">로그인</a>
    </div>
    <!-- /.form-box -->
    </div>
  </div><!-- /.card -->
</div>
<!-- /.register-box -->

<script>
$(function(){
	
	$("#profileChange").on("click", function(){
		$("#imageFile").click();
	})
	
	function readImage(input) {
	    // 인풋 태그에 파일이 있는 경우
	    if(input.files && input.files[0]) {
	        // 이미지 파일인지 검사 (생략)
	        // FileReader 인스턴스 생성
	        const reader = new FileReader()
	        // 이미지가 로드가 된 경우
	        reader.onload = e => {
	            const previewImage = document.getElementById("preview-image")
	            previewImage.src = e.target.result;
	        }
	        // reader가 이미지 읽도록 하기
	        reader.readAsDataURL(input.files[0])
	    }
	}
	// input file에 change 이벤트 부여
	const inputImage = document.getElementById("imageFile")
	inputImage.addEventListener("change", e => {
	    readImage(e.target)
	})
	
})


</script>
</body>
</html>
