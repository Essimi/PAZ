<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<br>

<div class="col-md-12">

	<div class="card">
	
		<div class="card-header">
			<h3 class="card-title">PROJECT MEMBERS</h3>
			
			<div class="card-tools">
				<span class="badge badge-danger">${fn:length(memberList) } Members</span>
					<button type="button" class="btn btn-tool" data-card-widget="collapse">
					<i class="fas fa-minus"></i>
					</button>
			</div>
		</div>


		<div class="card-body p-2">
			<ul class="users-list clearfix">
			
				<c:set var="memberList" value="${memberList}"></c:set>
				
				<c:choose>
				
					<c:when test="${not empty memberList}">
					
						<c:forEach items="${memberList}" var="member">
				
							<li>
								<img src="dist/img/user2-160x160.jpg" alt="User Image">
								<a class="users-list-name" href="#">${member.memId }</a>
								<span class="users-list-date">${member.position }</span>
							</li>
							
						</c:forEach>
						
					</c:when>
					
					<c:otherwise>
						
						<tr>
							<img src="${cPath }/resources/img/NoMmeber.png" alt="이미지 경로" />
						</tr>
						
					</c:otherwise>
					
				</c:choose>
			
			</ul>
		</div>
	
	</div>
</div>

</body>
</html>