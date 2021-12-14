
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
</script>
