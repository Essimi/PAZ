<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<style>
	img.table-avatar, .table-avatar img, .img-circle {
	    border-radius: 50%;
	    display: inline;
	    width: 2.5rem;
	}
/* 	.card{
		width: 1630px;
		height: 880px;
	} */
	.list-inline{
		margin-bottom: -10px;
	}
	#listBody tr{
		cursor: pointer;
	}
	.card-footer{
		background-color : rgba(0,0,0,0);
	}
	.custom-select{
		width : 150px;
	}
	.issueWriter, .issueBadge{
		text-align: center;
	}
	.importance, .issueType{
		width:50px;
		height:26px;
		font-size: 15px;
	}
	.table td{
		vertical-align: middle;
	}
	th{
		text-align: center;
	}
	th:nth-of-type(3),th:nth-of-type(4) {
		width: 6%;
	}
	
	#content {
		padding:30px;
	}
	
	#mainDiv {
		width: 100%;
	}
	
	#mainDiv .card {
		padding:30px;
		border-radius: 10px;
	}
	
	.card-header {
		padding-left: 0;
		padding-right: 0;
	}
	
	.insertBtn {
		float: right;
	}
	
	#pagingArea {
		padding: 0;
	    margin-top: 20px;
	}
</style>  
  
<section class="content">
 <div class="container-fluid">
   <div class="row">
     <div id="mainDiv">
       <div class="card">
       <div class="row" style="margin-bottom: 30px;">
		<div class="col-12" style="margin-top: 10px;">
			<h4>
				<i class="fas fa-broadcast-tower" style="margin-right: 10px;"></i> 이슈 목록
			</h4>
		</div>
	</div>
         <div class="card-header">
         <div id="searchUI">
           <select name="issueTypeCode" class="form-control custom-select">
	           <option value>유형</option>
	           <option value='ISSUE_TYPE001'>버그</option>
	           <option value='ISSUE_TYPE002'>요청</option>
           </select>
           <select name="importance" class="form-control custom-select">
	           <option value>중요도</option>
	           <option value='IMPORTANCE001'>긴급</option>
	           <option value='IMPORTANCE002'>높음</option>
	           <option value='IMPORTANCE003'>보통</option>
	           <option value='IMPORTANCE004'>낮음</option>
           </select>
           <select name="memId" class="form-control custom-select">
	           <option value>작성자</option>
	           <c:forEach items="${memList }" var="member">
	           		<option value='${member.memId }'>${member.memNickname }
	           			<c:if test="${member.outStatus  eq '1'}">
	           				[탈퇴]
	           			</c:if>
	           		</option>
	           </c:forEach>
           </select>
           <select name="recipient" class="form-control custom-select">
	           <option value>수신자</option>
	           <c:forEach items="${memList }" var="member">
	           		<option value='${member.memId }'>${member.memNickname }
	           			<c:if test="${member.outStatus  eq '1'}">
	           				[탈퇴]
	           			</c:if>
	           		</option>
	           </c:forEach>
           </select>
           <input type="button" class="btn btn-default" id="searchBtn" value="확인">
           <input type="button" class="btn btn-info insertBtn" value="등록" onclick="location.href='${cPath}/project/${project.pCode}/issue/issueWrite.do'">
           </div>
         </div>
         <!-- /.card-header -->
         <div class="card-body p-0">
           <table class="table table-bordered table-hover table-striped">
             <thead>
               <tr>
                 <th>제목</th>
                 <th>업무명</th>
                 <th style="width: 10%;">이슈유형</th>
                 <th style="width: 10%;">중요도</th>
                 <th>작성자</th>
                 <th>수신자</th>
               </tr>
             </thead>
             <tbody id="listBody">
           
             </tbody>
           </table>
         </div>
         <!-- /.card-body -->
         <div id="pagingArea" class="card-footer clearfix">
           ${pagingVO.pagingHTML }
         </div>
       </div>
       <!-- /.card -->
     </div>
     <!-- /.col -->
   </div>
 </div><!-- /.container-fluid -->
</section>

<form id="searchForm" method="post">
	<input type="hidden" name="page" />
	<input type="hidden" name="issueTypeCode" />
	<input type="hidden" name="importance" />
	<input type="hidden" name="memId" />
	<input type="hidden" name="recipient" />
</form>


 
