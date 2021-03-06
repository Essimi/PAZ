<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

  <security:authorize access="isAuthenticated()">
     <security:authentication property="principal.authMember" var="authMember"/>
  </security:authorize>
  

<style>


#requestListDiv {
	height: 300px;
	overflow-y: overlay;
}

::-webkit-scrollbar {
	width: 3px;
	background: none;
}

#requestListText {
	padding-left: 25px;
	padding-top: 20px;
	margin-bottom: -15px;
}

.pTitle {
	font-size: 25px;
}

.sender {
	font-size: 15px;
}

body:not(.sidebar-mini-md):not(.sidebar-mini-xs):not(.layout-top-nav) .content-wrapper,
	body:not(.sidebar-mini-md):not(.sidebar-mini-xs):not(.layout-top-nav) .main-footer,
	body:not(.sidebar-mini-md):not(.sidebar-mini-xs):not(.layout-top-nav) .main-header
	{
	margin-left: 0px;
}

#content {
	padding: 50px;
}

#plus {
	font-size: 50px;
	color: #ffc107;
	text-shadow: 0px 1px 1px #cbc8c8;
}


/* 여기부터  */

.myform fieldset{
    display: inline-block; /* 하위 별점 이미지들이 있는 영역만 자리를 차지함.*/
    direction: rtl; /* 이모지 순서 반전 */
    border: 0; /* 필드셋 테두리 제거 */
}
.myform fieldset legend{
    text-align: left;
}
.myform input[type=radio]{
    display: none; /* 라디오박스 감춤 */
}
.myform label{
    font-size: 2em; /* 이모지 크기 */
    color: transparent; /* 기존 이모지 컬러 제거 */
    text-shadow: 0 0 0 #f0f0f0; /* 새 이모지 색상 부여 */
}
.myform label:hover{
    text-shadow: 0 0 0 #ffc107; /* 마우스 호버 */
}
.myform label:hover ~ label{
    text-shadow: 0 0 0 #ffc107; /* 마우스 호버 뒤에오는 이모지들 */
}
.myform input[type=radio]:checked ~ label{
    text-shadow: 0 0 0 #ffc107; /* 마우스 클릭 체크 */
}
    
.reviewTable {
	width: 100%;
	text-align: center;
}


.reviewRating {
	margin:30px 0px;
}
  
.reviewText{
	padding: 30px;
	text-align: left;

}

.tableMenu {
	text-align: left;
	padding-left: 40px;
}

.modal-footer {
	display: block;
}
  
</style>

<script>

	$(function() {
		if(${reviewStatus}  == '1') {
			$('#addMember').trigger("click"); 
		}
		
		
		$('#saveBtn').on('click', function() {

			var review = {
					"kanbanGrade" : $('#kanbanForm').text(),
					"ganttchartGrade" : $('#ganttChartForm').text(),
					"workGrade" : $('#taskForm').text(),
					"codeGrade" : $('#codeReviewForm').text(),
					"chatGrade" : $("#chatForm").text(),
					"gitGrade" : $("#gitForm").text(),
					"feedback" : $('#feedbackInput').val()
			}

			
			 	// ajax 로 '0'으로 업데이트 시키기
				$.ajax({
					 url:"${cPath}/review/reviewUpdate.do",
					 data: review,
					 success : function(resp) { 
						 if(resp == "OK"){
							 alert("리뷰가 등록되었습니다.");
							 location.reload()
						 }else {
							 alert("리뷰 등록을 실패했습니다.")
						 }
						console.log(resp);
					},
					error : function(xhr, jQuery, error) {
						console.log(jQuery);
						console.log(error);
					}
					
				})   
		})
		
	})
	
	
	$('#reviewDeleteBtn').on('click', function () {
		$.ajax ({
			url:"${cPath}/review/reviewDelete.do",
			success : function () {
				
			}
		})
		
	})

	

</script>



