<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
#QnA_main_Content {
	height: 500px;
}
</style>


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

							<div class="card-footer">
								<div class="float-right">
									<input type="button" class="linkBtn btn btn-info" value="수정"
								       data-gopage="${cPath }/project/qnaNotAnswerList.do">
									<input type="button" class="linkBtn btn btn-info" value="삭제"
								       data-gopage="${cPath }/project/qnaNotAnswerList.do">
								</div>
								<input type="button" class="linkBtn btn btn-info" value="답변 작성"
								       data-gopage="${cPath }/project/qnaWrite.do">
							</div>
						</div>

					</div>
				</div>

				<br>

			</div>
		</div>
	</div>
</div>