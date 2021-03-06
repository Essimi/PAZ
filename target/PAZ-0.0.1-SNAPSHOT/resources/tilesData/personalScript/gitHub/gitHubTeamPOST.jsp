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
$(function(){
	
	// Toast 메시지 관련 이벤트 입니다.
	var message = ("${status}");
	
	var Toast = Swal.mixin({
		toast : true,
		position : 'top-end',
		showConfirmButton : false,
		timer : 3000
	});
	
	if (message == "FAIL") {
		toastr.error("Commit을 실패하였습니다. 다시 시도해주세요.");
	}else if(message == "UPDATE"){
		toastr.success("Commit을 성공하였습니다.")
	}
	
	// 파일 선택시 실행되는 이벤트 입니다.
	$('.content-wrapper').on('click', '.fileNameArea', function(){
		
		let type = $(this).data('type');					// 선택한 요소의 type 정보를 가져옵니다.
		let path = $(this).data('path');					// 선택한 요소의 path 정보를 가져옵니다.
		let download_url = $(this).data('download_url');	// 선택한 요소의 download_url 정보를 가져옵니다.
		
		let userPath = '${git.userName}/${git.repository}'  // DB에 저장된 유저경로를 불러옵니다.
		
		let selectPath = ("https://api.github.com/repos/" + userPath + "/contents/" + path) // 선택한 파일의 경로를 가져옵니다.
		
		// 폴더라면 해당 폴더를 탐색합니다.
		if(type == 'dir'){
			loadMyRepoTree(gitRepoCommand, path);			// 선택한 요소의 path 정보를 파라메터로 넘겨 실행시킵니다.
		}else{
		// 파일이면 해당 파일을 실행합니다.
			selectFileContent(selectPath);
		}
	})
	
	$("#example1").DataTable({
		"lengthChange" : false,
		"searching" : false,
		"info" : false,
		"ordering" : false,
		"paging" : false,
		"buttons" : [ "copy", "csv", "excel",  "print" ]
	}).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
})

// 전역변수로 초기화 해줍니다.
let gitRepoCommand = null;

// 페이지가 시작하자마자 실행되는 이벤트. 저장되어있는 repo가 있나 불러옵니다.
const startGitPage = function() {
	
	$.ajax({
		url : "${cPath}/project/${project.pCode}/gitHub/gitTeam.do",
		method: 'GET',
		success: function(resp) {
			
			// 데이터베이스에 레파지토리가 없을 경우 추가해줘야함
			// 데이터베이스에 레파지토리가 없을 경우 추가해줘야함
			// 데이터베이스에 레파지토리가 없을 경우 추가해줘야함
			// 데이터베이스에 레파지토리가 없을 경우 추가해줘야함
			
			let repoData = false; // 저장소가 없을 경우를 위한 변수를 지정해줍니다.
			
			let repository = '${git.repository}'; // repository 정보를 가져옵니다.
			let username = '${git.userName}';     // username 정보를 가져옵니다.
			
			gitRepoCommand = username + "/" + repository; // name 과 repo 를 합쳐 주소를 만듭니다.
			
			let repoHeader = $('.callOutHeader').find('a');     // 해당 위치를 지정해줍니다.
			repoHeader.attr('href', 'https://gitHub.com/' + gitRepoCommand);  // 링크를 추가합니다.
			repoHeader.find('span').text(gitRepoCommand);					  // 제목을 추가합니다.
			
			myRepo(gitRepoCommand); 	// 데이터를 가지고 해당 const 로 이동합니다.
			commitList(gitRepoCommand)  // 데이터를 가지고 해당 const 로 이동합니다.
			repoDate = true;        // 넘어온 데이터가 있기 때문에 true 로 변경해줍니다.
			
		},error: function(xhr, error, msg) {
			
		}	
	})
}

