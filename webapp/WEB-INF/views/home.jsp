<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>PAZ</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<jsp:include page="/resources/tilesData/homeScript/homePreScript.jsp"/>

<!-- font -->
<link rel="preconnect" href="https://fonts.googleapis.com"> 
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin> 
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

<style type="text/css">
body { 
	font-family: 'Noto Sans KR', sans-serif; 
}
</style>

<!-- PRE script 파일에 등록시 적용이 안됨. -->
<!-- 임시로 현재 jsp 파일에 등록했습니다. -->
<!-- 결제 관련 script -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<security:authorize access="isAuthenticated()">
   <security:authentication property="principal.authMember" var="authMember"/>
</security:authorize>

</head>


<style>

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


	.panel-body button {
		background: none;
	}


</style>

<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">
	<nav class="navbar navbar-default navbar-fixed-top">
				<img id="logoText" class="navbar-brand" src="${cPath }/resources/file/pazlocoo.png">
			<div class="" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${cPath }/notice/noticeList.do">NOTICE</a></li>
					<c:if test = "${not empty authMember.memId }">
						<li><a href="${cPath }/qna/qnaUserList.do">QNA</a></li>
					</c:if>
					<li><a href="#guide">GUIDE</a></li>
					<li><a href="#example">EXAMPLE</a></li>
					<li><a href="#contact">INFO</a></li>
					<security:authorize access="isAnonymous()">
						<li><a href="${cPath }/login/login.do">LOGIN</a></li>
						<li><a href="${cPath }/login/join.do">JOIN</a></li>
					</security:authorize>
					<security:authorize access="isAuthenticated()">
						<li><a href="${cPath }/login/requestKakaologout.do">LOGOUT</a></li>
					</security:authorize>
				</ul>
			</div>
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
			</div>
		</div>
	</nav>


	<div id="about" class="container-fluid slideanim2 slide2">
		<div class="row">
			<div id="titleText" class="col-sm-8 slideanim2 slide2">
				<h1>프로젝트 관리의</h1>
				<h1>시작부터 끝까지</h1>
				<h1>PAZ 에서</h1>
				<h1>빠르고 안전하게!</h1>
				<input id="project" type="button" class="btn btn-danger" value="프로젝트 시작하기" />
			</div>

			<div class="col-sm-4">
			<div class="windowcon">
				<div class="container">
					<img id="mainTitle" src="resources/adminLTE3/dist/img/mainTitle.png">
					<img id="mainTitle" src="resources/adminLTE3/dist/img/mainTitle.png">
					<img id="mainTitle" src="resources/adminLTE3/dist/img/mainTitle.png"> 
				</div>
			</div>
				<!-- <img id="mainTitle" src="resources/adminLTE3/dist/img/mainTitle.png" /> -->
			</div>
		</div>
	</div>


	<!-- 이용가이드  -->
	<div id="guide" class="container-fluid bg-grey">
		<!--  여기에 넣어 !!!  -->
		<div>
			<h2 id="guideText">PAZ의 빠르고 편리한 프로세스를 경험해보세요.</h2>
			<hr>
		</div>
		
		<ul class="nav nav-pills">
			<li class="active"><a data-toggle="pill" href="#home">Step 1</a></li>
			<li><a data-toggle="pill" href="#menu1">Step 2</a></li>
			<li><a data-toggle="pill" href="#menu2">Step 3</a></li>
			<li><a data-toggle="pill" href="#menu3">Step 4</a></li>
		</ul>

		<div class="tab-content" style="margin-top: 50px;">
			<div id="home" class="tab-pane fade in active">

				<div class="step">
					<h2>
						<span style="color: #358099">Step 1</span> &nbsp;&nbsp;&nbsp; 내
						프로젝트 생성
					</h2>
					<br>
					<p>진행하고자 하는 프로젝트를 생성해보세요.</p>
					<p>프로젝트 분야 선택 부터 팀원 관리 까지</p>
					<p>프로젝트 진행을 PAZ가 도와드립니다.</p>
					<br>
					<p style="font-size: 16px; color: gray;">* PAZ 에서는 Project Leader와 팀원이 원활히 소통할 수 있도록 프로젝트 관리를 도와줍니다.</p>
					<p style="font-size: 16px; color: gray;">* 월 4,900원의 결제가 필요합니다.</p>
				</div>
				<img id="step1" src="resources/adminLTE3/dist/img/step1.png" />
			</div>


			<div id="menu1" class="tab-pane fade">
				<div class="step">
					<h2>
						<span style="color: #358099">Step 2</span> &nbsp;&nbsp;&nbsp; 팀원 초대
					</h2>
					<br>
					<p>함께 프로젝트를 진행하고 싶은 회원을 초대합니다.</p>
					<p>초대한 팀원과 소통하며,</p>
					<p>프로젝트를 성공적으로 마무리하세요.</p>
					<br>
				</div>
				<img id="step2" src="resources/adminLTE3/dist/img/step2.png" />
			</div>

			<div id="menu2" class="tab-pane fade">
				<div id="divStep3" class="step">
					<h2>
						<span style="color: #358099">Step 3</span> &nbsp;&nbsp;&nbsp; 역할 지정
					</h2>
					<br>
					<p>함께 프로젝트를 진행하고 싶은 회원을 초대합니다.</p>
					<p>초대한 팀원과 소통하며,</p>
					<p>프로젝트를 성공적으로 마무리하세요.</p>
					<br>
				</div>
				<img id="step3" src="resources/adminLTE3/dist/img/step3.png" />
			</div>

			<div id="menu3" class="tab-pane fade">
				<div id="divStep4" class="step">

					<h2>
						<span style="color: #358099">Step 4</span> &nbsp;&nbsp;&nbsp; 프로젝트 진행
					</h2>
					<br>
					<p>모든 준비가 완료되었습니다.</p>
					<p>칸반, 업무 등록, 이슈 등</p>
					<p>PAZ의 모든 기능을 이용하여</p>
					<p>프로젝트 진행을 바로 시작하세요.</p>
					<br>
				</div>
				<img id="step4" src="resources/adminLTE3/dist/img/step4.png" />
			</div>
		</div>
	</div>

	<div id="example" class="container-fluid text-center bg-grey">
		<h2 style="margin-bottom: 0;">EXAMPLE</h2>
		<br>
		<h4>PAZ의 다음과 같은 기능들을 체험해보세요.</h4>
		<div class="row text-center slideanim">
			<div class="col-sm-4">
				<div class="thumbnail">
					<img src="${cPath }/resources/file/exkanban.JPG" alt="Paris" width="400" height="300">
					<p>
						<strong>칸반 보드</strong>
					</p>
					<p>자신의 업무를 자유롭게 옮기세요</p>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="thumbnail">
					<img src="${cPath }/resources/file/exgantt.JPG" alt="New York" width="400" height="300">
					<p>
						<strong>간트 차트</strong>
					</p>
					<p>실시간으로 업무의 진척도를 확인하세요</p>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="thumbnail">
					<img src="${cPath }/resources/file/exgithub.png"
						alt="San Francisco" width="400" height="300">
					<p>
						<strong>깃허브</strong>
					</p>
					<p>코드를 자유롭게 불러오세요</p>
				</div>
			</div>
		</div>
		<br>

		<h2 style="margin-top: 50px;">What our customers say</h2>
		<div id="myCarousel" class="carousel slide text-center" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<h4>
						"프로젝트를 관리하는데 효과적인 PAZ를 적극 추천합니다"<br>
						<span>김OO 개발자</span>
					</h4>
				</div>
				<div class="item">
					<h4>
						"깃허브 연동도 되다니 너무 좋아요 ... WOW!!"<br>
						<span>정OO 개발자</span>
					</h4>
				</div>
				<div class="item">
					<h4>
						"저희 회사에서 적극 활용중인 툴입니다!"<br>
						<span>이OO소프트웨어</span>
					</h4>
				</div>
			</div>

			<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev"> 
				<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> 
			<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next"> 
				<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</div>


	


	<input type="hidden" id="payHiddenBtn" class="btn btn-default" data-toggle="modal" data-target="#modal-lg">


	<!-- 결제 modal -->
	<div class="modal fade" id="modal-lg">
		<div class="modal-dialog modal-lg">
			<div class="modal-content" style="margin-top: 100px;">
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
				<div class="row slideanim1">
					<div class="col-sm-4-1 col-xs-12">
						<div class="text-center">
							<div>
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
						<div class="text-center">
							<div>
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
						</div>
					</div>
					<div class="col-sm-4-1 col-xs-12">
						<div class="text-center">
							<div>
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

	<footer class="container-fluid text-center">
		<a href="#myPage" title="To Top"> <span
			class="glyphicon glyphicon-chevron-up"></span>
		</a>
		<p>Paz Home Page</p>
	</footer>
	
<jsp:include page="/resources/tilesData/homeScript/homePostScript.jsp"/>	

</body>
</html>