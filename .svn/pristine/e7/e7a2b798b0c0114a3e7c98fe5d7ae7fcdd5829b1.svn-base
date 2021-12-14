<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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
				<form:hidden path="qandaCode" value = "${qnaUpdate.qandaCode }"/>
				<form:hidden path="qandaTitle" value = "${qnaUpdate.qandaTitle }"/>
				<div class="invoice p-3 mb-3">
					<div class="row">
						<div class="col-12">
	
							<h4>
								<i class="fas fa-chalkboard-teacher"></i> 고객센터 질문글 수정
							</h4>
	
							<br>
	
								<div class="card card-primary card-outline">
									<div class="card-body p-0">
										<div class="mailbox-read-info">
					
											<br> <span class = "form-control">${qnaUpdate.qandaTitle}</span> <br>
											
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