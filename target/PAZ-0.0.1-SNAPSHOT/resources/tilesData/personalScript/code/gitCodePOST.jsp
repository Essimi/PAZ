<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!-- CodeMirror -->
<script src="${cPath }/resources/adminLTE3/plugins/codemirror/codemirror.js"></script>
<script src="${cPath }/resources/adminLTE3/plugins/codemirror/mode/css/css.js"></script>
<script src="${cPath }/resources/adminLTE3/plugins/codemirror/mode/xml/xml.js"></script>
<script src="${cPath }/resources/adminLTE3/plugins/codemirror/mode/htmlmixed/htmlmixed.js"></script>

<!-- PRE 에 CSS 파일 등록시 적용이 안 됩니다.. -->
<!-- 임시로 현 POST 에 경로를 등록했습니다. -->
<link rel="stylesheet" href="${cPath }/resources/css/code/gitCode.css">


<script>
$(function() {
	// CodeMirror
	CodeMirror.fromTextArea(document.getElementById("codeMirrorDemo"), {
		mode : "htmlmixed",
		theme : "monokai"
	});
})

$('#saveTest').on('click', function(){
	
	if(confirm("정말 저장하시겠습니까?") == true){
		
		// 현재 CodeMirror 의 상세값을 불러옵니다.
		let editor = document.querySelector('.CodeMirror').CodeMirror; 
		
		// 상세값들 중 innerText 만 추출합니다.
		let contentArea = editor.display.wrapper.innerText;
					
		// base64 인코더를 사용하기 위해 Controller 로 전송합니다.
		$('#codeText').val(contentArea);
		$('#inputCommitMessageForm').val($('#inputCommitMessage').val());
		$('#gitCodeConversion').get(0).submit(); 
		
	}else{
		return false;
	}	
})
</script>