<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
#pagingArea {
	background-color: white;
	float: right;
}
</style>

<!-- ******************************************************
 현재 페이지는 문의하기를 제외한 모든 버튼을 다 보이게 합니다.(관리자 페이지) 
****************************************************** -->

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
							<i class="fas fa-chalkboard-teacher"></i> 고객센터 전체 글 목록 입니다.(관리자)
							<small class="float-right"> 
							    <input type="button"class="linkBtn btn btn-info" value="전체 글 조회" data-gopage="${cPath }/project/qnaList.do">
								<input type="button"class="linkBtn btn btn-info" value="삭제된 글만 조회" data-gopage="${cPath }/project/qnaDeleteList.do">
								<input type="button"class="linkBtn btn btn-info" value="답변이 없는 글만 조회" data-gopage="${cPath }/project/qnaNotAnswerList.do">
							</small>
						</h4>
					</div>
				</div>

				<br>

				<!-- 테이블 구역 -->
				<div class="container-fluid">
					<div class="row">
						<div class="col-12">
							<div class="card">
								<div class="card-body">
									<!-- 테이블 시작 -->
									<table id="example1" class="table table-bordered table-striped">
										<thead>
											<tr>
												<th>글번호</th>
												<th>제목</th>
												<th>작성자</th>
												<th>날짜</th>
												<!-- <th>삭제 유무</th> -->
											</tr>
										</thead>
										<c:set var="QnAList" value="${pagingVO.dataList}"></c:set>
										<tbody>
											<c:choose>
												<c:when test="${not empty QnAList }">
													<c:forEach items="${QnAList }" var="qna">
														<tr>
															<td>${qna.rnum }</td>
															<td><c:url value="qnaView.do" var="viewURL">
																	<c:param name="QnANo" value="${qna.qandaCode}" />
																</c:url> <a href="${viewURL }">${qna.qandaTitle }</a></td>
															<td>${qna.memId }</td>
															<td>${qna.qandaDate }</td>
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
										<!-- dataTable Template 사용을 위한 tfoot 제거 -->
										   <%--  <tfoot>
											<tr>
												<td colspan="6">
													<div id="pagingArea" class="card-footer clearfix">${pagingVO.pagingHTML }</div>
												</td>
											</tr>
										</tfoot>  --%>
									</table>
									<div id="pagingArea" class="card-footer clearfix">${pagingVO.pagingHTML }</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 페이징 폼, 페이지 변환 -->
<form id="searchForm">
	<input type="hidden" name="page" />
</form>

<!-- 페이징 스크립트 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/custom/paging.js"></script>

<!-- 페이징 스크립트, 페이지 변환 -->
<script type="text/javascript">
	let searchForm = $("#searchForm").paging();
</script>

