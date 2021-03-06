<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<style>
body {
	overflow-x: hidden;
}

#chatMain {
	margin-left: 68px;
}

#chatRoomMain {
	margin-left: 68px;
}

.marginClass {
	margin-top: 10px;
	font-size: 15px;
	font-weight: bolder;
}

#nameSpace {
	margin-top: 20px;
}

#memberPlace {
	text-align: right;
}

.checkbox {
	margin-top: 5px;
	vertical-align: middle;
	width: 25px;
	height: 25px;
	float: right;
	border-radius: 50px;
}

.imgPropilePlace {
	margin-top: -1px;
	vertical-align: middle;
	width: 35px;
	height: 35px;
	border-radius: 50px;
}

.marginNumber {
	padding-right: 100px;
}

#noChatRoom {
	margin-top: 10px;
	text-align: center;
}

.direct-chat-text::after, .direct-chat-text::before {
	border-right-color: #FFE4E1;
}
</style>


<div class="row">
	<div class="col-12" style="margin-top: 20px"></div>
</div>


<!-- 세션에 있는 나의 아이디를 저장시켜둔다. -->

<security:authorize access="isAuthenticated()">
	<security:authentication property="principal.authMember" var="authMember" />
</security:authorize>

<c:set var="memId" value="${authMember.memId }" />

<input id="myId" type="hidden" value="${memId }">


<div class="col-md-11" id="chatMain">
	<div class="card">

		<div class="card-header">
			<h3 class="card-title">PROJECT MEMBERS</h3>
			<div class="card-tools">
				<span class="badge badge-success"><a id="multipleChat">MULTIPLE CHAT</a></span> <span class="badge badge-danger">${fn:length(memberList) }MEMBERS</span>
				<button type="button" class="btn btn-tool" data-card-widget="collapse">
					<i class="fas fa-minus"></i>
				</button>
			</div>
		</div>

		<div class="card-body p-0" style="margin-top: 15px;">

			<ul class="users-list clearfix">

				<c:choose>

					<c:when test="${not empty memberList}">

						<c:forEach items="${memberList}" var="member">

							<c:set var="memberId" value="${member.memId }"></c:set>

							<c:choose>

								<c:when test="${memberId eq memId}">

									<li>
										<img style="width: 150px; height: 150px;" src="${cPath }/resources/file/profileImage/${member.saveName }" alt="User Image" onerror="this.src='${cPath }/resources/file/profileImage/profile.jpg'">

										<a id="${member.memId }" class="users-list-name marginClass" href="#modal" style="font-weight: bold; color: red;">ME</a>
										<span class="users-list-date">${member.memId }</span> <span class="users-list-date">${member.position }</span>
									</li>

								</c:when>

								<c:otherwise>

									<li>


										<img style="width: 150px; height: 150px;" src="${cPath }/resources/file/profileImage/${member.saveName }" alt="Error" onerror="this.src='${cPath }/resources/file/profileImage/profile.jpg'">


										<a id="${member.memId }" class="users-list-name marginClass" href="#modal">${member.memNickname }</a>
										<span class="users-list-date">${member.memId }</span> <span class="users-list-date">${member.position }</span>
									</li>

								</c:otherwise>

							</c:choose>

						</c:forEach>

					</c:when>

					<c:otherwise>
						<p style="text-align: center;">NO MEMBER</p>>
					</c:otherwise>

				</c:choose>

			</ul>
		</div>

	</div>
</div>

