<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    
    <style>
    	
    	.modalStyle {
    		padding : 40px;
    	}
    
    </style>

    
    	<div>
    		<h3>팀원 관리</h3> <br>
    	</div>
				
    	
        <!-- /.row -->
        <div class="row">
          <div class="col-12">
            <div class="card">
              <div class="card-header">
                <h3 class="card-title" style="color:gray;">프로젝트 팀원 리스트</h3>
                
               

                <div class="card-tools">
                  <div  class ="input-group input-group-sm">
        
				<button style="margin-right: 10px; width: 50px;" id="plSetting" type="button" class="btn btn-default btn-sm modalBtn" data-toggle="modal" data-target="#myModal2">  <i class="fas fa-cog"></i></button>
            	 <!-- Trigger the modal with a button -->
				<button style="width: 50px;" id="addMember" type="button" class="btn btn-default btn-sm modalBtn" data-toggle="modal" data-target="#myModal">  <i class="fas fa-user-plus"></i></button>
				
				<!-- Modal -->
				<div id="myModal" class="modal fade" role="dialog">
				  <div class="modal-dialog">
				
				    <!-- Modal content-->
				    <div class="modal-content modalStyle">
				      <div class="modal-header">
				        <h4 class="modal-title">프로젝트 멤버 추가</h4>
				        <button type="button" class="close" data-dismiss="modal">&times;</button>
				      </div>
				     
				     
				      <div class="modal-body modalStyle">
				        
				        
				      <form>
				      
				      <h5 style="margin-bottom: 20px;">요청 회원 정보</h5>
				       <div id="memInv" class="input-group mb-3">
		                  
		                  <select name="pStatus" id="inputStatus" class="form-control custom-select">
			                  <option disabled selected>역할 선택</option>
			                  <option value="AA">AA</option>
			                  <option value="BA">BA</option>
			                  <option value="DA">DA</option>
			                  <option value="TA">TA</option>
			                  <option value="UA">UA</option>
			                </select>
		                  <!-- /btn-group -->
		                  <input id="memName" type="text" class="form-control" placeholder="회원 아이디 입력">
		                </div>
		                
		                
		                <h5 style="margin-top:40px; margin-bottom: 20px;">주간 업무 시간</h5>
				       <div id="memWorkTime" class="input-group mb-3">
		                  
		                 <input name=workTime id="inputWorkTime" type="number" min="1" max="168" class="form-control">
		                  
		                </div>
				     </form>        
				        
				       
				       <p id = "tttt" style="display:none">없음</p>
				      
				        
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">취소</button>
				        <button id="saveBtn" type="button" class="btn btn-info btn-sm toastrDefaultSuccess invitedBtn" >확인</button>
				      
				      </div>
				    </div>
				
				  </div>
				</div>
				
				
				
				<!-- PL 권한 관리 모달 -->
				<!-- Modal -->
				<div id="myModal2" class="modal fade" role="dialog">
				  <div class="modal-dialog">
				
				    <!-- Modal content-->
				    <div class="modal-content modalStyle">
				      <div class="modal-header">
				        <h4 class="modal-title">프로젝트 멤버 관리 (PL 권한 부여)</h4>
				        <button type="button" class="close" data-dismiss="modal">&times;</button>
				      </div>
				     
				     
				      <div class="modal-body modalStyle">
				        
				        
				      <form>
				      
				      <h5 style="margin-bottom: 20px;">PL 권한 이양 멤버</h5>
				      <div id="plImpl" class="input-group mb-3">
		                  
		                  <select name="plSelect" id="plSelect" class="form-control custom-select">
			                  <option disabled selected>PL 권한을 이양할 멤버를 선택하세요.</option>
			                                   
			                  <c:choose>
			                    <c:when test="${not empty memberList}">
			                    	<c:forEach items="${memberList}" var="member">
			                    		<c:if test="${member.outStatus ne '1' }">
					                       <option value="${member.memId }">${member.memNickname }</option>
					                    </c:if>
				                    </c:forEach>
			                    </c:when>
			                    <c:otherwise>
			                    
			                    </c:otherwise>
			                   </c:choose>
			                   
			              </select>
		                  
		                </div>
		                
				      
				      <h5 style="margin-top:40px; margin-bottom: 20px;">내 역할 선택</h5>
				       <div id="myRole" class="input-group mb-3">
		                  
		                  <select name="myPosition" id="myRoleSelect" class="form-control custom-select">
			                  <option disabled selected>내 역할 선택을 선택하세요.</option>
			                  <option value="AA">AA</option>
			                  <option value="BA">BA</option>
			                  <option value="DA">DA</option>
			                  <option value="TA">TA</option>
			                  <option value="UA">UA</option>
			                </select>
		                  
		                </div>
		                
				     </form>        
				        
				       
				       <p id = "tttt" style="display:none">없음</p>
				      
				        
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">취소</button>
				        <button id="plSaveBtn" type="button" class="btn btn-info btn-sm toastrDefaultSuccess plOkBtn" >확인</button>
				      
				      </div>
				    </div>
				
				  </div>
				</div>
        
        
        </div>
                </div>
              </div>
              
 
                
                
              <!-- /.card-header -->
              <div id="memberList" class="card-body table-responsive p-0">
                <table class="table table-hover text-nowrap">
                  <thead>
                    <tr>
                      <th>아이디</th>
                      <th>이름</th>
                      <th>이메일</th>
                      <th>역할</th>
                      <th>주간 업무 시간</th>
                      <th id="remove"></th>
                    </tr>
                  </thead>
                  
                  
                  <tbody>
                  
                  
                  <c:choose>
                    <c:when test="${not empty memberList}">
                    	<c:forEach items="${memberList}" var="member">
                    		<c:if test="${member.outStatus ne '1' }">
	                    	<tr>
		                      <td>${member.memId }</td>
		                      <td>${member.memNickname }</td>
		                      <td>${member.memMail }</td>
		                      <td><span>${member.position}</span></td>
		                      <td><span>${member.workTime} 시간</span></td>
		                      
		                      <td>
			                      <c:if test="${member.position ne 'PL' }">
			                      	<a data-value="${member.memId}" class="btn btn-danger btn-sm memberDelete" >
					                   <i class="fas fa-trash"></i>
					                </a>
					              </c:if>
				              </td>
		                    </tr>
		                    </c:if>
	                    </c:forEach>
                    </c:when>
                    <c:otherwise>
                    	<tr>
                    	<td colspan="6">
                    	 프로젝트에 참여한 회원이 없습니다.
                    	</td>
                    	</tr>
                    </c:otherwise>
                   </c:choose>
                    
                  </tbody>
                  
                  
                  
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
        </div>
        <!-- /.row -->
        
        
        
        
        <br>
        <hr>
        <br>
        
        
        
        
       <!-- /.row -->
        <div class="row">
          <div class="col-12">
            <div class="card">
              <div class="card-header">
                <h3 class="card-title" style="color:gray;">요청 대기 리스트</h3>
                <div class="card-tools">
                  <div  class ="input-group input-group-sm"></div>
                </div>
              </div>
              
 
                
                
              <!-- /.card-header -->
              <div id="memberList" class="card-body table-responsive p-0">
                <table class="table table-hover text-nowrap">
                  <thead>
                    <tr>
                      <th>아이디</th>
                      <th>이름</th>
                      <th>메일</th>
                      <th>역할</th>
                    </tr>
                  </thead>
                  
                  
                  <tbody>
                  
                  
                  <c:choose>
                    <c:when test="${not empty requestList}">
                    	<c:forEach items="${requestList}" var="request">
	                    	<tr>
		                      <td>${request.recipient }</td>
		                      <td>${request.memNickname }</td>
		                      <td><span>${request.memMail}</span></td>
		                      <td><span>${request.position}</span></td>
		                    </tr>
	                    </c:forEach>
                    </c:when>
                    <c:otherwise>
                    	<tr>
                    	<td style="text-align:center" colspan="4">
                    	 진행한 초대 요청이 없습니다.
                    	</td>
                    	</tr>
                    </c:otherwise>
                   </c:choose>
                    
                  </tbody>
                  
                  
                  
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
        </div>
        <!-- /.row -->
        
      
        <script>
        
	        $(function() {
	            var Toast = Swal.mixin({
	              toast: true,
	              position: 'top-end',
	              showConfirmButton: false,
	              timer: 3000
	            });
	        
	        // 멤버 초대 
	        $('.invitedBtn').on('click', function() {
	        	
	        	if(!$('#inputStatus').val()) {
	        		toastr.error('역할을 입력하세요');
	        		
	        	} else {
		        	
		        	console.log($('#inputStatus').val());
		        	// 만약 아이디가 존재하고, 현재 프로젝트에 포함된 사람이 아니라면 비동기 요청 
	
		        	
		    			$.ajax({
		    				url : '${cPath}/setting/memberInvite.do',
		    				data : { "recipient" : $('#memName').val(),
		    						 "position" : $('#inputStatus').val(),
		    						 "workTime" : $('#inputWorkTime').val()
		    				},
		    				success : function(resp) {
		    					
		    					// 비동기 요청이 성공 -> insert가 성공했다면, 요청 성공 토스트창 출력
		    					if(resp == "ok") {
		    						$('#tttt').hide();
		    						toastr.success('프로젝트 초대 요청을 전송했습니다.')
		    						console.log("success")
		    						//$('#saveBtn').attr('data-dismiss', 'modal');
		    					// 요청 실패 -> 존재하지 않는 회원이거나, 이미 초대된 회원	
		    					}else if(resp == "failed") {
		    						toastr.error('해당 아이디가 존재하지 않거나, 이미 프로젝트에 참여한 회원입니다.')
		    						console.log("존재안하거나 이미 존재")
		    					}else if(resp == "requestMem") {
		    						toastr.success('이미 프로젝트 초대 요청을 전송한 회원입니다.')
		    						console.log("update")
		    						
		    					}
		    					
		    				},
		    				error: function(xhr, jQuery, error){
		    					// 요청이 실패했다면 , 요청 실패 토스트 창 출력
		    					console.log("아예실패 ")
		    					console.log(jQuery);
		    					console.log(error);
		    				}
		    		
		    			})
	        		
	        	}
	    			
	            
	          });
	        
	        
	        
	        
	        // PL 권한 이양
	        $('.plOkBtn').on('click', function() {
	        	
	        	if($('#plSelect').val() == null || $('#myRoleSelect').val() == null) {
	        		toastr.error('모든 항목을 입력해주세요.');
	        	}else {
	        		
	        		if(confirm("정말 권한을 부여하시겠습니까?")){
	        			
	        			$.ajax({
	        				
	        				url : '${cPath}/project/${project.pCode}/setting/plSelect.do',
	        				data : {
	        					"memId" : $('#plSelect').val(),
	        					"position" : $('#myRoleSelect').val()
	        				},
	        				success : function(resp) {
	        					
	        					if(resp == "OK") {
	        						toastr.success('PL권한 위임을 성공했습니다. 프로젝트 메인 페이지로 돌아갑니다.');
	        						location.href="${cPath}/project/myprojectList.do"
	        					}else {
	        						toastr.error('PL권한 위임을 실패했습니다. 다시 시도하세요.');
	        					}
	        					
	        				},
	        				error : function(xhr, jQuery, error) {
	        					toastr.error('PL권한 위임을 실패했습니다. 다시 시도하세요.');
	        					console.log(jQuery);
		    					console.log(error);
	        				}
	        			
	        			})
	        		}
	        		
	        	}
	        	
	        })
	        
	        
	        $('#myModal').on('hidden.bs.modal', function () {
	        	  location.reload();
	        	})
	        
	        }); 
	        
        
        </script>
        
        <div id="toast-container" class="toast-top-right"></div>
        
        
        <script type="text/javascript">
        
        	$(".memberDelete").on('click', function() {
        		
        		var id = $(this).attr('data-value');
        		
        		if(confirm(id + " 님을 프로젝트에서 삭제하시겠습니까? ")) {
        			
        			$.ajax({
        				
        				url : '${cPath}/setting/deleteMember.do',
        				data : { "deleteMember" : id },
        				success : function(resp) {
        					alert("삭제가 완료되었습니다.");
        					location.reload();
        					console.log(resp);
        				},
        				error: function(xhr, jQuery, error){
        					console.log(jQuery);
        					console.log(error);
        				}
        				
        			})
        		
        		}
        		
        	});
        	
        	
        	
        	$('.modal').on('hidden.bs.modal', function (e) {
        	    console.log('modal close');
        	    $(this).find('form')[0].reset()
        	});
        	
        	
        	
        	$('.modalBtn').on('click', function() {
        		
        		var back = $(this).attr('data-target')
        	
        		$(back).attr('style','background:#00000040')
        	})

		</script>
        
        
        
        
        
        

        
        