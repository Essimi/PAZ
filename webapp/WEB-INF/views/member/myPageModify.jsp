<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#profileChange{
		position: absolute;
		top: 72%;
	}
	#preview-image{
		position: absolute;
		top: 22%;
	}
	#memberModifyCard{
		width: 80%;
		position: absolute;
		left: 50%;
		transform: translateX(-50%);
	}
	.form-control{
		width: 50%;
	}
	#memberModifyHeader{
		margin-top: 5%;
	}
	#memberModifyH1{
		margin-left: 10%;
	}
	.col-7{
		max-width: 45%;
		margin-left: 9%;
	}
	
	.profileContent {
		padding: 70px;
	}
	
	.editBtn {
		margin-top: 30px;
	}
	
	#memberModifyCard {
		border-top: 3px solid #17a2b8;
	}
</style>
    
  <!-- Content Header (Page header) -->
    <section class="content-header">
      <div id="memberModifyHeader" class="container-fluid">
        <div class="row mb-2">
          <div id="memberModifyH1" class="col-sm-6">
            <h1>회원정보수정</h1>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
		
	  <form action="${cPath }/mypage/myPageUpdate.do" method="post" enctype="multipart/form-data">
      <!-- Default box -->
      <div id="memberModifyCard" class="card">
        <div class="card-body row profileContent">
          <div class="col-5 text-center d-flex align-items-center justify-content-center">
           <img id="preview-image" class="profile-user-img img-fluid img-circle" 
           		src="${cPath }/resources/file/profileImage/${memberInfo.memIkon.saveName }"
           		onerror="this.src='${cPath }/resources/file/profileImage/profile.jpg'" style="width:250px">
<%--            <img class="img-circle img-bordered-sm" src="${cPath }/resources/file/proflie.jpg" alt="User Image"> --%>
<%--            <img src="${cPath }/resources/file/proflie.jpg" class="img-circle elevation-2" alt="User Image"> --%>
			<input style="display: none;" type="file" id="imageFile" name="imageFile">
			<br>
			<button type="button" id="profileChange" class="btn btn-default">사진 변경</button>
          </div>
          <div class="col-7">
            <label for="inputEmail">아이디</label>
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text"><i class="fas fa-user"></i></span>
              </div>
              <input type="text" class="form-control" name="memId" placeholder="ID"  value="${memberInfo.memId }" readonly>
            </div>
            <label for="inputEmail">비밀번호</label>
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text"><i class="fas fa-lock"></i></span>
              </div>
              <input type="password" class="form-control" id="inputMemPass" name="memPass" placeholder="Password">
            </div>
            <div id="passMsg"></div>
             <label for="inputEmail">비밀번호 재입력</label>
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text"><i class="fas fa-lock"></i></span>
              </div>
              <input type="password" class="form-control" id="inputRetypePass" placeholder="Retype password">
            </div>
            <div id="passRetypeMsg"></div>
            <label for="inputEmail">닉네임</label>
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text"><i class="fas fa-address-card"></i></span>
              </div>
              <input type="text" class="form-control" name="memNickname" placeholder="NickName" value="${memberInfo.memNickname }">
            </div>
            <label for="inputEmail">이메일</label>
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text"><i class="fas fa-envelope"></i></span>
              </div>
              <input type="email" class="form-control" id="inputEmail" name="memMail" placeholder="Email" value="${memberInfo.memMail }">
            </div>
            <div id="mailMsg"></div>
            <label for="inputEmail">전화번호</label>
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text"><i class="fas fa-phone-alt"></i></span>
              </div>
              <input type="text" class="form-control" id="inputTel" name="memTel" placeholder="Tel" value="${memberInfo.memTel }">
            </div>
            <div id="telMsg"></div>
            <div class="form-group">
              <input type="submit" class="btn btn-info editBtn" value="수정하기">
            </div>
              ${message }
          </div>
        </div>
      </div>
     </form>

    </section>