<div class="col-md-11" id="chatRoomMain">

	<div class="container-fluid">
		<div class="row mb-1"></div>
	</div>

	<section class="content">
		<div class="card">

			<div class="card-header">
				<h3 class="card-title">CHATROOM LIST</h3>

				<div class="card-tools">
					<button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
						<i class="fas fa-minus"></i>
					</button>
				</div>
			</div>

			<div class="card-body p-0">
				<table class="table table-striped projects">

					<thead>
						<tr>
							<th style="width: 25%">ROOMNAME</th>
							<th style="width: 60%">MEMBERS</th>
							<th style="width: 15%"></th>
						</tr>
					</thead>

					<c:choose>

						<c:when test="${not empty chatRoomList}">

							<c:forEach items="${chatRoomList}" var="chatRoom">

								<tbody id="deleteChatTag${chatRoom.chatroomCode}">

									<tr>
										<td>
											<span> ${chatRoom.chatroomTitle} </span> <br /> <small> ${chatRoom.chatroomDate} </small>
										</td>

										<td>
											<ul class="list-inline">
												<c:forEach items="${chatRoom.memberSet}" var="member">
													<li class="list-inline-item">


														<img style="width: 50px; height: 50px; border-radius: 50px;" src="${cPath }/resources/file/profileImage/${member.saveName }" alt="Image" onerror="this.src='${cPath }/resources/file/profileImage/profile.jpg'">


													</li>
												</c:forEach>
											</ul>
										</td>

										<td class="project-actions text-right">

											<a class="btn btn-primary btn-sm" href="#">
												<i id="${chatRoom.chatroomCode}" class="fas fa-comment-dots startChatroom"> </i>
												<input type="hidden" value="${chatRoom.chatroomCode}">
											</a>

											<a class="btn btn-danger btn-sm" href="#">
												<i id="${chatRoom.chatroomCode}" class="fas fa-times-circle deleteChatroom"> </i>
											</a>

										</td>
									</tr>

								</tbody>

							</c:forEach>

						</c:when>

						<c:otherwise>

							<tbody>

								<tr>

									<td colspan="3">
										<p id="noChatRoom">채팅방이 존재하지 않습니다.</p>
									</td>


								</tr>

							</tbody>

						</c:otherwise>

					</c:choose>

				</table>
			</div>

		</div>
	</section>


</div>

<!-- 프로필 이미지를 열기 위한 모달 -->
<div class="modal fade" id="profileModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">

			<div class="modal-header">

				<h5 class="modal-title" id="exampleModalLabel">CHAT</h5>

				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>

			</div>

			<div class="modal-body">
				<div class="col-12 col-sm-6 col-md-12 d-flex align-items-stretch flex-column">
					<div class="card bg-light d-flex flex-fill">
						<div class="card-header text-muted border-bottom-0"></div>


						<div class="card-body pt-0">
							<div class="row">

								<div class="col-7">
									<h2 class="lead" id="nameSpace">
										<b></b>
									</h2>
									<p class="text-muted text-sm">
										<b id="aboutSpace"></b>
									</p>

									<input type="hidden" id="getChoiceMemId" value="">
									<input type="hidden" id="getChoiceMemNickname" value="">

									<ul class="ml-4 mb-0 fa-ul text-muted">

										<li class="small">
											<span class="fa-li"> <i class="fas fa-lg fa-building"> </i>
											</span> COMPANY : <span id="companySpace"></span>
										</li>


										<li class="small">
											<span class="fa-li"> <i class="fas fa-lg fa-phone"> </i>
											</span> PHONE : <span id="telSpace"></span>
										</li>

									</ul>

								</div>

								<img id="SpaceIMG" style="width: 168px; height: 150px;" src="" alt="User Image" onerror="this.src='${cPath }/resources/file/profileImage/profile.jpg'">

							</div>
						</div>

						<div class="card-footer">
							<div class="text-right">
								<a id="startChat" class="btn btn-sm bg-teal">
									<i class="fa fa-comment"></i>
								</a>

							</div>
						</div>
					</div>
				</div>

			</div>

		</div>
	</div>
</div>


<!-- 실제 채팅이 진행되는 모달 -->

<div class="modal fade" id="chatModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">

			<div class="modal-header">

				<h5 class="modal-title" id="exampleModalLabel">CHAT</h5>

				<button type="button" class="close" data-dismiss="modal" aria-label="Close" id="disconnectBtn">
					<span aria-hidden="true">&times;</span>
				</button>

			</div>

			<div class="card-header">
				<h3 class="card-title">DIRECT CHAT</h3>
			</div>

			<div class="modal-body">

				<div class="col-12 col-sm-6 col-md-12 d-flex align-items-stretch flex-column">
					<div class="card bg-light d-flex flex-fill">

						<div class="card-body">

							<div class="direct-chat-messages" id="messageArea"></div>

						</div>

						<!-- 메시지 전송 버튼 -->
						<div class="card-footer">

							<div class="input-group">
								<input type="text" name="message" placeholder="Type Message" class="form-control" id="messageTag">
								<span class="input-group-append">
									<button type="button" class="btn btn-primary" id="sendMsg">Send</button>
								</span>
							</div>

						</div>

					</div>
				</div>

			</div>

		</div>
	</div>
