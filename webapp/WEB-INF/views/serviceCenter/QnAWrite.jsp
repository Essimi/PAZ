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
							<i class="fas fa-chalkboard-teacher"></i> 고객센터 질문글 작성
						</h4>

						<br>
						<form method="post">

							<div class="card card-primary card-outline">
								<div class="card-body p-0">
									<div class="mailbox-read-info">

										<br> <input type="text" class="form-control" placeholder="제목을 입력해주세요" name="qandaTitle" required value="${qna.qandaTitle }"> <br>
									</div>

									<div class="mailbox-read-message" id="QnA_main_Content">

										<input type="text" class="form-control" id="QnA_WriteContent" placeholder="내용을 입력해주세요" name="qandaContent" required value="${qna.qandaContent }">
									</div>
								</div>

								<div class="card-footer">
									<div class="float-right">
										<input type="submit" class="linkBtn btn btn-info" value="작성하기" data-gopage="${cPath }/project/qnaWrite.do">
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