<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!-- 페이지 메인 문구 -->
<div class="container-fluid">
	<div class="row mb-2">
		<div class="col-sm-6">
			<h1>PL BOARD</h1>
		</div>
	</div>
</div>

<%-- <div class = "invoice mb-3" id = "firstCard">
	<!-- 자신의 업무 목록을 나타냅니다. -->
		<div class="card" id = "monthIssueCard">
			<div class="card-header">
				<h5 class="card-title">긴급 업무 리스트</h5>
			</div>
			<div class="row">
				<c:forEach items="${topTaskStatus }" var="topTaskStatus">
					<div class="col-12 col-sm-6 col-md-3">
						<div class="info-box">
							<c:choose>
								<c:when test = "${topTaskStatus.importanceName eq '낮음' }">
									<span class="info-box-icon bg-info elevation-1"><i class="fas fa-cog"></i></span>
								</c:when>
								<c:when test = "${topTaskStatus.importanceName eq '보통' }">
									<span class="info-box-icon bg-success elevation-1"><i class="fas fa-check"></i></span>
								</c:when>	
								<c:when test = "${topTaskStatus.importanceName eq '높음' }">
									<span class="info-box-icon bg-warning elevation-1"><i class="fas fa-star"></i></span>
								</c:when>	
								<c:when test = "${topTaskStatus.importanceName eq '긴급' }">
									<span class="info-box-icon bg-danger elevation-1"><i class="fas fa-exclamation-triangle"></i></span>
								</c:when>			
							</c:choose>
							<div class="info-box-content">
								<span class="info-box-text">${topTaskStatus.workName }</span>
								<span class="info-box-number">${topTaskStatus.progressName }%</span>
								<div id = "taskBar" class="progress-bar" style="width: ${topTaskStatus.progressName }%"></div>
							</div>			
						</div>
					</div>
				</c:forEach>
			</div>
	</div>
</div> --%>

<!--  <div class = "invoice mb-3" id = "firstCard"> -->
		<div class="card" id = "monthIssueCard">
			<div class="card-header">
				<h5 class="card-title">긴급 업무 리스트</h5>
			</div>
			<div class="row">
			
				<div class="card-body p-0">
	                <table class="table">
	                  <thead>
	                    <tr>
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
	                  
	                  <c:set var="dataList" value="${pagingVO }"></c:set>
	                  
	                  <c:choose>
	                  	<c:when test="${not empty dataList }">
	                  		<c:forEach items="${dataList }" var="data">
	                  		
	                  		
	                  			<tr class="selectTask">
			                      <td class="workNam" style="text-align: left; padding-left: 50px; padding-right: 50px;">${data.workName }</td>
			                      <td><span>${data.memNickname }</span></td>
			                      
			                      <!-- 현황 -->
			                      <c:if test="${data.workStatus eq 'STATUS001' }">
			                      	<td><span class="badge bg-light">TO DO</span></td>
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
			                      
			                      <td><span>${data.workStart }</span></td>
			                      <td><span>${data.workDeadline }</span></td>
			                      
			                      <td style=" vertical-align:middle;">
			                      
			                        <div class="progress progress-xs">
			                        
			                         <c:if test="${data.workStatus eq 'STATUS001' }">
			                         	<div class="progress-bar progress-bar-danger" style="width: ${data.progress}%; background-color: #f8f9fa; color:black;">${data.progress}%</div>
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
			</div>
	</div>
<!-- </div>               -->
              
              
  
  
  
  
  
              

<!-- donut Task Area 입니다. -->
<div class="row">
	
	<!-- 업무 담당자별 할당 비율 그래프 Area 입니다. -->
	<div class="col">
		<div class="card">
			<div class="card-header">
				<h3 class="card-title">팀원별 업무 비율</h3>
			</div>
			<div class="card-body p-0">
				<div class="d-md-flex">
					<div class="p-1 flex-fill">
						<div id="world-map-markers">
						
						<!-- highcharts - pie-legend -->	
						
							<figure class="plTaskManagement-highcharts-figure">
							  <div id="plTaskManagement"></div> 
							</figure>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 회원 소속별 분야 그래프 Area 입니다. -->
	<div class="col">
		<div class="card">
			<div class="card-header">
				<h3 class="card-title">팀원 이슈 요청건</h3>
			</div>
			<div class="card-body p-0" >
				<div class="d-md-flex">
					<div class="p-1 flex-fill">
						<div id="world-map-markers">
						
						<!-- highcharts - pie-legend -->	
						
							<figure class="managementTask-highcharts-figure">
							  <div id="managementTask"></div>
							</figure>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 대시보드팀원별 업무 상태 그래프 -->
<div class="row">
	<div class="col-md-12">
		<div class="card">
			<div class="card-header">
				<h5 class="card-title" id = "issueCountHeader">팀원별 업무상태</h5>
				
			</div>
					
			<div class="card-body">
			
			<!-- highcharts - line-labels -->
				<figure class="teamStateDash-highcharts-figure">
				  <div id="teamStateDash"></div>
				</figure>
		
			</div>
		</div>
	</div>
</div>


<!-- 팀원별 주간 업무시간 -->
<div class="row">
	<div class="col-md-12">
		<div class="card">
			<div class="card-header">
				<h5 class="card-title" id = "issueCountHeader">팀원별 주간 업무시간</h5>
				
			</div>
					
			<div class="card-body">
			
			<!-- highcharts - line-labels -->
				<figure class="workTime-highcharts-figure">
				  <div id="workTime"></div>
				</figure>
		
			</div>
		</div>
	</div>
</div>


