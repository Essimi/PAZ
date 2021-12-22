<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<style>

body {
	overflow-x:hidden;
}

#compose-textarea {
	height: 300px;
	display: none;
}

.note-editable {
	height: 520px;
}

.container-fluid {
	margin-left: 0px;
}

.fas {
	margin-left: 10px;
}

.fileName {
	font-size: 16px;
	font-weight: bold;
}

#compose-textarea {
	height: 300px;
	display: none;
}

.note-editable {
	height: 520px;
}

.marginNotice {
	margin-top: 8px;
	margin-bottom: 12px;
} {
	margin-top: 8px;
	margin-bottom: 8px;
}


/* ------- */


#content {
	padding:30px;
}

.invoice {
	padding: 30px;
	border-radius: 10px;
	border-top: 3px solid #3f6791;
}

.mailboxDiv {
	padding: 20px;
}

.mailbox-read-message {
	min-height: 350px;
}

</style>

<c:if test="${not empty message }">

<script>

	$(window).on('load',function(){
	    $('#msgModal').modal('show');
	});

</script>

</c:if>

<div class="row">
	<div class="col-12">
			<h1></h1>
	</div>
</div>


<!-- 메인페이지 시작 -->
<div class="container-fluid">
	<div class="row">
		<div class="col-12">
		
		<!-- 메인 Content 시작 -->
		
		<div class="invoice mb-3">
			<div class="row">
				<div class="col-12">
				<h4 style="margin-bottom: 10px;"><i class="fas fa-exclamation-circle marginNotice"></i> 프로젝트 공지사항 상세보기</h4>
				
				<div class="card noticeMain">
					<div class="card-body p-0">
					
						<div class="mailbox-read-info mailboxDiv">
						
						<h5 style="font-weight: bolder;">${notice.noticeTitle}</h5>
															
						</div>
						
					<div class="mailbox-read-message mailboxDiv" id="#noticeMainContent">
						<p style="white-space: pre-line;">${notice.noticeContents}</p>
					</div>
					
					<c:if test="${not empty notice.attatch }">
						<!-- /.card-body -->
						
						<div class="card-footer bg-white">
							<ul class="mailbox-attachments d-flex align-items-stretch clearfix">
							              
							<li>            
							
								<div class="mailbox-attachment-info">
									<i class="fas fa-paperclip">${notice.attatch.realName}</i>
									<span class="mailbox-attachment-size clearfix mt-1">
									
										<span>${notice.attatch.fileSize} KB</span>
										                  			
										<c:url value="/project/${project.pCode}/projectNotice/projectNoticeDownload.do" var="downloadURL">
											<c:param name="noticeCode" value="${notice.noticeCode }" />
										</c:url>
										                  			
										<a href="${downloadURL }" class="btn btn-default btn-sm float-right">
										<i class="fas fa-cloud-download-alt"></i>
										</a>
									</span>
								</div>
							
							</li>
							    
							</ul>
						</div>
					
					</c:if>
					
					
													
					</div>
					<div class="card-footer">
					
						<div class="float-right">
						
							<c:url value="/project/${project.pCode}/projectNotice/projectNoticeModify.do" var="viewURL">
								<c:param name="noticeCode" value="${notice.noticeCode }" />
							</c:url>
							
							<input type="button" class="linkBtn btn btn-secondary" value="수정" data-gopage="${viewURL }">
							<input type="button" class="linkBtn btn btn-secondary" value="삭제" data-toggle="modal" data-target="#exampleModal">
							
						</div>
													
					</div>
				</div>
				
				</div>
			</div>
			<br>
		
		</div>
		
		</div>
	</div>
</div>


<!-- 삭제버튼 / 삭제 모달창  -->
					
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
		
			<div class="modal-header">
			
				<h5 class="modal-title" id="exampleModalLabel">DELETE POST</h5>
				
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				
			</div>
			
			<div class="modal-body">삭제한 게시물은 복구 불가능합니다.</div>
			
			<c:url value="/project/${project.pCode}/projectNotice/projectNoticeDelete.do" var="deleteURL">
				<c:param name="noticeCode" value="${notice.noticeCode }" />
			</c:url>
			
			<div class="modal-footer">
				<button type="button" class="linkBtn btn btn-primary" data-gopage="${deleteURL }">삭제</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
			</div>
		</div>
	</div>
</div>


<!-- 메시지 모달창  -->
					
<!-- Modal -->
<div class="modal fade" id="msgModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
		
			<div class="modal-header">
			
				<h5 class="modal-title" id="exampleModalLabel">MESSAGE</h5>
				
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				
			</div>
			
			<div class="modal-body">${message }</div>
			
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">확인</button>
			</div>
		</div>
	</div>
</div>