<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!-- 환불 관련 스크립트, 타 jsp 에 구성시 실행이 안됩니다. -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<style>
	
/* 	.row1 {
		width: 50%;
		float: left;
	}
	
	.row2 {
		width: 50%;
		float: right;
	}

	.invoice2 {
		min-height: 700px;
    	overflow: auto;
	}
	
	.invoice2 .card-body {
		overflow: auto;
	} */
	
	.list-group-item {
		background-color: #ffdead00;
	}
	
	.profileLeftDiv {
		width: 50%;
		float: left;
	}
	
	.ulDiv {
		margin-left:-50px;
		width: 50%;
	    float: left;
	
	}
	
	.profile-username {
		margin-top:30px;
		font-weight: bolder;
		font-size: 24px;
	}
	
	.list-group-item {
		border:none;
	}
	
	.cardBodyProfile {
		padding-bottom: 100px;
	}
	
	.payImg {
		width: 70%;
	    border-radius: 20px;
	    box-shadow: 1px 1px 8px 0px #00000045;
	}
	
	.col-xs-12 {
	    border: 1px solid #ececec;
	    padding: 30px;
	    border-radius: 10px;
	    background: #8080800d;
	    margin: 10px;
	}
	
	.col-sm-4-1 {
		width: 30%;
	}
	
	.col-sm-4-1:hover {
		box-shadow: 1px 1px 15px 1px #00000040;
	}
	
	.payInfo p {
		color : gray;
	}
	
	.payInfo p:hover {
		color : black;
		font-weight: bolder;
	}
	
	.marginR {
		margin-right: 20px;
	}
	
	.spanW {
		display: inline-block;
		width: 80px;
		font-weight: bolder;
	}
	
	#refundArea th{
		vertical-align: middle;
	}
	
	#memberDeadLineInfo {
		color: #65a74a;
		font-weight: 600;
	}
</style>
<!-- 페이지 메인 문구 -->
<div class="container-fluid">
	<div class="row mb-2">
		<div class="col-sm-6">
			<h1>My Page</h1>
		</div>
		
	</div>
</div>
<hr>
<div class="container-fluid">
	<div class="row row1">
		<div class="col-12">
			<div>
				<div class="card-body box-profile cardBodyProfile">
				
					<input id = "changeMemberInfo" type="button" onclick="location.href='${cPath }/mypage/myPageUpdate.do'" class = "btn btn-warning btn-block btn-sm" value="회원정보수정"> 
					
				<div style="margin-top : 100px;">
					<div class="text-center profileLeftDiv">
				    	<img id = "memberImage" class="img-circle elevation-2" src="${cPath }/resources/file/profileImage/${memberInfo.memIkon.saveName }" 
							onerror="this.src='${cPath }/resources/file/profileImage/profile.jpg'">
						
					</div>
				
				
				<div class="ulDiv">
					<h3 class="profile-username">${memberInfo.memNickname } (${memberInfo.memId })</h3>
				
					<hr>
				  		
			    	<p><i class="fas fa-envelope marginR" style="color : #ffc107;"></i> <span class="marginR spanW">이메일</span> ${memberInfo.memMail }</p>
				
				
		  			<p><i class="fas fa-phone-alt marginR" style="color : #3f6791;"></i> <span class="marginR spanW">전화번호</span>  ${memberInfo.memTel }</p>
		  			
		        
		        	<p><i class="far fa-credit-card marginR" style="color : #5c5c5c;"></i> <span class="marginR spanW">결제마감일</span>  <a id = "memberDeadLineInfo">${memberInfo.payDeadline }</a> <input id = "extensionBtn" class=" btn btn-default btn-sm" type="button" id="plusBtn" data-toggle="modal" data-target="#modal-lgg" value ="연장하기"></p>
		  			 
		  			
		  			
		       
		   
				    
				  </div>
				  
				 </div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 메인페이지 시작 -->
