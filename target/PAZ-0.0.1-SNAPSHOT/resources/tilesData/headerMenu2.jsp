<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<security:authorize access="isAuthenticated()">
	<security:authentication property="principal.authMember" var="authMember"/>
</security:authorize>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<style>

	.modalContent {
		padding: 10px;
		border-top: 3px solid #3f6791;
	}
	
	.modal-header h4 {
		font-weight: 600;
	}
	
	#dateSpan {
		font-weight: 600;
		color:#3f6791;
	}
</style>
  
  <!-- 상단 메뉴 -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light" style="background:#f9f9f9">
    <!-- 오른쪽 아이콘 리스트  시작-->
    <ul class="navbar-nav ml-auto"> 
      <!-- timer -->
      
      <c:choose>
	      <c:when test = "${empty applicationScope[authMember.memId]}">
		      <li class="nav-item" >
		        <a class="nav-link" id = "onStart" data-slide="true" data-toggle="modal" role="button" data-target="#on">
		          <i class="fas far fa-clock"></i>
		        </a>
		      </li> 
		  </c:when>
	    
      	  <c:when test = "${applicationScope[authMember.memId] eq 'ON'}">
	          <li class="nav-item" >
	          	<a class="nav-link" id = "offEnd" data-slide="true" data-toggle="modal" role="button" data-target="#off">
	            	<i class="far fa-stop-circle"></i>
	            </a>
	          </li> 
	      </c:when> 
       </c:choose>
             
      <!-- 프로젝트 리스트 -->
<!--       <li class="nav-item" > -->
<%--         <a href="${cPath }/project/myprojectList.do" class="nav-link"  data-slide="true" role="button"> --%>
<!--           <i class="fas fa-clipboard-list"></i> -->
<!--         </a> -->
<!--       </li> -->
      
      <!-- 화상 회의 -->
      
	      <li class="nav-item" >
		      <div id="form">
<!-- 		        <input type="button" value="방 들어가기" id="submit"> -->
		        <a class="nav-link"  data-slide="true" id="submit" role="button">
		          <i class="fas fa-tv"></i>
	      	    </a>
      		 </div>
	      </li>
      
      
	<!-- ************************************************ --> 
	
	<!-- 채팅 -->
	<li class="nav-item dropdown">
	
	<a class="nav-link" href="${cPath }/project/${project.pCode}/chat/chatting.do" class="dropdown-item dropdown-footer">
	<i class="far fa-comments">
	</i>
	</a>
	
	</li>
	<!-- ************************************************ --> 
	
	<!-- 알람 -->
	<li class="nav-item dropdown">
	
	<a class="nav-link" data-toggle="dropdown" href="#">
	<i class="far fa-bell"></i>
	<span class="badge badge-warning navbar-badge" id="countAlarm"></span>
	</a>
	
	<!-- 알람 리스트 div -->
	<div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
	
	<div id="alarmListView">

	</div>	

	<div class="dropdown-divider"></div>
	<a href="${cPath }/project/${project.pCode}/alarm/alarmList.do" class="dropdown-item dropdown-footer">MORE ALARM</a>
	</div>
	
	</li>
	<!-- ************************************************ --> 
       
      <!-- Full Screen -->
      <li class="nav-item">
        <a class="nav-link" data-widget="fullscreen" href="#" role="button">
          <i class="fas fa-expand-arrows-alt"></i>
        </a>
      </li>
      
      
    </ul>
  </nav>
  
  
  <!-- 출근 modal -->
  <div class="modal fade" id="on">
    <div class="modal-dialog">
      <div class="modal-content modalContent">
        <div class="modal-header">
          <h4 class="modal-title">Timer</h4>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <p>현재 시간은 <span id = "dateSpan"></span>  입니다.</p>
          <p>업무를 시작하시겠습니까?</p>
        </div>
        <div class="modal-footer justify-content-between">
          <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
          <button type="button" id = "workStart" class="btn btn-warning">업무 시작</button>
        </div>
      </div>
    </div>
  </div>
  
  <!-- 퇴근 modal -->
  <div class="modal fade" id="off">
    <div class="modal-dialog">
      <div class="modal-content modalContent">
        <div class="modal-header">
          <h4 class="modal-title">Timer</h4>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <p>출근한 프로젝트 명 :  <span id = "startProjectName"></span></p>
          <p style="font-weight: 600;">출근한 시간 :  <span id = "startTime"></span></p>
          <p style="font-weight: 600;">현재 시간 :  <span id = "nowDate"></span></p>
          <p>퇴근하시겠습니까?</p>
        </div>
        <div class="modal-footer justify-content-between">
          <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
          <button type="button" id = "workEnd" class="btn btn-warning">퇴근</button>
        </div>
      </div>
    </div>
  </div>
  
  
  
<script>
var form = document.getElementById("submit")
form.addEventListener('click', ()=>{
	var win = window.open("https://192.168.0.52:3000/${project.pCode}", "_blank", "toolbar=yes,scrollbars=yes,resizable=yes,top=200,left=2300,width=1200,height=800");

});

