<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/commonjs/custom/jquery.form.min.js"></script>






<h3>
	<i class="fas fa-user-cog"></i> 관리자 페이지
</h3>

<hr>
<br>

<!-- 라인 기준  -->
<!-- 로그인/로그아웃 시간별 대시보드 -->
<div class="row">
	<div class="col-md-12">
		<h4 style="margin-bottom: 20px;">로그인/로그아웃 시간</h4>
		<div class="card">
			<div class="card-header">
				<h5 class="card-title" id="issueCountHeader">로그인 / 로그아웃 시간별 빈도수</h5>

			</div>

			<div class="card-body">

				<!-- highcharts - line-labels -->
				<figure class="loginLogoutTime-highcharts-figure"
					style="float: left;">
					<div id="loginLogoutTime" style="width: 1640px;"></div>
				</figure>

			</div>
		</div>
	</div>
</div>

<br>
<hr>
<br>

<h4>회원 관리</h4>
<br>
<div class="row">
	<div class="col-12">
		<div class="card">
			<div class="card-header">
				<h3 class="card-title">회원 리스트</h3>

				<div class="card-tools">
					<div class="input-group input-group-sm">
						<button id="adminMember" type="button" class="btn btn-default"
							onclick="location.href='${cPath}/admin/adminMemberList.do'">
							<i class="fas fa-align-justify"></i> 더보기
						</button>

					</div>
				</div>
			</div>
			<!-- /.card-header -->
			<div class="card-body table-responsive p-0">
				<table class="table table-hover text-nowrap">
					<thead>
						<tr>
							<th>아이디</th>
							<th>이름</th>
							<th>가입일</th>
							<th>회원소속</th>
							<th>생년월일</th>
							<th>성별</th>
							<th>탈퇴여부</th>
						</tr>
					</thead>
					<tbody>



						<c:set var="dataList" value="${memberpagingVO.dataList }"></c:set>


						<c:choose>
							<c:when test="${not empty dataList }">
								<c:forEach items="${dataList }" var="data">

									<tr>
										<td>${data.memId }</td>
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
		</div>
		<!-- /.card -->
	</div>
</div>


<br>
<hr>
<br>
<!-- 결제/환불 -->
<!-- 결제환불 리스트  -->
<div class = "row">


	<!-- 결제 환불 -->
			<div class="col">
			<h4 style="margin-bottom: 20px;">결제 및 환불</h4>
				<div class="card" >
					<div class="card-header">
						<h4 class="card-title">결제 및 환불 리스트</h4>

						<div class="card-tools">
							<div class="input-group input-group-sm">
								<button id="adminPay" type="button" class="btn btn-default"
									onclick="location.href='${cPath}/admin/payRetrieve/List.do'">
									<i class="fas fa-align-justify"></i> 더보기
								</button>
							</div>
						</div>
					</div>
					<!-- /.card-header -->
					<div class="card-body table-responsive p-0">
						<table class="table table-hover text-nowrap" style="height: 352px;">
							<thead>
								<tr>
									<th>결제 날짜</th>
									<th>결제/환불</th>
									<th>아이디</th>
									<th>개월수</th>
									<th>결제 금액</th>
								</tr>
							</thead>

							<tbody>
								<c:set var="payRetrieveList" value="${paypagingVO.dataList}"></c:set>

								<c:choose>

									<c:when test="${not empty payRetrieveList}">
										<c:forEach items="${payRetrieveList}" var="Retrieve">
											<tr>
												<td>${Retrieve.payDate }</td>

												<!-- 여기가 환불 결제 조회하는곳  -->

												<c:choose>
													<c:when test="${not empty Retrieve.refundInfo.refundCode}">
														<td>환불완료</td>
													</c:when>
													<c:otherwise>
														<td>결제완료</td>
													</c:otherwise>
												</c:choose>


												<td>${Retrieve.memId}</td>

												<td>${Retrieve.payMonth}개월</td>

												<td><fmt:formatNumber value="${Retrieve.payAmount}" pattern="#,###"/>원</td>
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
						</table>
					</div>
					<!-- /.card-body -->
				</div>
				<!-- /.card -->
			</div>
		<!-- </div> -->
	
	<!-- 틀 그래프 -->
	<!-- BAR CHART 결제/환불 -->
	
	<div class="col">
	<h4 style="margin-bottom: 20px;">매출</h4>
		<div class="card">
			<div class="card-header">
				<h3 class="card-title">월별 매출</h3>
			</div>
			<div class="card-body p-0">
				<div class="d-md-flex">
					<div class="p-1 flex-fill">
						<div id="world-map-markers">

							<!-- highcharts - pie-legend -->

							<figure class="payRfund-highcharts-figure" >
								<div id="payRfund" style="height: 320px;"></div>
							</figure>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<br>
