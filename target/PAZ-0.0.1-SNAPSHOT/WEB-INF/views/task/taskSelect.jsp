
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 


    <div class="col-md-9" style="max-width: 100%; margin-top: 25px;">
    
          <div class="card card-primary card-outline">
            <div class="card-header">
              <h3 class="card-title">업무 상세 조회</h3>
            </div>
            
            
            <!-- /.card-header -->
            <div class="card-body p-0">
            
              <div class="mailbox-read-info">
              <c:if test="${not empty task.topWorkName}">
                <span class="badge badge-info" data-toggle="tooltip" data-placement="top" title="상위 업무">${task.topWorkName }</span>
              </c:if>
                <h5 style="margin:10px 0px;">${task.workName }</h5>
                <h6 style="color:gray;">${task.workCode }</h6>
              </div>
              
              <div class="mailbox-read-info">

				<table class="table table-bordered">
					<tbody>
						<tr>	
							<th style="width: 15%;">담당자</th>
							<th style="width: 15%;">현황</th>
							<th style="width: 15%;">중요도
							</th><th style="width: 10%;">시작기한</th>
							<th style="width: 10%;">마감기한</th>
							<th>진척도</th>
						</tr>
					<tr>	
	
						<td>${task.memNickname }</td>
						
					
						
						<!-- 현황 -->
	                      <c:if test="${task.workStatus eq 'STATUS001' }">
	                      	<td><span class="badge bg-light">TO DO</span></td>
	                      </c:if>
	                      
	                      <c:if test="${task.workStatus eq 'STATUS002' }">
	                      	<td><span class="badge bg-success">IN PROCESS</span></td>
	                      </c:if>
	                      
	                      <c:if test="${task.workStatus eq 'STATUS003' }">
	                      	<td><span class="badge bg-secondary">DONE</span></td>
	                      </c:if>
	                      
	                      
	                      <!-- 중요도 -->
	                      <c:if test="${task.importance eq 'IMPORTANCE001' }">
	                      	<td><span class="badge bg-danger">긴급</span></td>
	                      </c:if>
	                      
	                      <c:if test="${task.importance eq 'IMPORTANCE002' }">
	                      	<td><span class="badge bg-warning">높음</span></td>
	                      </c:if>
	                      
	                      <c:if test="${task.importance eq 'IMPORTANCE003' }">
	                      	<td><span class="badge bg-warning">보통</span></td>
	                      </c:if>
	                      
	                      <c:if test="${task.importance eq 'IMPORTANCE004' }">
	                      	<td><span class="badge bg-info">낮음</span></td>
	                      </c:if>
						
						
						<td>${task.workStart }</td>
						<td>${task.workDeadline }</td>
						
						
						<td style=" vertical-align:middle;">
		                      
		                        <div class="progress progress-xs">
		                        
		                         <c:if test="${task.workStatus eq 'STATUS001' }">
		                         	<div class="progress-bar progress-bar-danger" style="width: ${task.progress}%; background-color: #f8f9fa; color:black;">${task.progress}%</div>
		                         </c:if>
		                         
		                         <c:if test="${task.workStatus eq 'STATUS002' }">
		                         	<div class="progress-bar progress-bar-danger" style="width: ${task.progress}%; background-color: #28a745; ">${task.progress}%</div>
		                         </c:if>
		                         
		                         <c:if test="${task.workStatus eq 'STATUS003' }">
		                         	<div class="progress-bar progress-bar-danger" style="width: ${task.progress}%; background-color: #6c757d; ">${task.progress}%</div>
		                         </c:if>
		                       	 
		                        </div>
		                        
		                </td>
		                      
		                      
					</tr>
					
					</tbody>
				</table>
                
              </div>
              
              
              <!-- /.mailbox-read-info -->
              <div class="mailbox-controls with-border">
                 <p>${task.workContents }</p>
              </div>
              
              
              
              <!-- /.mailbox-controls -->
              <div class="mailbox-read-message" style="background:#f7f7f7">
              
              <div id="editList">
              	<h5>수정 내역</h5>
              </div>
             <div style="overflow:auto; height:fit-contents; max-height:300px;">
             
             
             <c:choose>
              <c:when test="${not empty task.modifyHistoryList }">
              	<c:forEach items="${task.modifyHistoryList }" var="list">
	             	 <div class="callout callout-warning">
		                  <p style="margin-bottom:0px;">
			                  <span style="font-weight:bold;">${list.modifierId }</span> 님이 
			                  <span style="font-weight:bold; color:gray;">${list.columnKey}</span> (을)를 
			                  <span style="background: #f39c12; padding: 2px 5px; border-radius: 5px; color: white;">${list.beforeValue}</span> (에)서 
			                  <span style="background: #fd7e14; padding: 2px 5px; border-radius: 5px; color: white;">${list.afterValue }</span> (으)로 
			                  변경하셨습니다.
		                  </p>
		
		                  <p style="color:gray">${list.modifyDate }</p>
	                </div>
                </c:forEach>
			 </c:when>
			 <c:otherwise>
			 	<p style="color:gray">수정내역이 없습니다.</p>
			 </c:otherwise>
			</c:choose>
			
              </div>
              
            </div>
              <!-- /.mailbox-read-message -->
            </div>
            <!-- /.card-body -->
            
            <!-- /.card-footer -->
            <div class="card-footer">
            
            <c:if test="${position eq 'PL' || task.memId eq project.memId}">
              <button id="editTask" type="button" class="btn btn-default"><i class="fas fa-pencil-alt"></i> 수정</button>
              <button id="deleteTask" type="button" class="btn btn-default"><i class="far fa-trash-alt"></i> 삭제</button>
            </c:if>
            
            <button style="float:right;" id="backTask" type="button" class="btn btn-default" onclick="location.href='${cPath }/project/${project.pCode}/task/taskList.do'"><i class="fas fa-undo-alt"></i> 뒤로가기</button>
           
            </div>
            <!-- /.card-footer -->
          </div>
          <!-- /.card -->
        </div>
        
        
        <!-- 수정 시 보낼 taskVO -->
        <form id="taskForm" name="task" method="post">
        	<input type="hidden" name="workCode" value="${task.workCode }" /> 
        	<input type="hidden" name="topWorkCode" value="${task.topWorkCode }" /> 
        	<input type="hidden" name="workName" value="${task.workName }" /> 
        	<input type="hidden" name="workContents" value="${task.workContents }" /> 
        	<input type="hidden" name="workStart" value="${task.workStart }" /> 
        	<input type="hidden" name="workDeadline" value="${task.workDeadline }" /> 
        	<input type="hidden" name="progress" value="${task.progress }" /> 
        	<input type="hidden" name="importance" value="${task.importance }" /> 
        	<input type="hidden" name="workStatus" value="${task.workStatus }" /> 
        	<input type="hidden" name="memNickname" value="${task.memNickname }" /> 
        	<input type="hidden" name="topWorkName" value="${task.topWorkName }" /> 
        	<input type="hidden" name="memId" value="${task.memId }" /> 
        </form>
        
        
        
        
        <script>
			$(document).ready(function(){
			  $('[data-toggle="tooltip"]').tooltip();   
			});
			
			
			$('#editTask').on('click', function() {
				
				$('#taskForm').attr('action', '${cPath}/project/${project.pCode}/task/taskUpdate.do')
				$('#taskForm').submit();
				
			})
			
			
			$('#deleteTask').on('click', function() {
				
			
				if(confirm("해당 업무를 삭제하시겠습니까?")){
					
					$.ajax({
						url : "${cPath}/task/taskDelete.do",
						data : { 'workCode' : '${task.workCode }' },
						success : function(resp) {
							if(resp == "OK") {
								alert("삭제가 완료되었습니다.");
								location.href="${cPath}/project/${project.pCode}/task/taskList.do";
							}else {
								alert("삭제를 실패했습니다. 다시 시도하세요.");
							}
							
						},
						error: function(xhr, jQuery, error){
	    					console.log(jQuery);
	    					console.log(error);
	    			  }
					})
					
				}
			})
			
			
		</script>