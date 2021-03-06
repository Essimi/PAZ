<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<security:authorize access="isAuthenticated()">
   <security:authentication property="principal.authMember" var="authMember"/>
</security:authorize>


<style>
.modalContentStyle {

	width: 150%;
    margin-left: -15%;
}

.modalBodyStyle {
	border-top: 3px solid #f39c12;
    border-radius: 4px;

}

.modalDialogStyle {
	margin-top: 80px;
}

.modal-backdrop {
	display: none;
}

#leftImageModal {

    width: 50%;
    float: left;
    height: 100%;
    text-align: center;
}
 
#leftImageModal img {
	width: 150px;
	margin-top: 15%;
}

#rightModal {
    width: 50%;
    float: right;
    height: 100%;
    padding-left: 10px;
   
	
}

#rightModal i {
	margin-right: 10px;
}

#rightModal p {
	font-size: 15px;
	margin-bottom: 10px;
	color : #343a40cc;
}

#modalName {
	font-weight: bold;
    margin-top: 40px;
    color : #343a40;

}

</style>

 <!--  메인 사이드바 컨테이너 시작 -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!--  메인 로고 출력 --> 
    <a href="${cPath }/project/${project.pCode }/projectView.do" class="brand-link">
      <img src="${cPath }/resources/adminLTE3/dist/img/picon.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text font-weight-light">
      
      
       <c:set var="title" value="${project.pTitle }"></c:set>
        <c:choose>
        	<c:when test="${fn:length(title) gt 6 }">
        		${fn:substring(title,0,6) } ..
        	</c:when>
        	
        	<c:otherwise>
        		${title }
        	</c:otherwise>
        </c:choose>
      </span>
    </a>

   <!-- 사이드바 시작 -->
   
    <div class="sidebar">
    
      <!-- 사이드바 유저 접속 정보 -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image" id="leftImage">
        </div>
        <div class="info">
          <!-- 아이콘 클릭시 내 정보? 미정 -->
          <a id="leftA" class="d-block" data-toggle="modal" data-target="#myModalLeft"></a>
        </div>
        
        <c:if test="${position eq 'PL' }">
        	<span class="badge bg-warning" style="height: fit-content">PL</span>
        </c:if>
        
                
        <c:if test="${position ne 'PL' }">
        	<span class="badge bg-info" style="height: fit-content">${position }</span>
        </c:if>
        
      </div>

      
      
      <script type="text/javascript">
      
      	$(function() {
      	
      		$('#leftA').on('click', function() {
      			$('#myModalLeft').attr("style", "background: #00000066")
      			
      		})
      	})
      
      </script>  
		<div id="myModalLeft" class="modal fade" role="dialog">
		  <div class="modal-dialog modalDialogStyle">
		
		    <div class="modal-content modalContentStyle">
		      <div  class="modal-body modalBodyStyle"  style="padding:30px; height: 300px">
				
				<div id="leftImageModal">
				
				</div>
				
				<div id="rightModal">
				
					<h3 id="modalName">${authMember.memNickname} (${authMember.memId })</h3>
					
					<hr>
					
					
					<p> <i class="fas fa-envelope" style="color : #ffc107;"></i> ${authMember.memMail } </p>
					<p> <i class="fas fa-phone-alt" style="color : #3f6791;"></i> ${authMember.memTel }</p>
					<p> <i class="far fa-credit-card" style="color : #5c5c5c;"></i> ${authMember.payDeadline } <span style="font-size: 12px;">[결제 마감일]</span></p>
					<p> <i class="fas fa-birthday-cake" style="color : #d37c7c;"></i> ${authMember.memBirth }</p>
				
				</div>

				       
				        
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">확인</button>
			      
			      </div>
			    </div>
			
			  </div>
			</div>
      
      <!-- 메인 사이드바 -->
      <!-- 아이콘 - https://fontawesome.com/ -->
      <!-- i 태그 안에 넣으면 됩니다 -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
        

        
          <!-- li 태그 하나당 메뉴바 하나 입니다 -->
          <li class="nav-item">
            <a href="${cPath }/project/${project.pCode}/kanban/kanban.do" class="nav-link">
              <i class="nav-icon fas fa-columns"></i>
              <p>
                칸반       
              </p>
            </a>
          </li>
          
          <li class="nav-item">
            <a href="${cPath }/project/${project.pCode}/ganttChartTW/ganttChartTW.do" class="nav-link">
              <i class="nav-icon fas fa-list"></i>
              <p>
                간트 차트
              </p>
            </a>
          </li>
          
          <li class="nav-item">
            <a href="${cPath }/project/${project.pCode}/task/taskList.do" class="nav-link">
              <i class="nav-icon fas fa-folder-open"></i>
              <p>
               업무
                 
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="${cPath }/project/${project.pCode }/meeting/list.do" class="nav-link">
              <i class="nav-icon fab fa-confluence"></i>
              <p>
               회의록
                 
              </p>
            </a>
          </li>
      
          <li class="nav-item">
            <a href="${cPath }/project/${project.pCode}/issue/issueList.do" class="nav-link">
              <i class="nav-icon fas fa-exclamation-circle"></i>
              <p>
                이슈
              </p>
            </a>
          </li>
          
          <li class="nav-item">
            <a href="${cPath }/project/${project.pCode}/calendar/calendarMain.do" class="nav-link">
              <i class="nav-icon far fa-calendar"></i>
              <p>
               일정
              </p>
            </a>
          </li>
          
          <c:choose>
          	<c:when test="${position eq 'PL'}">
	          	<li class="nav-item">
	            <a href="${cPath }/project/${project.pCode}/projectPLStatus.do" class="nav-link">
	              <i class="nav-icon fas fa-chart-bar"></i>
	              <p>
	              <!-- 한규님 PL DashBoard 링크 넣으세여 -->
	              PL대시보드
	              </p>
	            </a>
	          </li>
          	</c:when>
          	
          	<c:when test="${position ne 'PL'}">
	          	<li class="nav-item">
	            <a href="${cPath }/project/${project.pCode}/projectPEStatus.do" class="nav-link">
	              <i class="nav-icon fas fa-chart-bar"></i>
	              <p>
	              	대시보드
	              </p>
	            </a>
	          </li>
          	</c:when>         
          </c:choose>
          
          <li class="nav-item">
            <a href="${cPath }/project/${project.pCode}/gitHub/gitTeam.do" class="nav-link">
              <i class="nav-icon fab fa-git"></i>
              <p>
                깃허브
                 
              </p>
            </a>
          </li>
          
          <li class="nav-item">
            <a href="${cPath }/project/${project.pCode}/news/newsList.do" class="nav-link">
              <i class="nav-icon far fa-newspaper"></i>
              <p>
                뉴스
              </p>
            </a>

	<!-- 이건 PL만 -->
          </li>
          
    	<c:if test="${position eq 'PL'}"> 
          <li id="navItem" class="nav-item">
            <a id="navA" href="#" class="nav-link">
              <i class="nav-icon fas fa-cog"></i>
              <p>
               설정
              <i class="right fas fa-angle-left"></i>
              </p>
            </a>
             <ul id="treeViewNav" class="nav nav-treeview">
              <li class="nav-item">
                 <a href="${cPath }/project/${project.pCode}/projectNotice/projectNoticeList.do" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>공지사항</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="${cPath }/project/${project.pCode}/calendar/calendarList.do" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>일정 관리</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="${cPath }/project/${project.pCode}/setting/memberSetting.do" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>팀원</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="${cPath }/project/${project.pCode}/gitHub/gitSetting.do" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>GitHub 연동</p>
                </a>
              </li>
              <!-- 미사용(정책 변경) -->
            </ul>
         </li>
      </c:if>
      
      
          
         </ul> 
      </nav>
    </div>
  </aside>

