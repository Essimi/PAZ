<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
							<i class="fas fa-chalkboard-teacher"></i> 고객센터 질문글 수정
						</h4>

						<br>
						<form method="post">

							<div class="card card-primary card-outline">
								<div class="card-body p-0">
									<div class="mailbox-read-info">

										<br> <input type="text" id = 'ttitle' class="form-control" placeholder="제목을 입력해주세요" required> <br>
									</div>

									<div class="mailbox-read-message" id="QnA_main_Content">

 										<textarea id="compose-textarea" class="form-control" required value></textarea>
										
									</div>
								</div>

								<div class="card-footer">
									<div class="float-right">
										<input type="button" id = "checkQna" class="linkBtn btn btn-info" value="수정하기">
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>

				<br>

			</div>
		</div>
	</div>
</div>

<form action = "<%=request.getContextPath()%>/qna/qnaUpdate.do" id = "qnaWrite" method="post" name = "qna">
	<input type = "hidden" name = "qandaCode" id = 'qandaCode'>
	<input type = "hidden" name = "qandaTitle" id = 'qandaTitle'>
	<input type = "hidden" name = "qandaContent" id = 'qandaContent'>
</form>