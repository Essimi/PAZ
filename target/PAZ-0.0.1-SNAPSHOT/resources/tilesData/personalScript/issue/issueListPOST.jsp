<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <script type="text/javascript" src="${cPath }/resources/js/commonjs/jquery.form.min.js"></script>
 <script type="text/javascript" src="${cPath }/resources/js/commonjs/custom/paging.js"></script>
 <script>
 $(function(){
	 var Toast = Swal.mixin({
			toast : true,
			position : 'top-end',
			showConfirmButton : false,
			timer : 3000
		});

		var message = "${status}";
		if (message != "") {
			switch (message) {
			case "INSERT":
				toastr.success("이슈 게시물을 등록하였습니다.");
				break;
			case "UPDATE":
				toastr.success("이슈 게시물을 수정하였습니다.");
				break;
			case "DELETE":
				toastr.success("이슈 게시물을 삭제하였습니다.");
				break;
			};
		};
 })
 
 
 	let listBody = $("#listBody");
	let pagingArea = $("#pagingArea");
 
	//paging함수만 사용하면 동기, ajaxForm을 뒤에 붙이면 비동기
	$("#searchForm").paging().ajaxForm({
		dataType : "json",
		success : function(resp) {
			listBody.empty();
			pagingArea.empty();
			
			let issueList = resp.dataList;
			let pagingHTML = resp.pagingHTML;
			let trTags = [];
			if(issueList){
				$.each(issueList, function(idx, issue){
					let trTag = 
						$("<tr>").append(
							$("<td>").addClass("issueTitle").data("issueCode", issue.issueCode).append($("<span>").text(issue.issueName)),
							$("<td>").addClass("issueWork").data("workCode", issue.workCode).append($("<span>").text(issue.workName)));
					switch (issue.issueTypeCode) {
					case 'ISSUE_TYPE001':
						trTag.append($("<td>").addClass("issueBadge").html($("<span>").addClass("badge bg-danger issueType").text("버그"))); break;
					case 'ISSUE_TYPE002':
						trTag.append($("<td>").addClass("issueBadge").html($("<span>").addClass("badge bg-success issueType").text("요청"))); break;
					};
					switch (issue.importance) {
					case 'IMPORTANCE001':
						trTag.append($("<td>").addClass("issueBadge").html($("<span>").addClass("badge bg-danger importance").text("긴급"))); break;
					case 'IMPORTANCE002':
						trTag.append($("<td>").addClass("issueBadge").html($("<span>").addClass("badge bg-warning importance").text("높음"))); break;
					case 'IMPORTANCE003':
						trTag.append($("<td>").addClass("issueBadge").html($("<span>").addClass("badge bg-primary importance").text("보통"))); break;
					case 'IMPORTANCE004':
						trTag.append($("<td>").addClass("issueBadge").html($("<span>").addClass("badge bg-success importance").text("낮음"))); break;
					};
					let liTags = [];
					 $.each(issue.issueRecipients, function(idx, recipient){  
						 let li = $("<li>").addClass("list-inline-item")
			    					.append($("<img>").addClass("table-avatar")
			    						.attr({
											src : '${cPath }/resources/file/profileImage/' + recipient.saveName,
											onerror : "this.src='${cPath }/resources/file/profileImage/profile.jpg'"
										})
										, $("<br>")
										, $("<span>").addClass("badge badge-success").text(recipient.memNickname).data("memId", recipient.memId)
			    					);
						 liTags.push(li);
		    		 	})
					trTag.append($("<td>").addClass("issueWriter").append($("<img>").addClass("img-circle img-bordered-sm")
										 .attr({
												src : '${cPath }/resources/file/profileImage/' + issue.saveName,
												onerror : "this.src='${cPath }/resources/file/profileImage/profile.jpg'"
												})
											, $("<br>")
											, $("<span>").addClass("badge badge-warning").text(issue.memNickname).data("memId", issue.memId)
											),
								$("<td>").html($("<div>").attr('id', 'recipient-profile')
										      .append($("<ul>").addClass("list-inline").attr("id", "recipientUL").append(liTags))
										      	)
								)
								
					trTags.push(trTag);
					
				});
			}else{
				let trTag = $("<tr>").html($("<td>").attr({colspan: "6"}).text("게시물 없음."))
				trTags.push(trTag);
			}
			
			listBody.append(trTags);
			pagingArea.html(pagingHTML);
			$("[name='page']").val("");
		},
		error : function(xhr, errorResp, error) {
			console.log(xhr);
			console.log(errorResp);
			console.log(error);
		}
	}).submit();
 
	
	$("#listBody").on("click", "tr", function(){
		let issueCode = $(this).children("td:eq(0)").data("issueCode");
		location.href = "${cPath}/project/${project.pCode}/issue/issueSelect.do?issueCode=" + issueCode;
	})
 </script>