<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">


</style>
<title>Insert title here</title>
</head>
<body>
 <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>나의 프로젝트 리스트</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Projects</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
    <!-- Main content -->
    <!-- <section class="content"> -->
      <!-- Default box -->
      <div class="card">
        <div class="card-header">
          <h3 class="card-title">Projects</h3>

          <div class="card-tools">
            <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
              <i class="fas fa-minus"></i>
            </button>
            <button type="button" class="btn btn-tool" data-card-widget="remove" title="Remove">
              <i class="fas fa-times"></i>
            </button>
          </div>
        </div>
        <div class="card-body p-0">
          <table class="table table-striped projects">
              <thead>
                  <tr>
                      <th style="width: 1%">
                         No
                      </th>
                      <th style="width: 20%">
                          	프로젝트 명
                      </th>
                      <th style="width: 50%">
                          	팀원
                      </th>
                      
                      <th style="width: 8%" class="text-center">
                      	      현황
                      </th>
                      <th style="width: 20%">
                      </th>
                  </tr>
              </thead>
              <tbody>
             	 <c:choose>
             		 <c:when test="${not empty dataList}">
              			<c:forEach items="${dataList }" var="project">
                  <tr>
                      <td>
                      ${project.pCode}
                      </td>
                      <td>
                          <a>
                           ${project.pTitle}
                          </a>
                          
                      </td>
                      <td>
                      
                          <ul class="list-inline">
                              <li class="list-inline-item">
                                  <img alt="Avatar" class="table-avatar" src="${cPath }/resources/adminLTE3/dist/img/avatar.png">
                                  
                              </li>
                              <li class="list-inline-item">
                                  <img alt="Avatar" class="table-avatar" src="${cPath }/resources/adminLTE3/dist/img/avatar2.png">
                              </li>
                              <li class="list-inline-item">
                                  <img alt="Avatar" class="table-avatar" src="${cPath }/resources/adminLTE3/dist/img/avatar3.png">
                              </li>
                              <li class="list-inline-item">
                                  <img alt="Avatar" class="table-avatar" src="${cPath }/resources/adminLTE3/dist/img/avatar4.png">
                              </li>
                          </ul>
                          <c:forEach items="${project.projectMember }" var="member">
                      <span class="badge badge-success">${member.memId}</span>
                      </c:forEach>
                      </td>
                      
                      <td class="project-state">
                          <span class="badge badge-success">진행중</span>
                      </td>
                      <td class="project-actions text-right">
                          <a class="btn btn-primary btn-sm" href="${cPath }/project/{projectName}.do">
                              <i class="fas fa-folder">
                              </i>
                              View
                          </a>
                          <a class="btn btn-info btn-sm" href="${cPath }/project/projectUpdate.do">
                              <i class="fas fa-pencil-alt">
                              </i>
                              Edit
                          </a>
                          <a class="btn btn-danger btn-sm" href="${cPath }/project/projectDelete.do">
                              <i class="fas fa-trash">
                              </i>
                              Delete
                          </a>
                      </td>
                  </tr>
                  </c:forEach>
                  </c:when>
 				</c:choose>
                  
                  
                  
                  
              </tbody>
          </table>
          
        </div>
        <!-- /.card-body -->
      </div>
      <!-- /.card -->
<a href="${cPath }/project/projectInsert.do">
          <i class="far fa-plus-square"></i>
          </a>
</div>
<!--     </section> -->
    <!-- /.content -->
</body>
</html>