<button id="addMember" type="button" hidden="hidden" class="btn btn-default btn-sm" data-toggle="modal" data-target="#myModal"></button>


				<!-- Modal -->
				<div id="myModal" class="modal fade" role="dialog">
				  <div class="modal-dialog" style="max-width: none; text-align: -webkit-center;">
				
				    <!-- Modal content-->
				    <div class="modal-content" style="padding:30px; border-top: 5px solid #f39c12; border-radius: 10px; width:600px;">
				      <!-- <div class="modal-header">
				        <h4 class="modal-title">프로젝트 멤버 추가</h4>
				        <button type="button" class="close" data-dismiss="modal">&times;</button>
				      </div> -->
				     
				     
				      <div class="modal-body" style="padding: 30px;">
					        
					     <div style="text-align:center;">
					     	<h2 style="font-weight: 600;"> 딱 한번 <i class="fas fa-check" style="color: #e74c3c; margin-left: 10px;"></i></h2>
					     	<h3> 리뷰를 작성할 수 있는 기회! </h3>
					     </div>
					        
					   <div class="reviewRating">
					    <div>
					    	
						    <form name="myform"  class="myform" method="post" action="./save">
						    	<table class="reviewTable" >
						    		<tr>
						    			<td class="tableMenu" style="width:50%">칸반 기능은 어떠셨나요 ? </td>
						    			<td> <fieldset>
										        <input type="radio" name="rating" value="5" id="kanban1"><label for="kanban1">⭐</label>
										        <input type="radio" name="rating" value="4" id="kanban2"><label for="kanban2">⭐</label>
										        <input type="radio" name="rating" value="3" id="kanban3"><label for="kanban3">⭐</label>
										        <input type="radio" name="rating" value="2" id="kanban4"><label for="kanban4">⭐</label>
										        <input type="radio" name="rating" value="1" id="kanban5"><label for="kanban5">⭐</label>
										    </fieldset>
										    <div id="kanbanForm" hidden="hidden"></div>
							    		</td>
						    		</tr>
						    	</table>
						    	
							   
							</form>
					    
					    </div>
				      
						
						<div>
						
						
							<form name="myform" class="myform" method="post" action="./save">
							
								<table class="reviewTable">
						    		<tr>
						    			<td class="tableMenu" style="width:50%">간트차트 기능은 어떠셨나요 ? </td>
										<td>		
										    <fieldset>
										        <input type="radio" name="rating" value="5" id="ganttchart1"><label for="ganttchart1">⭐</label>
										        <input type="radio" name="rating" value="4" id="ganttchart2"><label for="ganttchart2">⭐</label>
										        <input type="radio" name="rating" value="3" id="ganttchart3"><label for="ganttchart3">⭐</label>
										        <input type="radio" name="rating" value="2" id="ganttchart4"><label for="ganttchart4">⭐</label>
										        <input type="radio" name="rating" value="1" id="ganttchart5"><label for="ganttchart5">⭐</label>
										    </fieldset>
										    <div id="ganttChartForm"  hidden="hidden" ></div>
										</td>
									  </tr>
								</table>
							</form>
						</div>
						
						
						<div>
							<form name="myform" class="myform" method="post" action="./save">
								
								<table class="reviewTable" >
						    		<tr>
						    			<td class="tableMenu" style="width:50%">업무 기능은 어떠셨나요 ? </td>
						    			
										<td>	
								   		 <fieldset>
									        <input type="radio" name="rating" value="5" id="task1"><label for="task1">⭐</label>
									        <input type="radio" name="rating" value="4" id="task2"><label for="task2">⭐</label>
									        <input type="radio" name="rating" value="3" id="task3"><label for="task3">⭐</label>
									        <input type="radio" name="rating" value="2" id="task4"><label for="task4">⭐</label>
									        <input type="radio" name="rating" value="1" id="task5"><label for="task5">⭐</label>
									     </fieldset>
								    	 <div id="taskForm"  hidden="hidden"></div>
								    	</td>
								    	
								    </tr>
								 </table>
							</form>
						</div>
						
						
						
						
					<div>
						
						
						<form name="myform" class="myform" method="post" action="./save">
							<table class="reviewTable" >
					    		<tr>
					    			<td class="tableMenu" style="width:50%">코드리뷰 기능은 어떠셨나요 ? </td>
					    			
									<td>	
									    <fieldset> 
									        <input type="radio" name="rating" value="5" id="codeReview1"><label for="codeReview1">⭐</label>
									        <input type="radio" name="rating" value="4" id="codeReview2"><label for="codeReview2">⭐</label>
									        <input type="radio" name="rating" value="3" id="codeReview3"><label for="codeReview3">⭐</label>
									        <input type="radio" name="rating" value="2" id="codeReview4"><label for="codeReview4">⭐</label>
									        <input type="radio" name="rating" value="1" id="codeReview5"><label for="codeReview5">⭐</label>
									    </fieldset>
									    <div  id="codeReviewForm"  hidden="hidden"></div>
									</td>
								</tr>
							</table>
						</form>
					</div>



	
					<div>
						<form name="myform" class="myform" method="post" action="./save">
							<table class="reviewTable" >
					    		<tr>
					    			<td class="tableMenu" style="width:50%">채팅 기능은 어떠셨나요 ? </td>
					    			
									<td>	
									    <fieldset>
									        <input type="radio" name="rating" value="5" id="chat1"><label for="chat1">⭐</label>
									        <input type="radio" name="rating" value="4" id="chat2"><label for="chat2">⭐</label>
									        <input type="radio" name="rating" value="3" id="chat3"><label for="chat3">⭐</label>
									        <input type="radio" name="rating" value="2" id="chat4"><label for="chat4">⭐</label>
									        <input type="radio" name="rating" value="1" id="chat5"><label for="chat5">⭐</label>
									    </fieldset>
									    <div id="chatForm"  hidden="hidden"></div>
								   </td>
								</tr>
							</table>
						</form>
					</div>
						
						
					<div>
						
						
						<form name="myform" class="myform" method="post" action="./save">
							
							<table class="reviewTable" >
					    		<tr>
					    			<td class="tableMenu" style="width:50%">깃허브 기능은 어떠셨나요 ? </td>
					    			
									<td>	
									    <fieldset>
									        <input type="radio" name="rating" value="5" id="git1"><label for="git1">⭐</label>
									        <input type="radio" name="rating" value="4" id="git2"><label for="git2">⭐</label>
									        <input type="radio" name="rating" value="3" id="git3"><label for="git3">⭐</label>
									        <input type="radio" name="rating" value="2" id="git4"><label for="git4">⭐</label>
									        <input type="radio" name="rating" value="1" id="git5"><label for="git5">⭐</label>
									    </fieldset>
									    <div id="gitForm"  hidden="hidden"></div>
								   </td>
								</tr>
							</table>
						</form>
					</div>
					
					</div>
					
					<hr>
					
					<div class="reviewText">
						<h4 style="margin-bottom: 10px; font-weight: 600; color:#343a40;">개선사항<span style="color:gray; font-size:13px; margin-left:10px;">선택항목</span></h4>
						<input id="feedbackInput" type="text" class="form-control" placeholder="ex) 환불 처리가 느려요." style="width: 100%;"/>
					</div>
									        
				      </div>
				      <div class="modal-footer">
				        <button id="reviewDeleteBtn" type="button" class="btn btn-default btn-sm modalBtn" data-dismiss="modal" style="float: left;">다시는 보지않기</button>
				        <button type="button" class="btn btn-default btn-sm modalBtn" data-dismiss="modal" style="float: right;">닫기</button>
				        <button id="saveBtn" type="button" class="btn btn-info btn-sm toastrDefaultSuccess modalBtn" style="float: right;">확인</button>
				      
				      </div>
				    </div>
				
				  </div>
				</div>

