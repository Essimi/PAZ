<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script>
$(function(){
	
	const passRegExp = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,16}/
	const emailRegExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	const telRegExp = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/;
	
	var modifyFlag = true;
	
	// 비밀번호 정규식 체크
	var inputPass = $("#inputMemPass").on("keyup", function(){
		var passMsg = $("#passMsg");
		
		
		if(passRegExp.test(inputPass.val())){
			inputPass.removeClass("is-invalid");
			inputPass.addClass("is-valid");
			passMsg.empty();
			modifyFlag = true;
		}else{
			passMsg.empty();
			passMsg.append($("<p>").text("※8 ~ 16자 영문 대 소문자, 숫자, 특수문자를 사용 가능").css("color", "red"));
			inputPass.removeClass("is-valid");
			inputPass.addClass("is-invalid");
			modifyFlag = false;
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
				retypePassMsg.empty();
				retypePassMsg.append($("<p>").text("※비밀번호가 일치하지 않습니다.").css("color", "red"));
				retypePass.removeClass("is-valid");
				retypePass.addClass("is-invalid");
				modifyFlag = false;
			}
		}else{
			retypePassMsg.empty();
			retypePassMsg.append($("<p>").text("※필수 정보입니다.").css("color", "red"));
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
				mailMsg.empty();
				mailMsg.append($("<p>").text("이메일주소를 다시 확인해주세요.").css("color", "red"));
				inputEmail.removeClass("is-valid");
				inputEmail.addClass("is-invalid");
			}
		}else{
			mailMsg.empty();
			mailMsg.append($("<p>").text("필수 정보입니다.").css("color", "red"));
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
				telMsg.empty();
				telMsg.append($("<p>").text("ex) 010-111-1111 형식으로 입력").css("color", "red"));
				inputTel.removeClass("is-valid");
				inputTel.addClass("is-invalid");
			}
		}else{
			telMsg.empty();
			telMsg.append($("<p>").text("필수 정보입니다.").css("color", "red"));
		}
	});
	
	var Toast = Swal.mixin({
		toast : true,
		position : 'top-end',
		showConfirmButton : false,
		timer : 3000
	});

	$("form").submit(function(){
		if(!modifyFlag){
			toastr.error("형식에 맞게 입력해주세요.");
			return false;
		}
	})
	
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
	            previewImage.src = e.target.result
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