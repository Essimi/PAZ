<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
#pagingArea {
	background-color: white;
	float: right;
}





#rufwp{
	background: gray;
	width: 100%;
	height: 110px;
}

.testTTTT{
	width: 150px;
	height: 37px;
	margin-left: 50px;
}

#realCost{

 margin-left: 300px;

}

#selectBOXTESTNAME{
	width: 155px;
	margin-left: 150px;
}
#selectBOXTESTCOST{
	width: 155px;
	margin-left: 150px;
}
</style>
 

<!-- ******************************************************
 현재 페이지는 문의하기를 제외한 모든 버튼을 다 보이게 합니다.(관리자 페이지) 
****************************************************** -->

<!-- 페이지 메인 문구 -->
<div class="container-fluid">
	<div class="row mb-2">
		<div class="col-sm-6">
			<h1>Service Center</h1>
		</div>
	</div>
</div>

<!-- 메인페이지 시작 -->
<div class="container-fluid">
	<div class="row">
		<div class="col-12">
			<!-- 메인 Content 시작 -->
			<div class="invoice p-3 mb-3">
				<div class="row">
					<div class="col-12">
						<h4>
							<i class="fas fa-chalkboard-teacher"></i> 고객센터 전체 글 목록 입니다.(관리자)
							<small class="float-right"> 
							    <input type="button"class="linkBtn btn btn-info" value="전체 글 조회" data-gopage="${cPath }/project/qnaList.do">
								<input type="button"class="linkBtn btn btn-info" value="삭제된 글만 조회" data-gopage="${cPath }/project/qnaDeleteList.do">
								<input type="button"class="linkBtn btn btn-info" value="답변이 없는 글만 조회" data-gopage="${cPath }/project/qnaNotAnswerList.do">
							</small>
						</h4>
					</div>
				</div>

				<br>

				<!-- 테이블 구역 -->
				<div class="container-fluid">
					<div class="row">
						<div class="col-12">
							<div class="card">
								<div class="card-body">
									<!-- 테이블 시작 -->
									<table id="example1" class="table table-bordered table-striped">
										<thead>
											<tr>
												<th>글번호</th>
												<th>제목</th>
												<th>작성자</th>
												<th>날짜</th>
												<!-- <th>삭제 유무</th> -->
											</tr>
										</thead>
										<c:set var="QnAList" value="${pagingVO.dataList}"></c:set>
										<tbody>
											<c:choose>
												<c:when test="${not empty QnAList }">
													<c:forEach items="${QnAList }" var="qna">
														<tr>
															<td>${qna.rnum }</td>
															<td><c:url value="qnaView.do" var="viewURL">
																	<c:param name="QnANo" value="${qna.qandaCode}" />
																</c:url> <a href="${viewURL }">${qna.qandaTitle }</a></td>
															<td>${qna.memId }</td>
															<td>${qna.qandaDate }</td>
														</tr>
													</c:forEach>
												</c:when>
												<c:otherwise>
													<tr>
														<td colspan="6">게시글이 없습니다.</td>
													</tr>
												</c:otherwise>
											</c:choose>	
										</tbody>
										<!-- dataTable Template 사용을 위한 tfoot 제거 -->
										   <%--  <tfoot>
											<tr>
												<td colspan="6">
													<div id="pagingArea" class="card-footer clearfix">${pagingVO.pagingHTML }</div>
												</td>
											</tr>
										</tfoot>  --%>
									</table>
									<div id="pagingArea" class="card-footer clearfix">${pagingVO.pagingHTML }</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 페이징 폼, 페이지 변환 -->
<form id="searchForm">
	<input type="hidden" name="page" />
</form>

<!-- 페이징 스크립트 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/commonjs/custom/paging.js"></script>

<!-- 페이징 스크립트, 페이지 변환 -->
<script type="text/javascript">
	let searchForm = $("#searchForm").paging();
</script>



























<button type="button" class="btn btn-default" data-toggle="modal" data-target="#modal-lg">Launch Large Modal</button>