//gitRepo 저장소가 있을 경우 실행됩니다.
const myRepo = function(gitRepoCommand){ 
	
	loadMyRepoTree(gitRepoCommand, null); // 받아온 파라메터를 가지고 해당 이벤트로 이동합니다.
										  // 첫 실행은 path 값이 없기 때문에, null 로 명시해줍니다.
}

// 파일 사이즈를 사이즈별로 정리합니다.
// http://daplus.net/javascript-%EB%B0%94%EC%9D%B4%ED%8A%B8-%EB%8B%A8%EC%9C%84%EC%9D%98-%ED%8C%8C%EC%9D%BC-%ED%81%AC
// %EA%B8%B0%EB%A5%BC-%EC%82%AC%EB%9E%8C%EC%9D%B4-%EC%9D%BD%EC%9D%84-%EC%88%98%EC%9E%88%EB%8A%94-%EB%AC%B8/
function fileSizeConversion(bytes, size = true, dp = 1){
	
	const thresh = size ? 1000 : 1024;

	if (Math.abs(bytes) < thresh) {
		return bytes + ' Byte';
	}

	const units = size
		? ['KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB']
		: ['KiB', 'MiB', 'GiB', 'TiB', 'PiB', 'EiB', 'ZiB', 'YiB'];
	let u = -1;
	const r = 10 ** dp;

	do {
		bytes /= thresh;
		++u;
	} while (Math.round(Math.abs(bytes) * r) / r >= thresh && u < units.length - 1);

	return bytes.toFixed(dp) + ' ' + units[u];
}
	
// 커밋 리스트를 불러옵니다.
const commitList = function(gitRepoCommand){
	
	$.ajax({
		url : "https://api.github.com/repos/" + gitRepoCommand + "/commits",
		dataType : "json", //JSON데이터 불러옴
		method : "GET", 
		beforeSend : function(xhr){ // 토큰값 명시(임시)
			xhr.setRequestHeader("Authorization", "token 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")	
		},
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
		},
		async : false
	});
}

