<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<div class="invoice mb-3">

	<div class="row" >
		<div class="col-12" style="margin-bottom: 10px;">
			<h4><i class="fas fa-calendar-check" style="margin-right: 10px;"></i>일정 등록</h4>
			<button id="contentbutton" class="btn btn-info" type="button">TEST</button>
		</div>
	</div>

      <div class="row">
        
          <div class="card card-primary">

            
            
            <div class="card-body">
            
	            <form:form action="${cPath}/project/${pCode }/calendar/calendarInsert.do" method="post">
	              <div class="form-group">
	                <label for="inputName" >일정 명</label>
	                <input type="text" id="inputName" class="form-control" name = "scheduleName" placeholder="일정명을 입력하세요.">
	                <form:errors path="scheduleName" element="span" cssClass="error"/>
	              </div>
	              <div class="form-group contentDiv">
	                <label for="inputDescription">일정 내용</label>
	                <textarea id="inputDescription" class="form-control" rows="4" name = "scheduleContent" value></textarea>
	              </div>
	              
	              <div class="form-group startDate">
	                <label for="inputClientCompany">시작날짜</label>
	                <input id="startDate" type="date"  class="form-control dateForm" name = "scheduleStart">
	              </div>
	              
	              <div class="form-group endDate">
	                <label for="inputClientCompany">마감날짜</label>
	                <input id="deadDate" type="date" class="form-control dateForm" name = "scheduleDeadline">
	              </div>
	           
	           
		          <a href="${cPath }/project/${pCode }/calendar/calendarList.do" class="btn btn-info">Cancel</a>
		          <input type="submit" value="SAVE" class="btn btn-success float-right">
		        
		        
	           </form:form>
	           
           
           </div>
        
        
      </div>
     <!-- /.card-body -->
   </div>
   <!-- /.card -->

</div>
<script>
$('#contentbutton').click(function () {
	$('#inputName').val("log4j 긴급 수정 기간")
	$('#inputDescription').val("log4j 보안 이슈가 발생했습니다. 이슈 확인 부탁드립니다.")
	$('#startDate').val("2021-12-23")
	$('#deadDate').val("2021-12-25")
	
})
</script>
  