<script>

	$('input:radio[name=rating]').on('click', function() {
		$(this).parent().next().empty();
		$(this).parent().next().append($(this).val())

	})
  
	$('.modal').on('hidden.bs.modal', function (e) {
	    console.log('modal close');
	    $(this).find('form')[0].reset()
	});
	
	$('#myModal').on('hidden.bs.modal', function () {
  /* 	  location.reload(); */
  	})
  


</script>



	<!-- 내 프로젝트 요청 리스트 -->
	<div id="requestListText">
		<h3>프로젝트 요청 리스트</h3>
		<hr style="margin-left: -25px;">
	</div>
	<div id="requestListDiv">
		<div class="card-body pb-0">
			<c:set var="requestList" value="${requestListList}"></c:set>
			<c:choose>
				<c:when test="${not empty requestList }">
					<c:forEach items="${requestList}" var="request1">
						<div class="card bg-light d-flex flex-fill">
							<div class="card-header text-muted border-bottom-0">${request1.partName }
							</div>
							<div class="card-body pt-0">
								<div class="row">
									<div class="col-7">
										<h2 class="lead pTitle">
											<b>${request1.pTitle }</b>
										</h2>
									</div>
								</div>
							</div>
							<div class="card-footer">
								<ul class="ml-4 mb-0 fa-ul text-muted">
									<li class="small sender"><span class="fa-li"><i class="fas fa-hand-holding-heart"></i></span> 요청 발신자 : ${request1.sender }</li>
									<li class="small sender"><span class="fa-li"><i class="fas fa-id-card"></i></span> 역할 : ${request1.position }</li>

								</ul>
								
								<div class="text-right">

									<!-- 수락 거절 -->
									<a data-value="${request1.pCode },${request1.reqCode },${request1.position}" class="btn btn-sm bg-teal requestBtn requestOk" style="width:100px;"> <i
										class="fas fa-check"></i></a> 
									<a data-value="${request1.pCode },${request1.reqCode },${request1.position}" class="btn btn-sm bg-red requestBtn requestFaild" style="width:100px;"> <i class="fas fa-times"></i></a>

									<!-- 팀 구성원 뽑아오기 -->
									<!-- a href="#" title="프로젝트 멤버" data-toggle="popover" data-placement="top" data-content=""
										class="btn btn-sm btn-primary memListBtn"> <i class="fas fa-user"></i>Member</a> -->
								</div>
							</div>
						</div>
					</c:forEach>
				</c:when>

				<c:otherwise>
					<p style="text-align: center; margin-top: 100px; color: gray;">
						프로젝트 초대 요청이 없습니다.</p>
				</c:otherwise>

			</c:choose>

		</div>
	</div>
	
	<br>
	<br>
	
	<!-- 프로젝트 요청 리스트 끝 -->
	
