<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<script type="text/javascript" src="${cPath }/resources/js/commonjs/custom/jquery.form.min.js"></script>

<style>
#contents{
width : 50%;
height: 30%;
}
/* .col-md-6{
width: 50%;
}
 */
/* #newnews{
margin-left: 50%;
} */
/* 
#title{
margin-left: 32%;
} */

.fas fa-exclamation-triangle{
size: 5x;
}
#icon{
size: 5x;
text-align: center;
}
.deleteModal{
text-align: center;
}

#content {
	padding: 30px;
}

.invoice {
	padding: 20px;
	border-radius: 10px;
}

.card-widget {
	margin-bottom: 30px;
}


#contents img {
	box-shadow: 0px 0px 7px 0px #0000001f;
    width: 50%;
    border : 1px solid #d9d9d9;
    border-radius: 5px;
}

.replyEdit {
	width:100%;
	margin-top: 20px;
}


</style>

<security:authorize access="isAuthenticated()">
	<security:authentication property="principal.authMember" var="authMember"/>
 </security:authorize>




<!-- <div class="content-wrapper invoice mb-3" style="margin-left: 0;"> -->
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 id="title"><i class="far fa-newspaper" style="margin-right: 10px;"></i>NEWS</h1>
				</div>
				<div class="col-sm-6">
						

					
				</div>
				


			</div>
		</div>
		<!-- /.container-fluid -->
	</section>

	<div class="row" style="justify-content: center;">
		<div class="col-md-6" style="flex:none; max-width: none; width: 60%;">
			<!-- Box Comment -->
		
		<div>

		</div>	
			
			<div class="cardSplit">
						<div id="newnews" style="margin-bottom: 30px; float: right;">
					<button style="width: fit-content;" class="btn btn-warning btn-block" type="button"
						onclick="location.href='${cPath }/project/${project.pCode}/news/newsInsert.do' ">
						<i class="fa fa-bell"></i> 새로운 뉴스 등록하기
					</button>

			</div>
			
			
					<c:set var="NewsList" value="${dataList }"></c:set>
					<c:choose>
						<c:when test="${not empty NewsList}">
							<c:forEach items="${NewsList}" var="news">
				<div class="card card-widget" style="clear: both;">
				<div class="card-header">
								<div class="user-block">
									<!-- 프로필 사진  -->
									<img class="img-circle"
										src="${cPath }/resources/file/profileImage/${authMember.memIkon.saveName }"
										onerror="this.src='${cPath }/resources/file/profileImage/profile.jpg'">

									<!-- 유저 이름  -->
									<span class="username">${news.memNickname}</span> <span
										class="description">${news.newsDate}</span>
								</div>
								<div class="card-tools">
									<c:if test="${news.memId eq authMember.memId}">
										<a class="btn btn-tool"
											href="${pageContext.request.contextPath}/project/${news.pCode}/news/newsUpdate.do?newsCode=${news.newsCode}">
											<i class="far fa-edit"></i>
										</a>
										<a class="btn btn-tool" data-toggle="modal"
											data-target="#modal-danger" id="${news.newsCode}"> <i
											class="fas fa-times"></i>
										</a>
									</c:if>
								</div>
			   </div>
								<div class="card-body">
									<a id="contents">${news.newsContents }</a>

								</div>
								<div class="card-footer">

									<form class="replyInsertForm">
										<div class="input-group">
											<input type="hidden" class="newsCode"
												value="${news.newsCode}" /> <input type="text"
												class="commentContent form-control"
												placeholder="댓글을 입력하세요 ..."> <span
												class="input-group-append"> <input type="submit"
												value="등록" class="replyInsertBtn btn btn-warning">
											</span>
										</div>
									</form>
								</div>
								<!-- 댓글 자리랑 댓글 다는 폼  -->
								<c:forEach items="${news.replyList}" var="newsReply">
									<div id="listBody" class="card-footer card-comments">
										<!--댓글 달기  -->
										<div class="card-comment">
											<!-- User image -->
											<img class="img-circle img-sm"
												src="${cPath }/resources/file/profileImage/${authMember.memIkon.saveName }"
										onerror="this.src='${cPath }/resources/file/profileImage/profile.jpg'">
											<!-- 댓글 리스트 -->
											<div id="replyForm" class="comment-text">
												<input type="hidden" name="newsCode" class="newsCode"
													value="${newsReply.newsCode }">
												<!-- /.username -->
												<span class="username"> ${newsReply.memNickname} <span
													class="text-muted float-right commentDate">${newsReply.commentDate}&nbsp;</span>
												</span>
												<div class="currentCommentContent">
													<input type="hidden" class="commentCode"
														value="${newsReply.commentCode }"> <span
														class="commentContent">${newsReply.commentContent}</span>

													<!-- 로그인한 사람에게만 권한 부여  -->
													<c:if test="${newsReply.memId eq authMember.memId}">
														<a data-toggle="modal" data-target="#delmodal"
															id="${newsReply.commentCode}"
															class="text-muted float-right">삭제</a>
														<a class="text-muted float-right editBtn">수정&nbsp;</a>
													</c:if>
												</div>
											</div>
										</div>
										<!-- /.comment-text -->
									</div>
								</c:forEach>
								</div>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="2">조건에 맞는 게시글이 없음.</td>
							</tr>
						</c:otherwise>
					</c:choose>

				</div>
				<!-- /.card-footer -->
			</div>
			<!-- /.card -->
		</div>
		<!-- /.col -->
	</div>

