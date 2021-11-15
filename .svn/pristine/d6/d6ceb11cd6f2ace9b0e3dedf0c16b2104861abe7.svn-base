<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="${cPath }/resource/js/cheditor/cheditor.js"></script>

	<form id="meetingForm" method="post" enctype="multipart/form-data">
<%-- 		<input type="text" name="meetingCode" value="${meeting.meetingCode }"> --%>
<%-- 		<input type="text" name="pCode" value="${meeting.pCode}"> --%>
		<div class="col-md-9">
		            <div class="card card-primary card-outline">
		              <div class="card-header">
		                <h3 class="card-title">회의록 작성</h3>
		              </div>
		              <!-- /.card-header -->
		              <div class="card-body">
<!-- 		                <div class="form-group"> -->
<!-- 		                	  작성자 : <input class="form-control" placeholder="To:" name="memId"> -->
<!-- 		                </div> -->
		                <div class="form-group">
		                  	주제 : <input class="form-control" placeholder="Subject:" name="meetingTopic" >
		                </div>
		                <div class="form-group">
		          		      내용
		                    <textarea name="meetingContent" id="compose-textarea" class="form-control" style="height: 300px" >

		                    </textarea>
		                    <br>결과
		                     <textarea name="meetingResult" id="compose-textarea" class="form-control" style="height: 100px">
		                     
		                    </textarea>
<!-- 		                    회의 참여 인원 -->
<!-- 		                    <input type="text" name="memId"> -->
<!-- 		                    <input type="text" name="memId"><br> -->
<!-- 		                   프로젝트 코드  -->
<!-- 		                    <input type="text" name="pCode"> -->
<!-- 		                    <input type="text" name="pCode"> -->
							
									                    
		                </div>
		                <div class="mailbox-attachment-info" style="width: 30%" >
		                      <span>회의 참여자 :&nbsp</span><br>
		                     <!-- 여기다가 비동기로 프로젝트 참여한 사람들 넣기 -->
		                     <span>
		                     <c:set var="projectmemberList" value="${dataListVO.dataList }"></c:set>
		                  
		                      	 <c:forEach items="${projectmemberList}" var="projectmember" varStatus="vs">
		                      	 	<input name="memId" class="projectman" type="checkbox" value="${projectmember.memId }">
		                      	 	<span>${projectmember.memNickname} <br> </span>
		                      	 </c:forEach>                      	 	
		                      </span>
		                </div>
		                <br>
		                <div class="form-group">
		                <!-- 파일은 아직이다 -->
		                  <div class="btn btn-default btn-file">
		                    <i class="fas fa-paperclip"></i> Attachment
		                    <input type="file" name="attachment">
		                  </div>
		                  <p class="help-block">Max. 32MB</p>
		                </div>
		              </div>
		              <!-- /.card-body -->
		              <div class="card-footer">
		                <div class="float-right">
		                  <button type="submit" class="btn btn-primary"><i class="far fa-envelope"></i> 등록하기</button>
		                </div>
		                <button type="reset" class="btn btn-default"><i class="fas fa-times"></i> 취소하기</button>
		              </div>
		              <!-- /.card-footer -->
		            </div>
		            <!-- /.card -->
		</div>
		<div id="meetingHidden">
		</div>
		
	</form>	
	
	<script>
	/* var meetingForm = $('#meetingForm').on('submit',function(){//form값이 서브밋이되면 실행한다
		var meetingHidden = $(this).find('#meetingHidden');
		var projectman = $(this).find('.projectman');	//프로젝트맨 .(클래스)를 찾아서 //여기서 디스는 프로젝트 폼
		var count = 0;									//개수를 세기위한 변수
		$.each(projectman, function(idx,projectone){	//반복이 된다  p맨이 인덱스부터 p원까지
			
			console.log(this.value)					//프로젝트 원 ==this
			var memId = this.value;						//벨류에는 아이디 값을 집어넣는다
			if($(this).is(':checked')){					//:(타입)/ 체크가 된다면 뉴태그를 실행 
				var newtag = $('<input>').attr({	//뉴 태그를 만든다(<intput type="hidden" name="memberList[개수].memId">)
							 'type': 'hidden',
							 'name' : 'memberList[%C].memId'.replace('%C',count++), //replace 교체한다  %c를 카운트로
							 'value' : memId //값은 memId
				})
				meetingHidden.append(newtag) //폼테그 안에 추가한다 뉴 태그를
			}
		})
		return true;
	}) */
	</script>