//Tree 구조를 나타냅니다.
const loadMyRepoTree = function(gitRepoCommand, path){ 
	
	$.ajax({
		// 파일 선택 이벤트에서 현 ajax를 실행시키지 않는 경우(최초 실행)
		// 주소값의 path 는 null 값으로 들어가며, 삼항연산자 거짓으로 인해 /contents 까지만 실행됩니다.
		// 파일 선택으로 현 이벤트 실행시 선택한 fileNameArea 의 data-path 의 값을 파라메터로 가져와 추가해줍니다.
		url : 'https://api.github.com/repos/' + gitRepoCommand + '/contents' + (path ? '/' + path : ''),
		method : "GET",
		dataType : "JSON",
		beforeSend : function(xhr){ // 토큰값 명시(임시)
			xhr.setRequestHeader("Authorization", "token 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")	
		},
		success : function(resp){
			console.log(resp)
			
			let gitFileArea = $('.content-wrapper').find('.gitFileArea') // 파일 구역 설정을 위해 지정해줍니다.
			gitFileArea.empty() 							             // 초기화를 위해 비워줍니다.
			
			folders = []; // repository 요청 시 배열 형태로 넘어오기 때문에 배열을 생성합니다.(폴더)
			files = [];	  // repository 요청 시 배열 형태로 넘어오기 때문에 배열을 생성합니다.(파일)	
			
			$.each(resp, function(index, item){ 							               // 결과값을 모두 출력하기 위해 each 문을 사용합니다.
				let fileArea = $('#repoInfo').children('.fileInfo').clone(); 	           // 출력된 값을 저장하기 위해 div 영역을 설정해줍니다. (하위 영역까지 복사)
				let fileIcon = item.type == 'file' ? 'doc' : 'folder'; 				       // 응답 속성들 중 file 을 찾아 삼항연산을 실행합니다. (file 와 같으면 doc, 아니라면 folder)
				let fileSize = item.size == 0 ? '' : fileSizeConversion(item.size);        // 응답 속성들 중 size 를 찾아 삼항연산(사이즈 비교)를 실행합니다. 0 이라면 비워줍니다.
				let fileName = 	fileArea.find('.fileNameArea'); 					       // 파일 이름을 지정할 div 영역을 설정해줍니다.
				
				fileName.text(item.name);												   // 지정한 div 영역에 응답 속성들 중 name을 text 형식으로 지정합니다.
				
				if(fileIcon == 'folder'){
					fileArea.children('.fileName').children('i').addClass('gitIcon fas fa-folder'); // 상단에서 실행한 type 삼항연산의 결과값을 대입합니다.
				}else{
					fileArea.children('.fileName').children('i').addClass('gitIcon far fa-file-alt'); // 상단에서 실행한 type 삼항연산의 결과값을 대입합니다.
				}
				
				fileArea.children('.fileSize').children('.fileSizeArea').text(fileSize);   // 상단에서 실행한 size 삼항연산의 결과값을 대입합니다.
				
				fileName.addClass(item.type); 											   // 지정한 div 영역에 응답 속성들 중 type 을 class 로 추가합니다.
				fileName.attr('data-type', item.type); 									   // 지정한 영역에 data-type 으로 type 속성을 넣어줍니다.
				fileName.attr('data-path', item.path); 									   // 지정한 영역에 data-path 으로 path 속성을 넣어줍니다.
				
				if(item.type == 'file'){ 												   // 만약 응답 속성 type 이 file 이라면
					fileName.attr('data-download_url', item.download_url);				   // download url 속성을 추가해줍니다.
				}
				
				(item.type == 'file' ? files : folders).push(fileArea); 				   // type 형태에 따라 미리 생성한 배열에 push 해줍니다.
					
			})
		
			let gitFileHeader = $('.callout').find('.gitFileHeader');		               // 해당 위치의 영역을 선언합니다. (현재 경로 출력하는 위치)
			
			// 현재 위치의 폴더가 가장 상위 폴더인 경우 fileNameArea 클래스를 제거합니다.(아무런 값도 출력이 되지 않게 합니다.)
			let firstPath = $('<a ' + (path ? 'class = "fileNameArea"' : '') + ' data-type = "dir">' + gitRepoCommand);
			gitFileHeader.html(firstPath);
			
			// 현재 위치의 경로가 가장 상위 경로가 아닐 경우 뒤로가기를 만들어줍니다. (path 가 참인 경우, 선택으로 이벤트를 발생시킨 경우)
			if(path){
				let fileArea = $('#repoInfo').children('.fileInfo').clone(); 		 // 출력된 값을 저장하기 위해 div 영역을 설정해줍니다. (하위 영역까지 복사)
				let fileName = fileArea.find('.fileNameArea');						 // 해당 위치의 영역을 선언합니다.
				fileName.text('뒤로가기...') 											 // 문자 변경 가능, 이름을 지정해줍니다.
				fileArea.children('.fileName').children('i').addClass('icon-folder') // 해당 위치의 아이콘을 선언합니다.
				fileArea.addClass('baseFolder') 									 // 클래스를 추가해줍니다. 생략 가능
		
				// 만약 받아온 값에서 / 가 없다면 null 을 반환합니다.(예외 처리)
				// 파일을 점차적으로 들어간다면 / 가 쌓이기 때문에, 뒤에서 / 까지의 문자를 자릅니다.(이전 상위 폴더)
				parentPath = path.lastIndexOf('/') == -1 ? null : path.substring(0, path.lastIndexOf('/'));
				
				fileName.attr('data-type', 'dir');      							 // 경로일경우 당연히 폴더이기 때문에 data-type 을 dir 로 하드코딩 합니다.
				fileName.attr('data-path', parentPath); 							 // 상단에서 추출한 상위폴더 path 를 지정합니다.
				
				gitFileArea.append(fileArea) 										 // 출력해주는 공간에 현 조건문에서 추출한 값들을 대입합니다.
				
				// path 가 null 이 아닐 경우 현재까지의 경로를 표시해줍니다.
				rootPath = path.split('/'); 										 // 모든 경로를 나타내기 위해 / 로 자른 후 배열로 만듭니다.
				pathLength = rootPath.length; 										 // 반복문을 돌기 위해 선언한 배열의 길이를 선언합니다.
				
				for(i = 0; i < pathLength; i++){ 									 // 길이만큼 반복문 진행
					let pathTag = $('#repoInfo').find('.fileNameArea').clone(); 	 // 출력된 값을 저장하기 위해 div 영역을 설정해줍니다. (하위 영역까지 복사)
					pathTag.attr('data-type', 'dir'); 								 // 폴더 구조이기 때문에 data-type 을 dir 로 하드코딩 합니다.
					pathTagDir = ''; 												 // 초기화
					
					for(k = 0; k <= i; k++){ 
						// 현재 진입한 길이만큼 반복문을 돌며, 배열로 생성한 rootPath 들을 불러와 / 를 추가하며 경로를 만듭니다.
						// ex) webapp -> WEB-INF -> spring 진입 시
						// rootPath['webapp', 'WEB-INF', 'spring']
						// 현 반복문 진행시 -> webapp/WEB-INF/spring
						pathTagDir = pathTagDir + (k == 0 ? '' : '/') + rootPath[k];
					}
					
					pathTag.attr('data-path', pathTagDir); 						     // 상단에서 생성한 경로를 data-path 로 주입합니다.
					pathTag.text(rootPath[i]);			   							 // 몇 번째 경로인지 text 로 주입합니다.
					
					gitFileHeader.append(' / ');									 // 경로를 구분짓기 위해 / 를 추가합니다.
					
					if(i == pathLength-1){ 											 // 경로의 마지막일경우 이동하지 못하게 제외시킵니다.(이벤트 제외)
						pathTag.removeClass('fileNameArea')
					}
					
					gitFileHeader.append(pathTag); 									 // 상단에서 구한 pathTag 값을 주입합니다.
				}
			}
			
		// 폴더 -> 파일 순으로 출력해줍니다.
		gitFileArea.append(folders)
		gitFileArea.append(files)
		
		// 최하단의 스타일을 변경합니다.
		$('.gitFileArea').children('.fileInfo').last().css("border-bottom", "none");
		
		},error : function(xhr, error, msg){
			
		},
		async : false
	});
}

