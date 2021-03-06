<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 메인페이지 시작 -->

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

</style>

<div class="row">
	<div class="col-12">
			<h1></h1>
	</div>
</div>

<form action="${cPath }/project/${project.pCode}/projectNotice/projectNoticeModify.do" method="post" enctype="multipart/form-data">
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-12">
				<!-- 메인 Content 시작 -->
				<div class="invoice p-3 mb-3">
					<div class="row">
						<div class="col-12">
						
							<h3><i class="fas fa-exclamation-circle marginNotice"></i> 프로젝트 공지사항 수정</h3>
												
							<div class="col-md-12">
								<div class="card card-primary card-outline">
								
									<div class="card-header">
										<h3 class="card-title">UPDATE THE NOTICE</h3>
									</div>
										
										<!-- /.card-header -->
										<div class="card-body">
										
										 	<div class="form-group">
												<input type="hidden" class="form-control" name="noticeCode" value="${notice.noticeCode}">
											</div>
										
											<div class="form-group">
												<input class="form-control" name="noticeTitle" placeholder="TITLE" value="${notice.noticeTitle}">
											</div>
											                
											<div class="form-group">
												<textarea id="compose-textarea" class="form-control" name="noticeContents">${notice.noticeContents}</textarea>
											</div>
											
											<div class="form-group">
												<div class="btn btn-default btn-file">
													<i class="fas fa-paperclip"></i>파일첨부
													<input type="file" name="noticeFile" id="fileUpload">
												</div>
												<span class="fileName" id="fileNamePlace">${notice.attatch.realName}</span>
											</div>
											
										</div>
										<!-- /.card-body -->
										<div class="card-footer">
										                
											
											<div class="float-right">
											
												<input type="submit" class="linkBtn btn btn-primary" value="수정" data-gopage="${cPath }/project/${project.pCode}/projectNotice/projectNoticeModify.do">
												<input type="button" class="linkBtn btn btn-primary" OnClick="javascript:history.back(-1)" value="취소">
												
											</div>
																		
										</div>
									
								</div>
							</div>
						
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</form>


<script>

$(function () {
	$('#compose-textarea').summernote()
})

</script>

<script>

$("#fileUpload").change(function(){
	
	var file = this.files[0];
	$('#fileNamePlace').html(file.name);

});

</script>