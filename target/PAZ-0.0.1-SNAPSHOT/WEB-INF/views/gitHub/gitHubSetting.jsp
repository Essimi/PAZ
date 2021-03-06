<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<input type="hidden"  id="gitID" value="${git.userName}">
<input type="hidden"  id="gitREPO" value="${git.repository}">
<input type="hidden"  id="gitToken" value ="${token }">

<!-- 페이지 메인 문구 -->
<div class="container-fluid">
	<div class="row mb-2">
		<div class="col-sm-6">
			<h1>Git Connect</h1>
		</div>
	</div>
</div>

<!-- 메인페이지 시작 -->
<div class="container-fluid" >
	<div class="row">
		<div class="col-12" >
			<!-- 메인 Content 시작 -->
			<div class="invoice p-3 mb-3" >

				<div class="row">
                    <!-- 프로젝트 연동 시작 -->
                    
                    <c:set var="reponame" value="${git.repository}"></c:set>
                    
                    <c:choose>
	                    <c:when test = "${not empty reponame }">
							<div class="col-12">
								<h4>
									<i class="fas fa-chalkboard-teacher"></i> ${git.repository}
									<small class="float-right">연동 일자 : ${git.gitDate }</small>
								</h4>
							</div>
						</c:when>
						
						<c:otherwise>
							<div class="col-12">
								<h4>
									<i class="fas fa-chalkboard-teacher"></i> 연동된 프로젝트가 없습니다.
								</h4>
							</div>
						</c:otherwise>	
					</c:choose>
												
				</div>

                <!-- 연동 Modal Info -->
				<div class="modal fade" id="modal-lg">
					<div class="modal-dialog modal-lg">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title">레파지토리 연동 모달창</h4>
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							
							<div class="float-right">
								<input type = "button" id = "insertData" value = "TEST" class = "btn btn-info" style = "margin: 10px;">
							</div>
								
							<div class="modal-body modalBody">
								
								<div class="form-group-id">
									<label>Git User ID</label> <br>
									
									<div class="inputDiv">
										<input type="text" id="inputGitId" class="form-control">
										<button id = "gitCheckBtn" class = "btn btn-block btn-info" onclick = "gitCheckId()">확인</button>
									</div>
									
									<div class="checkDiv">
										<i id = "checkIcon"></i>
									</div>
									
								</div>
								<div class="form-group-repo">
									<label>Git Repo</label> <br>
									
									<div class="inputDiv">
										<input type="text" id="inputGitRepo" class="form-control">
										<button id = "gitCheckBtn" class = "btn btn-block btn-info" onclick = "gitCheckRepo()">확인</button>
									</div>
									
									<div class="checkDiv">
										<i id = "checkIcon"></i>
									</div>
									
								</div>
								<!-- 토큰이 연동에 필요한건 아니지만, 미입력시 commit, delete 등 수정에 관한 전반적인 작업을 할 수 없습니다. -->
								<!-- 조회는 가능 -->
							    <!-- <div class="form-group">
									<label>토큰</label><small id = "smallInfo">미입력시 commit, delete 등 수정에 관한 전반적인 작업을 할 수 없습니다.</small> <br>
									<input type="text" id="inputGitToken" class="form-control">
									<button id = "gitCheckBtn" class = "btn btn-block btn-info" onclick = "gitCheckToken()">확인</button>
									<i></i>
								</div> -->
							</div>
							<div class="modal-footer justify-content-between">
								<button type="button" class="btn btn-default" data-dismiss="modal">나가기</button>
								<button id = 'gitInfoSaveBtn' type="button" class="btn btn-warning" disabled>저장</button>
							</div>
						</div>						
					</div>					
				</div>
				<!-- ***************************** -->

                <!-- 해제 Modal Info -->
				<div class="modal fade" id="modal-danger">
					<div class="modal-dialog">
						<div class="modal-content bg-danger">
							<div class="modal-header">
								<h4 class="modal-title">해제 연동 모달</h4>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<p>정말 연동을 해제하시겠습니까?</p>
							</div>
							<div class="modal-footer justify-content-between">
								<button type="button" class="btn btn-outline-light"
									data-dismiss="modal">나가기</button>
								<button id = 'gitInfoDeleteBtn' type="button" class="btn btn-outline-light">해제</button>
							</div>
						</div>
					</div>
				</div>
                <!-- ***************************** -->



                <!-- 데이터 테이블 구역 -->
				<div class="container-fluid">
					<div class="row">
						<div class="col-12">
							<div class="card">
								<div class="card-body">
									<c:choose>
							        	<c:when test = "${empty reponame }">
											<button type="button" class="gitSettingBtn btn btn-default" data-toggle="modal"
												data-target="#modal-lg" id = "btn1">연동하기</button>
										</c:when>
							
						                <c:when test = "${not empty reponame }">
											<button type="button" class="gitSettingBtn btn btn-danger" data-toggle="modal"
												data-target="#modal-danger" id = "btn2">해제하기</button>
										</c:when>
									</c:choose>	
								    <!-- 테이블 시작 -->
									<table id="example1" class="table table-head-fixed text-nowrap">
										<thead>
											<tr>
												<th>순번</th>
												<th>Id</th>
												<th>Email</th>
												<th>message</th>
												<th>Date</th>
											</tr>
										</thead>
										<tbody id = "commitList">
											
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<br>
				
			    <!-- 코드 수 구역 -->
				<div class="col-6">
					<div class="col-12">
						<h4>
							<i class="fab fa-node-js"></i> Code List
						</h4>
					</div>

					<div class="table-responsive">
						<table class="table" id = "languageCode">
							
						</table>
					</div>
				</div>
				<!-- 종료 -->
			</div>
		</div>
	</div>
</div>

<!-- 메인페이지 종료 -->