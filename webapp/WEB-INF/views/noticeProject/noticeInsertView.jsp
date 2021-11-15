<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 메인페이지 시작 -->

<form action="${cPath }/notice/noticeInsert.do" method="post" enctype="multipart/form-data">
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-12">
				<!-- 메인 Content 시작 -->
				<div class="invoice p-3 mb-3">
					<div class="row">
						<div class="col-12">
						
							<h4>
							<i class="fas fa-chalkboard-teacher"></i> 공지사항 작성
							</h4>
							
							<br>
												
							<div class="col-md-12">
								<div class="card card-primary card-outline">
								
									<div class="card-header">
										<h3 class="card-title">Create a new notice</h3>
									</div>
										
										<!-- /.card-header -->
										<div class="card-body">
										
										 	
										
											<div class="form-group">
												<input class="form-control" name="noticeTitle" placeholder="TITLE">
											</div>
											                
											<div class="form-group">
												<textarea id="compose-textarea" class="form-control" name="noticeContents" style="height: 300px"></textarea>
											</div>
											
											<div class="form-group">
												<div class="btn btn-default btn-file">
													<i class="fas fa-paperclip"></i>파일첨부
													<input type="file" name="noticeFile">
												</div>
											</div>
										</div>
										<!-- /.card-body -->
										<div class="card-footer">
										                
											
											<div class="float-right">
											
												<input type="submit" class="linkBtn btn btn-info" value="등록" data-gopage="${cPath }/notice/noticeInsert.do">
												<input type="button" class="linkBtn btn btn-info" value="취소">
												
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