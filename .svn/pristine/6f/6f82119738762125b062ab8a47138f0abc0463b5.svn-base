<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Forgot Password</title>

</head>

<style>

	.login-card-body {
		 padding: 50px 100px;
   		 border-radius: 100px;	
	}
	
	.login-box, .register-box {
		width: 600px;
	}


</style>

<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <a href="${cPath }"><b>PAZ </b>Forgot Password</a>
  </div>
  <!-- /.login-logo -->
  <div class="card">
    <div class="card-body login-card-body">
      <p class="login-box-msg">You forgot your password? Here you can easily retrieve a new password.</p>

      <form action="recover-password.html" method="post">
        <div class="input-group mb-3">
          <input type="text" id="memId" class="form-control" placeholder="ID">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-user"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input type="email" id="memMail" class="form-control" placeholder="Email">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-envelope"></span>
            </div>
          </div>
        </div>
		<p id="findPassMsg" class="login-box-msg"></p>
        <div class="row">
          <div class="col-12">
            <button id="emailCheck" type="submit" class="btn btn-primary btn-block">임시 비밀번호 발급</button>
          </div>
          <!-- /.col -->
        </div>
      </form>
      <p class="mt-3 mb-1">
        <a href="${cPath}/login/login.do">로그인</a>
      </p>
      <p class="mb-0">
        <a href="${cPath }/login/join.do" class="text-center">회원가입</a>
      </p>
    </div>
    <!-- /.login-card-body -->
  </div>
</div>
<!-- /.login-box -->
<script type="text/javascript">
	$("#emailCheck").on("click", function(event){
		event.preventDefault();
		var id = $("#memId").val();
		var mail = $("#memMail").val();
		var msg = $("#findPassMsg");
		
		$.ajax({
			url : "${cPath}/login/find/passMailCheck.do",
			data : {memId: id, memMail: mail},
			method : "post",
			success : function(resp) {
				if(resp.status == "OK"){
					msg.text(resp.message).css("color", "green");
				}else{
					msg.text(resp.message).css("color", "red");
				}
			},
			error : function(xhr, errorResp, error) {
				console.log(xhr);
				console.log(errorResp);
				console.log(error);
			}
		})
		
		return false;
	})
	
</script>
</body>
</html>
