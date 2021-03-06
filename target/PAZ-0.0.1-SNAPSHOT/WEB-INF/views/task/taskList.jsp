<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<div class="invoice mb-3">

	<div class="row" style="margin-bottom: 30px;">
		<div class="col-12" style="margin-top: 10px;">
			<h4>
				<i class="fas fa-tasks" style="margin-right: 10px;"></i> 업무 목록
			</h4>
		</div>
	</div>
	<%-- <form action="${cPath }/task/taskList.do" method="post"> --%>
	    <div id="selectDiv">
	    				
	    				<!-- 담당자 -->
	     				<select name="taskMember" id="taskMember" class="form-control custom-select">
		                  <option selected value >담당자</option>
		                 
		                 <c:set var="memList" value="${memList }"></c:set>
		                 <c:choose>
		                 	<c:when test="${not empty memList}">
		                 		<c:forEach items="${memList }" var="member">
		                 		
			                 		<!-- 반복문. 해당 프로젝트 멤버 리스트 -->
			                  		<!-- not empty memberList 일 때, 반복함.  -->
		                 			<option value="${member.memId }">${member.memNickname }</option>
		                 		
		                 		</c:forEach>
		                 	</c:when>
		                 	
		                 	<c:otherwise>
		                 		<option disabled value="${member.memId }">${member.memNickname }</option>
		                 	</c:otherwise>
		                 </c:choose>
		                </select>
		                
		                
		                <!-- 현황 -->
		                 <select name="taskStatus" id="taskStatus" class="form-control custom-select">
		                 
		                  <option selected value>현황</option>
		                  
		                  <!-- if문. 현황이 status001 일 땐, to do  -->
		                  <option value="STATUS001">TO DO</option>
		                  
		                  <!-- 002  -->
		                  <option value="STATUS002">IN PROCESS</option>
		                  
		                  <!-- 003 -->
		                  <option value="STATUS003">DONE</option>
		                  
		                </select>
		                
		                
		                <!-- 중요도 -->
		                 <select name="taskImportance" id="taskImportance" class="form-control custom-select">
		                  <option selected value>중요도</option>
		                  
		                  <!-- if문. 001 일 땐 긴급 -->
		                  <option value="IMPORTANCE001">긴급</option>
		                  
		                  <!-- 002 -->
		                  <option value="IMPORTANCE002">높음</option>
		                  
		                  <!-- 003 -->
		                  <option value="IMPORTANCE003">보통</option>
		                  
		                  <!-- 004 -->
		                  <option value="IMPORTANCE004">낮음</option>
		                </select>
		                
		                
		                <input id="sortBtn" type="button" value="확인" class="btn btn-default searchBtn" />
		                
		                
		            
	                	<input id="insertTaskBtn" type="button" value="업무 등록" class="btn btn-info insertTaskBtn" onclick="location.href='${cPath}/project/${project.pCode }/task/taskInsert.do'" />
	   					
	    </div>
    
    
    
    <div class="card">
    
			<div class="card-header">
                <h3 class="card-title">업무 리스트</h3>

                <div class="card-tools">
                  <div class="input-group input-group-sm">
                    <input type="text" name="taskName" id="taskName" class="form-control float-right" placeholder="업무명을 입력하세요." style="width:250px;">

                    <div class="input-group-append">
                      <button id="searchBtn" type="button" class="btn btn-default searchBtn"> <!-- 얘도 클릭 이벤트, form 넘 -->
                        <i class="fas fa-search"></i>
                      </button>
                    </div>
                  </div>
                </div>
              </div>
              
              
              <div class="card-body p-0">
                <table class="table">
                  <thead>
                    <tr>
                      <th>업무코드</th>
                      <th style="width:30%;">업무명</th>
                      <th>담당자</th>
                      <th>현황</th>
                      <th>중요도</th>
                      <th>시작기한</th>
                      <th>마감기한</th>
                      <th style="width:20%;">진척도</th>
                    </tr>
                  </thead>
                  <tbody>
                  
                  <c:set var="dataList" value="${pagingVO.dataList }"></c:set>
                  
                  <c:choose>
                  	<c:when test="${not empty dataList }">
                  		<c:forEach items="${dataList }" var="data">
                  		
                  		
                  			<tr class="selectTask">
                  			  <td>${data.workCode }</td>
		                      <td class="workNam" style="text-align: left; padding-left: 50px; padding-right: 50px;">${data.workName }</td>
		                      <td><span>${data.memNickname }</span></td>
		                      
		                      <!-- 현황 -->
		                      <c:if test="${data.workStatus eq 'STATUS001' }">
		                      	<td><span class="badge bg-info">TO DO</span></td>
		                      </c:if>
		                      
		                      <c:if test="${data.workStatus eq 'STATUS002' }">
		                      	<td><span class="badge bg-success">IN PROCESS</span></td>
		                      </c:if>
		                      
		                      <c:if test="${data.workStatus eq 'STATUS003' }">
		                      	<td><span class="badge bg-secondary">DONE</span></td>
		                      </c:if>
		                      
		                      
		                      <!-- 중요도 -->
		                      <c:if test="${data.importance eq 'IMPORTANCE001' }">
		                      	<td><span class="badge bg-danger">긴급</span></td>
		                      </c:if>
		                      
		                      <c:if test="${data.importance eq 'IMPORTANCE002' }">
		                      	<td><span class="badge bg-warning">높음</span></td>
		                      </c:if>
		                      
		                      <c:if test="${data.importance eq 'IMPORTANCE003' }">
		                      	<td><span class="badge bg-warning">보통</span></td>
		                      </c:if>
		                      
		                      <c:if test="${data.importance eq 'IMPORTANCE004' }">
		                      	<td><span class="badge bg-info">낮음</span></td>
		                      </c:if>
		                      
		                      <td><span>${data.workStart }</span></td>
		                      <td><span>${data.workDeadline }</span></td>
		                      
		                      <td style=" vertical-align:middle;">
		                      
		                        <div class="progress progress-xs">
		                        
		                         <c:if test="${data.workStatus eq 'STATUS001' }">
		                         	<div class="progress-bar progress-bar-danger" style="width: ${data.progress}%; background-color: #16a2b8;">${data.progress}%</div>
		                         </c:if>
		                         
		                         <c:if test="${data.workStatus eq 'STATUS002' }">
		                         	<div class="progress-bar progress-bar-danger" style="width: ${data.progress}%; background-color: #28a745; ">${data.progress}%</div>
		                         </c:if>
		                         
		                         <c:if test="${data.workStatus eq 'STATUS003' }">
		                         	<div class="progress-bar progress-bar-danger" style="width: ${data.progress}%; background-color: #6c757d; ">${data.progress}%</div>
		                         </c:if>
		                       	 
		                        </div>
		                        
		                      </td>
		                    </tr>  
		                    
		                    <form name="taskForm" action="${cPath }/project/${project.pCode }/task/selectTaskView.do" class="workForm" method="post">
		                    	<input type="hidden" name="workCode" value="${data.workCode }" />
		                    	<input type="hidden" name="topWorkCode" value="${data.topWorkCode }" />
		                    	<input type="hidden" name="workName" value="${data.workName }"/>
		                    	<input type="hidden" name="workContents" value="${data.workContents }"/>
		                    	<input type="hidden" name="memNickname" value="${data.memNickname }"/>
		                    	<input type="hidden" name="workStatus" value="${data.workStatus }"/>
		                    	<input type="hidden" name="importance" value="${data.importance }"/>
		                    	<input type="hidden" name="workStart" value="${data.workStart }"/>
		                    	<input type="hidden" name="workDeadline" value="${data.workDeadline }"/>
		                    	<input type="hidden" name="progress" value="${data.progress }"/>
		                    	<input type="hidden" name="topWorkName" value="${data.topWorkName }"/>
		                    	<input type="hidden" name="memId" value="${data.memId }"/>
		                    	<input type="hidden" name="pCode" value="${data.pCode }"/>
		                    </form>
		                    
                  		</c:forEach>

                  	</c:when>
                  	
                  	<c:otherwise>
                  		<tr>
                  			<td colspan="8">등록된 업무 리스트가 없습니다. </td>
                  		</tr>
                  	</c:otherwise>
                  
                  
                  
                  </c:choose>                    
                  </tbody>
                </table>
              </div>
              <!-- /.card-body -->

               <div id="pagingArea" class="card-footer clearfix">${pagingVO.pagingHTML }</div>

            </div>
 </div> 
            <br><br>
            
            
            <%-- <form action="${cPath }/task/taskList.do" method="post"> --%>
            <form action="${cPath }/project/${project.pCode }/task/taskList.do" id="searchForm" method="post">
				<input type="hidden" name="page" />
				<input type="hidden" name="taskMember" id="formTaskMember"/>
				<input type="hidden" name="taskStatus" id="formTaskStatus"/>
				<input type="hidden" name="taskImportance" id="formTaskImportance" />
				<input type="hidden" name="taskName" id="formTaskName" />
			</form>
			
			<!-- 등록 시 필요. memberList -->
		
			
            
            <script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/commonjs/custom/paging.js"></script>
             
             <!-- 페이징 스크립트, 페이지 변환 -->
			<script type="text/javascript">
				let searchForm = $("#searchForm").paging();
			</script>
            
            
            <!-- 검색. -->
			<script>
			
			$("[name='taskMember']").val("${pagingVO.detailSearch.memId}");
			$("[name='taskStatus']").val("${pagingVO.detailSearch.workStatus}");
			$("[name='taskImportance']").val("${pagingVO.detailSearch.importance}");
			$("[name='taskName']").val("${pagingVO.detailSearch.workName}");
			
			
			
			// 정렬 버튼 클릭 시 
			$('.searchBtn').on('click', function() {
				
				
			 	var taskMember = $('#taskMember').val();
				var taskStatus = $('#taskStatus').val();
				var taskImportance = $('#taskImportance').val();
				var taskName = $('#taskName').val();
				
				
				$('#formTaskMember').val(taskMember);
				$('#formTaskStatus').val(taskStatus);
				$('#formTaskImportance').val(taskImportance);
				$('#formTaskName').val(taskName);
				
				$('#searchForm').submit(); 
			})
			
			
			$('.selectTask').on('click', function() {
				
				$(this).next().submit();
			})
			
			
			$('#insertTaskBtn').on('click', function() {
				
			})
			
			</script>