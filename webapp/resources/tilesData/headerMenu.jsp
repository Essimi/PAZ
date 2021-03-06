<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 챗봇 아이디를 가져오기 위한 코드-->
    
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <sec:authorize access="isAuthenticated()">
    	<sec:authentication property="principal.authMember" var="authMember" />
    </sec:authorize>
    
    <input id="chatbotId" type="hidden" value="<c:out value="${authMember.memId}"/>">
    
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    
    <ul class="navbar-nav">
	    <li class="nav-item">
	    	<a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
	    </li>
	    
	    <li class="nav-item d-none d-sm-inline-block">
	    	<a href="${cPath }" class="nav-link">Home</a>
	    </li>
	    
	    <c:if test = "${not empty authMember.memId }">    
	    	 <c:if test="${authMember.memId ne 'admin' }">
			    <li class="nav-item d-none d-sm-inline-block">
			    	<a href="${cPath }/project/myprojectList.do" class="nav-link">Project List</a>
			    </li>
		    </c:if>
		</c:if>    
    </ul>
    
    <!-- 오른쪽 아이콘 리스트  시작-->
    <ul class="navbar-nav ml-auto">
    
    <c:if test="${authMember.memId eq 'admin' }">
    
	    <!-- 관리자 페이지 -->
	    <li class="nav-item" >
		    <a class="nav-link" data-slide="true" href = "${cPath }/admin/adminMain.do" role="button">
		    	<i class="fas fa-tools"></i>
		    </a>
	    </li>
    
    </c:if>
    
    <!-- 마이페이지 -->
    <c:if test = "${not empty authMember.memId }">
       <c:if test="${authMember.memId ne 'admin' }">
	      <li class="nav-item" >
	        <a class="nav-link"  data-slide="true" href="${cPath }/mypage/myPage.do" role="button">
	          <i class="fas fa-user"></i>
	        </a>
	      </li> 
      </c:if>
    </c:if>
    
    <!-- 공지사항 -->
    <c:if test = "${not empty authMember.memId }">
	    <li class="nav-item" >
		    <a class="nav-link" data-slide="true" href = "${cPath }/notice/noticeList.do" role="button">
		    	<i class="fas fa-bullhorn"></i>
		    </a>
	    </li>
    </c:if>
    
    <!-- 챗봇 -->
    <c:if test = "${not empty authMember.memId }">
	    <li class="nav-item" >
		    <a class="nav-link hello" data-slide="true" onclick="ChannelIO('showMessenger')" data-slide="true"  role="button">
		    	<i class="fas fa-robot"></i>
		    </a>
	    </li>
    </c:if>
    
    <!-- 고객센터 -->
    <c:if test = "${not empty authMember.memId }">
	    <li class="nav-item" >
		    <a class="nav-link" data-slide="true" href = "${cPath }/qna/qnaUserList.do" role="button">
		    	<i class="far fa-grin"></i>
		    </a>
	    </li>
    </c:if>
    
    <!-- 로그아웃 -->
    <c:if test = "${not empty authMember.memId }">
	    <li class="nav-item" >
		    <a class="nav-link" data-slide="true" href = "${cPath }/login/requestKakaologout.do" role="button">
		    	<i class="fas fa-sign-out-alt"></i>
		    </a>
	    </li>
    </c:if>
    
    </ul>
    
    </nav>