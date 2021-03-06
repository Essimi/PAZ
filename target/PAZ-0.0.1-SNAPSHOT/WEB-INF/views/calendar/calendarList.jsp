<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
#thead{
text-align: center;
}

.icon{
size: 5x;
text-align: center;
}

</style>


<c:set var="CalendarList" value="${pagingVO.dataList}"></c:set>
<div class="invoice mb-3">

	
	<div class="row" >
		<div class="col-12" style="margin-bottom: 10px;">
			<h4>
				<i class="fas fa-calendar-check" style="margin-right: 10px;"></i>일정 관리 [PL]
		</div>
	</div>
	

	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-header">
				<input type="button" value="일정 등록" class="btn btn-info float-right" onclick = "location.href = '${cPath }/project/${pCode}/calendar/calendarInsert.do'">
					<div class="card-tools">
						<div class="input-group input-group-sm" style="width: 150px;">
						</div>
					</div>
				</div>
				<div class="card-body table-responsive p-0">
					<table class="table table-hover text-nowrap">
						<thead id = "thead">
							<tr>
								<th>시작날짜</th>
								<th>마감날짜</th>
								<th>제목</th>
								<th>내용</th>
								<th></th>
								<th></th>
								
							</tr>
						</thead>
						
	
						<tbody>
							<c:choose>
								<c:when test="${not empty CalendarList}">
									<c:forEach items="${CalendarList}" var="calendar">
	
										<tr>
										    
											<td>${calendar.scheduleStart }</td>
											<td>${calendar.scheduleDeadline}</td>
	
											<td>${calendar.scheduleName }</td>
											<td>${calendar.scheduleContent}</td>
										
											
											<td><a class="btn btn-info btn-sm" href="${cPath }/project/${pCode }/calendar/calendarUpdate.do?scheduleCode=${calendar.scheduleCode}" ><i
													class="fas fa-pencil-alt"></i>  </a></td>
											
	
											<td><a class="btn btn-danger btn-sm"  data-toggle="modal" data-target="#modal-danger" id="${calendar.scheduleCode}" ><i
													class="fas fa-trash"></i> </a></td>
	
										</tr>
	
										
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="2">조건에 맞는 게시글이 없음.</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</tbody>
						<tfoot>
							<tr>
								<td colspan="6">
									<div id="pagingArea" style="float: left;"
										class="card-footer clearfix">${pagingVO.pagingHTML }</div>
								</td>
								
								<td>
								
								
								</td>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	
	
	<form id="searchForm">
		<input type="hidden" name="page" />
	</form>
	
	<div class="modal fade" id="modal-danger">
		<div class="modal-dialog">
			<div class="modal-content bg-default">
				<div class="icon">
		<br><br>
			<h1><i class="fas fa-exclamation-triangle icon"></i></h1>
		
		</div>
				<div class="modal-body">
				
					<p>정말 삭제하시겠습니까?</p>
				</div>
				<div class="modal-footer justify-content-between">
					<button type="button" class="btn btn" data-dismiss="modal">취소</button>
					<button type="button" class="linkBtn btn btn" id="realDelBtn">삭제</button>
				</div>
			</div>
		</div>
	</div>

</div>

<!-- 삭제 확인 버튼 (비동기) -->
<script>


$('#modal-danger').on("show.bs.modal", function (event) {
	$(this).data("scheduleCode", event.relatedTarget.id)
})


	$("#realDelBtn").on("click", function(event) {
		
	let scheduleCode = $(this).parents('#modal-danger').data("scheduleCode")

	$.ajax({
			url : "${cPath}/project/${pCode }/calendar/calendarDelete.do",

			data : {
				"scheduleCode" : scheduleCode
				
			},
			dataType: "json",
			success : function(resp) {
				
				alert(resp.message);
				
				if(resp.result == "OK"){
					location.href = "${cPath}/project/${pCode}/calendar/calendarList.do";
				
				}

			},
			error : function(xhr, jQuery, error) {
				console.log(jQuery);
				console.log(error);
			}
		}) 
	}
)
</script>

<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/custom/paging.js"></script>

<script type="text/javascript">
	let searchForm = $("#searchForm").paging();
</script>

