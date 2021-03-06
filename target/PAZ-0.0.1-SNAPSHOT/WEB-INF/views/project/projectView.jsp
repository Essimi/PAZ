<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
	
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/commonjs/custom/jquery.form.min.js">
</script>	

<security:authorize access="isAuthenticated()">
	<security:authentication property="principal.authMember"
		var="authMember" />
</security:authorize>

<div class="row" id="monthIssueCardArea">
	<div class="col-md-12">
		<div class="card" id="monthIssueCard">
			<div class="card-header">
				<h5 class="card-title">프로젝트 업무</h5>
			</div>

			<div class="row" id="monthIssueCardBody">

				<div class="col-md-3 col-sm-6 col-12 firstInfo">
					<div class="info-box shadow-none">
						<span class="info-box-icon bg-info iconCss"><i class="fas fa-tasks"></i></span>
						<div class="info-box-content">
							<span class="info-box-text">총 업무 수량</span> <span class="info-box-number">${projectWorkCount.workCount } </span>
						</div>
					</div>
				</div>

				<div class="col-md-3 col-sm-6 col-12 firstInfo">
					<div class="info-box shadow-none">
						<span class="info-box-icon bg-warning iconCss"><i class="fas fa-thumbtack"></i></span>
						<div class="info-box-content">
							<span class="info-box-text">진행중인 업무 수량</span> <span class="info-box-number">${projectWorkCount.process }</span>
						</div>
					</div>
				</div>

				<div class="col-md-3 col-sm-6 col-12 firstInfo">
					<div class="info-box shadow-none">
						<span class="info-box-icon bg-success iconCss"><i
							class="fas fa-check"></i></span>
						<div class="info-box-content">
							<span class="info-box-text">완료된 업무 수량</span> <span class="info-box-number">${projectWorkCount.done }</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="card memberInfoCard">
	<div class="card-header">
		<h3 class="card-title">Projects Detail</h3>
		<div class="card-tools">
			<button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
				<i class="fas fa-minus"></i>
			</button>
			<button type="button" class="btn btn-tool" data-card-widget="remove" title="Remove">
				<i class="fas fa-times"></i>
			</button>
		</div>
	</div>
	<div class="card-body memberInfoCardBody">
		<div class="row memberInfoCardBodyRow">
			<div class="col-12 col-md-12 col-lg-4 order-1 order-md-2 colOver">
				<div class="row memberInfoCardBodyRow2">
					<div class="col-12">

						<!-- 프로젝트 참여자들을 불러오는 반복문 입니다. -->

						<c:forEach items="${memberList }" var="memberList">
							<div class="card post" style="padding:30px; border-left: 6px solid #3f6791bf; background: #fbfbfbc4;">
								<div class="user-block">
									<img class="img-circle elevation-2" src="${cPath }/resources/file/profileImage/${memberList.saveName }"
										onerror="this.src='${cPath }/resources/file/profileImage/profile.jpg'">
									<span class="username"> <a href="#">${memberList.memNickName }</a>
									</span> <span class="description">${memberList.position }</span>
								</div>
								<p><i class="fas fa-phone-alt" style="color : #3f6791; margin-right: 10px;"></i>${memberList.memTel}</p>
								<p><i class="fas fa-envelope" style="color : #ffc107; margin-right: 10px;"></i>${memberList.memMail}</p>
							</div>
						</c:forEach>

					</div>
				</div>
			</div>
			<div class="col-12 col-md-12 col-lg-8 order-2 order-md-1 colPadding">
				<h3 class="text-primary">
					<i class="fas fa-paint-brush"></i> ${projectAll.pTitle}
				</h3>
				<p class="text-muted">${projectAll.pContent }</p>
				
				<br>
				
				<div class="text-muted" style="margin-top: 20px">
					<p class="text-sm">
						프로젝트 시작 날짜 <b class="d-block">${projectAll.pStartDate }</b>
					</p>
					<p class="text-sm">
						프로젝트 마감 날짜 <b class="d-block">${projectAll.pEndDate }</b>
					</p>
				</div>

				<br>
				<br>

				<ul class="list-unstyled">
					<li><i class="far fa-fw fa-file-word"></i> ${projectAll.partName }</li>
				</ul>
			</div>
		</div>
	</div>
</div>


