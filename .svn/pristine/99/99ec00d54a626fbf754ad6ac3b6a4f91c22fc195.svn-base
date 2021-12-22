<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
#mainMargin {
	transition: margin-left .3s ease-in-out;
	margin-left: 25px;
	margin-right: 10px;
}
</style>

<!-- 세션에 있는 나의 아이디를 저장시켜둔다. -->

<security:authorize access="isAuthenticated()">
	<security:authentication property="principal.authMember" var="authMember" />
</security:authorize>

<c:set var="memId" value="${authMember.memId }" />

<input id="myId" type="hidden" value="${memId }">

<!-- ***************************** -->

<div class="content-wrapper" id="mainMargin">

	<section class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">

				<div class="col-sm-6" style="margin-top: 8px;">
					<h1>
						<i class="fas fa-user-clock"></i>
						TIMELINE
					</h1>
				</div>

			</div>
		</div>
	</section>



	<section class="content">
		<div class="container-fluid">

			<div class="row">
				<div class="col-md-12">


					<c:choose>

						<c:when test="${not empty alarmList}">

							<div class="timeline">

								<c:set var="date" value=""></c:set>

								<c:forEach items="${alarmList}" var="alarm">


									<c:set var="alarmType" value="${alarm.alarmType}"></c:set>

									<fmt:formatDate var="afterdate" pattern="MM.dd.yyyy" value="${alarm.alarmDate }" />
									<fmt:formatDate var="afterdateClass" pattern="MMddyyyy" value="${alarm.alarmDate }" />


									<c:set var="timeAgo" value="" />

									<c:set var="now" value="<%=new java.util.Date()%>" />
									<c:set var="postTime" value="${alarm.alarmDate }" />

									<fmt:parseNumber value="${now.time}" integerOnly="true" var="nowNumber" />
									<fmt:parseNumber value="${postTime.time}" integerOnly="true" var="Number" />

									<c:set var="millisecond" value="${nowNumber - Number}" />

									<fmt:formatNumber value="${millisecond / (100000)}" var="sec" pattern="0" />

									<c:choose>

										<c:when test="${sec < 60}">
											<c:set var="timeAgo" value="${sec}분" />
										</c:when>

										<c:when test="${sec > 60 &&  sec < 1440}">
											<fmt:formatNumber value="${sec / (60)}" var="time" pattern="0" />
											<c:set var="timeAgo" value="${time}시간" />
										</c:when>

										<c:otherwise>
											<fmt:formatNumber value="${sec / (60)}" var="time" pattern="0" />
											<c:set var="timeAgo" value="${time}시간" />

											<fmt:formatNumber value="${time / (24)}" var="days" pattern="0" />

											<c:set var="timeAgo" value="${days}일전" />
										</c:otherwise>

									</c:choose>


									<c:choose>



										<c:when test="${alarmType eq 'ALARM_TYPE003'}">





											<c:choose>

												<c:when test="${date eq afterdate}">

												</c:when>

												<c:otherwise>
													<div class="time-label ${afterdateClass }">
														<span class="bg-green">${afterdate }</span>
													</div>
												</c:otherwise>

											</c:choose>

											<div id="${alarm.alarmCode }DeleteLine">
												<i class="fas fa-bullhorn bg-maroon"></i>
												<div class="timeline-item">
													<span class="time"><i class="fas fa-clock"></i> ${timeAgo } 전</span>






													<c:choose>

														<c:when test="${alarm.alarmCheck eq 1}">

															<h3 class="timeline-header">
																<a href="#" id="${alarm.alarmCode }" data-postCode=${alarm.postCode } data-alarmCheck=${alarm.alarmCheck } class="selectPost">새로운 공지사항이 등록되었습니다.</a>

																<a href="#" style="color: red; font-weight: bold; font-size: 16px;" id="${alarm.alarmCode }" class="deleteAlarm ${afterdateClass }">
																	<span aria-hidden="true">&times;</span>
																</a>

															</h3>
															<div class="timeline-body">${alarm.alarmTitle }</div>

														</c:when>

														<c:otherwise>

															<h3 class="timeline-header">
																<a href="#" id="${alarm.alarmCode }" class="selectPost" data-postCode=${alarm.postCode } data-alarmCheck=${alarm.alarmCheck } style="color: gray; font-weight: normal;">새로운 공지사항이 등록되었습니다.</a>

																<a href="#" style="color: red; font-weight: bold; font-size: 16px;" id="${alarm.alarmCode }" class="deleteAlarm ${afterdateClass }">
																	<span aria-hidden="true">&times;</span>
																</a>


															</h3>
															<div class="timeline-body" style="color: gray;">${alarm.alarmTitle }</div>

														</c:otherwise>

													</c:choose>

												</div>
											</div>




										</c:when>



										<c:when test="${alarmType eq 'ALARM_TYPE002'}">

											<c:choose>
												<c:when test="${date eq afterdate}">



												</c:when>

												<c:otherwise>



													<div class="time-label ${afterdateClass }">
														<span class="bg-green">${afterdate }</span>
													</div>

												</c:otherwise>
											</c:choose>

											<div id="${alarm.alarmCode }DeleteLine">
												<i class="fas fa-user bg-yellow"></i>
												<div class="timeline-item">
													<span class="time"><i class="fas fa-clock"></i> ${timeAgo } 전</span>




													<c:choose>

														<c:when test="${alarm.alarmCheck eq 1}">

															<h3 class="timeline-header">
																<a href="#" id="${alarm.alarmCode }" class="selectPost" data-postCode=${alarm.postCode } data-alarmCheck=${alarm.alarmCheck }>"${alarm.alarmTitle }" 업무가 추가되었습니다.</a>

																<a href="#" style="color: red; font-weight: bold; font-size: 16px;" id="${alarm.alarmCode }" class="deleteAlarm ${afterdateClass }">
																	<span aria-hidden="true">&times;</span>
																</a>

															</h3>
															<div class="timeline-body">${alarm.alarmContents}</div>

														</c:when>

														<c:otherwise>

															<h3 class="timeline-header">
																<a href="#" id="${alarm.alarmCode }" class="selectPost" data-postCode=${alarm.postCode } data-alarmCheck=${alarm.alarmCheck } style="color: gray; font-weight: normal;">"${alarm.alarmTitle }" 업무가 추가되었습니다.</a>

																<a href="#" style="color: red; font-weight: bold; font-size: 16px;" id="${alarm.alarmCode }" class="deleteAlarm ${afterdateClass }">
																	<span aria-hidden="true">&times;</span>
																</a>

															</h3>
															<div class="timeline-body" style="color: gray;">${alarm.alarmContents}</div>

														</c:otherwise>

													</c:choose>










												</div>
											</div>



										</c:when>


										<c:otherwise>

											<c:choose>
												<c:when test="${date eq afterdate}">



												</c:when>

												<c:otherwise>



													<div class="time-label ${afterdateClass }">
														<span class="bg-green">${afterdate }</span>
													</div>

												</c:otherwise>
											</c:choose>

											<div id="${alarm.alarmCode }DeleteLine">
												<i class="fas fa-exclamation-triangle bg-purple"></i>
												<div class="timeline-item">
													<span class="time"><i class="fas fa-clock"></i> ${timeAgo } 전</span>







													<c:choose>

														<c:when test="${alarm.alarmCheck eq 1}">

															<h3 class="timeline-header">
																<a href="#" id="${alarm.alarmCode }" class="selectPost" data-postCode=${alarm.postCode } data-alarmCheck=${alarm.alarmCheck }>"${alarm.alarmTitle }" 이슈가 등록되었습니다.</a>

																<a href="#" style="color: red; font-weight: bold; font-size: 16px;" id="${alarm.alarmCode }" class="deleteAlarm ${afterdateClass }">
																	<span aria-hidden="true">&times;</span>
																</a>

															</h3>
															<div class="timeline-body">${alarm.alarmContents }</div>

														</c:when>

														<c:otherwise>

															<h3 class="timeline-header">
																<a href="#" id="${alarm.alarmCode }" class="selectPost" data-postCode=${alarm.postCode } data-alarmCheck=${alarm.alarmCheck } style="color: gray; font-weight: normal;">${alarm.alarmTitle }" 이슈가 등록되었습니다.</a>

																<a href="#" style="color: red; font-weight: bold; font-size: 16px;" id="${alarm.alarmCode }" class="deleteAlarm ${afterdateClass }">
																	<span aria-hidden="true">&times;</span>
																</a>

															</h3>
															<div class="timeline-body" style="color: gray;">${alarm.alarmContents}</div>

														</c:otherwise>

													</c:choose>





												</div>
											</div>

										</c:otherwise>


									</c:choose>

									<c:set var="date" value="${afterdate }"></c:set>

								</c:forEach>

								<div>
									<i class="fas fa-clock bg-gray"></i>
								</div>

							</div>

						</c:when>






						<c:otherwise>

						</c:otherwise>

					</c:choose>




				</div>
			</div>
		</div>

	</section>