<hr>
<br>

<!-- 라인 기준  -->
<div class="row">

	<!-- 왼쪽 그래프 -->

	<!-- 회원 남/녀,연령대 비율 그래프. -->
	<div class="col">
		<h4 style="margin-bottom: 20px;">회원 남/녀,연령대</h4>
		<div class="card">
			<div class="card-header">
				<h3 class="card-title">회원 남/녀,연령대 비율 그래프</h3>
			</div>
			<div class="card-body p-0">
				<div class="d-md-flex">
					<div class="p-1 flex-fill">
						<div id="world-map-markers" style="height: 432px">

							<!-- highcharts - pie-legend -->

							<div
								style="position: relative; left: 50px; top: 20px; z-index: 2;">
								<figure class="jender-highcharts-figure">
									<div id="jender" style="height: 150px; width: 150px;"></div>
								</figure>
							</div>

							<div
								style="position: relative; left: 10px; top: -150px; z-index: 1;">
								<figure class="ageList-highcharts-figure">
									<div id="ageList" style="width: 800px;"></div>
								</figure>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="col">
		<h4 style="margin-bottom: 20px;">회원 소속</h4>
		<div class="card">
			<div class="card-header">
				<h3 class="card-title">회원 소속별 그래프</h3>
			</div>
			<div class="card-body p-0">
				<div class="d-md-flex">
					<div class="p-1 flex-fill">
						<div id="world-map-markers">

							<!-- highcharts - pie-legend -->

							<figure class="memderClassification-highcharts-figure" >
								<div id="memderClassification"></div>
							</figure>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</div>

<br>
<hr>
<br>
<div class="row">
	<div class="col-md-12">
		<h4 style="margin-bottom: 20px;">분야별 프로젝트</h4>
		<div class="card">
			<div class="card-header">
				<h5 class="card-title" id="issueCountHeader">분야별 프로젝트 그래프</h5>

			</div>

			<div class="card-body">

				<!-- highcharts - line-labels -->
				<figure class="projectClass-highcharts-figure" style="float: left;">
					<div id="projectClass" style="width: 1640px;"></div>
				</figure>

			</div>
		</div>
	</div>
</div>
<br>
<hr>
<br>


<!-- 라인 기준  -->
<div class="row">

	<!-- 왼쪽 그래프 -->

	<!-- 회원 남/녀,연령대 비율 그래프. -->
	<div class="col">
		<h4 style="margin-bottom: 20px;">메뉴별 평균 평점</h4>
		<div class="card">
			<div class="card-header">
				<h3 class="card-title">메뉴별 평균 평점 그래프</h3>
			</div>
			<div class="card-body p-0">
				<div class="d-md-flex">
					<div class="p-1 flex-fill">
						<div id="world-map-markers">
			
							<!-- highcharts - pie-legend -->
									<figure class="projectFunction-highcharts-figure">
										<div id="projectFunction" style="height: 480px;"></div>
									</figure>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="col">
		<h4 style="margin-bottom: 20px;">특정 기능 선호도</h4>
		<div class="card">
			<div class="card-header">
				<h3 class="card-title">특정 단어 빈도수</h3>
			</div>
			<div class="card-body p-0">
				<div class="d-md-flex">
					<div class="p-1 flex-fill">
						<div id="world-map-markers">

							<!-- highcharts - pie-legend -->
								<figure class="wordStackTo-highcharts-figure">
									<div id="wordStackTo" style="width: 600px; height: 480px"></div>
								</figure>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="col">
		<h4 style="margin-bottom: 20px;">개선사항</h4>
		<div class="card">
			<div class="card-header">
				<h3 class="card-title">개선사항 리스트</h3>
			</div>
			<div class="card-body p-0">
				<div class="d-md-flex">
					<div class="p-1 flex-fill">
						<div id="world-map-markers">

							<div class="card-body" style="height: 510px;">
							<!-- 테이블 시작 -->
							<table class="table table-bordered table-striped"
								style="height: 480px;">
								<thead>
									<tr>
										<th>후기글</th>
									</tr>
								</thead>
								<tbody id="listBody">

								</tbody>
								<tfoot>
									<tr>
										<td>
											<div id="pagingArea" class="card-footer clearfix"></div>
										</td>
									</tr>
								</tfoot>

							</table>
						</div>

							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<!-- 게시판 페이징 기능 -->
<form id="searchForm">
	<input type="hidden" name="page" />
</form>