// 파일을 선택했을시 해당 파일의 주소를 가져와 Content 를 불러옵니다.
const selectFileContent = function(selectPath){
	
	$.ajax({
		url : selectPath,
		dataType : "JSON", //JSON데이터 불러옴
		method : "GET", 
		beforeSend : function(xhr){ // 토큰값 명시(임시)
			xhr.setRequestHeader("Authorization", "token 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")	
		},
		success : function(resp) {
			
			console.log(resp);
			
			let contentUrl = resp.download_url.substring(50); // 선택한 파일의 경로값을 가져옵니다.
			let contentData = resp.content;                   // Content 값을 지정합니다.
			let contentSha = resp.sha;						  // update 를 하기 위한 sha 주소값을 받아옵니다.	
			$('#codeContent').val(contentData);      		  // 데이터 전송과 주소 이동을 위해 form 태그에 값을 주입합니다.
			$('#codeSha').val(contentSha);			 		  // 데이터 전송과 주소 이동을 위해 form 태그에 값을 주입합니다.	
			$('#codeUrl').val(contentUrl);			 		  // 데이터 전송과 주소 이동을 위해 form 태그에 값을 주입합니다.
			$('#gitRepoCommand').val(gitRepoCommand);         // 데이터 전송과 주소 이동을 위해 form 태그에 값을 주입합니다.
			$('#codeForm').get(0).submit();          		  // form 태그를 실행합니다.
	
		},
		error : function(xhr, error, msg) {
		},
		async : false
	});
}
</script>