<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<tiles:insertAttribute name="preScript" />
	<tiles:insertAttribute name="preScript2" />	
<title>PAZ</title>
</head>
<body class = "hold-transition sidebar-mini">

<div id="loading">
	<div id="loading-image" class="spinner-border text-primary"></div>
	<%-- <img id="loading-image" src="${cPath }/resources/adminLTE3/dist/img/KakaoTalk_Photo_2021-12-08-11-57-54.png" alt="Loading..." /> --%>
</div>

<div class="wrapper">
	<!-- *-definitions 에서 받아온 값들을 지정 -->
	<div id="header">
		<tiles:insertAttribute name="header"/>
	</div>
	<div id="header2">
		<tiles:insertAttribute name="header2"/>
	</div>
	<div id="left">
		<tiles:insertAttribute name="left"/>
	</div>
	<div id="content" class = "content-wrapper">
		<tiles:insertAttribute name="content"/>
	</div>
</div>		

<tiles:insertAttribute name="postScript" />	
<tiles:insertAttribute name="postScript2" />	
</body>
</html>