<div class="row row2">
	<div class="col-12">
		<!-- 메인 Content 시작 -->
		<div class="invoice p-3 mb-3 invoice2">
			<div class="row">
				<div class="col-12">
					<h4>
						<i id = "refundHead" class="fas fa-money-check"></i> 환불이 가능한 결제 리스트 입니다.
						<input id = "qnaLinkBtn" type="button" class="linkBtn btn btn-warning btn-sm" id="QnA_WriteButton" value="고객센터 문의하기" data-gopage="${cPath }/qna/qnaWrite.do"> 
			    	</h4>
				    <p style="margin-left: 10px; color:gray;">결제일자가 한 달이 지나지 않은 결제만 환불이 가능합니다.<p>
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
					<h4 id = "payAddInfo">결제수단을 선택해주세요<img id="refundIcon" class="refundIconClass" src="${cPath }/resources/file/creditCard.png" style="width: 25px; margin-left: 10px;"></h4>
					
				</div>
				<div class="row slideanim">
					<div class="col-sm-4-1 col-xs-12">
						<div class="panel panel-default text-center">
							<div class="panel-heading">
								<div><h1><img id="refundIcon" class="payImg" src="${cPath }/resources/file/paycoImg.png"></h1></div>
							</div>
							<br>

							<div class="panel-body">
								<button type="button" class="btn btn-block payInfo" value="5000, payco, 1">
									<p>
										<strong>1</strong> 개월 (5,000)
									</p>
								</button>
								<button type="button" class="btn btn-block payInfo" value="10000, payco, 3">
									<p>
										<strong>3</strong> 개월 (10,000)
									</p>
								</button>
								<button type="button" class="btn btn-block payInfo" value="15000, payco, 5">
									<p>
										<strong>5</strong> 개월 (15,000)
									</p>
								</button>
								<button type="button" class="btn btn-block payInfo" value="20000, payco, 7">
									<p>
										<strong>7</strong> 개월 (20,000)
									</p>
								</button>
								<button type="button" class="btn btn-block payInfo" value="25000, payco, 9">
									<p>
										<strong>9</strong> 개월 (25,000)
									</p>
								</button>
							</div>
						</div>
					</div>
					<div class="col-sm-4-1 col-xs-12">
						<div class="panel panel-default text-center">
							<div class="panel-heading">
								<div><h1><img id="refundIcon" class="payImg" src="${cPath }/resources/file/kakaoPayImg.png"></h1></div>
							</div>

							<br>

							<div class="panel-body">
								<button type="button" class="btn btn-block payInfo" value="5000, kakao, 1">
									<p>
										<strong>1</strong> 개월 (5,000)
									</p>
								</button>
								<button type="button" class="btn btn-block payInfo" value="10000, kakao, 3">
									<p>
										<strong>3</strong> 개월 (10,000)
									</p>
								</button>
								<button type="button" class="btn btn-block payInfo" value="15000, kakao, 5">
									<p>
										<strong>5</strong> 개월 (15,000)
									</p>
								</button>
								<button type="button" class="btn btn-block payInfo" value="20000, kakao, 7">
									<p>
										<strong>7</strong> 개월 (20,000)
									</p>
								</button>
								<button type="button" class="btn btn-block payInfo" value="25000, kakao, 9">
									<p>
										<strong>9</strong> 개월 (25,000)
									</p>
								</button>
							</div>
							<div class="panel-footer"></div>
						</div>
					</div>
					<div class="col-sm-4-1 col-xs-12">
						<div class="panel panel-default text-center">
							<div class="panel-heading">
								<div><h1><img id="refundIcon" class="payImg" src="${cPath }/resources/file/tossImg.png"></h1></div>
							</div>
							<br>
							<div class="panel-body">
								<button type="button" class="btn btn-block payInfo" value="5000, uplus, 1">
									<p>
										<strong>1</strong> 개월 (5,000)
									</p>
								</button>
								<button type="button" class="btn btn-block payInfo" value="10000, uplus, 3">
									<p>
										<strong>3</strong> 개월 (10,000)
									</p>
								</button>
								<button type="button" class="btn btn-block payInfo" value="15000, uplus, 5">
									<p>
										<strong>5</strong> 개월 (15,000)
									</p>
								</button>
								<button type="button" class="btn btn-block payInfo" value="20000, uplus, 7">
									<p>
										<strong>7</strong> 개월 (20,000)
									</p>
								</button>
								<button type="button" class="btn btn-block payInfo" value="25000, uplus, 9">
									<p>
										<strong>9</strong> 개월 (25,000)
									</p>
								</button>
							</div>
						</div>
					</div>
				</div>

			

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