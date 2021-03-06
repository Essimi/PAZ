<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
	$(function() {
		// 페이지 시작하자마자 실행되는 함수
		startGitPage();
	})
</script>

<!-- <div class="invoice mb-3"> -->
<!-- 페이지 메인 문구 -->
 <div class="container-fluid">
	<div class="row mb-2">
		<div class="col-sm-6">
			<h2>
				<i class="fab fa-github-square" style="margin-right: 10px;"></i>Git Team
			</h2>
		</div>
	</div>
</div> 


<!-- 메인페이지 시작 -->
<div class="container-fluid">
	<div class="row">
		<div class="col-12">
			<!-- 메인 Content 시작 -->
			<div class="invoice p-3 mb-3">
			
				<!-- 깃허브 아이디, 저장소 이름을 나타냅니다. 클릭시 해당 깃허브 링크로 이동합니다. -->
				<div class="callout callout-info callOutHeader">
	            	<h3>
	            		<i class="fas fa-info-circle"></i>
	            			<a>
	            				<span id = "repoHeaderInfo"></span>
	            			</a>
	            		
	            	</h3>
	            	
	            	<br>
	            	
	                <!--  폴더 트리구조 이용시 현재 진입한 경로를 보여줍니다. 가장 상위폴더일시 빈 값 으로 출력됩니다. -->
	              	<h6><span>현재 경로 : </span><span class = "gitFileHeader"></span></h6>
	            </div>
	            
	            <!-- 트리구조를 나타낼 공간입니다. -->
	            <div class="callout" id="girFileAreaDiv">
					<!-- 트리구조 한 줄당 나타낼 공간입니다. -->
					<!-- 하단의 파일 구조 문을 clone 하면서 추가합니다. -->
					<div class="gitFileArea"></div>
				</div>
				
				<!-- 파일 구조를 나타낼 영역입니다. -->
			    <!-- 자식을 찾기 위해 생성했으며 hidden 으로 숨겨줍니다. -->
				<div id="repoInfo" hidden="true">
					<!-- 출력한 파일의 정보를 나타낼 영역입니다. -->
					<div class="fileInfo row" >
						<!-- 해당 파일의 이름을 나타낼 영역입니다. -->
						<div class="fileName col">
							<!-- 파일의 타입에 따라 아이콘이 변경됩니다. -->
							<i></i>
							<!-- 파일의 이름을 나타냅니다. -->
							<a class="fileNameArea"></a>
						</div>
						<!-- 파일 사이즈를 나타낼 영역입니다. -->
						<!-- 파일 사이즈가 존재하지 않는 경우(폴더) 출력되지 않습니다. -->
						<div class="fileSize">
							<span class="fileSizeArea"></span>
						</div>
					</div>
				</div>
				
				<br>
				<br>
				<br>
				<br>
				
				<div class="callout callout-info">
	            	<h3><i class="fas fa-info"><a><span id = "repoHeaderInfo">Commit List</span></a></i></h3>
	            	
	            	<br>
	            	
	                <!--  폴더 트리구조 이용시 현재 진입한 경로를 보여줍니다. 가장 상위폴더일시 빈 값 으로 출력됩니다. -->
	            </div>
				
				<!-- 데이터 테이블 구역 -->
				<div class="container-fluid">
					<div class="row">
						<div class="col-12">
							<div class="card">
								<div class="card-body">
								    <!-- 테이블 시작 -->
									<table id="example1" class="table table-bordered table-striped">
										<thead>
											<tr>
												<th>순번</th>
												<th>Id</th>
												<th>Email</th>
												<th>message</th>
												<th>Date</th>
											</tr>
										</thead>
										<tbody id = "commitList">
											
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 메인페이지 종료 -->
<!-- </div> -->

<!-- Code Content 전송을 위한 form 태그 -->
<form action="<%=request.getContextPath() %>/project/${project.pCode}/gitHub/gitCode.do" id = "codeForm" method = "post">
	<input type = "hidden" id = "codeContent" name = "codeContent">
	<input type = "hidden" id = "codeUrl" name = "codeUrl">
	<input type = "hidden" id = "codeSha" name = "codeSha">
	<input type = "hidden" id = "gitRepoCommand" name = "codeUserInfo">
</form>