<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>

$('#editIssue').on('click', function() {
	location.href = "${cPath}/project/${project.pCode}/issue/issueModify.do?issueCode=" + "${issue.issueCode}";
})

$("#realDelBtn").on("click", function(){
	location.href = "${cPath}/project/${project.pCode}/issue/issueDelete.do?issueCode=" + "${issue.issueCode}";
})

</script>