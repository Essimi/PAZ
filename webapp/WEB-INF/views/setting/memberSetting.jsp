<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<style>
	#content {
		padding:30px;
	}
	
	#memberSearch {
		margin-top : 30px;
	}
	
	#memberList {
		height : 250px; 
	}
	
	body { overflow : hidden;}
	
	#remove {
		width: 10%;
	}
	
	#addMember {
	 margin-right: 10px;
     width: 100px;
	}
	
	.modal-content {
		width: 500px;
	}
	
	#toast-container {
		width: 100%; 
		text-align: -webkit-center;
	}
	
	.modal-title {
		font-size: 20px;
	    color: gray;
	}
	
	#memInv{
		margin-top : 10px;
	}
	
	#inputStatus{
		text-align:center;
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
        
            	 <!-- Trigger the modal with a button -->
				<button id="addMember" type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#myModal">  <i class="fas fa-user-plus"></i></button>
				
				<!-- Modal -->
				<div id="myModal" class="modal fade" role="dialog">
				  <div class="modal-dialog">
				
				    <!-- Modal content-->
				    <div class="modal-content">
				      <div class="modal-header">
				        <h4 class="modal-title">프로젝트 멤버 추가</h4>
				        <button type="button" class="close" data-dismiss="modal">&times;</button>
				      </div>
				     
				     
				      <div class="modal-body">
				        
				        
				      <form>
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
		                  <input id="memName" type="text" class="form-control">
		                </div>
				     </form>        
				        
				       
				       <p id = "tttt" style="display:none">없음</p>
				      
				        
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">취소</button>
				        <button id="saveBtn" type="button" class="btn btn-info btn-sm toastrDefaultSuccess" >확인</button>
				      
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
	                    	<tr>
		                      <td>${member.memId }</td>
		                      <td>${member.memNickname }</td>
		                      <td>${member.memMail }</td>
		                      <td><span>${member.position}</span></td>
		                      <td><span>${member.workTime} 시간</span></td>
		                      
		                      <td>
			                      <c:if test="${member.position ne 'PL' }">
			                      	<a data-value="${member.memId}" class="btn btn-danger btn-sm memberDelete" >
					                   <i class="fas fa-trash"></i>Delete
					                </a>
					              </c:if>
				              </td>
		                    </tr>
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
	        	
	        $('.toastrDefaultSuccess').on('click', function() {
	        	
	        	console.log($('#inputStatus').val());
	        	// 만약 아이디가 존재하고, 현재 프로젝트에 포함된 사람이 아니라면 비동기 요청 

	        	
	    			$.ajax({
	    				url : '${cPath}/setting/memberInvite.do',
	    				data : { "recipient" : $('#memName').val(),
	    						 "position" : $('#inputStatus').val()
	    				},
	    				success : function(resp) {
	    					
	    					// 비동기 요청이 성공 -> insert가 성공했다면, 요청 성공 토스트창 출력
	    					if(resp == "ok") {
	    						$('#tttt').hide();
	    						toastr.success('프로젝트 초대 요청을 전송했습니다.')
	    						//$('#saveBtn').attr('data-dismiss', 'modal');
	    					// 요청 실패 -> 존재하지 않는 회원이거나, 이미 초대된 회원	
	    					}else if(resp == "failed") {
	    						// 입력 창 밑에 출력.
	    						/* $('#myModal').modal('hide').remove();
	    						$('#myModal').modal('show'); */
	    						
	    						/* document.getElementById('tttt').removeClass(hidden); */
	    						toastr.error('해당 아이디가 존재하지 않거나, 이미 프로젝트에 참여한 회원입니다.')
	    						console.log("존재안하거나 이미 존재")
	    					}
	    					
	    				},
	    				error: function(xhr, jQuery, error){
	    					// 요청이 실패했다면 , 요청 실패 토스트 창 출력
	    					console.log("아예실패 ")
	    					console.log(jQuery);
	    					console.log(error);
	    				}
	    		
	    			})
	    			
	            
	          });
	        
	        
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

		</script>
        
        
        
        
        
        

        
        