<!-- 내 프로젝트 리스트 -->
	<div class="content-wrapper" style="padding: 20px;">
		<section class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<h1>나의 프로젝트 리스트</h1>
					</div>
				</div>
			</div>
		</section> 
		<div class="card">
			<div class="card-header">
				<h3 class="card-title">Projects</h3>
			</div>
			
			<div class="card-body p-0">
				<table class="table table-striped projects">
					<thead>
						<tr>
							<th style="width: 1%">No</th>
							<th style="width: 20%">프로젝트 명 </th>
							<th style="width: 50%">팀원</th>
							<th style="width: 8%" class="text-center">현황</th>
							<th style="width: 20%"></th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${not empty dataList}">
								<c:forEach items="${dataList }" var="projectdata">
								<c:set var="cre"
									value="${fn:replace(projectdata.pCreateDate,'-','')}"></c:set>
								<c:set var="sta"
									value="${fn:replace(projectdata.pStartDate,'-','')}"></c:set>
								<c:if test="${projectdata.statusCode ne 'PROJECT_STATE004' }">
										
											<tr>
												<td class = "testPCode">${projectdata.pCode}</td>
												<td><a> ${projectdata.pTitle}</a></td>
												<td>
													<ul class="list-inline">
														<c:forEach items="${projectdata.projectMember }" var="member">
															<li class="list-inline-item">
																<img alt="Avatar" class="table-avatar" 
																	src="${cPath }/resources/file/profileImage/${member.memIkon.saveName }"
																	onerror="this.src='${cPath }/resources/file/profileImage/profile.jpg'"><br>
																<span class="badge badge-success">${member.memNickname}</span>
															</li>
														</c:forEach>
													</ul>
												</td>
		

														
												<!-- 프로젝트 상태 조건문 출력 -->
												<td class="project-state">
													<button class="btn btn-success" >
														진행중
													</button>	
												</td>
												
												<td class="project-actions text-right"><a data-value="${projectdata.pCode }" class="btn btn-primary btn-sm projectView"> <i
														class="fas fa-folder"> </i></a> 
												<c:choose>
													<c:when test="${not empty plList}">
														<c:forEach items="${plList }" var="plCode">
															<c:set var="plText" value="${plCode.pCode }"/>
															<c:if test="${projectdata.pCode eq plText}">
																<a data-value="${projectdata.pCode}" class="btn btn-info btn-sm projectEdit"> <i class="fas fa-pencil-alt"></i> </a>
																<a data-value="${projectdata.pCode}" class="btn btn-danger btn-sm projectDelete"> <i class="fas fa-trash"></i> </a>
															</c:if>
														</c:forEach>
													</c:when>
												</c:choose>
												<form class="viewForm" action="${cPath }/project/${projectdata.pCode}/projectView.do">
													<input type="hidden" name="memId" class="memIdValue" /> <input type="hidden" name="pCode" class="pCodeValue" />
												</form></td>
											</tr>
										</c:if>
									
								</c:forEach>
							</c:when>
						</c:choose>
					</tbody>
				</table>
			</div>
		</div>
		<div style="text-align: center;">
			<a href="${cPath }/project/projectInsert.do" id="plus"> <i
				class="fas fa-plus-square"></i>
			</a>
		</div>
	</div>
	
	<form id="updateForm" action="${cPath }/project/projectUpdate.do"
		method="post">
		<input type="hidden" name="value" id="updateValue" />
	</form>
	
	
