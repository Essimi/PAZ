<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



 <div class="col-md-9">
          <div class="card card-primary card-outline">
            <div class="card-header">
              <h2 class="card-title"><i class="fas fa-chalkboard-teacher" style="margin-right: 10px;"></i> 회의록 조회</h2>
            	<h10 style="float: right">글 번호  : ${meeting.meetingCode }</h10>
              
            </div>
            <!-- /.card-header -->
            <div class="card-body p-0">
              <div class="mailbox-read-info">
                <h5>${meeting.meetingTopic }</h5>
                <h6 style="color:gray;">From: ${meeting.memNicknameTo }
                  <span class="mailbox-read-time float-right">${meeting.meetingDate }</span></h6>
              	<c:choose>
                      		<c:when test ="${not empty meeting.memberList }">
		                      	 <c:forEach items="${meeting.memberList }" var="member">
		                      	 	<span class="memBadge badge badge-success">${member.memNicknameWe} </span>&nbsp&nbsp
	                      	 	 </c:forEach>    
							</c:when>
							<c:otherwise>
								<span>
									 - 회의록 참여자 미입력
									<br><br>
								</span>
							</c:otherwise>
	                    </c:choose>        
              </div>
              <!-- 내용 -->
              <div class="mailbox-controls with-border">
                <p>${meeting.meetingContent }</p>
               
              </div>
              <!-- 결론 -->
              <div class="mailbox-read-message">
				<p>결론</p>
                <p>${meeting.meetingResult }</p>

              </div>
              <!-- /.mailbox-read-message -->
            </div>
            <!-- /.card-body -->
            <div class="card-footer bg-white">
              <ul class="mailbox-attachments d-flex align-items-stretch clearfix">
               
                	<c:choose>
                		<c:when test="${not empty meeting.attatch }">
			                <li style="border-radius: 10px;">
						                	 <div style="border-radius: 10px;" class="mailbox-attachment-info">
							                    <i class="fas fa-paperclip">${meeting.attatch.realName}</i>
						                  		<span class="mailbox-attachment-size clearfix mt-1">
						                  			<span>${meeting.attatch.fileSize} KB</span>
						                  			
						                  			<c:url value="/meeting/download.do" var="downloadURL">
														<c:param name="meetingCode" value="${meeting.meetingCode }" />
													</c:url>
						                  			
						                  			<a href="${downloadURL }" class="btn btn-default btn-sm float-right"><i class="fas fa-cloud-download-alt"></i></a>
						                        </span>
						                  	</div>
						                  	
			                </li>
                  		</c:when>
	                  		<c:otherwise></c:otherwise>
                  		</c:choose>
              </ul>
            </div>
            <!-- /.card-footer -->
            <div class="card-footer">
            	<input type="button" class="btn btn-default" value="목록으로" onclick="location.href='${cPath }/project/${project.pCode }/meeting/list.do'">
           	
            
	            <!-- 수정 / 삭제 버튼 -->
	            <div class="float-right">
		               <!-- 수정 버튼 -->
			              
						 <div class="col-md-auto" style="display: inline-block;">
							<c:if test="${authMemberMemId eq meeting.memId}">
					
					              <c:url value="/project/${project.pCode }/meeting/modify.do" var="updateURL">
					              	<c:param name="what" value="${meeting.meetingCode }"/>           	
					              </c:url>
					              <input type="button" class="btn btn-default"  value="글 수정" onclick="location.href='${updateURL }'">
		
							</c:if>
						</div>
						
		             <!-- 삭제 모달 창/ 삭제버튼/ 삭제 폼 -->
		             <div class="col-md-auto" style="display: inline-block;">
		              <!-- 삭제 폼 -->
			              <form action="${cPath }/project/${project.pCode }/meeting/delete.do" method="post" name="meetingDelete">
						  <input type="hidden" name="what" value="${ meeting.meetingCode}">
						  <input type="hidden" name="memId" value="${ meeting.memId}">
			              </form>
			              
						<!-- 삭제버튼 / 삭제 모달창  -->
						
							<c:if test="${authMemberMemId eq meeting.memId}">
								<!-- Button trigger modal -->
								<button type="button" class="btn btn-default"  data-toggle="modal" data-target="#exampleModal">삭제</button>
					
								<!-- Modal -->
								<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
									aria-labelledby="exampleModalLabel" aria-hidden="true"
								>
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="exampleModalLabel">게시물 삭제</h5>
												<button type="button" class="close" data-dismiss="modal" aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
											</div>
											<div class="modal-body">게시물을 삭제하시겠습니까?</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-primary" onclick="clickDel(meetingDelete)">삭제하기</button>
												<button type="button" class="btn btn-secondary" data-dismiss="modal">취소하기</button>
											</div>
										</div>
									</div>
								</div>
								<script>
									function clickDel(formName) {
										formName.action = "${cPath }/project/${project.pCode }/meeting/delete.do";
										formName.method = "post";
										formName.submit();
									}
								</script>
							</c:if>
						</div>
			   	</div>
	      	
            </div>
            <!-- /.card-footer -->
          </div>
          <!-- /.card -->
        </div>
        



	