<div class="modal fade" id="modal-lg">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">결제하기!</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			
			<br>

			<div id="pricing" class="container-fluid">
				<div class="text-center">
					<h4>결제수단을 선택해주세요</h4>
				</div>
				<div class="row slideanim">
					<div class="col-sm-4 col-xs-12">
						<div class="panel panel-default text-center">
							<div class="panel-heading">
								<h1>PAYCO</h1>
							</div>
							
							<br>
							
							<div class="panel-body">
								<button type="button" class="btn btn-block btn-outline-danger testTTTT" value="5000, payco, 1개월">
									<p><strong>1</strong> 개월 (5,000)</p>
								</button>
								<button type="button" class="btn btn-block btn-outline-danger testTTTT" value="10000, payco, 3개월">
									<p><strong>3</strong> 개월 (10,000)</p>
								</button>
								<button type="button" class="btn btn-block btn-outline-danger testTTTT" value="15000, payco, 5개월">
									<p><strong>5</strong> 개월 (15,000)</p>
								</button>
								<button type="button" class="btn btn-block btn-outline-danger testTTTT" value="20000, payco, 7개월">
									<p><strong>7</strong> 개월 (20,000)</p>
								</button>
								<button type="button" class="btn btn-block btn-outline-danger testTTTT" value="25000, payco, 9개월">
									<p><strong>9</strong> 개월 (25,000)</p>
								</button>
							</div>
						</div>
					</div>
					<div class="col-sm-4 col-xs-12">
						<div class="panel panel-default text-center">
							<div class="panel-heading">
								<h1>KAKAO</h1>
							</div>
							
							<br>
							
							<div class="panel-body">
								<button type="button" class="btn btn-block btn-outline-warning testTTTT" value="5000, kakao, 1개월">
									<p><strong>1</strong> 개월 (5,000)</p>
								</button>
								<button type="button" class="btn btn-block btn-outline-warning testTTTT" value="10000, kakao, 3개월">
									<p><strong>3</strong> 개월 (10,000)</p>
								</button>
								<button type="button" class="btn btn-block btn-outline-warning testTTTT" value="15000, kakao, 5개월">
									<p><strong>5</strong> 개월 (15,000)</p>
								</button>
								<button type="button" class="btn btn-block btn-outline-warning testTTTT" value="20000, kakao, 7개월">
									<p><strong>7</strong> 개월 (20,000)</p>
								</button>
								<button type="button" class="btn btn-block btn-outline-warning testTTTT" value="25000, kakao, 9개월">
									<p><strong>9</strong> 개월 (25,000)</p>
								</button>
							</div>
							<div class="panel-footer"></div>
						</div>
					</div>
					<div class="col-sm-4 col-xs-12">
						<div class="panel panel-default text-center">
							<div class="panel-heading">
								<h1>TOSS</h1>
							</div>
							<br>
							<div class="panel-body">
								<button type="button" class="btn btn-block btn-outline-primary testTTTT" value="5000, uplus, 1개월">
									<p><strong>1</strong> 개월 (5,000)</p>
								</button>
								<button type="button" class="btn btn-block btn-outline-primary testTTTT" value="10000, uplus, 3개월">
									<p><strong>3</strong> 개월 (10,000)</p>
								</button>
								<button type="button" class="btn btn-block btn-outline-primary testTTTT" value="15000, uplus, 5개월">
									<p><strong>5</strong> 개월 (15,000)</p>
								</button>
								<button type="button" class="btn btn-block btn-outline-primary testTTTT" value="20000, uplus, 7개월">
									<p><strong>7</strong> 개월 (20,000)</p>
								</button>
								<button type="button" class="btn btn-block btn-outline-primary testTTTT" value="25000, uplus, 9개월">
									<p><strong>9</strong> 개월 (25,000)</p>
								</button>
							</div>
						</div>
					</div>					
				</div>
				
				<br> 
				<br>

			</div>
			<div class="modal-footer justify-content-between">
				<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
			</div>
		</div>
	</div>
</div>

<script>

	$('.testTTTT').click(function() {
		var cost = $(this).val().split(',');

		var money = cost[0]; // 가격 지정
		var plat = cost[1]; // 플랫폼 이름 지정
		var platt = plat.trim()
		
		var IMP = window.IMP; // 문서에는 생략 가능이라는데 생략할 경우 실행이 안됩니다.
		IMP.init('imp23458695');
	
		IMP.request_pay({
			pg : platt,
			merchant_uid : 'merchant_' + new Date().getTime(),
			name : '프로젝트 결제',
			amount : money,
			buyer_email : 'daeduck@PAZ.LASTPROJECT',
			buyer_name : 'PAZ',
			buyer_tel : '010-1234-5678',
			buyer_addr : '대전 대덕인재개발원',
			buyer_postcode : '123-456'
		}, function(rsp) {
			console.log(rsp);
			if (rsp.success) {
				var msg = '결제가 완료되었습니다.';
				msg += '고유ID : ' + rsp.imp_uid;
				msg += '상점 거래ID : ' + rsp.merchant_uid;
				msg += '결제 금액 : ' + rsp.paid_amount;
				msg += '카드 승인번호 : ' + rsp.apply_num;
				/*  $.ajax({ // 데이터를 보낼 ajax
					    type: "GET", 
					    url: "/user/mypage/charge/point", //충전 금액값을 보낼 url 설정
					    data: {
					        "amount" : money
					    },
					}); */
			} else {
				var msg = '결제에 실패하였습니다.';
				msg += '에러내용 : ' + rsp.error_msg;
			}
			console.log(msg);
			//document.location.href="/user/mypage/home"; //alert창 확인 후 이동할 url 설정
		});		
	})
</script>

