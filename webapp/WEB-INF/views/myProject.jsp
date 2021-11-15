<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	
	#requestListDiv {
		height : 300px;
		overflow-y:overlay; 
	}
	
	::-webkit-scrollbar {
		width: 3px;
		background: none;
	}
	
	#requestListText {
		padding-left: 25px;
	    padding-top: 20px;
	    margin-bottom: -15px;
	}
	
	.pTitle {
		font-size : 25px;
	}
	
	.sender {
		font-size : 15px;
	}
	
	body:not(.sidebar-mini-md):not(.sidebar-mini-xs):not(.layout-top-nav) .content-wrapper, body:not(.sidebar-mini-md):not(.sidebar-mini-xs):not(.layout-top-nav) .main-footer, body:not(.sidebar-mini-md):not(.sidebar-mini-xs):not(.layout-top-nav) .main-header {
		margin-left : 0px;
	}
	
	#content { 
		 padding: 50px;
	}
	
	#plus {
		font-size: 50px;
	    color: #ffc107;
	    text-shadow: 0px 1px 1px #cbc8c8;
	}
	
</style>

</head>
<body>

 	<!-- 내 프로젝트 요청 리스트 -->
 	<div id="requestListText">
 		<h3>프로젝트 요청 리스트</h3>
 		<hr style="margin-left: -25px;">
 	</div>
 	<div id="requestListDiv">
	 	<div class="card-body pb-0">
	 	<c:set var="requestList" value="${requestList}"></c:set>
	 	<c:choose>
			<c:when test="${not empty requestList }">
		 	 	<c:forEach items="${requestList}" var="request">
				 	 <div class="card bg-light d-flex flex-fill">
				      <div class="card-header text-muted border-bottom-0">
				        프로젝트 요청 
				      </div>
				      <div class="card-body pt-0">
				        <div class="row">
				          <div class="col-7">
				            <h2 class="lead pTitle" ><b>${request.pTitle }</b></h2>
				          </div>
			
				        </div>
				      </div>
				      <div class="card-footer">
			      		<ul class="ml-4 mb-0 fa-ul text-muted">
			              <li class="small sender"><span class="fa-li"><i class="fas fa-hand-holding-heart"></i></span> 요청 발신자 : ${request.sender }</li>
			              <li class="small sender"><span class="fa-li"><i class="fas fa-id-card"></i></span> 역할 : ${request.position }</li>
			            </ul>
				        <div class="text-right">
				        
				        <!-- 수락 거절 -->
				          <a data-value="${request.pCode },${request.reqCode },${request.position}" class="btn btn-sm bg-teal requestBtn requestOk">
				            <i class="fas fa-check"></i>
				          </a>
				          <a data-value="${request.pCode },${request.reqCode }" class="btn btn-sm bg-red requestBtn requestFaild">
				            <i class="fas fa-times"></i>
				          </a>
				        
				        
				          <!-- 팀 구성원 뽑아오기 -->
				          <a href="#" title="Member List" data-toggle="popover" data-placement="top" data-content="Content" class="btn btn-sm btn-primary">
				            <i class="fas fa-user"></i> Member
				          </a>
				          
					          
				        </div>
				      </div>
				    </div>
			    </c:forEach>
			    </c:when>
			    
	   			 <c:otherwise>
					<p style="text-align: center; margin-top: 100px; color: gray;">
						 프로젝트 초대 요청이 없습니다.
					</p>
				</c:otherwise>
				
		    </c:choose>
		    
		    
	    </div> 
    </div> 
	<br>
	<br>




	<script>
		$(document).ready(function(){
		  $('[data-toggle="popover"]').popover();
		});
		
		$(".requestOk").on("click", function() {
			
			console.log($(this).attr('data-value'));
			
			$.ajax({
				url : "${cPath}/project/requestProject.do",
				data : { "value" : $(this).attr('data-value'),
						 "memId" : "${requestList.get(0).getMemId()}",
						 "msg" : "ok"
				},
				success : function(resp) {
					alert("프로젝트 초대 요청을 수락하셨습니다.");
					location.reload();
				},
				error: function(xhr, jQuery, error){
					console.log(jQuery);
					console.log(error);
				}
		
			})
		})
		
		
		$(".requestFaild").on("click", function() {
			
			$.ajax({
				url : "${cPath}/project/requestProject.do",
				data : { "value" : $(this).attr('data-value'),
						 "memId" : "${requestList.get(0).getMemId()}",
						 "msg" : "faild"
				},
				success : function(resp) {
					alert("프로젝트 요청을 거절했습니다. ");
					location.reload();
					console.log(resp);
				},
				error: function(xhr, jQuery, error){
					console.log(jQuery);
					console.log(error);
				}
		
			})
		})
		
	</script>



	<!-- 프로젝트 요청 리스트 끝 -->
	
	

