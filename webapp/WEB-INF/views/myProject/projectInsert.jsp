<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body:not(.sidebar-mini-md):not(.sidebar-mini-xs):not(.layout-top-nav) .content-wrapper, body:not(.sidebar-mini-md):not(.sidebar-mini-xs):not(.layout-top-nav) .main-footer, body:not(.sidebar-mini-md):not(.sidebar-mini-xs):not(.layout-top-nav) .main-header {
		margin-left : 0px;
	}
	
	#content { 
		 padding: 50px;
	}
</style>
</head>
<body>
<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>프로젝트 생성</h1>
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
              <h3 class="card-title">General</h3>

              <div class="card-tools">
                <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
                  <i class="fas fa-minus"></i>
                </button>
              </div>
            </div>
            <div class="card-body">
            <form action="${pageContext.request.contextPath}/project/projectInsert.do" method="post">
              <div class="form-group">
                <label for="pTitle">프로젝트 명</label>
                <input type="text" name="pTitle" class="form-control">
              </div>
              <div class="form-group">
                <label for="pContent">프로젝트 내용</label>
                <textarea name="pContent" class="form-control" rows="4"></textarea>
              </div>
              <div class="form-group">
                <label for="pPartCode">프로젝트 분야</label>
                <select name="pPartCode" class="form-control custom-select">
                  <option selected disabled>Select one</option>
                  <option value="PART001">은행 프로젝트 </option>
                  <option value="PART002">보험 프로젝트 </option>
                  <option value="PART003">공공부문 프로젝트</option>
                  <option value="PART004">이동통신사 (부가서비스) 프로젝트</option>
                  <option value="PART005">이동통신사 (레거시) 프로젝트</option>
                  <option value="PART006">웹 포털 프로젝트</option>
                  <option value="PART007">스마트폰 앱 기반 프로젝트</option>
                  <option value="PART008">게임 (모바일) 프로젝트</option>
                  <option value="PART009">게임 (온라인) 프로젝트</option>
                  <option value="PART010">솔루션 프로젝트</option>
                  <option value="PART011">ERP 프로젝트</option>
                  <option value="PART012">기타 프로젝트</option>
                  
                </select>
              </div>
              <div class="form-group">
                <label for="pStartDate">시작날짜</label>
                <input type="date" name="pStartDate" class="form-control" min="2021-11-30">
              </div>
                <div class="form-group">
                <label for="pEndDate">마감날짜</label>
                <input type="date" name="pEndDate" class="form-control" min="2021-11-30">
               
              </div>

      <div class="row">
        <div class="col-12">
          <a href="${cPath }/project/myprojectList.do" class="btn btn-secondary">Cancel</a>
          <input type="submit" value="Create new Project" class="btn btn-success float-right">
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
  <!-- /.content-wrapper -->
</body>
</html>