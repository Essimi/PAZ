<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


	<form:form commandName="meetingVO" id="meetingForm" method="post" enctype="multipart/form-data">
		<input type="hidden" name="pCode" value="${dataListVO.pCode}">
		<div class="col-md-9">
		            <div class="card card-primary card-outline" style="	border-top: 3px solid #17a2b8;">
		              <div class="card-header">
		                <h3 class="card-title"><i class="fas fa-chalkboard-teacher" style="margin-right: 10px;"></i> 회의록 작성</h3>
		                <input type="button" id="testIn" class = "btn btn-info" style="float: right;"  value = "TEST">
		              </div>
		              <!-- /.card-header -->
		              <div class="card-body">
 		               
		               <input type="hidden" class="form-control" name="write" value="${authMemberMemId}">
		              
		                <div class="form-group">
		                  	<span class="textSpan">주제</span> 
		                  	<input id="insertTitle" class="form-control" placeholder="Subject:" name="meetingTopic" value=${meetingVO.meetingTopic }>
		                  	<form:errors path="meetingTopic" element="span" style = "color: red"/>
		                </div>
		                
						<br>
		                
		                
		                <div class="form-group">
		          		      <span class="textSpan">내용</span>
		                    <textarea name="meetingContent" id="compose-textarea" class="form-control" style="height: 300px">
		                    	${meetingVO.meetingContent }
		                    </textarea>
		                 	<form:errors path="meetingContent" element="span" style = "color: red"/>
		                 
		                    <br>
		                    
		                     <span class="textSpan">결론</span>
		                     <textarea name="meetingResult" id="compose-textarea-result" class="form-control" style="height: 100px">${meetingVO.meetingResult }</textarea>
			  		         <form:errors path="meetingResult" element="span" style = "color: red"/>
			  		                     
		                </div>
		                
		                
		                <div class="mailbox-attachment-info"  style="width: 300px;">
		                      <span class="meetingMem">회의 참여자</span>
		                      
		                     <!-- 여기다가 비동기로 프로젝트 참여한 사람들 넣기 -->
		                     
			                     <span>
			                     	<c:set var="projectmemberList" value="${dataListVO.dataList }"></c:set>
			                  
			                      	 <c:forEach items="${projectmemberList}" var="projectmember" varStatus="vs">
			                      	 	<div style="margin-bottom: 5px;">
				                      	 	<input name="memId" class="projectman" type="checkbox"  value="${projectmember.memId }"  style="margin-right: 10px;">
				                      	 	<span>${projectmember.memNickname} <br> </span>
			                      	 	</div>
			                      	 </c:forEach>                      	 	
			                    </span>
		                     
		                     
		                </div>
		                <br>
		              <div class="form-group">
			 			 <div class="btn-file fileDiv" >
				 			<div id="fileArea" >
				 			<span style="float: left;"><i class="fas fa-paperclip"></i>파일첨부</span>
				 			
				 			
				 			<div class="custom-file mb-3">
							  <input type="file" class="custom-file-input" id="customFile" name="meetingFile">
							  <label class="custom-file-label" for="customFile">첨부할 파일을 선택하세요.</label>
							</div>
											 			
				 			
					 		</div>
						 </div>
					 </div>
											
		              </div>
		              <!-- /.card-body -->
		              <div class="card-footer">
		                <div class="float-right">
		                  <button type="submit" class="btn btn-info"> 등록하기</button>
		                </div>
		                <button type="reset" class="btn btn-default"> 취소하기</button>
		              </div>
		              <!-- /.card-footer -->
		            </div>
		            <!-- /.card -->
		</div>
		<div id="meetingHidden">
		</div>
		
	</form:form>	
	
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