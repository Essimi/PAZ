<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 공통부분 preScript 입니다. -->

<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome Icons -->
<link rel="stylesheet" href="${cPath }/resources/adminLTE3/plugins/fontawesome-free/css/all.min.css">
<!-- SweetAlert2 -->
<link rel="stylesheet" href="${cPath }/resources/adminLTE3/plugins/sweetalert2-theme-bootstrap-4/bootstrap-4.min.css">
<!-- Toastr -->
<link rel="stylesheet" href="${cPath }/resources/adminLTE3/plugins/toastr/toastr.min.css">
<!-- overlayScrollbars -->
<link rel="stylesheet" href="${cPath }/resources/adminLTE3/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="${cPath }/resources/adminLTE3/dist/css/adminlte.min.css">

<!-- jQuery -->
<script src="${cPath }/resources/adminLTE3/plugins/jquery/jquery.min.js"></script>

<!--font -->
<link rel="preconnect" href="https://fonts.googleapis.com"> 
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin> 
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">


<!-- CSS -->
<link rel="stylesheet" href="${cPath }/resources/css/main.css">


<script type="text/javascript">
	$.getContextPath=function(){
		return "${cPath}";
	}
	
	$(window).on('load', function(){ 
		$('#loading').hide(); 
	});
</script>