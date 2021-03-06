<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 페이지 메인 문구 -->
<div class="container-fluid">
	<div class="row mb-2">
		<div class="col-sm-6">
			<h1>PE BOARD</h1>
		</div>
	</div>
</div>

<div class = "invoice mb-3" id = "firstCard">
	<!-- 자신의 업무 목록을 나타냅니다. -->
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

<!-- 월별 이슈 그래프 출력 구간 입니다. -->
<div class="row">
	<div class="col-md-12">
		<div class="card" id = "monthIssueCard">
			<div class="card-header">
				<h5 class="card-title">월간 이슈</h5>
			</div>
					
			<div class="card-body">
			
			<!-- highcharts - line-labels -->
			
				<figure class="highcharts-figure">
				  <div id = "monthIssueCount"></div>
				 
				</figure>
					
			</div>
			<div class="card-footer">
				<div class="row">
					<c:forEach items="${monthIssueRank }" var="monthIssueRank">
						<div class="col-sm-3 col-6">
							<div class="description-block border-right">
								<h3><span class="description-percentage text-success">${monthIssueRank.rnum }.</span></h3>
								<h5 class="description-header">${monthIssueRank.issueCount } 개</h5>
								<span class="description-text">${monthIssueRank.issueDate }월 의 Issue 개수</span>
							</div>
						</div>
					</c:forEach>		
				</div>
			</div>
		</div>
	</div>
</div>


<!-- donut Task Area 입니다. -->
<div class="row">
	
	<!-- 나의 업무 상태 Area 입니다. -->
	<div class="col">
		<div class="card">
			<div class="card-header">
				<h3 class="card-title">업무 상태 분포도</h3>
			</div>
			<div class="card-body p-0">
				<div class="d-md-flex">
					<div class="p-1 flex-fill">
						<div id="world-map-markers">
						
						<!-- highcharts - pie-legend -->	
						
							<figure class="highcharts-figure">
								<div id="taskRatio"></div>
							</figure>	
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 나의 이슈 상태 Area 입니다. -->
	<div class="col">
		<div class="card">
			<div class="card-header">
				<h3 class="card-title">이슈 상태 분포도</h3>
			</div>
			<div class="card-body p-0" >
				<div class="d-md-flex">
					<div class="p-1 flex-fill">
						<div id="world-map-markers">
						
						<!-- highcharts - pie-legend -->	
						
							<figure class="highcharts-figure">
								<div id="issueRatio"></div>
							</figure>	
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 월별 이슈 그래프 출력 구간 입니다. -->
<div class="row">
	<div class="col-md-12">
		<div class="card">
			<div class="card-header">
				<h5 class="card-title" id = "issueCountHeader">상위업무별 이슈 발생 개수</h5>
				<small class="float-right"> 
					<button id="plain" class = "btn btn-info">Plain</button>
				  	<button id="inverted" class = "btn btn-info">Inverted</button>
				  	<button id="polar" class = "btn btn-info">Polar</button>
			  	</small>
			</div>
					
			<div class="card-body">
			
			<!-- highcharts - line-labels -->
			
			<figure class="highcharts-figure">
			  <div id="issueCount"></div>
			</figure>
			</div>
		</div>
	</div>
</div>