<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- 상단 이름 -->
<div class="container-fluid">
	<div class="row mb-2">
		<div class="col-sm-6">
			<h1>Code Reivew</h1>
		</div>
	</div>
</div>

<!-- Code Mirror -->
<div class="row">
	<div class="col-md-12">
		<div class="card card-outline card-info">
			<div class="card-header">
				<h1 class="card-title">${codeUrl}</h1>
				 <input type="button" class="btn btn-info" data-toggle="modal" data-target="#modal-default" value = "수정하기">
			</div>
			<div class="card-body p-0">
				<textarea id="codeMirrorDemo" class="p-3" style = "height: 800px;">
					${codeData}
             	</textarea>
			</div>
			<div class="card-footer">
			</div>
		</div>
	</div>
</div>

<!-- modal -->
<div class="modal fade" id="modal-default">
	<div class="modal-dialog">
		<div class="modal-content gitModalContent">
			<div class="modal-header">
				<h4 class="modal-title">추가 정보</h4>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body gitModalBody">
				<div class="form-group-message">
					<label>Commit 내역에 남길 message 를 입력해주세요</label> <br>
					<input type="text" id="inputCommitMessage" class="form-control">
				</div>
				 <div class="saveArea">
					<span style="margin-right: 20px; color:black;">저장 위치</span>
					<i class="fas fa-folder-open" style="color:#ffc760; margin-right: 10px;"></i>${codeUrl }
				</div>
			</div>
			<div class="modal-footer justify-content-between">
				<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
				<button type="button" class="btn btn-primary" id = "saveTest">저장</button>
			</div>
		</div>
	</div>
</div>

<form action = "<%=request.getContextPath()%>/project/${project.pCode}/gitHub/gitCodeConversion.do" id = "gitCodeConversion" method = "post">
	<input type = "hidden" id = "codeText" name = "codeText">
	<input type = "hidden" id = "inputCommitMessageForm" name = "inputCommitMessageForm">
</form>