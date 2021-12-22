<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<link rel="stylesheet" href="${cPath}/resources/adminLTE3/plugins/fontawesome-free/css/all.min.css">
<link rel="stylesheet" href="${cPath}/resources/adminLTE3/dist/css/adminlte.min.css">
<script src="${cPath}/resources/adminLTE3/plugins/jquery/jquery.min.js"></script>


<script type="text/javascript">
	$.getContextPath=function(){
		return "${cPath}";
	}
</script>

<style>
body:not(.sidebar-mini-md):not(.sidebar-mini-xs):not(.layout-top-nav) .content-wrapper,
	body:not(.sidebar-mini-md):not(.sidebar-mini-xs):not(.layout-top-nav) .main-footer,
	body:not(.sidebar-mini-md):not(.sidebar-mini-xs):not(.layout-top-nav) .main-header
	{
	margin-left: 0px;
}
</style>
	

<div class="error-page" style="margin-top: 150px;">
	<h2 class="headline text-warning" style="float: none; text-align: center; ">${codeNumber}</h2>
	<h4 class="headline text-warning" style="float: none; text-align: center; font-size: 50px;">${code}</h4>
</div>
	

<div class="error-content" style="width: 100%; text-align: center; margin-top: 50px; ">
	<h3>
		<i class="fas fa-exclamation-triangle text-warning"></i> ${message }
	</h3>

	<p>
		요청된 주소  : ${url }
	</p>
	
	<a href="${cPath}">return to home</a>

</div>

<script src="${cPath}/resources/adminLTE3/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="${cPath}/resources/adminLTE3/dist/js/adminlte.min.js"></script>