</div>


<!-- 알람 삭제를 진행하기 위한 컨트롤러 -->

<script>
	$('.deleteAlarm').click(function() {

		var myId = $('#myId').val();

		var alarmCode = $(this).attr("id");
		var thisClass = $(this).attr("class");

		var array = thisClass.split(" ");
		var findClassTag = '.' + array[1];

		var classNumber = $(findClassTag).length;

		$.ajax({

			data : {
				myId : myId,
				alarmCode : alarmCode
			},
			dataType : "json",
			url : "${cPath}/alarm/alarmDelete.do",

			success : function(resp) {

				var idTag = '#' + resp.alarmCode + 'DeleteLine';
				$("div").remove(idTag);

				if (classNumber == 2) {
					$("div").remove(findClassTag);
				}

			},
			error : function(error) {
				console.log("실패");
			}

		});

	});
</script>

<!-- ************************* -->

<!-- 알람 상세 조회를 위한 컨트롤러 -->

<script>
	$('.selectPost')
			.click(
					function() {

						var alarmCode = $(this).attr("id");
						var postCode = $(this).attr('data-postcode');
						var alarmCheck = $(this).attr('data-alarmCheck');

						console.log(alarmCode);
						console.log(postCode);
						console.log(alarmCheck);

						var url = "${cPath}/project/${project.pCode}/alarm/alarmUpdate.do?alarmCode="
								+ alarmCode
								+ "&postCode="
								+ postCode
								+ "&alarmCheck=" + alarmCheck;

						console.log(url);

						location.href = url;

					});
</script>

<!-- ************************* -->