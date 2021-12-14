<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<!-- ******************************************************
현재 페이지는 로그인한 회원의 질문글만 보입니다. (삭제된 글은 조회 X)
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
							<i class="fas fa-chalkboard-teacher"></i> 고객센터 문의글 목록 [회원]
						<input type="button" class="linkBtn btn btn-warning btn-sm" id="QnA_WriteButton" value="문의하기" data-gopage="${cPath }/qna/qnaWrite.do"> 
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
									<table class="table table-bordered table-striped">
										<thead>
											<tr>
												<th>글번호</th>
												<th>제목</th>
												<th>작성자</th>
												<th>날짜</th>
											</tr>
										</thead>
										<c:set var="QnAList" value="${pagingVO.dataList}"></c:set>
										<tbody>
											<c:choose>
												<c:when test="${not empty QnAList }">
													<c:forEach items="${QnAList }" var="qna">
														<tr>
															<td>${qna.rnum }</td>
															<td style="text-align: left; padding-left: 20px;"><c:url value="qnaView.do" var="viewURL">
																	<c:param name="QnANo" value="${qna.qandaCode}" />
																</c:url> <a href="${viewURL }">${qna.qandaTitle }</a></td>
															<td>${qna.memId}</td>
															<td>${qna.qandaDate }</td>
														</tr>
													</c:forEach>
												</c:when>
												<c:otherwise>
													<tr>
														<td colspan="6">문의한 게시글이 없습니다.</td>
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
	</div>
</div>

<!-- 페이징 폼, 페이지 변환 -->
<form id="searchForm">
	<input type="hidden" name="page" />
</form>

<!-- 페이징 스크립트 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/commonjs/custom/paging.js"></script>

<!-- 페이징 스크립트, 페이지 변환 -->
<script type="text/javascript">
	let searchForm = $("#searchForm").paging();
</script>