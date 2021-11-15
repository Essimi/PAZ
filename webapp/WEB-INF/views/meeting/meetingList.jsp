<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<style>
#pagingArea {
	background-color: white;
	float: right
}
</style>

<!-- 페이지 메인 문구 -->
<div class="container-fluid">
	<div class="row mb-2">
		<div class="col-sm-6">
			<h1>회의록</h1>
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
							<i class="fas fa-chalkboard-teacher"></i> 회의록 목록
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
										<c:set var="meetingList" value="${pagingVO.dataList}"></c:set>
										<tbody>
											<c:choose>
												<c:when test="${not empty meetingList }">
													<c:forEach items="${meetingList }" var="meeting">
														<tr>
															<td>${meeting.meetingCode}</td>
															<td>
																<c:url value = "select.do" var = "viewURL">
	   																	<c:param name = "what" value = "${meeting.meetingCode}"/>
	   															</c:url>
																<a href = "${viewURL }">${meeting.meetingTopic }</a>
															</td>	
															<td>${meeting.memId }</td>
															<td>${meeting.meetingDate }</td>
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
													<div id="pagingArea" class="card-footer clearfix">${pagingVO.pagingHTML }
														
														<div class="float-right">
																
																<c:url value="/meeting/write.do" var="viewURL">
                                                   					<c:param name="pCode" value="PROJECT00004" />
                                                				</c:url>
																<input type="button" value="등록하기" onclick="location.href='${viewURL }'">
														</div>
														
													</div>
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

<form id="searchForm">
	<input type="hidden" name="page" />
</form>
		

<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/custom/paging.js"></script>

<script type="text/javascript">
	let searchForm = $("#searchForm").paging();
</script>