<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
#contents{
width : 50%;
height: 30%;
}
</style>

<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1>NEWS</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">News</li>
					</ol>
				</div>
				<div>
					<button class="btn btn-primary btn-block" type="button" onclick="location.href='${cPath }/news/newsInsert.do' ">
						<i class="fa fa-bell"></i> 새로운 뉴스 등록하기
					</button>

				</div>


			</div>
		</div>
		<!-- /.container-fluid -->
	</section>

	<div class="row">
		<div class="col-md-6">
			<!-- Box Comment -->
			<div class="card card-widget">
				<div class="card-header">

					<c:set var="NewsList" value="${news.dataList }"></c:set>
					<c:choose>
						<c:when test="${not empty NewsList}">
							<c:forEach items="${NewsList}" var="news">
								<div class="user-block">
									<!-- 프로필 사진  -->
									<img class="img-circle" src="${cPath }/resources/adminLTE3/dist/img/농담곰2.jpg"
										alt="User Image">

									<!-- 유저 이름  -->
									<span class="username">${news.memId}</span> <span
										class="description">${news.newsDate}</span>
								</div>
								<div class="card-tools">

									<a class="btn btn-tool"
										data-card-widget="collapse" href="${cPath }/news/newsUpdate.do?newsCode=${news.newsCode}">
										<i class="far fa-edit"></i>
									</a>
									<a class="btn btn-tool"
										data-card-widget="remove" data-toggle="modal" data-target="#modal-danger" id="${news.newsCode}" >
										<i class="fas fa-times"></i>
									</a>
									</div>
								
								<div class="card-body">
									<a id="contents">${news.newsContents }</a>
									
								</div>
								<div class="card-footer card-comments">
                <div class="card-comment">
                  <!-- User image -->
                  <img class="img-circle img-sm" src="${cPath }/resources/adminLTE3/dist/img/농담곰2.jpg" alt="User Image">

                  <div class="comment-text">
                    <span class="username">
                      Maria Gonzales
                      <span class="text-muted float-right">8:03 PM Today</span>
                    </span><!-- /.username -->
                    It is a long established fact that a reader will be distracted
                    by the readable content of a page when looking at its layout.
                  </div>
                  </div>
                  <!-- /.comment-text -->
                </div>
								<div class="card-footer">

									<form action="${cPath }/news/newsReplyInsert.do" method="post">
										<img class="img-fluid img-circle img-sm"
											src="${cPath }/resources/adminLTE3/dist/img/농담곰2.jpg" alt="Alt Text">
										<!-- .img-push is used to add margin to elements next to floating images -->
										<div class="img-push">
											<input type="text" class="form-control form-control-sm"
												placeholder="Press enter to post comment">
										</div>
									</form>
								</div>
<br>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="2">조건에 맞는 게시글이 없음.</td>
							</tr>
						</c:otherwise>


					</c:choose>

					<!-- /.card-body -->
					<!-- /.card-comment -->
					<div class="card-footer card-comments">

						<!--         <div class="card-comment">
                  User image
                  <img class="img-circle img-sm" src="../dist/img/user3-128x128.jpg" alt="User Image"> -->

						<!--  <div class="comment-text">
                    <span class="username">
                      Maria Gonzales
                      <span class="text-muted float-right">8:03 PM Today</span>
                    </span>/.username
                    It is a long established fact that a reader will be distracted
                    by the readable content of a page when looking at its layout.
                  </div> -->
						<!-- /.comment-text -->


					</div>
					<!-- /.card-comment -->
				</div>
				<!-- /.card-footer -->

			</div>
			<!-- /.card-footer -->
		</div>
		<!-- /.card -->
	</div>
	<!-- /.col -->
	
	<div class="modal fade" id="modal-danger">
	<div class="modal-dialog">
		<div class="modal-content bg-danger">
			<div class="modal-header">
				<h4 class="modal-title">안내!</h4>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
			
				<p>정말 삭제하시겠습니까?</p>
			</div>
			<div class="modal-footer justify-content-between">
				<button type="button" class="btn btn-outline-light" data-dismiss="modal">취소</button>
				<button type="button" class="linkBtn btn btn-outline-light" id="realDelBtn">삭제</button>
			</div>
		</div>
	</div>
</div>
<script>


$('#modal-danger').on("show.bs.modal", function (event) {
	$(this).data("newsCode", event.relatedTarget.id)
})


	$("#realDelBtn").on("click", function(event) {
		
	let newsCode = $(this).parents('#modal-danger').data("newsCode")

	$.ajax({
			url : "${cPath}/news/newsDelete.do",

			data : {
				"newsCode" : newsCode
				
			},
			dataType: "json",
			success : function(resp) {
				
				alert(resp.message);
				
				if(resp.result == "OK"){
					/*${pageContext.request.contextPath}/calendar/calendarList.do */
				location.href = $.getContextPath() + resp.redirect;
				
				}

			},
			error : function(xhr, jQuery, error) {
				console.log(jQuery);
				console.log(error);
			}
		}) 
	}
)
</script>
