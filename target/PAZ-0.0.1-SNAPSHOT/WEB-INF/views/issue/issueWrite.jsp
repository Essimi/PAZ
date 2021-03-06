<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style>


	#content {
		padding: 30px;
	}
	
	.card-primary.card-outline {
		border-top: 3px solid #17a2b8;
	}
	
	.table {
		text-align: center;
	}
	
	.tableEdit {
		margin-bottom: 0;
	}
	#issueSpeaker, #issueHelper{
		margin-left : 1%;
		float: right;
	}
</style>
 
<security:authorize access="isAuthenticated()">
   <security:authentication property="principal.authMember" var="authMember"/>
</security:authorize>

    <div class="col-md-9" style="max-width: 100%; margin-top: 25px;">
    
          <div class="card card-primary card-outline">
            <div class="card-header">
	            <c:choose>
	            <c:when test="${empty issue }">
	              <h3 class="card-title">이슈 등록</h3>
	            </c:when>
	            <c:otherwise>
	              <h3 class="card-title">이슈 수정</h3>
	            </c:otherwise>
	            </c:choose>
	            <input type="button" id="issueSpeaker" class="btn btn-info" value="발표자">
	            <input type="button" id="issueHelper" class="btn btn-info" value="팀원">
            </div>
            
           	<form:form commandName="issue">
           
            <!-- /.card-header -->
            <div id="searchUI" class="card-body p-0">
            
              <div class="mailbox-read-info">
                <input name="issueName" type="text" style="margin:10px 0px; font-size:20px;  width:70%;" placeholder="이슈 제목을 입력하세요." 
                	value="${issue.issueName }"/>
                <br>
                <form:errors path="issueName" element="span" cssStyle="color: red"/>
                <input name="memId" type="hidden" value="${authMember.memId }">
                <div class="container" style="margin-left: 0;">

				  <!-- Trigger the modal with a button -->
				  <button style="width:200px; margin-top:20px;" type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#myModal">관련 업무 선택</button>
					<div id="topWorkCodeDiv">
						<c:if test="${!empty issue.workCode }">
							<p style='margin-top:10px;'>
								<i style='color:#dc3545; margin-right:10px;'class='fas fa-check'></i>
								${issue.workCode } - ${issue.workName }
							</p>
							<input type="hidden" name="workCode" value="${issue.workCode }">
							<input type="hidden" name="workName" value="${issue.workName }">
						</c:if>
						<form:errors path="workCode" element="span" cssStyle="color: red"/>
					</div>
				  <!-- Modal -->
				  <div class="modal fade" id="myModal" role="dialog">
				    <div class="modal-dialog modal-lg">
				    
				      <!-- Modal content-->
				      <div class="modal-content">
				        <div class="modal-header">
				          <h4 class="modal-title">관련 업무 선택</h4>
				          <button type="button" class="close" data-dismiss="modal">&times;</button>
				        </div>
				        
				        <!-- 상위 업무 검색 -->
				        <div class="modal-body">
				        
				        <div>
				        	<p>검색할 업무 이름을 입력하세요. </p>
				        </div>
				        
				         <div class="input-group input-group-sm">
		                  <input autocomplete="off" id="topWorkSearch" type="text" class="form-control">
		                  <span class="input-group-append">
		                    <button type="button" class="btn btn-default btn-flat">Go!</button>
		                  </span>
		                </div>
		                
		                
		                <div class="searchList card-body table-responsive p-0">
		                
		                	<table class="table table-hover text-nowrap" id="searchListTable">
		                		
		                	
		                	</table>
		                
		                </div>
		                
                            
				        </div>
				        
				        <div class="modal-footer">
				          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				        </div>
				      </div>
				      
				    </div>
				  </div>
				  
				</div>
                
              </div>
              
              <div class="mailbox-read-info">

				<table class="table table-bordered tableEdit">
					<thead>
						<tr>	
							<th style="width: 15%;">작성자</th>
							<th style="width: 15%;">이슈유형</th>
							<th style="width: 15%;">중요도</th>
							<th style="width: 10%;">작성일</th>
						</tr>
					</thead>
					<tbody>
						<tr>	
							<td style='vertical-align: middle;'>${authMember.memNickname }</td>
							<td>
								<select name="issueTypeCode" class="form-control custom-select">
						           <option value>유형</option>
						           <option value='ISSUE_TYPE001'>버그</option>
						           <option value='ISSUE_TYPE002'>요청</option>
					            </select>
				            </td>
				            <td>
					            <select name="importance" class="form-control custom-select">
						           <option value>중요도</option>
						           <option value='IMPORTANCE001'>긴급</option>
						           <option value='IMPORTANCE002'>높음</option>
						           <option value='IMPORTANCE003'>보통</option>
						           <option value='IMPORTANCE004'>낮음</option>
					            </select>
					        </td>
							<td id="currentDate" style="vertical-align: middle;"></td>
						</tr>
					</tbody>
				</table>
                <form:errors path="issueTypeCode" element="span" cssStyle="color: red"/>
               	<br>
                <form:errors path="importance" element="span" cssStyle="color: red"/>
              </div>
              <!-- 내용 -->
              <div class="mailbox-controls with-border">
              	<textarea id="compose-textarea" class="form-control" style="height: 300px; display: none;" value>
              		${issue.issueContents }
              	</textarea>
              </div>
              <form:errors path="issueContents" element="span" cssStyle="color: red"/>
              <!-- 수신자 -->
              <div class="mailbox-read-message" style="background:#f7f7f7; padding:20px;">
              	<div class="card">