<!-- 공지사항 리스트 -->
<div class="row">

	<div class="co1 leftCard">
		<div class="col-md-12">
			<div class="card leftCardArea">
				<div class="card-header">
					<h5 class="card-title">프로젝트의 공지사항 리스트</h5>
				</div>

				<div class="row leftCardBody">
					<div class="card-body cardWidth">
					
						<!-- 프로젝트의 공지사항 리스트 입니다. -->
					
						<table class="table table-bordered table-striped" style="text-align: center;">
						
							<thead>
								<tr>
									<th style="width:15%;">글번호</th>
									<th>제목</th>
									<th style="width:20%">날짜</th>
								</tr>
							</thead>
							
							<tbody id="noticeBody">
								
							</tbody>
							
							<tfoot>
								<tr>
									<td colspan="6">
										<div id="pagingArea" class="card-footer clearfix"></div>
									</td>
								</tr>
							</tfoot>
							
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- 스케쥴 리스트 -->
	<div class="co1 rightCard">
		<div class="col-md-12">
			<div class="card rightCardArea">
				<div class="card-header">
					<h5 class="card-title">프로젝트의 스케쥴 리스트</h5>
				</div>

				<div class="row rightCardBody">
					<div class="row rightCardBodyrow">
						<div class="col-md-12 calendarList">
							<div class="timeline">
							
								<!-- 프로젝트의 스케쥴 리스트 입니다. -->

								<c:forEach items="${projectMainCalendarList }" var="projectMainCalendarList">
								
									<div id = "testDivID${projectMainCalendarList.pCode }">
										<div class="timeline-item">
											<span class="time">${projectMainCalendarList.scheduleDeadline }</span> 
											<span class="time"><i class="fas fa-clock" style = "margin-right: 12px; color:white"></i>${projectMainCalendarList.scheduleStart }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;~~~</span>
											<h3 class="timeline-header no-border">${projectMainCalendarList.scheduleName }</h3>
										</div>
									</div>

								</c:forEach>

								<div>
									<i class="fas fa-clock bg-gray"></i>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</div>


<!-- 프로젝트 이슈 리스트 -->
<div class="row projectIssueList">
	<div class="col-md-12 projectIssueListDiv">
		<div class="card" id="monthIssueCard" >
			<div class="card-header">
				<h5 class="card-title">프로젝트 긴급 이슈 리스트</h5>
			</div>
			<div class="card-body monthIssueCardBodyDiv">
				<table class="table table-bordered table-striped table-hover">
					<thead>
						<tr>
							<th>글번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>수신자</th>
						</tr>
					</thead>
					<tbody id="listBody">

						<!--  긴급 이슈 목록 List 입니다. -->
						
						<c:choose>
							<c:when test="${not empty mainIssueList}">
								<c:forEach items="${mainIssueList }" var="mainIssueList">
									<tr style = "cursor: pointer;">
										<td class = "issueCode" data-issuecode = "${mainIssueList.issueCode }">${mainIssueList.issueName }</td>
		
										<c:choose>
											<c:when test="${mainIssueList.issueTypeCode eq 'ISSUE_TYPE001'}">
												<td class = "issueTd"><span class="badge bg-danger issueTypeArea">버그</span></td>
											</c:when>
											<c:when test="${mainIssueList.issueTypeCode eq 'ISSUE_TYPE002'}">
												<td class = "issueTd"><span class="badge bg-success issueTypeArea">요청</span></td>
											</c:when>
										</c:choose>
		
										<td class = "issueTd">
											<ul class="list-inline">
												<li class="list-inline-item"><img alt="Avatar" class="table-avatar"
													src="${cPath }/resources/file/profileImage/${mainIssueList.saveName }" onerror="this.src='${cPath }/resources/file/profileImage/profile.jpg'"><br>
													<span class="badge badge-success">${mainIssueList.memNickname}</span>
												</li>
											</ul>
										</td>
		
										<td>
											<ul class="list-inline">
												<c:forEach items="${mainIssueList.issueRecipients }"
													var="issueRecipients">
													<li class="list-inline-item"><img alt="Avatar" class="table-avatar"
														src="${cPath }/resources/file/profileImage/${issueRecipients.saveName }" onerror="this.src='${cPath }/resources/file/profileImage/profile.jpg'"><br>
														<span class="badge badge-success">${issueRecipients.memNickname}</span>
													</li>
												</c:forEach>
											</ul>
										</td>
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
				</table>
			</div>
		</div>
	</div>
</div>


<form id="searchForm">
	<input type="hidden" name="page" />
</form>