<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="${cPath }/resources/js/commonjs/custom/commons.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/commonjs/custom/paging.js">
</script>

<script>
window.addEventListener('load', function () {

	let sizeTest = ${projectMainCalendarList.size()};	
	
	for(i = 1; i <= sizeTest; i++){
		
		var test = Math.floor(Math.random() * 10000) + 1;
								
		$('#testDivID' + i).prepend("<i class='fas fa-circle' style='color:#" + test + "; background-color:#e5dede'></i>" );
									
	} 
})

$("#listBody").on("click", "tr", function(){
	
	let issueCode = $(this).find(".issueCode").data("issuecode");
		
	location.href = "${cPath}/project/${project.pCode}/issue/issueSelect.do?issueCode=" + issueCode;
})

</script>

<script>

let noticeBody = $("#noticeBody");
let pagingArea = $("#pagingArea");

let searchForm = $("#searchForm").paging()
	.ajaxForm({
		url : '${cPath}/project/${project.pCode}/projectView.do',					
		dataType : 'json',                              
		success : function(resp){                       
			noticeBody.empty();                            
			pagingArea.empty();
			
			let noticeList = resp.dataList;                    
			let pagingHTML = resp.pagingHTML;          
			let trTags=[];
			
			if (noticeList) {
				
				$.each(noticeList,function(idx,notice){
					
					let trTag = $("<tr>").append(
							$("<td>").text(notice.rnum),
							$("<td>").text(notice.noticeTitle).attr({
								class : "checkBtn",
								id : notice.noticeCode,
								style : "color: #3f6791; text-align:left;"
							}),	
							$("<td>").text(notice.noticeDate)
					)
					trTags.push(trTag); 
				});
				
			} else {
				let trTag = $("<tr>").html(
						$("<td>").text("공지사항이 존재하지 않음.")		
				);
				trTags.push(trTag);
			}                                                  
			                                                   
			noticeBody.append(trTags);                          
			pagingArea.html(pagingHTML);                       
		},                                                     
		error:function(xhr, jQuery, error){                                
			console.log(error);                                 
		}                                                       
	}).submit();                                           

</script>

<script>

	$(document).on("click",".checkBtn",function() {
		let noticeId = $(this).attr("id");
		let viewURL = "${cPath }/project/${project.pCode }/projectNotice/projectNoticeSelect.do?noticeCode="+noticeId;
		
		location.href = viewURL;
	});

</script>