<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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


/* --------- */



#content {
	padding:30px;
}

.invoice {
	padding: 30px;
	border-radius: 10px;
	border-top: 3px solid #3f6791;
}

</style>

<div class="row">
	<div class="col-12">
			<h1></h1>
	</div>
</div>

<!-- 메인페이지 시작 -->
<form action="${cPath }/project/${project.pCode}/projectNotice/projectNoticeInsert.do" method="post" enctype="multipart/form-data">
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-12">
				<!-- 메인 Content 시작 -->
				<div class="invoice mb-3">
					<div class="row">
						<div class="col-12">
						
							<h4 style="margin-bottom: 20px;"><i class="fas fa-exclamation-circle marginNotice"></i> 프로젝트 공지사항 작성</h4>
												
							<div class="col-md-12">
								<div class="card">
								
									<div class="card-header">
										<h3 class="card-title">공지사항 등록</h3>
									</div>
										
										<!-- /.card-header -->
										<div class="card-body">
										
										 	
										
											<div class="form-group">
												<input class="form-control" name="noticeTitle" placeholder="TITLE">
											</div>
											                
											<div class="form-group">
												<textarea id="compose-textarea" class="form-control" name="noticeContents"></textarea>
											</div>
											
											<div class="form-group">
												<div class="btn btn-default btn-file" id="fileName">
													<i class="fas fa-paperclip"></i>파일첨부
													<input type="file" name="noticeFile" id="fileUpload">
												</div>
												<span class="fileName" id="fileNamePlace"></span>
											</div>
											
										</div>
										<!-- /.card-body -->
										<div class="card-footer">
										                
											
											<div class="float-right">
												<input type="submit" class="linkBtn btn btn-secondary" value="등록" data-gopage="${cPath }/project/${project.pCode}/projectNotice/projectNoticeInsert.do">
												<input type="button" class="linkBtn btn btn-secondary" OnClick="javascript:history.back(-1)" value="취소">
												
											</div>
																		
										</div>
										<!-- /.card-footer -->
									
									
								</div>
								<!-- /.card -->
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
	$('#fileNamePlace').text(file.name);

});

</script>