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
	
	#cardDiv {
		padding:0px 300px;
	}
	
	.editBtn{
		float: right;
	    margin-top: 30px;
	    width: 150px;
	    margin-left : 20px; 
	}	
	
	#editH3{
		margin-botton : 30px
	}
</style>

</head>
<body>

			<form action="${cPath }/project/projectUpdate.do" method="post">
				<div id="cardDiv">
	             <div class="card-body">
				 <h3 id="editH3">프로젝트 수정</h3>
				 <hr>
	              <div class="form-group">
	                <label for="inputName">프로젝트명</label>
	                <input name="pTitle" type="text" id="inputName" class="form-control" value="${project.pTitle }">
	              </div>
	              <div class="form-group">
	                <label for="inputDescription">프로젝트 내용</label>
	                <textarea name="pContent" id="inputDescription" class="form-control" rows="4" value >${project.pContent }</textarea>
	              </div>
	              <div class="form-group">
	                <label id="statusLabel" value="${project.pPartCode}" for="inputStatus">분야</label>
	                <select name="pStatus" id="inputStatus" class="form-control custom-select">
	                  <option disabled>Select one</option>
	                  <option value="PART001">은행프로젝트</option>
	                  <option value="PART002">보험</option>
	                  <option value="PART003">공공부문</option>
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
					 
				  <input id="saveBtn" type="button" class="btn btn-info editBtn" value="저장"/>
				  <input type="button" class="btn btn-default editBtn" value="취소" onclick="location.href='${cPath }/project/myprojectList.do'"/>
					 
	            </div>
	            <!-- /.card-body -->
	          </div>
			 
	          
	          <!-- /.card -->
			
		</form>
		
		
		<script>
		
			
			$(function(){
				
				var statusCode = $("#statusLabel").attr('value');
				
				console.log(statusCode); 
				
				// value 값으로 selected 속성 주기(두 번째 방법)
				$('#inputStatus').val(statusCode).prop('selected', true);
				
			})
			
			$("#saveBtn").on("click", function() {
				
				if(confirm("저장하시겠습니까?")) {
					
					// ajax 로 vo 넘기는 법 궁금 !!! 
					$.ajax({
						url: "${cPath}/project/projectUpdate.do",
						data : { "pCode" : '${project.pCode}',
								 "pTitle" : $("#inputName").val(),
								 "pContent" : $("#inputDescription").val(),
								 "pPartCode" : $("#inputStatus").val() },
	    				success : function(resp) {
	    					console.log(resp);
	    					
	    					if(resp == "OK") {
	    						alert("수정을 성공했습니다.");
	    						location.href="${cPath}/project/myprojectList.do";
	    					}else {
	    						alert("수정을 실패했습니다. 다시 시도하세요.")
	    					}
	    				},
	    				error: function(xhr, jQuery, error){
	    					console.log(jQuery);
	    					console.log(error);
	    				}
						
					})
					
				}
			
			})
			
		
		</script>

	
</body>
</html>