<script type="text/javascript">
	var AuthenticatedId = "${authMember.memId}";
	var leftImage = $("#leftImage");
	var leftImageModal = $('#leftImageModal');
	var leftA = $("#leftA");
	
	$.ajax({
		url : "${cPath}/mypage/leftMemberInfo.do",
		data : {memId : AuthenticatedId },
		method : "post",
		dataType : "json",
		success : function(resp) {
			let saveName = "";
			if(resp.memIkon){
				saveName = resp.memIkon.saveName;
			}else{
				saveName = "profile.jpg";
			}
			
			// 이건 소스가 아니라 객체라서, 객체의 레퍼런스 값을 변수로 받아놓은거래.
			// 이걸 두번 쓰려면 복제해서 써야지, 바로 갖다 넣으면 그냥 위치만 변경되는거임 
			let imgTag = $("<img>").addClass(['img-circle', 'elevation-2'])
								   .attr({
										src : '${cPath }/resources/file/profileImage/' + saveName,
										onerror : "this.src='${cPath }/resources/file/profileImage/profile.jpg'"
										});
			
			// 이렇게 imagTag 를 복제해서 넣기
			let imgTag2 = imgTag.clone();
			
			leftImage.html(imgTag);
			leftImageModal.append(imgTag2); 
			leftA.text(resp.memNickname + "(" + resp.memId + ")");
		},
		error : function(xhr, errorResp, error) {
			console.log(xhr);
			console.log(errorResp);
			console.log(error);
		}
	})
</script>