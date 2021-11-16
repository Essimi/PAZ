<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<tiles:insertAttribute name="preScript" />
</head>
<body class = "hold-transition sidebar-mini">

<div class="wrapper">
		<!-- *-definitions 에서 받아온 값들을 지정 -->
		<div id="header">
			<tiles:insertAttribute name="header"/>
		</div>
		<div id="content" class = "content-wrapper">
			<tiles:insertAttribute name="content"/>
		</div>
		<tiles:insertAttribute name="postScript" />	
</div>		

</body>
</html>