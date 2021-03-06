<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

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

#pagingArea {
	background-color: white;
	float: right;
}

#noticeButton {
	margin-top: 15px;
	height: 38px;
}

/* ------ */

#content {
	padding: 30px;
}

.invoice {
	padding: 30px;
	border-radius: 10px;
	border-top: 3px solid #3f6791;
}

.btnDiv {
	margin-bottom: 10px;
	float: right;
}

.noticeTitleA {
	color: black;
}

.noticeTitleA:hover {
	color:gray;
}
</style>

<!-- 메인페이지 시작 -->

<div class="row">
	<div class="col-12">
			<h1></h1>
	</div>
</div>

<div class="container-fluid">
	<div class="row">
		<div class="col-12">
			<!-- 메인 Content 시작 -->
			<div class="invoice mb-3">
				
				<div class="row">
					<div class="col-12 marginNotice">
						<h3><i class="fas fa-exclamation-circle"></i> 프로젝트 공지사항</h3>
					</div>
				</div>
				
				<!-- 테이블 구역 -->
				
						<div class="col-12">
							<div class="card">
								<div class="card-body">
								
								<div class="btnDiv">
									<input type="button"
											class="linkBtn btn btn-warning" id="noticeButton"
											value="공지작성" data-gopage="${cPath }/project/${project.pCode}/projectNotice/projectNoticeInsert.do">
								
								</div>
								
								
									<!-- 테이블 시작 -->
									<table class="table table-bordered table-striped">
									
										<thead style="text-align: center;">
											<tr>
												<th style="width: 10%;">글번호</th>
												<th style="width: 600px;">제목</th>
												<th>작성자</th>
												<th>날짜</th>
											</tr>
										</thead>
										
										<c:set var="noticeList" value="${pagingVO.dataList}"></c:set>
										
										<tbody style="text-align: center;">
											<c:choose>
											
												<c:when test="${not empty noticeList}">
													<c:forEach items="${noticeList}" var="notice">
													<tr>
														<td>${notice.rnum }</td>
														
														<td style="text-align: left; padding-left: 20px;">
														
															<c:url value="projectNoticeSelect.do" var="viewURL">
																<c:param name="noticeCode" value="${notice.noticeCode }" />
															</c:url>
															
															<a class="noticeTitleA" href="${viewURL }">${notice.noticeTitle}</a>

														</td>
														
														<td>${notice.memId }</td>
														<td>${notice.noticeDate }</td>
													</tr>
													</c:forEach>
												</c:when>
												
												<c:otherwise>
													<tr>
														<td colspan="6">게시글이 없습니다.</td>
													</tr>
												</c:otherwise>
											</c:choose>
										</tbody>
										
										
										<tfoot>
										
											<tr>
											
											<td colspan="6">
											
											
											
											<div id="pagingArea" class="card-footer clearfix">${pagingVO.pagingHTML }</div>
											
											</td>
											
											</tr>
										</tfoot>
										
									</table>
								</div>
							</div>
						</div>
					
			</div>
		</div>
	</div>
</div>

<form id="searchForm">
	<input type="hidden" name="page" />
</form>


<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/commonjs/custom/paging.js">
</script>

<script type="text/javascript">
	let searchForm = $("#searchForm").paging();
</script>