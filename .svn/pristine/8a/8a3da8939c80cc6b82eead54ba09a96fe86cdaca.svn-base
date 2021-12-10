<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

    
<style>
#requestListDiv {
	height: 300px;
	overflow-y: overlay;
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
	font-size: 25px;
}

.sender {
	font-size: 15px;
}

body:not(.sidebar-mini-md):not(.sidebar-mini-xs):not(.layout-top-nav) .content-wrapper,
	body:not(.sidebar-mini-md):not(.sidebar-mini-xs):not(.layout-top-nav) .main-footer,
	body:not(.sidebar-mini-md):not(.sidebar-mini-xs):not(.layout-top-nav) .main-header
	{
	margin-left: 0px;
}

#content {
	padding: 50px;
}

#plus {
	font-size: 50px;
	color: #ffc107;
	text-shadow: 0px 1px 1px #cbc8c8;
}


.custom-select {
	width:200px;
}


#selectDiv{
	margin-bottom: 10px;
}

.table.text-center, .table.text-center td, .table.text-center th {
	vertical-align: middle;
}


</style>



<h3>전체 회원 리스트</h3>
<hr><br>


	<!-- 셀렉트 박스 (정렬) 부 -->
	    <div id="selectDiv">
	    				
	    				<!-- 소속 -->
	     				<select name="memCompany" id="memCompany" class="form-control custom-select">
		                  <option selected value >회원소속</option>
		                  <option value="기업">기업</option>
		                  <option value="기관">기관</option> 
		                  <option value="기타">기타</option>
		                </select>
		                
		                
		                <!-- 탈퇴 여부  -->
		                 <select name="outCode" id="outCode" class="form-control custom-select">
		      
		                  <option selected value>탈퇴여부</option>
		                  <option value="1">Y</option>
		                  <option value="0">N</option>
		                </select>
		                
		                
		                <input id="sortBtn" type="button" value="확인" class="btn btn-default searchBtn" />
		                
		       
	    </div>
	    
	    
	    
	    
	    
	    
	    
	    <!--  리스트 부분 -->

		<div class="row">
          <div class="col-12">
            <div class="card">
              <div class="card-header">
                <h3 class="card-title">회원 리스트</h3>

                <div class="card-tools">
                  <div class="input-group input-group-sm">
                    <input style="width: 250px;" type="text" id="memId" name="table_search" class="form-control float-right" placeholder="회원 아이디로 검색 가능">

                    <div class="input-group-append">
                      <button type="submit" class="btn btn-default searchBtn">
                        <i class="fas fa-search"></i>
                      </button>
                    </div>
                  </div>
                </div>
              </div>
              <!-- /.card-header -->
              <div class="card-body table-responsive p-0">
                <table class="table table-hover text-nowrap text-center">
                  <thead>
                    <tr>
                      <th style="width:20%;">아이디</th>
                      <th>이름</th>
                      <th>가입일</th>
                      <th>회원소속</th>
                      <th>생년월일</th>
                      <th>성별</th>
                      <th>탈퇴여부</th>
                    </tr>
                  </thead>
                  <tbody>
                  
                  
                  
                  <c:set var="dataList" value="${pagingVO.dataList }"></c:set>
                  
                  
                  <c:choose>
                  	<c:when test="${not empty dataList }">
                  	  <c:forEach items="${dataList }" var="data">
	                  
	                    <tr>
	                      <td class="tableMemId" data-value="${data.memId }">${data.memId }</td>
	                      <td>${data.memNickname }</td>
	                      <td>${data.joinDate }</td>
	                      <td>${data.memCompany }</td>
	                      <td>${data.memBirth}</td>
	                      
	                      <!-- 성별 -->
	                      <c:if test="${data.memGender eq '0' }">
	                      	<td>남자</td>
	                      </c:if>
	                      
	                      <c:if test="${data.memGender eq '1' }">
	                      	<td>여자</td>
	                      </c:if>
	                      
	                      
	                      <!-- 회원 탈퇴 여부 -->
	                      <c:if test="${data.outCode eq '0' }">
	                      	  <td>N</td>
	                      </c:if>
	                      
	                      <c:if test="${data.outCode ne '0' }">
		                      <td>Y</td>
	                      </c:if>
	                      

	                    </tr>
	                    
                    </c:forEach>
                   </c:when>
                   <c:otherwise>
                   
                   </c:otherwise>
                   </c:choose>
                  </tbody>
                </table>
              </div>
              <!-- /.card-body -->
	          <div id="pagingArea" class="card-footer clearfix">${pagingVO.pagingHTML }</div>
            </div>
            <!-- /.card -->
          </div>
          
          
        </div>


 <%-- <form action="${cPath }/task/taskList.do" method="post"> --%>
<form action="${cPath }/admin/adminMemberList.do" name="member" id="searchForm" method="post">
	<input type="hidden" name="page" />

    <input type="hidden" name="outCode" id="formOutCode"/>
	<input type="hidden" name="memCompany" id="formMemCompany"/>
	<input type="hidden" name="memId" id="formMemId" />
</form>



<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/commonjs/custom/paging.js"></script>

<script type="text/javascript">
	// 페이징 스크립트, 페이지 변환 
	let searchForm = $("#searchForm").paging();
	
	// 초기값 설정
	$("[name='memCompany']").val("${pagingVO.detailSearch.memCompany}");
	$("[name='outCode']").val("${pagingVO.detailSearch.outCode}");
	$("[name='memId']").val("${pagingVO.detailSearch.memId}");
	
	// 정렬 버튼 클릭 시 
	$('.searchBtn').on('click', function() {
		
		
	 	var memCompany = $('#memCompany').val();
		var outCode = $('#outCode').val();
		var memId = $('#memId').val();
		
		
		$('#formMemCompany').val(memCompany);
		$('#formOutCode').val(outCode);
		$('#formMemId').val(memId);
		
		$('#searchForm').submit(); 
	})
	
	$('.memOut').on('click', function() {
		
		var memId = $(this).parents("tr").children(".tableMemId").attr('data-value');
		
		if(confirm("해당 회원을 탈퇴시키시겠습니까?")) {
			
			$.ajax({
				
				url : "${cPath}/admin/adminMemberDelete.do",
				data : { "outCode" : '1' ,
						 "memId" : memId },
				success : function(resp) {
					
					if(resp == "OK"){
						alert("탈퇴를 완료했습니다.")
						location.reload()
					}else {
						alert("탈퇴 진행을 실패했습니다. 다시 시도하세요.")
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