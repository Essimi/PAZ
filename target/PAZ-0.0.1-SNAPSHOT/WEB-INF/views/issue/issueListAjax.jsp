<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<div class="card">
         <div class="card-header">
           <h3 class="card-title">Bordered Table</h3>
         </div>
         <!-- /.card-header -->
         <div class="card-body">
           <table class="table table-bordered">
             <thead>
               <tr>
                 <th>제목</th>
                 <th>업무명</th>
                 <th>이슈유형</th>
                 <th>중요도</th>
                 <th>작성자</th>
                 <th>수신자</th>
               </tr>
             </thead>
             <tbody id="listBody">
            	<c:forEach items="${pagingVO.dataList }" var="issue" varStatus="status">
               <tr>
                 <td>${issue.issueName }</td>
                 <td>${issue.workName }</td>
                  <c:choose>
                 	<c:when test="${issue.issueTypeCode eq 'ISSUE_TYPE001'}">
		            	<td><span class="badge bg-danger">버그</span></td>
                 	</c:when>
                 	<c:when test="${issue.issueTypeCode eq 'ISSUE_TYPE002'}">
		            	<td><span class="badge bg-warning">요청</span></td>
                 	</c:when>
                 </c:choose>
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
                 <td>
                 	<img class="img-circle img-bordered-sm" src="${cPath }/resources/file/profileImage/${issue.saveName }" 
                 		onerror="this.src='${cPath }/resources/file/profileImage/profile.jpg'"><br>
                 	<span class="badge badge-warning">${issue.memNickname}</span>
                 </td>
                 <td>
						<div id="recipient-profile">
					<ul class="list-inline">
						<c:forEach items="${issue.issueRecipients }" var="recipient">
							<li class="list-inline-item">
									<img alt="Avatar" class="table-avatar" 
										src="${cPath }/resources/file/profileImage/${recipient.saveName }"
								onerror="this.src='${cPath }/resources/file/profileImage/profile.jpg'"><br>
								<span class="badge badge-success">${recipient.memNickname}</span>
							</li>
						</c:forEach>
					</ul>
						</div>
				</td>
               </tr>
             </c:forEach>
             </tbody>
           </table>
         </div>
         <!-- /.card-body -->
         <div id="pagingArea" class="card-footer clearfix">
           ${pagingVO.pagingHTML }
         </div>
       </div>
    
    
    
    
    
    
    
    
    
    
    
 