<script>
		$(document).ready(function() {
			$('[data-toggle="popover"]').popover();
		});

		$(".requestOk").on("click", function() {

			console.log($(this).attr('data-value'));

			$.ajax({
				url : "${cPath}/project/requestProject.do",
				data : {
					"value" : $(this).attr('data-value'),
					"memId" : "${requestList.get(0).getMemId()}",
					"msg" : "ok"
				},
				success : function(resp) {
					alert("프로젝트 초대 요청을 수락하셨습니다.");
					location.reload();
				},
				error : function(xhr, jQuery, error) {
					console.log(jQuery);
					console.log(error);
				}

			})
		})

		$(".requestFaild").on("click", function() {

			$.ajax({
				url : "${cPath}/project/requestProject.do",
				data : {
					"value" : $(this).attr('data-value'),
					"memId" : "${requestList.get(0).getMemId()}",
					"msg" : "faild"
				},
				success : function(resp) {
					alert("프로젝트 요청을 거절했습니다. ");
					location.reload();
					console.log(resp);
				},
				error : function(xhr, jQuery, error) {
					console.log(jQuery);
					console.log(error);
				}

			})
		})
	
		$(".projectDelete").on("click", function() {

			if (confirm("정말 삭제하시겠습니까?")) {

				$.ajax({
					url : "${cPath }/project/projectDelete.do",
					data : {
						"value" : $(this).attr('data-value')
					},
					success : function(resp) {
						alert("프로젝트가 삭제되었습니다.");
						location.reload();
						console.log(resp);
					},
					error : function(xhr, jQuery, error) {
						console.log(jQuery);
						console.log(error);
					}

				})
			}

		})

		$(".projectEdit").on("click", function() {

			console.log("누름 ");

			var dataValue = $(this).attr('data-value');

			console.log(dataValue);

			$("#updateValue").attr("value", dataValue);

			console.log($("#updateValue").attr('value'));

			$("#updateForm").submit();

		})

		$(".projectView").on("click", function() {

			var dataValue = $(this).attr('data-value');
			var form = $(this).siblings('form');

			console.log('${authMember.memId}');
			console.log(dataValue);

			form.children(".memIdValue").attr("value", '${authMember.memId}');
			form.children(".pCodeValue").attr("value", dataValue);

			form.submit();

		})
		
		
	</script>