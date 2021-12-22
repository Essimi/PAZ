<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 
<style>
	.recipientsList{
		width: 35%;
	}
	.recipient{
		text-align: left;
		width: 35%;
	}
	.recipientRole, .recipientTd{
		text-align: center;
	}
	.mailbox-controls {
		height: 200px;
	}

/* 	.issueBoard{
		width: 80%;
	} */
	.contentWrapper{
		background-color: #f4f6f9;
	}
	
	#realDelete, #Pdelete{
		text-align: center;
	}
	
	#content {
		padding:30px;
	}
	
	.mailbox-read-info, .mailbox-controls {
		padding: 20px;
	}
	
	.table {
		text-align: center;
	}
	
	.card-primary.card-outline {
    	border-top: 3px solid #17a2b8;
	}
</style>
 
<security:authorize access="isAuthenticated()">
   <security:authentication property="principal.authMember" var="authMember"/>
</security:authorize>

    <div style="width: 100%;">
    
          <div class="card card-primary card-outline issueCard">
            <div class="card-header">
              <h3 class="card-title">이슈 상세 조회</h3>
            </div>
            
            
            <!-- /.card-header -->
            <div class="card-body p-0">
            
              <div class="mailbox-read-info">
                <h5 style="margin:10px 0px;">${issue.issueName }</h5>
                <h6 style="color:gray;">${issue.workName }[${issue.workCode }]</h6>
              </div>
              
              <div class="mailbox-read-info">

				<table class="table table-bordered issueBoard">
					<thead>
						<tr>	
							<th>작성자</th>
							<th>이슈유형</th>
							<th>중요도</th>
							<th>작성일</th>
						</tr>
					</thead>
					<tbody>
						<tr>	
							<td>${issue.memNickname }</td>
							<!-- 이슈 유형 -->
		                    <c:choose>
			                 	<c:when test="${issue.issueTypeCode eq 'ISSUE_TYPE001'}">
					            	<td><span class="badge bg-danger">버그</span></td>
			                 	</c:when>
			                 	<c:when test="${issue.issueTypeCode eq 'ISSUE_TYPE002'}">
					            	<td><span class="badge bg-warning">요청</span></td>
			                 	</c:when>
	                 		</c:choose>
		                    <!-- 중요도 -->
							 <c:choose>
			                 	<c:when test="${issue.importance eq 'IMPORTANCE001'}">
					            	<td><span class="badge bg-danger">긴급</span></td>
			                 	</c:when>
			                 	<c:when test="${issue.importance eq 'IMPORTANCE002'}">
					            	<td><span class="badge bg-warning">높음</span></td>
			                 	</c:when>
			                 	<c:when test="${issue.importance eq 'IMPORTANCE003'}">
					            	<td><span class="badge bg-primary">보통</span></td>
			                 	</c:when>
			                 	<c:when test="${issue.importance eq 'IMPORTANCE004'}">
					            	<td><span class="badge bg-success">낮음</span></td>
			                 	</c:when>
			                 </c:choose>
							<td>${issue.issueDate }</td>
						</tr>
					</tbody>
				</table>
                
              </div>
              <!-- 내용 -->
              <div class="mailbox-controls with-border">
                 <p>${issue.issueContents }</p>
              </div>
              <!-- 수신자 -->
              <div class="mailbox-read-message" style="background:#f7f7f7">
              	<div class="card recipientsList">
              
              <div class="card-body table-responsive p-0">
                <table class="table table-valign-middle">
                  <thead>
                  <tr>
                    <th>수신자</th>
                    <th class="recipientRole">역할</th>
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${issue.issueRecipients }" var="recipient">
                  <tr>
                    <td class="recipient">
                      <img alt="Product 1" class="img-circle img-size-32 mr-2"
                      		src="${cPath }/resources/file/profileImage/${recipient.saveName }" 
                      		onerror="this.src='${cPath }/resources/file/profileImage/profile.jpg'">
                      ${recipient.memNickname }
                      <c:if test="${recipient.outStatus eq '1'}">
                      	[탈퇴]
                      </c:if>
                    </td>
                    <td class="recipientTd">${recipient.position }</td>
                  </tr>
                  </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
            <!-- /.card -->
           	  </div>
              <!-- /.mailbox-read-message -->
            </div>
            <!-- /.card-body -->
            
            <!-- /.card-footer -->
            <div class="card-footer">
            
            <c:if test="${authMember.memId eq issue.memId}">
              <button id="editIssue" type="button" class="btn btn-default"><i class="fas fa-pencil-alt"></i> 수정</button>
              <button id="deleteIssue" type="button" class="btn btn-default" data-toggle="modal" data-target="#modal-danger"><i class="far fa-trash-alt"></i> 삭제</button>
            </c:if>
           
            </div>
            <!-- /.card-footer -->
          </div>
          <!-- /.card -->
        </div>
        
        <div class="modal fade" id="modal-danger">
		<div class="modal-dialog">
			<div class="modal-content bg-default">
				<div class="icon">
		<br><br>
			<h1 id="Pdelete"><i class="fas fa-exclamation-triangle icon"></i></h1>
		
		</div>
				<div class="modal-body">
				
					<p id="realDelete">정말 삭제하시겠습니까?</p>
				</div>
				<div class="modal-footer justify-content-between">
					<button type="button" class="btn btn" data-dismiss="modal">취소</button>
					<button type="button" class="linkBtn btn btn" id="realDelBtn">삭제</button>
				</div>
			</div>
		</div>
	</div>
        