<!-- 수정 폼 시작 -->
	 <div id="editFormdiv" style="display:none;">
	 	<form class="replyUpdateForm">
	 	<input type="hidden" name="newsCode" class="newsCode">
	 	<input type="hidden" name="commentCode" class="commentCode">
		<textarea name="commentContent" class="commentContent form-control replyEdit"></textarea><br>
		<input class="btn btn-secondary btn-sm" type="submit" value="저장"> <input type="button" value="취소" class="btn btn-default btn-sm replyUpdateCancel">
		</form>
	 </div>
	<!-- 수정 폼 끝 -->
	
	
	
	<div class="modal fade" id="modal-danger">
	<div class="modal-dialog">
		<div class="modal-content bg-default">
		<div id="icon">
		<br><br>
			<h1><i class="fas fa-exclamation-triangle"></i></h1>
		
		</div>
			<div class="modal-body deleteModal">
			
				<p>정말 삭제하시겠습니까?</p>
			</div>
			<div class="modal-footer justify-content-between">
				<button type="button" class="btn btn" data-dismiss="modal">취소</button>
				<button type="button" class="linkBtn btn btnt" id="realDelBtn">삭제</button>
			</div>
		</div>
	</div>
</div>

	<div class="modal fade" id="delmodal">
	<div class="modal-dialog">
		<div class="modal-content bg-default">
			<div id="icon">
		<br><br>
			<h1><i class="fas fa-exclamation-triangle"></i></h1>
		
		</div>
			<div class="modal-body deleteModal">
			
				<p>정말 삭제하시겠습니까?</p>
			</div>
			<div class="modal-footer justify-content-between">
				<button type="button" class="btn btn" data-dismiss="modal">취소</button>
				<button type="button" class="linkBtn btn btn" id="replyDelBtn">삭제</button>
			</div>
		</div>
	</div>
</div>

	<script>




$('#modal-danger').on("show.bs.modal", function (event) {
	$(this).data("newsCode", event.relatedTarget.id)
})



	$("#realDelBtn").on("click", function(event) {
		
	let newsCode = $(this).parents('#modal-danger').data("newsCode")

	$.ajax({
			url : "${cPath}/project/{pCode}/news/newsDelete.do",

			data : {
				"newsCode" : newsCode
				
			},
			dataType: "json",
			success : function(resp) {
				
				alert(resp.message);
				
				if(resp.result == "OK"){
				location.href = $.getContextPath() + resp.redirect;
				
				}

			},
			error : function(xhr, jQuery, error) {
				console.log(jQuery);
				console.log(error);
			}
		}) 
	}
)

$('#delmodal').on("show.bs.modal", function (event) {
	$(this).data("commentCode", event.relatedTarget.id)
})



	$("#replyDelBtn").on("click", function(event) {
		
	let commentCode = $(this).parents('#delmodal').data("commentCode")

	$.ajax({
			url : "${cPath}/news/newsReplyDelete.do",

			data : {
				"commentCode" : commentCode
				
			},
			success : function(resp) {
				alert(resp);
				if(resp == "OK"){
				location.href = "${cPath}/project/${pCode}/news/newsList.do";
				
				}

			},
			error : function(xhr, jQuery, error) {
				alert("실패함?")
				console.log("======================================")
				console.log(xhr);
				console.log(jQuery);
				console.log(error);
			}
		}) 
	}
)




