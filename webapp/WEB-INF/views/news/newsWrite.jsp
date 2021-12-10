<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
#card{
width : 60%;

}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$('#summernote').summernote({
			
			height : 600,
			minHeight : null,
			maxHeight : null,
/* 			maxWidth : 500px, */
			focus : true,
			callbacks: {	//여기 부분이 이미지를 첨부하는 부분
				onImageUpload : function(files) {
					uploadSummernoteImageFile(files[0],this);
				},
				onPaste: function (e) {
					var clipboardData = e.originalEvent.clipboardData;
					if (clipboardData && clipboardData.items && clipboardData.items.length) {
						var item = clipboardData.items[0];
						if (item.kind === 'file' && item.type.indexOf('image/') !== -1) {
							e.preventDefault();
						}
					}
		
				}
			}
	});
		
		$('#summernote').summernote('insertImage', url, function ($image) {
			  $image.css('width', $image.width() / 3);
			  $image.attr('data-filename', 'retriever');
			});
	});
	
	

	
	 
	function uploadSummernoteImageFile(file, editor) {
		data = new FormData();
		data.append("file", file);
		$.ajax({
			data : data,
			type : "POST",
			dataType : "json",
			url : "${cPath}/news/uploadSummernoteImageFile.do",
			contentType : false,
			processData : false,
			success : function(data) {
				console.log(data)
            	//항상 업로드된 파일의 url이 있어야 한다.
				$(editor).summernote('insertImage', data.url);
			}
		});
	}
</script>


 <div class="content-wrapper">
 <div id="card">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>뉴스 등록</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">News write</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="card card-outline card-info">
				<div class="card-header">
					<h3 class="card-title">NEW NEWS!</h3>
				</div>
				<!-- /.card-header -->

				<form id = "newsForm" action="${cPath }/project/${project.pCode }/news/newsInsert.do" method="post">

					<div class="card-body">
						<textarea name = "newsContents" id="summernote" value>
                	내용을 입력해 주세요.
              </textarea>
              <br>
					<div class="row">
						<div class="col-12">
							<a href="${cPath }/project/${project.pCode }/news/newsList.do"
								class="btn btn-secondary">Cancel</a> 
							<input type="submit" value="SAVE" class="btn btn-success float-right">
						</div>
					</div>
					</div>

				</form>
			</div>
		</div>
		
		<!-- /.col-->
	</div>
</section>
</div>
</div>


