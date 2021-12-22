<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    

    <div class="col-md-9" style="max-width: 100%; margin-top: 25px;">
    
          <div class="card card-primary card-outline">
            <div class="card-header">
              <h3 class="card-title">업무 등록</h3>
              
              <input type="button" id="testBtn" value="test" class="btn btn-default btn-sm" style="float: right;"/>
            </div>
            
            
            <!-- /.card-header -->
            <div class="card-body p-0">
            
              <div class="mailbox-read-info">
              	<br>
                <input id="workNameInput" type="text" style="margin:10px 0px; font-size:20px;  width:70%;" placeholder="업무 이름을 입력하세요."/>
                
               	
               	<div class="container">

				  <!-- Trigger the modal with a button -->
				  <button style="width:200px; margin-top:20px;" type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#myModal">상위 업무 선택</button>
					<div id="topWorkCodeDiv"></div>
				  <!-- Modal -->
				  <div class="modal fade" id="myModal" role="dialog">
				    <div class="modal-dialog modal-lg">
				    
				      <!-- Modal content-->
				      <div class="modal-content">
				        <div class="modal-header">
				          <h4 class="modal-title">상위 업무 선택</h4>
				          <button type="button" class="close" data-dismiss="modal">&times;</button>
				        </div>
				        
				        <!-- 상위 업무 검색 -->
				        <div class="modal-body">
				        
				        <div>
				        	<p>검색할 업무 이름을 입력하세요. </p>
				        </div>
				        
				         <div class="input-group input-group-sm">
		                  <input autocomplete="off" id="topWorkSearch" type="text" class="form-control">
		                  <span class="input-group-append">
		                    <button type="button" class="btn btn-default btn-flat">Go!</button>
		                  </span>
		                </div>
		                
		                
		                <div class="searchList card-body table-responsive p-0">
		                
		                	<table class="table table-hover text-nowrap" id="searchListTable">
		                		
		                	
		                	</table>
		                
		                </div>
		                
                            
				        </div>
				        
				        <div class="modal-footer">
				          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				        </div>
				      </div>
				      
				    </div>
				  </div>
				  
				</div>
                
                
                
              </div>
              
              <div class="mailbox-read-info">

				<table class="table table-bordered">
					<tbody>
						<tr>	
							<th style="width: 15%;">담당자</th>
							<th style="width: 15%;">현황</th>
							<th style="width: 15%;">중요도
							</th><th style="width: 10%;">시작기한</th>
							<th style="width: 10%;">마감기한</th>
							<th>진척도</th>
						</tr>
					<tr>	
	
						<td>
						
		    				<!-- 담당자 -->
		     				<select name="taskMember" id="taskMember" class="form-control custom-select">
			                  <option selected disabled value >담당자</option>
			                 
			                 <c:set var="memList" value="${memList }"></c:set>
			                 <c:choose>
			                 	<c:when test="${not empty memList}">
			                 		<c:forEach items="${memList }" var="member">
			                 		
				                 		<!-- 반복문. 해당 프로젝트 멤버 리스트 -->
				                  		<!-- not empty memberList 일 때, 반복함.  -->
			                 			<option value="${member.memId }">${member.memNickname }</option>
			                 		
			                 		</c:forEach>
			                 	</c:when>
			                 	
			                 	<c:otherwise>
			                 		<option disabled value="${member.memId }">${member.memNickname }</option>
			                 	</c:otherwise>
			                 </c:choose>
			                </select>
						
						
						</td>

						<!-- 현황 -->
		                 <td>
		                 	<select name="taskStatus" id="taskStatus" class="form-control custom-select">
		                 
			                  <option disabled value>현황</option>
			                  
			                  <!-- if문. 현황이 status001 일 땐, to do  -->
			                  <option value="STATUS001">TO DO</option>
			                  
			                  <!-- 002  -->
			                  <option value="STATUS002">IN PROCESS</option>
			                  
			                  <!-- 003 -->
			                  <option value="STATUS003">DONE</option>
		                  
		                	</select>
	                	</td>


                   		<td>
		                      <!-- 중요도 -->
			                 <select name="taskImportance" id="taskImportance" class="form-control custom-select">
			                  <option selected disabled value>중요도</option>
			                  
			                  <!-- if문. 001 일 땐 긴급 -->
			                  <option value="IMPORTANCE001">긴급</option>
			                  
			                  <!-- 002 -->
			                  <option value="IMPORTANCE002">높음</option>
			                  
			                  <!-- 003 -->
			                  <option value="IMPORTANCE003">보통</option>
			                  
			                  <!-- 004 -->
			                  <option value="IMPORTANCE004">낮음</option>
			                </select>
						</td>
						
						
						<td>
							<input id="dateInputStart" class="dateInput" type="date" value/>
							<%-- <p>${task.workStart }</p> --%>
						</td>
						
						<td>
						
							<input id="dateInputDeadline" class="dateInput" type="date" value/>
							<%-- <p>${task.workDeadline }</p> --%>
							
						</td>
						
						
						<td style=" vertical-align:middle;">
						
							<select name="taskProgress" id="taskProgress" class="form-control custom-select">
		                 
			                  <option disabled value>진척도</option>
			                  
			                  <option value="PROGRESS0000">0%</option>
			                  <option value="PROGRESS0010">10%</option>
			                  <option value="PROGRESS0020">20%</option>
			                  <option value="PROGRESS0030">30%</option>
			                  <option value="PROGRESS0040">40%</option>
			                  <option value="PROGRESS0050">50%</option>
			                  <option value="PROGRESS0060">60%</option>
			                  <option value="PROGRESS0070">70%</option>
			                  <option value="PROGRESS0080">80%</option>
			                  <option value="PROGRESS0090">90%</option>
			                  <option value="PROGRESS0100">100%</option>
			                  
		                  
		                	</select>
		                      
		                     
		                       	 
		                        
		                </td>
		                      
		                      
					</tr>
					
					</tbody>
				</table>
                
              </div>
              
              
              <!-- /.mailbox-read-info -->
              <div class="mailbox-controls with-border">
              
              
              <textarea id="compose-textarea" class="form-control" style="height: 300px; display: none;" value></textarea>
             

              </div>
              
              

              <!-- /.mailbox-read-message -->
            </div>
            <!-- /.card-body -->
            
            <!-- /.card-footer -->
            <div class="card-footer">
              <button id="insertTask" type="button" class="btn btn-default"><i class="fas fa-pencil-alt"></i> 확인</button>
              <button id="backTask" type="button" class="btn btn-default" onclick="location.href='${cPath }/project/${project.pCode}/task/taskList.do'"><i class="fas fa-undo-alt"></i> 뒤로가기</button>
            </div>
            <!-- /.card-footer -->
          </div>
          <!-- /.card -->
        </div>
        
        
        
        
        <script>
        
        	var dataValue = null;
        	var modifyList = ${task.modifyHistoryList }
        	
        	$('#insertTask').on('click', function () {
        	
        		var workNameInput = $('#workNameInput').val();
        		var workStartInput = $('#dateInputStart').val();
        		var workDeadlineInput = $('#dateInputDeadline').val();
        		var workImportanceInput = $('#taskImportance').val();
        		var workMemIdInput = $('#taskMember').val();
        		
        		
        		var workStatusInput = $('#taskStatus').val();
        		var workProgressInput = $('#taskProgress').val();
        		
        		
        		var data = {
        				'workName' : workNameInput,
        				'topWorkCode' : $('#topWorkCodeDiv').text(),
        				'workContents' : $('#compose-textarea').val(),
         				'workStart' : workStartInput,
        				'workDeadline' : workDeadlineInput,
        				'progress' : workProgressInput,
        			 	'importance' : workImportanceInput,
        				'workStatus' : workStatusInput,
        				'memId' : workMemIdInput
        		}
        		
        		
        		console.log(workNameInput +","+ workStartInput +","+  workDeadlineInput +","+  workImportanceInput +","+  workMemIdInput +","+  workStatusInput +","+  workProgressInput)
        		// 미입력 칸 확인
        		if(!(workNameInput && workStartInput && workDeadlineInput && workImportanceInput && workMemIdInput)) {
        			alert("미기재 항목이 존재합니다. 모든 항목을 입력해주세요.")
        		}else {
        			
        			if(confirm("업무 내용을 저장하시겠습니까?")){
        				
        				
	        			$.ajax ({
	        				url : '${cPath}/project/${project.pCode}/task/taskInsert.do',
	        				data : data,
	        				method : 'post',
	        				success : function(resp) {
	        					
	        					if(resp == "OK") {
	        						location.href="${cPath}/project/${project.pCode}/task/taskList.do"
	        						
	        					}else {
	        						alert("등록을 실패했습니다. 다시 시도하세요.")
	        					}
	        					
	        					// 넘어온 값에 따라, 성공, 실패 여부 판단 
	        					
	        				},
	        				error: function(xhr, jQuery, error){
	 	    					console.log(jQuery);
	 	    					console.log(error);
	 	    			  }
	        			})
        				
        			}
        			
        		}
        		
        		
        	})
        	


        
			$(document).ready(function(){
			  $('[data-toggle="tooltip"]').tooltip();   
			});
			
	  
			  $('#topWorkSearch').keyup(function () {
				  
				  var searchWorkName = $(this).val();
				  $.ajax ({
					  url : "${cPath}/task/taskSearch.do",
					  data : { searchWorkName : $(this).val() },
					  method : 'post',
					  success : function(resp) {
						   $('#searchListTable').empty();
						   
						   console.log(resp.length)

						  for(let i = 0; i < resp.length; i++){
							  console.log(resp[i].workCode);
							  
							  $('#searchListTable').append(
									  "<tr class='searchTr' style='margin-top:20px;'>" +
									  "<td style='text-align:center;'>" + resp[i].workCode + "</td>" +
									  "<td style='text-align:center;'>" + resp[i].workName + "</td>" +
									  "<td style='text-align:center;'><input type='button' value='선택' class='btn btn-info btn-sm btnCheck' " +
									  "data-value=' "+ resp[i].workCode + " - " + resp[i].workName + " '></input></td>" +
									  "</tr>"
								);
							  
							  $('.btnCheck').on('click', function () {
								 dataValue = $(this).attr('data-value');
								 
								 
								 console.log("for문 안에 " + dataValue);
								 $('#topWorkCodeDiv').html("<p style='margin-top:10px;'><i style='color:#dc3545; margin-right:10px;'class='fas fa-check'></i>" + dataValue + "</p>");
								 $('#topWorkSpan').attr('data-value', dataValue)
								 $('#myModal').modal('hide');
							  })
		
						  } 
						   
						   
	    					//$('.searchList').text(resp.workName);
	    					
	    				},
	    			  error: function(xhr, jQuery, error){
	    					console.log(jQuery);
	    					console.log(error);
	    			  }
				  })
			  })
			  
				
			  $(function () {
			    //Add text editor
			    $('#compose-textarea').summernote()
			  })

			
			  $('#testBtn').on('click', function () {
				  $('#workNameInput').val("log4j 보안 이슈");
				  $('#taskMember').val("aa004"); 
				  $('#taskImportance').val("IMPORTANCE001"); 
				  $('#dateInputStart').val("2021-12-23"); 
				  $('#dateInputDeadline').val("2021-12-25"); 
				  $('#compose-textarea').summernote('editor.insertText', 'log4j 관련 보안 이슈가 발생했으니 빠른 대응 부탁드립니다. 해당 이슈는 JNDI 인터페이스의 LDAP 를 이용합니다. log4j의 버전을 2.16 이상으로 올리거나 log4j 의 PatternLayout 수정 또는 JndiLookup, JndiManager 클래스를 비활성화 시키는 작업을 진행하길 바랍니다.');
				  
				 
			  })

			
		</script>
		
		
	