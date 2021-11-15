<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


 <!--  메인 사이드바 컨테이너 시작 -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!--  메인 로고 출력 --> 
    <a href="index3.html" class="brand-link">
      <img src="${cPath }/resources/adminLTE3/dist/img/picon.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text font-weight-light">PAZ</span>
    </a>

   <!-- 사이드바 시작 -->
   
    <div class="sidebar">
    
      <!-- 사이드바 유저 접속 정보 -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="${cPath }/resources/adminLTE3/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
          <!-- 아이콘 클릭시 내 정보? 미정 -->
          <a href="?" class="d-block">USER NAME</a>
        </div>
      </div>

     
      <!-- 메인 사이드바 -->
      <!-- 아이콘 - https://fontawesome.com/ -->
      <!-- i 태그 안에 넣으면 됩니다 -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
        

        
          <!-- li 태그 하나당 메뉴바 하나 입니다 -->
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-columns"></i>
              <p>
                칸반       
              </p>
            </a>
          </li>
          
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-list"></i>
              <p>
                간트 차트
              </p>
            </a>
          </li>
          
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-folder-open"></i>
              <p>
               업무
                 
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fab fa-confluence"></i>
              <p>
               회의록
                 
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="resources/adminLTE3/pages/forms/editors.jsp" class="nav-link">
              <i class="nav-icon fas fa-code"></i>
              <p>
                코드
              </p>
            </a>
          </li>
      
          <li class="nav-item">
            <a href="resources/adminLTE3/pages/calendar.html" class="nav-link">
              <i class="nav-icon fas fa-exclamation-circle"></i>
              <p>
                이슈
              </p>
            </a>
          </li>
          
          <li class="nav-item">
            <a href="resources/adminLTE3/pages/gallery.html" class="nav-link">
              <i class="nav-icon far fa-calendar"></i>
              <p>
               일정 관리
              </p>
            </a>
          </li>
          
          <li class="nav-item">
            <a href="resources/adminLTE3/pages/kanban.html" class="nav-link">
              <i class="nav-icon fas fa-chart-bar"></i>
              <p>
              대시보드
              </p>
            </a>
          </li>
          
          <li class="nav-item">
            <a href="r
            esources/adminLTE3/pages/layout/fixed-topnav.html" class="nav-link">
              <i class="nav-icon fab fa-git"></i>
              <p>
                깃허브
                 
              </p>
            </a>
          </li>
          
          <li class="nav-item">
            <a href="#" class="nav-link">
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
                <a href="../../index.html" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>공지사항</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="../../index2.html" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>일정</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="${cPath }/setting/memberSetting.do" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>팀원</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="../../index3.html" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>GitHub 연동</p>
                </a>
              </li>
            </ul>
         </li>
      </c:if>
      
      
          
         </ul> 
      </nav>
    </div>
  </aside>
  