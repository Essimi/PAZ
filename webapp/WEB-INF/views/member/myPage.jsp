<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!-- 환불 관련 스크립트, 타 jsp 에 구성시 실행이 안됩니다. -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<!-- 페이지 메인 문구 -->
<div class="container-fluid">
	<div class="row mb-2">
		<div class="col-sm-6">
			<h1>My Page</h1>
		</div>
	</div>
</div>

<div class="container-fluid">
	<div class="row">
		<div class="col-12">
			<div class="invoice p-3 mb-3">
				<div class="card-body box-profile">
					<div class="text-center">
						<input id = "changeMemberInfo" type="button" onclick="location.href='${cPath }/mypage/myPageUpdate.do'" class = "btn btn-primary btn-block" value="회원정보수정"> 
				    	<img id = "memberImage" class="img-circle elevation-2" src="${cPath }/resources/file/profileImage/${memberInfo.memIkon.saveName }" 
							onerror="this.src='${cPath }/resources/file/profileImage/profile.jpg'">
					</div>
				
					<h3 class="profile-username text-center">${memberInfo.memId }</h3>
				
					<ul class="list-group list-group-unbordered mb-3">
						<li class="list-group-item">
					    	<b>ID</b> 
					    	<a class="float-right">${memberInfo.memId }</a>
						</li>
						<li class="list-group-item">
					    	<b>NAME</b> 
					    	<a class="float-right">${memberInfo.memNickname }</a>
						</li>
				  		<li class="list-group-item">
					    	<b>E-Mail</b> 
					    	<a class="float-right">${memberInfo.memMail }</a>
						</li>
						<li class="list-group-item">
				  			<b>PHONE_NUMBER</b> 
				  			<a class="float-right">${memberInfo.memTel }</a>
				        </li>
				        <li class="list-group-item">
				  			<b>프로그램 사용 기한</b> 
				  			<input id = "extensionBtn" class="float-right btn btn-info" type="button" id="plusBtn" class="btn btn-default" data-toggle="modal" data-target="#modal-lgg" value ="연장하기">
				  			<a id = "memberDeadLineInfo" class="float-right">${memberInfo.payDeadline }</a>
				        </li>
				    </ul>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 메인페이지 시작 -->
<div class="row">
	<div class="col-12">
		<!-- 메인 Content 시작 -->
		<div class="invoice p-3 mb-3">
			<div class="row">
				<div class="col-12">
					<h4>
						<i id = "refundHead" class="fas fa-money-check"></i> 환불이 가능한 결제 리스트 입니다.
						<input id = "qnaLinkBtn" type="button" class="linkBtn btn btn-warning btn-sm" id="QnA_WriteButton" value="고객센터 문의하기" data-gopage="${cPath }/project/qnaWrite.do"> 
			    	</h4>
				    <p>결제일자가 한 달이 지나지 않은 결제만 환불이 가능합니다.<p>
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
								<table class="table table-bordered table-striped">
									<thead>
										<tr>
											<th>결제일자</th>
											<th>금액</th>
											<th>개월</th>
											<th>결제수단</th>	
										</tr>
									</thead>
									<tbody id = "refundArea">
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 추가결제 -->
<div class="modal fade" id="modal-lgg">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>

			<div id="pricing" class="container-fluid payAddArea">
				<div class="text-center">
					<h4 id = "payAddInfo">결제수단을 선택해주세요</h4>
				</div>
				<div class="row slideanim">
					<div class="col-sm-4 col-xs-12">
						<div class="panel panel-default text-center">
							<div class="panel-heading">
								<h1>PAYCO</h1>
							</div>
							<br>

							<div class="panel-body">
								<button type="button" class="btn btn-block btn-outline-danger payInfo" value="5000, payco, 1">
									<p>
										<strong>1</strong> 개월 (5,000)
									</p>
								</button>
								<button type="button" class="btn btn-block btn-outline-danger payInfo" value="10000, payco, 3">
									<p>
										<strong>3</strong> 개월 (10,000)
									</p>
								</button>
								<button type="button" class="btn btn-block btn-outline-danger payInfo" value="15000, payco, 5">
									<p>
										<strong>5</strong> 개월 (15,000)
									</p>
								</button>
								<button type="button" class="btn btn-block btn-outline-danger payInfo" value="20000, payco, 7">
									<p>
										<strong>7</strong> 개월 (20,000)
									</p>
								</button>
								<button type="button" class="btn btn-block btn-outline-danger payInfo" value="25000, payco, 9">
									<p>
										<strong>9</strong> 개월 (25,000)
									</p>
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
								<button type="button" class="btn btn-block btn-outline-warning payInfo" value="5000, kakao, 1">
									<p>
										<strong>1</strong> 개월 (5,000)
									</p>
								</button>
								<button type="button" class="btn btn-block btn-outline-warning payInfo" value="10000, kakao, 3">
									<p>
										<strong>3</strong> 개월 (10,000)
									</p>
								</button>
								<button type="button" class="btn btn-block btn-outline-warning payInfo" value="15000, kakao, 5">
									<p>
										<strong>5</strong> 개월 (15,000)
									</p>
								</button>
								<button type="button" class="btn btn-block btn-outline-warning payInfo" value="20000, kakao, 7">
									<p>
										<strong>7</strong> 개월 (20,000)
									</p>
								</button>
								<button type="button" class="btn btn-block btn-outline-warning payInfo" value="25000, kakao, 9">
									<p>
										<strong>9</strong> 개월 (25,000)
									</p>
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
								<button type="button" class="btn btn-block btn-outline-primary payInfo" value="5000, uplus, 1">
									<p>
										<strong>1</strong> 개월 (5,000)
									</p>
								</button>
								<button type="button" class="btn btn-block btn-outline-primary payInfo" value="10000, uplus, 3">
									<p>
										<strong>3</strong> 개월 (10,000)
									</p>
								</button>
								<button type="button" class="btn btn-block btn-outline-primary payInfo" value="15000, uplus, 5">
									<p>
										<strong>5</strong> 개월 (15,000)
									</p>
								</button>
								<button type="button" class="btn btn-block btn-outline-primary payInfo" value="20000, uplus, 7">
									<p>
										<strong>7</strong> 개월 (20,000)
									</p>
								</button>
								<button type="button" class="btn btn-block btn-outline-primary payInfo" value="25000, uplus, 9">
									<p>
										<strong>9</strong> 개월 (25,000)
									</p>
								</button>
							</div>
						</div>
					</div>
				</div>

				<br> <br>

			</div>
			<div class="modal-footer justify-content-between">
				<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
			</div>
		</div>
	</div>
</div>
             
<!-- 환불 modal -->                
<div class="modal fade" id="modal-refund">
	<div class="modal-dialog">
		<div class="modal-content">
    		<div class="modal-header">
	        	<h4 class="modal-title">환불 사유를 입력해주세요</h4>
	        	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
                	<span aria-hidden="true">&times;</span>
                </button>
    		</div>
    		<div class="modal-body">
    			<input type = "text" class="form-control form-control-lg" id = "refundText">
      		</div>
      		<div class="modal-footer justify-content-between">
		        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
		        <button type="button" class="btn btn-info" id = "realRefundBtn">환불하기</button>
      		</div>
    	</div>
  	</div>
</div>