$(function () {
	
	
	//listReply();
	
	
	$("#replyUpdateCancel").on("click", function () {
		$(".currentCommentContent").show();
		$("body").append("#editFormdiv");
		$("#editFormdiv").hide();
		
	});
	
	$(".editBtn").on("click", function () {
		var commentContent = $(this).parent().find(".commentContent").text().trim();
		var newsCode = $(this).parents(".currentCommentContent").siblings(".newsCode").val().trim();
		var commentCode = $(this).siblings(".commentCode").val().trim();
// 		var memId = "aa001";
// 		var newsCode = $(this).find(".newsCode").val()
// 		var writeDate = $(this).parent().find(".commentDate").text();

		$("#editFormdiv").show();

		$("[name=commentContent]", "#editFormdiv").val(commentContent);
		$("[name=commentCode]", "#editFormdiv").val(commentCode);
		$("[name=newsCode]", "#editFormdiv").val(newsCode);
		
		$("#editFormdiv").insertBefore($(this).parent());
		$(this).parent().hide();

	})
	
	$(".replyInsertForm").on("submit", function () {
		
		
		var commentContent = $(this).find(".commentContent").val()
		var memId = "${authMember.memId}";
		var newsCode = $(this).find(".newsCode").val()
		
		var params = {
				
				"commentContent" : commentContent,
				"memberId" : memId,
				"newsCode" : newsCode
				
		};
		
		$.ajax({
			type: "post",
			url: "${cPath}/news/newsReplyInsert.do",
			data: params,
			dataType : "text",
			success: function (data) {
				if(data=="success"){
					alert("댓글이 등록되었습니다");
					listReply(newsCode);
					location.href = "${cPath}/project/${pCode}/news/newsList.do";
					/* $(this).find(".commentContent").val();
					"${authMember.memId}"; */
				}else{
					alert("댓글이 등록 실패!!");
				}
			},
			error : function(){
				alert("오류");
			}
		})
		
		
	})
	
	
	$(".replyUpdateForm").on("submit", function (event) {
		event.preventDefault()
		var commentContent = $(this).find("[name=commentContent]").val()
		var memId = "${authMember.memId}";
		var newsCode = $(this).find("[name=newsCode]").val() 
		var commentCode = $(this).find("[name=commentCode]").val()
		
		var params = {
				
				"commentContent" : commentContent,
				"memberId" : memId,
				"newsCode" : newsCode,
 				"commentCode" : commentCode
		};
		
		$.ajax({
			type: "post",
			url: "${cPath}/news/newsReplyUpdate.do",
			data: params,
			dataType : "text",
			success: function (data) {
				if(data=="success"){
					alert("댓글이 수정되었습니다");
					listReply(newsCode);
					location.href = "${cPath}/project/${pCode}/news/newsList.do";
					//$("#commentContent").val("");
				}else{
					alert("댓글이 등록 실패!!");
				}
			},
			error : function(){
				alert("오류");
			}
		})
		
		return false;
	})
	
	function listReply(newsCode) {
		$.ajax({
			//type에 대해 
			type: "get",
			url: "${cPath}/news/newsReplyList.do?newsCode=" + newsCode ,
			success: function (result) {
		
				let replyList = result;
				let htmlCode = "";
				
				if(replyList){
					$.each(replyList, function(idx, reply){
						
						 htmlCode += '<div class="card-comment">';
						 htmlCode += ' <img class="img-circle img-sm" src="${cPath}/resources/file/profileImage/${authMember.memIkon.saveName }" alt="User Image">';
						 htmlCode += ' <div id="replyForm" class="comment-text">';
						 htmlCode += '<input type="hidden" name="newsCode" class="newsCode" value="${newsReply.newsCode }">'
						 htmlCode += '   <span class="username">';
						 htmlCode += 	reply.memId;
						 htmlCode += '     <span class="text-muted float-right">' + reply.commentDate + '</span>';
						 htmlCode += '   </span>';
						 htmlCode += '<div class="currentCommentContent">'
						 htmlCode += '<input type="hidden" class="commentCode" value="${newsReply.commentCode }">'
						 htmlCode += '<span class="commentContent">'
						 htmlCode += 	reply.commentContent;
						 htmlCode += '</span>'
						 htmlCode += '<a data-toggle="modal" data-target="#modal-danger" id="${newsReply.commentCode}" class="text-muted float-right">삭제</a>'
						 htmlCode += '<a class="text-muted float-right editBtn">수정</a>'
						 htmlCode += ' </div>';
						 htmlCode += ' </div>';
						 htmlCode += '</div>';
						 
					});
				}else{
					htmlCode = "";
				}
				
				$("#listBody").html(htmlCode);
				
				
			}
			
		});
		
	}
	

	

	
	
})

function editBtn(reply){
	var htmlCode = "";
	
	htmlCode += '<div class="card-comment">';
	 htmlCode += ' <img class="img-circle img-sm" src="${cPath }/resources/file/profileImage/${authMember.memIkon.saveName }" ';
	 //htmlCode += ' onerror="this.src='${cPath }/resources/file/profileImage/profile.jpg'">'; 
	 htmlCode += ' <div id="replyForm" class="comment-text">';
	 htmlCode += '   <span class="username">';
	 htmlCode += 	reply.memId;
	 htmlCode += '     <span class="text-muted float-right">' + reply.commentDate + '</span>';
	 htmlCode += '   </span>';
	 htmlCode += '	<textarea name="updateForm" id="updateForm cols="30" rows="2">';
	 htmlCode += reply.commentContent;
	 htmlCode += '</textarea>';
	 htmlCode += ' </div>';
	 htmlCode += '</div>';
	 
	 $("#listBody").html(htmlCode);
	
}



</script>