</div>


<!-- 채팅방에 초대할 멤버를 선택하는 모달 -->

<div class="modal fade" id="multipleChatModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">

			<div class="modal-header">

				<h5 class="modal-title" id="exampleModalLabel">CHAT</h5>

				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>

			</div>

			<div class="modal-body">

				<div class="col-12 col-sm-6 col-md-12 d-flex align-items-stretch flex-column">

					<div class="card">
						<div class="card-header">
							<h3 class="card-title">
								<i class="ion ion-clipboard mr-1"></i>
								INVITATION CHAT
							</h3>
						</div>

						<div class="card-body">
							<ul class="todo-list" data-widget="todo-list">
								<c:choose>

									<c:when test="${not empty memberList}">

										<c:forEach items="${memberList}" var="member">

											<c:set var="memberId" value="${member.memId }" />

											<c:if test="${ memId ne memberId }">

												<li>
													<div class="icheck-primary d-inline ml-2">
														<img class="imgPropilePlace" src="${cPath }/resources/file/profileImage/${member.saveName }" onerror="this.src='${cPath }/resources/file/profileImage/profile.jpg'">
														<span style="margin-left: 10px;">${member.memNickname } / ${member.memId } / ${member.position }</span>
														<input name="checkbox" class="checkbox" type="checkbox" value="${member.memId }">
													</div>
												</li>

											</c:if>

										</c:forEach>

									</c:when>

									<c:otherwise>
										멤버가 존재하지 않습니다.
									</c:otherwise>
								</c:choose>
							</ul>
						</div>
						<!-- /.card-body -->
						<div class="card-footer clearfix">
							<button type="button" class="btn btn-primary float-right" id="nextBtn">NEXT</button>
						</div>

					</div>

				</div>

			</div>

		</div>
	</div>
</div>




<!-- 채팅방 멤버 선택 이후 채팅방을 정보를 입력하기 위한 모달 -->

<div class="modal fade" id="MakeMultipleChatModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">

			<div class="modal-header">

				<h5 class="modal-title" id="exampleModalLabel">CHAT</h5>

				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>

			</div>

			<div class="modal-body">

				<div class="col-12 col-sm-6 col-md-12 d-flex align-items-stretch flex-column">

					<div class="card">
						<div class="card-header">
							<h3 class="card-title">
								<i class="ion ion-clipboard mr-1"></i>
								CREATE CHATROOM
							</h3>
						</div>

						<div class="card-body">

							<div class="card-body">
								<div class="form-group">
									<label for="inputName">CHATROOM TITLE</label>
									<input type="text" id="chatTitle" class="form-control">
								</div>
							</div>

						</div>
						<!-- /.card-body -->
						<div class="card-footer clearfix">
							<button type="button" class="btn btn-primary float-right" id="makeChatBtn">NEXT</button>
						</div>

					</div>

				</div>

			</div>

		</div>
	</div>
</div>

<!-- 채팅방 멤버가 1명 미만일 경우 경고창을 띄운다 -->
<div class="modal fade" id="chatWarningModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">

			<div class="modal-header">

				<h5 class="modal-title" id="exampleModalLabel">CHAT</h5>

				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>

			</div>

			<div class="modal-body">멤버를 선택해주세요.</div>

		</div>
	</div>
</div>


<!-- 삭제버튼 / 삭제 모달창  -->

<div class="modal fade" id="chatDeleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
		
			<div class="modal-header">
			
				<h5 class="modal-title" id="exampleModalLabel">OUT CHAT</h5>
				
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				
			</div>
			
			<div class="modal-body">채팅방 나가기 이후에는 어떤 데이터의 복원도 불가능합니다.</div>
			
			<div class="modal-footer">
				<button type="button" class="linkBtn btn btn-primary" onclick="outChatroom()">삭제</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
			</div>
		</div>
	</div>
</div>