<!-- 내 프로젝트 리스트 -->
<div class="content-wrapper" style="padding: 20px;">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>나의 프로젝트 리스트</h1>
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
                       	<c:if test="${project.statusCode ne 'PROJECT_STATE004' }">
                       	<c:if test="${project.statusCode ne 'PROJECT_STATE003' }">
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
                              <c:forEach items="${project.projectMember }" var="member">
                              <li class="list-inline-item">
                                  <img alt="Avatar" class="table-avatar" src="${cPath }/resources/adminLTE3/dist/img/avatar2.png"><br>
                                  <span class="badge badge-success">${member.memId}</span>
                              </li>
		                      </c:forEach>
                 
                          </ul>

                      </td>
                      
                      <td class="project-state">
                          <span class="badge badge-success">진행중</span>
                      </td>
                      
	                      <td class="project-actions text-right">
	                          <a data-value="${project.pCode }" class="btn btn-primary btn-sm projectView" > 
	                              <i class="fas fa-folder">
	                              </i>
	                              View
	                          </a>
	                          
	 
	                          
	                      
	                      
                          <c:choose>
               				<c:when test="${not empty plList}">
	                          <c:forEach items="${plList }" var="plCode">
	                           <c:set var ="plText" value="${plCode.pCode }"/>
	                           
	                          	<c:if test="${project.pCode eq plText}">
	              
		                          <a data-value="${project.pCode}" class="btn btn-info btn-sm projectEdit">
		                              <i class="fas fa-pencil-alt">
		                              </i>
		                              Edit
		                          </a>
		                          <a data-value="${project.pCode}" class="btn btn-danger btn-sm projectDelete" >
		                              <i class="fas fa-trash">
		                              </i>
		                              Delete
		                          </a>
	                          </c:if>
	                          
	                     </c:forEach>
                    </c:when>
                    </c:choose>
                    
                        <form class="viewForm" action="${cPath }/project/${project.pCode}/projectView.do" method="post" >
						   	<input type="hidden" name="memId" class="memIdValue"/>
						   	<input type="hidden" name="pCode" class="pCodeValue"/>
					    </form> 
                    </td>
                 </tr>
                 </c:if>
               </c:if>
           </c:forEach>
       	</c:when>
      </c:choose>
               
                  
                  
                  
              </tbody>
          </table>
          
        </div>
        <!-- /.card-body -->
      </div>
      <!-- /.card -->
      
      <div style="text-align:center;">
		  <a href="${cPath }/project/projectInsert.do" id="plus">
          	<i class="fas fa-plus-square"></i>
          </a>
      </div>
</div>
<!--     </section> -->
    <!-- /.content -->
    
   <form id="updateForm" action="${cPath }/project/projectUpdate.do" method="post" >
   	<input type="hidden" name="value" id="updateValue"/>
   </form>
    
    

    
    <script>
    
    	$(".projectDelete").on("click", function() {
    		
    		if(confirm("정말 삭제하시겠습니까?")) {
    			
    			$.ajax({
    				url : "${cPath }/project/projectDelete.do",
    				data : {"value" : $(this).attr('data-value')},
    				success : function(resp) {
    					alert("프로젝트가 삭제되었습니다.");
    					location.reload();
    					console.log(resp);
    				},
    				error: function(xhr, jQuery, error){
    					console.log(jQuery);
    					console.log(error);
    				}
    				
    			})
    		}
    		
    	})
    	
    	$(".projectEdit").on("click", function() {
    		
    		console.log("누름 ");
    		
    		var dataValue = $(this).attr('data-value');
    		
    		console.log(dataValue);
    		
    		$("#updateValue").attr("value", dataValue);
    		
    		console.log($("#updateValue").attr('value'));
    		
    		$("#updateForm").submit(); 
    		
    	})
    	
    	
    	$(".projectView").on("click", function() {
    	
    		var dataValue = $(this).attr('data-value');
    		var form = $(this).siblings('form');
    		
    		
    		console.log('${memId}');
    		console.log(dataValue);
    		 
    		form.children(".memIdValue").attr("value", '${memId}');
    		form.children(".pCodeValue").attr("value", dataValue);
    		
    		form.submit();
    		
    		
    	})
    	
    	
    	
    </script>


	
</body>
</html>