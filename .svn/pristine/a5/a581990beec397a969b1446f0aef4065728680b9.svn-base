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

<h3>결제/환불 리스트</h3>
<hr><br>


	<!-- 셀렉트 박스 (정렬) 부 -->
	    <div id="selectDiv">
	    				
		                <!-- 환불 여부  -->
		                 <select name="refund" id="refund" class="form-control custom-select">
		      
		                  <option selected value>결제/환불</option>
		                  <option value="PAY">결제</option>
		                  <option value="REFUND">환불</option>
		                </select>
		                
		                
		                <input id="sortBtn" type="button" value="확인" class="btn btn-default searchBtn" />
		                
		       
	    </div>


 <!--  리스트 부분 -->

		<div class="row">
          <div class="col-12">
            <div class="card">
              <div class="card-header">
                <h3 class="card-title">결제/환불 리스트</h3>

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
                      	<th style="width:20%;">결제 날짜</th>
						<th>결제/환불</th>
						<th>아이디</th>
						<th>개월수</th>
						<th>결제 금액</th>
                    </tr>
                  </thead>
                  <tbody>
                  
                  
                  
                  <c:set var="payRetrieveList" value="${pagingVO.dataList }"></c:set>
                  
                  
                  <c:choose>
                  	<c:when test="${not empty payRetrieveList }">
                  	  <c:forEach items="${payRetrieveList }" var="Retrieve">
	                  
	                    <tr>
	                      <td>${Retrieve.payDate }</td>
	                      
	                      <c:choose>
	                      	<c:when test="${not empty Retrieve.refund}">
	                      		<td>환불완료</td>
	                      	</c:when>
	                      	<c:otherwise>
	                      		<td>결제완료</td>
	                      	</c:otherwise>
	                      </c:choose>
	                      
	                      <td>
	                      		<c:url value="/admin/payRetrieve/select.do" var="viewURL">
	                      			<c:param name="payCode" value="${Retrieve.payCode }"/>
	                      		</c:url>
	                      		<a href="${viewURL }">${Retrieve.memId }</a>
	                      </td>
	                      <td>${Retrieve.payMonth }</td>
	                      <td>${Retrieve.payAmount }</td>
	                      
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








<form action="${cPath }/admin/payRetrieve/List.do" name="pay" id="searchForm" method="post">
	<input type="hidden" name="page" />

    <input type="hidden" name="refund" id="formRefund"/>
	<input type="hidden" name="memId" id="formMemId" />
</form>



<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/commonjs/custom/paging.js">
</script>

<script type="text/javascript">
	//페이징 스크립트, 페이지 변환
	let searchForm = $("#searchForm").paging();
	
	//초기값 설정

	$("[name='refund']").val("${pagingVO.detailSearch.refund}");
	$("[name='memId']").val("${pagingVO.detailSearch.memId}");
	
	// 정렬 버튼 클릭 시 
	$('.searchBtn').on('click', function() {		
		

		var outCode = $('#refund').val();
		var memId = $('#memId').val();
		
		
		$('#formRefund').val(outCode);
		$('#formMemId').val(memId);
		
		$('#searchForm').submit(); 
	})
	
	
	
	
	
	
	
	
	
	
	
	
</script>