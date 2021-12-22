<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!-- 페이지 메인 문구 -->
<div class="container-fluid">
	<div class="row mb-2">
		<div class="col-sm-6">
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
					<div class="col-12" style="margin-top: 10px;">
						<h4>
							<i class="fas fa-chalkboard-teacher" style="margin-right: 10px;"></i> 회의록 목록
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
									  <div id="searchUI" class="form-inline" style="float: left">
										  <!-- 검색타입 -->
										  <div class="input-group input-group-sm" style="width: 100px;">
						                    <select name="searchType" class="form-control mr-3">
												<option value>전체</option>
												<option value="meetingTopic">제목</option>
												<option value="memId">작성자</option>
												<option value="meetingContent">내용</option>
											</select>
						                    </div>
										  <!-- 검색기능 -->
						                  <div class="input-group input-group-sm" style="width: 150px; float: right ">
						                    <input type="text" name="searchWord" class="form-control float-right" placeholder="Search">
						                    <div class="input-group-append">
						                      <input type="button" value="검색" id="searchBtn" class="btn btn-default">
						                    </div>
						                  </div>
						                 
					                  </div>
					                  
					                  <c:url value="/project/${project.pCode }/meeting/write.do" var="viewURL">
<%--                                                                   <c:param name="pCode" value="${project.pCode }" /> --%>
                                      </c:url>
					                   <!-- 등록 버튼 -->
						                <input id="createBtn" class="btn btn-info " type="button" value="등록하기" onclick="location.href='${viewURL }'">
						                  
					                    <br>
									<!-- 테이블 시작 -->
									<table class="table table-bordered table-striped">
										<thead>
											<tr>
												<th style="width: 10%">글번호</th>
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
			<!-- 글번호 -->									<td style="width: 20%">${meeting.meetingCode}</td>
															<td class="mettingTitle" style="text-align: left; padding-left: 30px; padding-right: 30px;">
																<c:url value = "select.do" var = "viewURL">
	   		<!-- 제목을 눌러 이동(글번호 상세목록으로) -->						<c:param name = "what" value = "${meeting.meetingCode}"/>
	   															</c:url>
																<a href = "${viewURL }">${meeting.meetingTopic }</a>
															</td>	
			<!--글쓴이-->									<td>${meeting.memNickname }</td>	
			<!--날짜 -->									<td>${meeting.meetingDate }</td>
														</tr>
													</c:forEach>
													
												</c:when>
												<c:otherwise>
													<tr>
														<td colspan="6" style="text-align: center;">게시글이 없습니다.</td>
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

<!--  -->
<form id="searchForm">
	<input type="hidden" name="searchType" />
	<input type="hidden" name="searchWord" />
	<input type="hidden" name="page" />
</form>

<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/commonjs/custom/paging.js"></script>
<script type="text/javascript">	
	$("[name='searchWord']").val("${searchVO.searchWord}");
	$("[name='searchType']").val("${searchVO.searchType}");
	let searchForm = $("#searchForm").paging();
</script>






