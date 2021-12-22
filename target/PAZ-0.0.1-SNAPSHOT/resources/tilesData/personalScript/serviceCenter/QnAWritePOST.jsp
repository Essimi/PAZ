
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- Summernote -->
<script
	src="${cPath }/resources/adminLTE3/summernote/summernote-bs4.min.js"></script>

<script> 
$(function () {
	//Add text editor
    $('#compose-textarea').summernote();
	
	console.log("${status}")
	
	var Toast = Swal.mixin({
		toast : true,
		position : 'top-end',
		showConfirmButton : false,
		timer : 3000
	});
	
	var message = "${status}";
	if (message == "FAIL") {
		toastr.error("등록에 실패하셨습니다. 다시 시도해주세요.");
	};
})

// 질문글 작성 버튼
$("#qnaInsert").on("click", function(){

	$("#insertTitle").val("환불한 금액은 언제 입금되나요?")
			
	$('#compose-textarea').summernote('editor.insertText', '급하게 쓸 곳이 있습니다');

})

// 답글 작성 버튼
$("#answerInsert").on("click", function(){

	$("#insertTitle").val("3주 이내에 입금됩니다.")
			
	$('#compose-textarea').summernote('editor.insertText', '카드사의 승인에 따라 시간이 달라질 수 있습니다.');

})
</script>
