<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<style>
body {
	overflow-x:hidden;
}

#noticeMainContent {
	
}

body:not(.sidebar-mini-md):not(.sidebar-mini-xs):not(.layout-top-nav) .content-wrapper,
	body:not(.sidebar-mini-md):not(.sidebar-mini-xs):not(.layout-top-nav) .main-footer,
	body:not(.sidebar-mini-md):not(.sidebar-mini-xs):not(.layout-top-nav) .main-header
	{
	margin-left: 0px;
}

.container-fluid {
	padding-left: 280px;
}

.marginNotice {
	margin-top: 8px;
	margin-bottom: 8px;
}

/* .noticeMain {
	height: 850px;
} */

#content {
	padding: 30px 100px;
}

.invoice {
	padding:30px;
	border-radius: 10px;
	border-top: 3px solid #17a2b8;
}

.container-fluid {
	padding-left: 0;
}

#noticeMainContent {
	height: 400px;
	padding:20px;
}

.mailbox-read-info {
	padding:20px;
}

.mailbox-read-info h5 {
	font-weight: bolder;
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
		<div style="width: 100%">
		
		<!-- 메인 Content 시작 -->
		
		<div class="invoice mb-3">
			<div class="row">
				<div class="col-12">
				<h3><i class="fas fa-exclamation-circle marginNotice"></i> 공지사항 상세보기</h3>
				
				<div class="card noticeMain">
					<div class="card-body p-0">
					
						<div class="mailbox-read-info">
						
						<h5>${notice.noticeTitle}</h5>
															
						</div>
						
					<div class="mailbox-read-message" id="noticeMainContent">
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
										                  			
										<c:url value="/notice/download.do" var="downloadURL">
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
						
							<c:url value="/notice/noticeUpdate.do" var="viewURL">
								<c:param name="noticeCode" value="${notice.noticeCode }" />
							</c:url>
							
							<security:authorize access="isAuthenticated()">
								<security:authentication property="principal.authMember" var="authMember"/>
							</security:authorize>
							
							<c:set var="memId" value="${authMember.memId }" />
							
							<c:if test="${ memId eq 'admin' }">
							
								<input type="button" class="linkBtn btn btn-primary" value="수정" data-gopage="${viewURL }">
								<input type="button" class="linkBtn btn btn-primary" value="삭제" data-toggle="modal" data-target="#exampleModal">
							
							</c:if>
							
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
			
			<c:url value="/notice/noticeDelete.do" var="deleteURL">
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