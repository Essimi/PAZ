<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 삭제 확인 버튼 (비동기) -->
<script>
	$("#realDelBtn").on("click", function() {

		$.ajax({
			url : "${cPath }/project/qnaDelete.do",
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