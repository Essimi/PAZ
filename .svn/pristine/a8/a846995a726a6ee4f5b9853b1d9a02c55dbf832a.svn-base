<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>일정 수정</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Project Add</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>


    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-md-6">
          <div class="card card-primary">
            <div class="card-header">
              <h3 class="card-title"></h3>

              <div class="card-tools">
                <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
                  <i class="fas fa-minus"></i>
                </button>
              </div>
            </div>
            <div class="card-body">
            
            <form action="${pageContext.request.contextPath}/calendar/calendarUpdate.do" method="post">
              <div class="form-group">
              <input type="hidden" name = "scheduleCode" value="${calendar.scheduleCode }">
                <label for="inputName">일정 명</label>
                <input type="text" id="inputName" class="form-control" name = "scheduleName" value="${calendar.scheduleName }">
              </div>
              <div class="form-group">
                <label for="inputDescription">일정 내용</label>
                <textarea id="inputDescription" class="form-control"  rows="4" name = "scheduleContent" >${calendar.scheduleContent}</textarea>
              </div>
              
              <div class="form-group">
                <label for="inputClientCompany">시작날짜</label>
                <input type="date" id="inputClientCompany" class="form-control" name = "scheduleStart" value="${calendar.scheduleStart }">
              </div>
                <div class="form-group">
                <label for="inputClientCompany">마감날짜</label>
                <input type="date" id="inputClientCompany" class="form-control" name = "scheduleDeadline" value="${calendar.scheduleDeadline }">
              </div>
           

      <div class="row">
        <div class="col-12">
          <a href="${cPath }/calendar/calendarList.do" class="btn btn-secondary">Cancel</a>
          <input type="submit" value="SAVE" class="btn btn-success float-right">
           </form>
        </div>
            </div>
            <!-- /.card-body -->
          </div>
          <!-- /.card -->
        </div>
    
          <!-- /.card -->
        </div>
      </div>
      </div>
    </section>
   
    <!-- /.content -->
  </div>