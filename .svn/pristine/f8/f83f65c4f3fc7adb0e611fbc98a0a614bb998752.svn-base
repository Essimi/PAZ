<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- DataTables  & Plugins -->
<script src="${cPath }/resources/adminLTE3/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${cPath }/resources/adminLTE3/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="${cPath }/resources/adminLTE3/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="${cPath }/resources/adminLTE3/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<script src="${cPath }/resources/adminLTE3/plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
<script src="${cPath }/resources/adminLTE3/plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
<script src="${cPath }/resources/adminLTE3/plugins/jszip/jszip.min.js"></script>
<script src="${cPath }/resources/adminLTE3/plugins/pdfmake/pdfmake.min.js"></script>
<script src="${cPath }/resources/adminLTE3/plugins/pdfmake/vfs_fonts.js"></script>
<script src="${cPath }/resources/adminLTE3/plugins/datatables-buttons/js/buttons.html5.min.js"></script>
<script src="${cPath }/resources/adminLTE3/plugins/datatables-buttons/js/buttons.print.min.js"></script>
<script src="${cPath }/resources/adminLTE3/plugins/datatables-buttons/js/buttons.colVis.min.js"></script>


<script>
let gitUserId = document.getElementById("gitID").value
let gitUserRepo = document.getElementById("gitREPO").value
	
//깃허브 정보 연결
$("#gitInfoSaveBtn").on("click", function() {	
	
	let gitId = document.getElementById('inputGitId').value;
	let gitRepo = document.getElementById('inputGitRepo').value;
	
	 $.ajax({
		url : "${cPath}/project/${project.pCode}/gitHub/gitRepoSave.do",
		method : 'POST',
		data : {
			"gitId" : gitId,
			"gitRepo" : gitRepo
		},
		success : function(message) {

			// POST 데이터 제외한 페이지 새로고침
			location.replace(location.href);			
		},
		error : function(xhr, jQuery, error) {
			console.log(jQuery);
			console.log(error);
		}
	}) 
})

// 깃허브 연결 해제
$("#gitInfoDeleteBtn").on("click", function() {	
	
	 $.ajax({
		url : "${cPath}/project/${project.pCode}/gitHub/gitRepoDelete.do",
		success : function(message) {
			alert(message);
			// POST 데이터 제외한 페이지 새로고침
			location.replace(location.href);			
		},
		error : function(xhr, jQuery, error) {
			console.log(jQuery);
			console.log(error);
		}
	}) 
})

//깃 아이디 체크
const gitCheckId = function(){

	let gitId = document.getElementById('inputGitId').value;
		
	 // 아이콘 설정
    let icon = $('.form-group-id').find('i');
	icon.removeClass();
	
	let idCheck = gitUserInfo(gitId);
	
	if(idCheck){
		icon.addClass('far fa-check-circle');
	}else{
		icon.addClass('far fa-times-circle');
	} 
}

//깃 아이디 체크 (API)
const gitUserInfo = function(idInfo){

	let idCheck = null;
	
	$.ajax({
		url : 'https://api.github.com/users/' + idInfo,
		dataType : 'json',
		method : 'GET',
		// 토큰값 불필요
		beforeSend : function(xhr){
			xhr.setRequestHeader("Authorization", "token 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")	
		},
		success : function(resp){
			idCheck = resp;
		},
		error : function(xhr, error, msg){
		
		},
		async: false
	});
	
	return idCheck; 
}

// 깃 레파지토리 체크
const gitCheckRepo = function(){

	let gitId = document.getElementById('inputGitId').value;
	let gitRepo = document.getElementById('inputGitRepo').value;
		
	 // 아이콘 설정
    let icon = $('.form-group-repo').find('i');
	icon.removeClass();
	
    // 미리 입력받은 아이디와 레파지토리를 동시 입력
	let repoCheck = gitUserRepository(gitId, gitRepo);
	
	if(repoCheck){
		icon.addClass('far fa-check-circle');
		// 아이디와 레파지토리가 둘 다 인증된다면
		// 저장 버튼을 활성화 합니다.
		document.getElementById('gitInfoSaveBtn').removeAttribute('disabled');
	}else{
		icon.addClass('far fa-times-circle');
	} 
}

//깃 레파지토리 체크 (API)
const gitUserRepository = function(idInfo, repoInfo){

	let repoCheck = null;
	
	$.ajax({
		url : 'https://api.github.com/repos/' +idInfo + '/' + repoInfo,
		dataType : 'json',
		method : 'get',
		// 토큰값 불필요
		beforeSend : function(xhr){
			xhr.setRequestHeader("Authorization", "token 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")	
		},  
		success : function(resp){
			repoCheck = resp;
		},
		error : function(xhr, error, msg){
		
		},
		async: false
	});
	
	return repoCheck; 
}

// 깃 커밋 내역 불러오기
$.ajax({
	url : "https://api.github.com/repos/" + gitUserId + "/" + gitUserRepo + "/commits",
	dataType : "json", //JSON데이터 불러옴
	method : "GET", 
	success : function(resp) {
				
		$("#commitList").empty();
				
		let array = resp;
		let max = array.length; // 각 commit 당 count 처리하기 위해서 length 값 구함	
				
		for (let i = 0; i < array.length; i++) { // 길이값 만큼 반복문 진입
			$("#commitList").append(
				"<tr>"
				+ "<th>" + max + "</th>"
				+ "<th>" + array[i].commit.author.name + "</th>"
				+ "<th>" + array[i].commit.author.email + "</th>"
				+ "<th>" + array[i].commit.message + "</th>"
				+ "<th>" + array[i].commit.author.date.substr(0 , 10) + "</th>"
				+ "</tr>");
				max = max-1;
		}
	},
	error : function(xhr, error, msg) {
		$('#commitList').append("<tr><td style = 'text-align:center' colspan = '5'>커밋 내역이 없습니다.</td></tr>")
	}
});

//깃 언어 내역 불러오기
$.ajax({
	url : "https://api.github.com/repos/" + gitUserId + "/" + gitUserRepo + "/languages",
	dataType : "json", //JSON데이터 불러옴
	method : "GET", 
	success : function(resp) {
		
		let language = Object.keys(resp); // 언어들 

		// 3번째 코드까지만 출력함
		for (let i = 0; i < 3; i++) { 
			$("#languageCode").append(
				"<tr>"
				+ "<th>" + language[i] + "</th>"
				+ "<td>" + resp[language[i]] + "</td>"
				+ "</tr>");
		} 		
		
	    // 언어 리스트가 4 보다 클 경우 총합하여 보여줌
		if(language.length > 4){
			
			var anotherCode = 0;
			
			for(let k = 4; k < language.length; k++){
				
				anotherCode += parseInt(resp[language[k]]);
			}
			
			$("#languageCode").append(
					"<tr>"
					+ "<th>Another Code</th>"
					+ "<td>" + anotherCode + "</td>"
					+ "</tr>");
		}
	},
	error : function(xhr, error, msg) {
	}
});

// 파일 저장 관련 스크립트
$(function() {
	$("#example1").DataTable({
		"lengthChange" : false,
		"searching" : false,
		"info" : false,
		"ordering" : false,
		"paging" : false,
		"buttons" : [ "copy", "csv", "excel", "pdf", "print" ]
	}).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
}); 
</script>