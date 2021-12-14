<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!-- 페이지 메인 문구 -->
<div class="container-fluid">
	<div class="row mb-2">
		<div class="col-sm-6">
			<h1>Service Center</h1>
		</div>
	</div>
</div>

<!-- 메인페이지 시작 -->
<div class="container-fluid">
	<div class="row">
		<div class="col-12">
			<!-- 메인 Content 시작 -->
			<div class="invoice p-3 mb-3">
				<div class="row">
					<div class="col-12">

						<h4>
							<i class="fas fa-chalkboard-teacher"></i> 고객센터 상세보기
						</h4>
						
						<small class="float-right"> 
							<button class = "linkBtn btn btn-info" id = "gotoList" data-gopage="${cPath }/qna/qnaUserList.do">리스트로 이동하기</button>
						</small>

						<br>

						<div class="card card-primary card-outline">
							<div class="card-body p-0">
								<div class="mailbox-read-info">

									<h5>${qna.qandaTitle}</h5>

								</div>

								<div class="mailbox-read-message" id="QnA_main_Content">

									<br> <br> ${qna.qandaContent} <br>
									
								</div>
							</div>
							
							 <!-- 버튼의 조건 입니다. -->
							 <!-- 로그인한 회원의 아이디를 알기 위한 security 추가 -->
							 <security:authorize access="isAuthenticated()">
								 <security:authentication property="principal.authMember" var="authMember"/>
							 </security:authorize>

							<div class="card-footer">
								<div class="float-right">

									<c:url value="qnaUpdate.do" var="updateURL">
										<c:param name="QnANo" value="${qna.qandaCode}" />
									</c:url>
									<c:if test="${authMember.memId ne 'admin'}">
										<c:if test = "${qna.memId eq authMember.memId }">
											<input type="button" class="linkBtn btn btn-info" value="수정" data-gopage="${updateURL }"> 
											<input type="button" class="btn btn-danger" data-toggle="modal" data-target="#modal-danger" value="삭제" id="delBtn">
										</c:if>	
									</c:if>	
										
								</div>
								
							   
								
								<c:if test="${authMember.memId eq 'admin'}">
									<c:if test="${empty qna.parentCode}">
										<c:url value="qnaWrite.do" var="answerQnAURL">
											<c:param name="parentCode" value="${qna.qandaCode }" />
										</c:url>
										<input type="button" class="linkBtn btn btn-info" value="답글 작성" data-gopage="${answerQnAURL }">
									</c:if>	
								</c:if>
							</div>
						</div>
					</div>
				</div>

				<br>

			</div>
		</div>
	</div>
</div>

<!-- 삭제 확인 Modal -->
<div class="modal fade" id="modal-danger">
	<div class="modal-dialog">
		<div class="modal-content bg-danger">
			<div class="modal-header">
				<h4 class="modal-title">안내!</h4>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
			
				<p>정말 삭제하시겠습니까?</p>
				
			</div>
			<div class="modal-footer justify-content-between">
				<button type="button" class="btn btn-outline-light" data-dismiss="modal">취소</button>
				<button type="button" class="linkBtn btn btn-outline-light" id="realDelBtn">삭제</button>
			</div>
		</div>
	</div>
</div>