<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>



	<form id="meetingForm" method="post" enctype="multipart/form-data">
		<input type="hidden" name="meetingCode" value="${meeting.meetingCode }">
		<input type="hidden" name="pCode" value="${meeting.pCode}">
		<input type="hidden" name="write" value="${authMemberMemId }">
<!-- 		<div class="col-md-9"> -->
		            <div class="card card-primary card-outline">
		              <div class="card-header">
		                <h3 class="card-title"><i class="fas fa-chalkboard-teacher" style="margin-right: 10px;"></i> 회의록 수정</h3>
		              </div>
		              <!-- /.card-header -->
		              <div class="card-body">
		                <div class="form-group">
		                  	<span class="textSpan">주제</span> <input class="form-control" placeholder="Subject:" name="meetingTopic" value="${meeting.meetingTopic }" >
		                </div>
		                <div class="form-group">
		          		      <span class="textSpan">내용</span>
		                    <textarea name="meetingContent" id="compose-textarea" class="form-control" style="height: 300px">${meeting.meetingContent }</textarea>
		                    <br>
		                    
		                     <span class="textSpan">결론</span>
		                     <textarea name="meetingResult"  class="form-control" style="height: 100px">${meeting.meetingResult }</textarea>
							
									                    
		                </div>
		                <div class="mailbox-attachment-info"  style="width: 300px;" >
		                      <span class="meetingMem">회의 참여자</span>
		                      
		                     <!-- 여기다가 비동기로 프로젝트 참여한 사람들 넣기 -->
		                     
		                     <span>
		                     <c:set var="projectmemberList" value="${dataListVO.dataList }"></c:set>
		                  
		                      	 <c:forEach items="${projectmemberList}" var="projectmember" varStatus="vs">
		                      	 	<div style="margin-bottom: 5px;">
			                      	 	<input name="memId" class="projectman" type="checkbox" <c:if test="${projectmember.checkyn ne 'y'}">checked</c:if> value="${projectmember.memId }">
			                      	 	<span>${projectmember.memNickname} <br> </span>
			                      	</div>
		                      	 </c:forEach>                      	 	
		                      </span>
		                </div>
		                
		                <br>
		           	
		           
		                <div class="form-group">
		                
				 			<span style="float: left; font-weight: 600;"><i class="fas fa-paperclip"></i>기존 파일 &nbsp</span><br>
								<c:choose>
					           		<c:when test="${not empty meeting.attatch.realName}">
										<span class="fileName" style="color:gray;">
											${meeting.attatch.realName}
										</span>
					           		</c:when>					           		
					           		<c:otherwise>
					           			<span class="fileName" style="color:gray;">
					           				등록한 첨부파일이 없습니다.
					           			</span>
					           		</c:otherwise>
					           	</c:choose>
							
					 		
		               </div>
		               
		               
		                <div class="form-group newFileForm">
		                 
				 			<div id="fileArea" >
					 			<span style="float: left; font-weight: 600;"><i class="fas fa-paperclip"></i>파일첨부</span>
					 			
					 			
						    <div class="custom-file mb-3">
							  <input type="file" class="custom-file-input" id="customFile" name="meetingFile">
							  <label class="custom-file-label" for="customFile">첨부할 파일을 선택하세요.</label>
							</div>
					 			
					 			
					 		</div>
		              </div>
		            </div>
		              <!-- /.card-body -->
		              <div class="card-footer">
		                <div class="float-right">
		                  <button type="submit" class="btn btn-info"> 수정완료</button>
		                </div>
		                <button type="reset" class="btn btn-default"> 취소하기</button>
		            </div>
		           
		              <!-- /.card-footer -->
		            <!-- /.card -->
		</div>
		<div id="meetingHidden">
		</div>
		
	</form>	
	
<script type="text/javascript">
		$(function () {
		    //Add text editor
		    $('#compose-textarea').summernote()
		  })
		
		
		let fileArea = $("#fileArea").on("click", ".ctlBtn", function(){
			let id = this.id;
			console.log(id);
			let divTag = $(this).closest("div");
		});
		
// Add the following code if you want the name of the file appear on select
 $(".custom-file-input").on("change", function() {
   var fileName = $(this).val().split("\\").pop();
   $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
 });

</script>
	
	