<!--               <div class="card-header border-0"> -->
<!--                 <div class="card-tools"> -->
<!--                   <a href="#" class="btn btn-tool btn-sm"> -->
<!--                     <i class="fas fa-bars"></i>E -->
<!--                   </a> -->
<!--                 </div> -->
<!--               </div> -->
              <div class="card-body table-responsive p-0">
                <table class="table table-valign-middle">
                  <thead>
                  <tr>
                    <th>수신자</th>
                    <th>역할</th>
                    <th>체크</th>
                  </tr>
                  </thead>
                  <tbody id="recipientList">
                  <c:forEach items="${memList }" var="member">
	                  <c:if test="${member.outCode eq '0' and authMember.memId ne member.memId}">
		                  <tr>
		                    <td>
		                      <img alt="Product 1" class="img-circle img-size-32 mr-2"
		                      		src="${cPath }/resources/file/profileImage/${member.memIkon.saveName }" 
		                      		onerror="this.src='${cPath }/resources/file/profileImage/profile.jpg'">
		                      ${member.memNickname }
		                    </td>
		                    <td>${member.memRoles[0] }</td>
		                    <td>
		                    	<input type="checkbox" name="recipient" value="${member.memId }">
		                    </td>
		                  </tr>
	                  </c:if>
                  </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
            <c:if test="${!empty recipientsMsg }">
            	<span style="color: red">${recipientsMsg }</span>
            </c:if>
            <!-- /.card -->
           	  </div>
              <!-- /.mailbox-read-message -->
            </div>
            <!-- /.card-body -->
            </form:form>
            <!-- /.card-footer -->
            <div class="card-footer">
            <c:choose>
            <c:when test="${empty issue.issueCode }">
           		<button id="confirmIssue" type="button" class="btn btn-default"><i class="fas fa-pencil-alt"></i> 등록</button>
            </c:when>
            <c:otherwise>
           		<button id="confirmIssue" type="button" class="btn btn-default"><i class="fas fa-pencil-alt"></i> 수정</button>
            </c:otherwise>
            </c:choose>
            <button id="cancelIssue" type="button" class="btn btn-default"><i class="far fa-trash-alt"></i> 취소</button>
           
            </div>
            <!-- /.card-footer -->
          </div>
          <!-- /.card -->
        </div>
        
        <form id="issueForm" method="post">
        	<input type="hidden" name="issueName">
        	<input type="hidden" name="memId">
        	<input type="hidden" name="issueTypeCode">
        	<input type="hidden" name="importance">
        	<input type="hidden" name="issueContents">
        	<input type="hidden" name="workCode">
        	<input type="hidden" name="workName">
        	<input type="hidden" name="Recipients">
        </form>
        
