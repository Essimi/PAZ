<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<style>

body {
	overflow-x:hidden;
}

#pagingArea {
	background-color: white;
	float: right;
}

#noticeButton {
	margin-top: 15px;
	height: 38px;
}

body:not(.sidebar-mini-md):not(.sidebar-mini-xs):not(.layout-top-nav) .content-wrapper,
	body:not(.sidebar-mini-md):not(.sidebar-mini-xs):not(.layout-top-nav) .main-footer,
	body:not(.sidebar-mini-md):not(.sidebar-mini-xs):not(.layout-top-nav) .main-header
	{
	margin-left: 0px;
}

.container-fluid {
	padding-left: 280px;
}

.fas {
	margin-left: 10px;
}

.marginNotice {
	margin-top: 8px;
	margin-bottom: 8px;
}


#content {
	padding: 30px 100px;
}

.container-fluid {
	padding-left: 0;
}

.invoice {
	padding: 30px;
    width: 100%;
    border-radius: 10px;
    
    border-top: 3px solid #17a2b8;
}

td a {
	color:black;
}

td a:hover {
	color: gray;
}


.insertBtn {
	float: right;
	margin-bottom: 10px;
}
</style>

<!-- 메인페이지 시작 -->

<div class="row">
	<div class="col-12">
			<h1 style="margin:20px 0px;">Notice</h1>
	</div>
</div>

<div class="container-fluid">
	<div class="row" style="justify-content: center;">
		<div style="width:100%;">
			<!-- 메인 Content 시작 -->
			<div class="invoice mb-3">
				
				<div class="row">
					<div class="col-12 marginNotice">
						<h3><i class="fas fa-exclamation-circle"></i> 공지사항</h3>
					</div>
				</div>
				
				<!-- 테이블 구역 -->
				
						<div class="col-12">
							<div class="card" style="margin:20px;">
								<div class="card-body">
								
								<div class="insertBtn">
								
									<security:authorize access="isAuthenticated()">
										<security:authentication property="principal.authMember" var="authMember"/>
									</security:authorize>
									
									<c:set var="memId" value="${authMember.memId }" />
									
									<c:if test="${ memId eq 'admin' }">
									
										<input type="button"
										class="linkBtn btn btn-warning" id="noticeButton"
										value="공지작성" data-gopage="${cPath }/notice/noticeInsert.do">
									
									</c:if>
								</div>
								
								
									<!-- 테이블 시작 -->
									<table class="table table-bordered table-striped">
									
										<thead style="text-align: center;">
											<tr>
												<th>글번호</th>
												<th>제목</th>
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
														
														<td style="text-align: left; padding-left: 20px; padding-right: 20px;">
														
															<c:url value="notice.do" var="viewURL">
																<c:param name="noticeCode" value="${notice.noticeCode }" />
															</c:url>
															
															<a href="${viewURL }">${notice.noticeTitle}</a>

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