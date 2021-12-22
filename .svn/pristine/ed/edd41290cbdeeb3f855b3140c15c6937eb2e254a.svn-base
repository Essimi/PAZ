<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 메인페이지 시작 -->

<style>

body {
	overflow-x:hidden;
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

body:not(.sidebar-mini-md):not(.sidebar-mini-xs):not(.layout-top-nav) .content-wrapper,
	body:not(.sidebar-mini-md):not(.sidebar-mini-xs):not(.layout-top-nav) .main-footer,
	body:not(.sidebar-mini-md):not(.sidebar-mini-xs):not(.layout-top-nav) .main-header
	{
	margin-left: 0px;
}

.fas {
	margin-left: 10px;
}

.marginNotice {
	margin-top: 8px;
	margin-bottom: 12px;
}

#content {
	padding: 30px 100px;
}


.invoice {
	padding:30px;
	border-radius: 10px;
	border-top: 3px solid #17a2b8;
}


</style>

<div class="row">
	<div class="col-12">
			<h1></h1>
	</div>
</div>

<form action="${cPath }/notice/noticeUpdate.do" method="post" enctype="multipart/form-data">
	
	<div class="container-fluid">
		<div class="row">
			<div style="width: 100%;">
				<!-- 메인 Content 시작 -->
				<div class="invoice mb-3">
					<div class="row">
						<div class="col-12">
						
							<h3><i class="fas fa-exclamation-circle marginNotice"></i> 공지사항 수정</h3>
												
							<div class="col-md-12">
								<div class="card">
								
									<div class="card-header">
										<h3 class="card-title">공지사항 수정</h3>
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
											
												<input type="submit" class="linkBtn btn btn-secondary" value="수정" data-gopage="${cPath }/notice/noticeUpdate.do">
												<input type="button" class="linkBtn btn btn-default" OnClick="javascript:history.back(-1)" value="취소">
												
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