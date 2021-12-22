<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 삭제 확인 버튼 (비동기) -->
<script>

$(function () {
	
	var message = ("${status}");
		
	var Toast = Swal.mixin({
		toast : true,
		position : 'top-end',
		showConfirmButton : false,
		timer : 3000
	});
	
	if (message == "FAIL") {
		toastr.error("등록에 실패하셨습니다. 다시 시도해주세요.");
	}else if(message == "INSERT"){
		toastr.success("등록에 성공하였습니다.")
	}
})
	$("#realDelBtn").on("click", function() {

		$.ajax({
			url : "${cPath }/qna/qnaDelete.do",
			data : {
				"QnANo" : '${qna.qandaCode}'
			},
			success : function(resp) {
				alert("질문이 삭제되었습니다.");
				location.href = "qnaUserList.do";

			},
			error : function(xhr, jQuery, error) {
				console.log(jQuery);
				console.log(error);
			}
		})
	}
)
</script>