<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!-- 버튼의 조건 입니다. -->
 <!-- 로그인한 회원의 아이디를 알기 위한 security 추가 -->
 <security:authorize access="isAuthenticated()">
	 <security:authentication property="principal.authMember" var="authMember"/>
 </security:authorize>

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
			
			<form:form commandName = "qna">
				<div class="invoice p-3 mb-3">
					<div class="row">
						<div class="col-12">	
							<h4>
								<c:if test="${authMember.memId eq 'admin'}">
									<i class="fas fa-chalkboard-teacher"></i> 답글 작성
								</c:if>
								
								<c:if test="${authMember.memId ne 'admin'}">
									<i class="fas fa-chalkboard-teacher"></i> 고객센터 질문글 작성
								</c:if>
							</h4>
	
							<br>
	
								<div class="card card-primary card-outline">
									<div class="card-body p-0">
										<div class="mailbox-read-info">
	
											<br> <form:input path="qandaTitle" type="text" class="form-control" placeholder="제목을 입력해주세요"/> <br>
											<form:errors path = "qandaTitle" element = "span" style = "color : red"/>
											
										</div>
	
										<div class="mailbox-read-message" id="QnA_main_Content">
											<form:errors path = "qandaContent" element = "span" style = "color : red"/>
	 										<form:textarea  path = "qandaContent" id="compose-textarea" class="form-control" />
										</div>
									</div>
	
									<div class="card-footer">
										<div class="float-right">
											<input type="submit" class = "btn btn-info" value="작성하기">
										</div>
									</div>
								</div>
						</div>
					</div>
	
					<br>
	
				</div>
			</form:form>
		</div>
	</div>
</div>