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
		 padding: 50px 300px;
	}
	
	.card-primary:not(.card-outline)>.card-header {
		background-color: #f39c12;
	}
	
	.cardBody {
		padding: 30px 150px;
	}
</style>
</head>
<body>
<!-- Content Wrapper. Contains page content -->

      <div class="row">
        <div style="width: 100%;">
          <div class="card card-primary">
            <div class="card-header">
              <h3 class="card-title">프로젝트 생성</h3>

            </div>
            <div class="card-body cardBody">
            <form action="${pageContext.request.contextPath}/project/projectInsert.do" method="post">
              <div class="form-group">
                <label for="pTitle">프로젝트 명</label>
                <input id="pTitle" type="text" name="pTitle" class="form-control">
              </div>
              <div class="form-group">
                <label for="pContent">프로젝트 내용</label>
                <textarea id="pContent" name="pContent" class="form-control" rows="4"></textarea>
              </div>
              <div class="form-group">
                <label for="pPartCode">프로젝트 분야</label>
                <select id="pPartCode" name="pPartCode" class="form-control custom-select">
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
                <input id="pStartDate" type="date" name="pStartDate" class="form-control" min="2021-12-20">
              </div>
                <div class="form-group">
                <label for="pEndDate">마감날짜</label>
                <input id="pEndDate" type="date" name="pEndDate" class="form-control" min="2021-12-20">
               
              </div>

      <div class="row">
        <div class="col-12" style="margin-top:50px;">
          <a href="${cPath }/project/myprojectList.do" class="btn btn-secondary">Cancel</a>
          <input type="submit" value="Create new Project" class="btn btn-success float-right">
       </form>
          <button type="button" class="btn btn-info" id="contentbutton">TEST</button>
        </div>
            </div>
            <!-- /.card-body -->
          </div>
          <!-- /.card -->
        </div>
    
          <!-- /.card -->

  <!-- /.content-wrapper -->
</body>
</html>

<script>
$('#contentbutton').click(function () {
	$('#pTitle').val("개발 프로그램 관리 협업 프로젝트")
	$('#pContent').val("개발 프로그램 관리 협업 프로젝트를 진행합니다.")
	$('#pPartCode').val("PART006")
	$('#pStartDate').val("2021-12-21")
	$('#pEndDate').val("2022-08-30")
	
})
</script>