// 회원에게 보여질 시간 관련 함수 입니다.
const realTime = function(){

	let today = new Date();
	function getWeek1( weekNo ) {
		var week = ["일", "월", "화", "수", "목", "금", "토" ];
		return week[weekNo];
	}
	
	let year = today.getFullYear();
	let month = today.getMonth()+1;
	let date = today.getDate();
	let week = getWeek1(today.getDay());
	let ampm = "오전 ";
	let hour = today.getHours();
	let lealhour = today.getHours(); // 24 시간으로 저장하기 위한 변수 설정
	let miniute =today.getMinutes();
	let second = today.getSeconds();
	
	// 조건문으로 오전 오후를 판단합니다.
	if (hour>12){
		
		hour = hour - 12;
		ampm = "오후 "
	}
	
	// 01, 02.. 형식으로 나올 수 있도록 설정합니다.
	if (month<10){ month = "0" + month;}
	if (date<10){ date = "0" + date;}
	if (week<10){ week = "0" + week;}
	if (hour<10){ hour = "0" + hour;}
	if (miniute<10){ miniute = "0" + miniute;}
	if (second<10){ second = "0" + second;}
	
	// 출력을 위한 결과를 생성합니다.
	let seeTime = (year + "년 " + month + "월 " + date + "일 (" 
				+ week + ") " + ampm + hour + "시 " + miniute + "분 " + second + "초 ");
	
	// 저장을 위한 결과를 생성합니다.
	let saveDBTime = (year + "-" + month + "-" + date + " " + lealhour + ":" + miniute + ":" + second);
	
	return {
		seeTime : seeTime,
		saveDBTime : saveDBTime
	};
};

// 버튼을 눌렀을 때의 시간을 기록합니다. (보여준 시간과 저장하는 시간의 동일성을 위함)
let realTimeSave = null;

// 출근 버튼을 눌렀을 경우 입니다.
$('#onStart').on('click', function(){
	
	let see = realTime();	
	$("#dateSpan").html(see.seeTime);
	
	realTimeSave = see.saveDBTime;
	console.log(realTimeSave)
	
})
	
// 업무 시작 ajax 입니다.
$('#workStart').on('click', function(){
		
	$.ajax({
		url : "/PAZ/project/timer/timerStart.do",
		method : "POST",
		data :{
			
			"timeSum" : realTimeSave
		},
		success : function(resp){
			
			alert(resp)
			location.replace(location.href);
		},
		error : function(xhr, jQuery, error) {
			console.log(jQuery);
			console.log(error);
		}	
	})
})
	
let offCode = null;	
	
// 퇴근 버튼을 눌렀을 경우 입니다.
$('#offEnd').on('click', function(){
	
	$.ajax({
		url : "/PAZ/project/timer/timerEndInfo.do",
		method : "POST",
		success : function(resp){
			
			console.log(resp);
			offCode = resp.whCode;
			$("#startTime").html(resp.whStart);
			$("#startProjectName").html(resp.ptitle);
					
		},error : function(xhr, jQuery, error) {
			console.log(jQuery);
			console.log(error);
		}
	})
	
	let see = realTime();	
	$("#nowDate").html(see.seeTime);
	
	realTimeSave = see.saveDBTime;
	
});

// 퇴근 ajax 입니다.
$('#workEnd').on('click', function(){
	
	$.ajax({
		url : "/PAZ/project/timer/timerEnd.do",
		method : "POST",
		data : {
			"timeSum" : realTimeSave,
			"whCode" : offCode
		},
		success : function(resp){
			alert(resp)
			location.replace(location.href);
		},
		error : function(xhr, jQuery, error) {
			console.log(jQuery);
			console.log(error);
		}			
	})
})

</script>

<!-- 알람 처리 자바 스크립트입니다. --> 

<script>

$(function() {
	
	let textArea = $("#alarmListView");
	let viewTag = "";
	
	$.ajax({
		url : '${cPath}/project/${project.pCode}/alarm/alarmView.do',	
		method : "POST",
		success : function(resp){
			
			alarmList = resp.alarmPreviewList;
			
			$('#countAlarm').text(resp.count);
			
			$.each (alarmList, function (index, alarm) {
				
				var url = "${cPath}/project/${project.pCode}/alarm/alarmUpdate.do?alarmCode="
					+ alarm.alarmCode
					+ "&postCode="
					+ alarm.postCode
					+ "&alarmCheck=" 
					+ alarm.alarmCheck;
				
				viewTag += "<div class='dropdown-divider'></div>";
				viewTag += "<a href='";
				viewTag += url;
				viewTag += "' class='dropdown-item'>";
				
				if (alarm.alarmType == 'ALARM_TYPE003') {
					viewTag += "<span class='badge bg-danger'>NEW NOTICE</span>";
				} else if (alarm.alarmType == 'ALARM_TYPE002') {
					viewTag += "<span class='badge bg-warning'>NEW WORK</span>";
				} else if (alarm.alarmType == 'ALARM_TYPE001') {
					viewTag += "<span class='badge bg-success'>NEW ISSUE</span>";
				}
				
				viewTag += "<p style='overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'>"
				viewTag += alarm.alarmTitle;
				viewTag += "</p>";
				viewTag += "</a>";
				
			});
			
			console.log(viewTag);
			textArea.append($("<div>").addClass("alarmView").html(viewTag));
			
		},
		error : function(xhr, jQuery, error) {
			console.log(error);
		}			
	})
	
});

</script>

<!-- ************************************************ --> 