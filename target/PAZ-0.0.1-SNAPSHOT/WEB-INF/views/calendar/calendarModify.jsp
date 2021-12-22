<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  


<div class="invoice mb-3">

	<div class="row" >
		<div class="col-12" style="margin-bottom: 10px;">
			<h4>
				<i class="fas fa-calendar-check" style="margin-right: 10px;"></i>일정 수정
			</h4>
		</div>
	</div>
	
	
      <div class="row">
      
          <div class="card card-primary">

            <div class="card-body">
            
            <form action="${cPath}/project/${pCode }/calendar/calendarUpdate.do" method="post">
              <div class="form-group">
              <input type="hidden" name = "scheduleCode" value="${calendar.scheduleCode }">
                <label for="inputName">일정 명</label>
                <input type="text" id="inputName" class="form-control" name = "scheduleName" value="${calendar.scheduleName }">
              </div>
              <div class="form-group contentDiv">
                <label for="inputDescription">일정 내용</label>
                <textarea id="inputDescription" class="form-control"  rows="4" name = "scheduleContent" >${calendar.scheduleContent}</textarea>
              </div>
              
              <div class="form-group startDate">
                <label for="inputClientCompany">시작날짜</label>
                <input type="date" id="inputClientCompany" class="form-control dateForm" name = "scheduleStart" value="${calendar.scheduleStart }">
              </div>
              
              <div class="form-group endDate">
                <label for="inputClientCompany">마감날짜</label>
                <input type="date" id="inputClientCompany" class="form-control dateForm" name = "scheduleDeadline" value="${calendar.scheduleDeadline }">
              </div>
           

	          <a href="${cPath }/project/${pCode }/calendar/calendarList.do" class="btn btn-secondary">Cancel</a>
	          <input type="submit" value="SAVE" class="btn btn-success float-right">
        
         </form>

        </div>
        <!-- /.card-body -->
      </div>
      <!-- /.card -->
    </div>
    
   </div>
          <!-- /.card -->
</div>