<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" style="height: auto;"><head>
<meta charset="UTF-8">
	

<!-- 인증관련 preScript 입니다. -->

<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&amp;display=fallback">
<!-- Font Awesome Icons -->
<link rel="stylesheet" href="/PAZ/resources/adminLTE3/plugins/fontawesome-free/css/all.min.css">
<!-- icheck bootstrap -->
<link rel="stylesheet" href="/PAZ/resources/adminLTE3/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="/PAZ/resources/adminLTE3/dist/css/adminlte.min.css">


<!-- jQuery -->
<script src="/PAZ/resources/adminLTE3/plugins/jquery/jquery.min.js"></script>






<style>

	body:not(.sidebar-mini-md):not(.sidebar-mini-xs):not(.layout-top-nav) .content-wrapper, body:not(.sidebar-mini-md):not(.sidebar-mini-xs):not(.layout-top-nav) .main-footer, body:not(.sidebar-mini-md):not(.sidebar-mini-xs):not(.layout-top-nav) .main-header {
		margin-left:0;
	}
</style>


<script type="text/javascript">
	$.getContextPath=function(){
		return "/PAZ";
	}
</script>

<title>PAZ</title>
</head>
<body style="height: auto;">
	<div id="content">



  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" style="min-height: 870px; padding: 50px;">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
           <img style="width:100px;" id="logoText" class="navbar-brand" src="/PAZ/resources/file/pazlocoo.png">
          </div>
          
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="card">
        <div class="card-header">
          <h3 class="card-title">메일 인증완료!</h3>

          <div class="card-tools">
            <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
              <i class="fas fa-minus"></i>
            </button>
            <button type="button" class="btn btn-tool" data-card-widget="remove" title="Remove">
              <i class="fas fa-times"></i>
            </button>
          </div>
        </div>
        <div class="card-body">
         <span style="color:gray; display: inline-block; margin-bottom: 10px;">Email authentication has been completed. Please return to the membership registration page and follow the remaining procedures.</span>
          <br>
         	 이메일 인증이 완료되었습니다. 회원가입 페이지로 돌아가서 남은 진행절차를 따라주세요.
        </div>
        <!-- /.card-body -->
        <div class="card-footer"></div>
        <!-- /.card-footer-->
      </div>
      <!-- /.card -->

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <footer class="main-footer">
    
     All rights reserved.
  </footer>





	</div>
<script type="text/javascript">
	$(function(){
		let ws = null;
		let sessionId = ${sessionId};
		ws = new WebSocket("ws://192.168.0.52${cPath}/websocket/emailAuth");
		ws.onopen = function(event){
			ws.send(sessionId);
			console.log(event);
		}
		ws.onclose = function(event){
			console.log(event);
		}
		ws.onerror = function(event){
			console.log(event);
		}
		ws.onmessage = function(event){
			console.log(event);
		}
	})

</script>


<!-- 인증관련 postScript -->

<!-- Bootstrap 4 -->
<script src="/PAZ/resources/adminLTE3/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE min App -->
<script src="/PAZ/resources/adminLTE3/dist/js/adminlte.min.js"></script>
	

</body></html>