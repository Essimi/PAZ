<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<link rel="stylesheet" href="${cPath }/resources/adminLTE3/summernote/summernote-bs4.min.css">



    <div class="col-md-9" style="max-width: 100%; margin-top: 25px;">
    
          <div class="card card-primary card-outline">
            <div class="card-header">
              <h3 class="card-title">업무 수정</h3>
              
               <input type="button" id="testBtn" value="test" class="btn btn-default btn-sm" style="float: right;"/>
            </div>
            
            
            <!-- /.card-header -->
            <div class="card-body p-0">
            
              <div class="mailbox-read-info">
              <c:if test="${not empty task.topWorkCode}">
                <span id="topWorkSpan" class="badge badge-info topWorkBadge" data-toggle="tooltip" data-placement="top" title="상위 업무" data-value="${task.topWorkCode }">${task.topWorkName }</span>
              </c:if>

              	<br>
                <input id="workNameInput" type="text" style="margin:10px 0px; font-size:20px;  width:70%;" value="${task.workName }" />
                
               	<h6 style="color:gray;">${task.workCode }</h6>
               	
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
	
						<td>${task.memNickname }</td>

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
	                	
	                	<%-- 
		                      <c:if test="${data.workStatus eq 'STATUS001' }">
		                      	<td><span class="badge bg-light">TO DO</span></td>
		                      </c:if>
		                      
		                      <c:if test="${data.workStatus eq 'STATUS002' }">
		                      	<td><span class="badge bg-success">IN PROCESS</span></td>
		                      </c:if>
		                      
		                      <c:if test="${data.workStatus eq 'STATUS003' }">
		                      	<td><span class="badge bg-secondary">DONE</span></td>
		                      </c:if> --%>
	                	
	                	
						
	                      
	                      
	                      <!-- 중요도 -->
	                      <c:if test="${task.importance eq 'IMPORTANCE001' }">
	                      	<td><span class="badge bg-danger importanceBadge" data-value="${task.importance }">긴급</span></td>
	                      </c:if>
	                      
	                      <c:if test="${task.importance eq 'IMPORTANCE002' }">
	                      	<td><span class="badge bg-warning importanceBadge" data-value="${task.importance }">높음</span></td>
	                      </c:if>
	                      
	                      <c:if test="${task.importance eq 'IMPORTANCE003' }">
	                      	<td><span class="badge bg-warning importanceBadge" data-value="${task.importance }">보통</span></td>
	                      </c:if>
	                      
	                      <c:if test="${task.importance eq 'IMPORTANCE004' }">
	                      	<td><span class="badge bg-info importanceBadge" data-value="${task.importance }">낮음</span></td>
	                      </c:if>
						
						
						<td>
							<input id="dateInputStart" class="dateInput" type="date" value="${task.workStart }" />
						</td>
						
						<td>
						
							<input id="dateInputDeadline" class="dateInput" type="date" value="${task.workDeadline }" />
							
						</td>
						
						
						<td style=" vertical-align:middle;">
						
							<select name="taskProgress" id="taskProgress" class="form-control custom-select">
		                 
			                  <option disabled value>진척도</option>
			                  
			                  <option value="0" data-value="PROGRESS0000">0%</option>
			                  <option value="10" data-value="PROGRESS0010">10%</option>
			                  <option value="20" data-value="PROGRESS0020">20%</option>
			                  <option value="30" data-value="PROGRESS0030">30%</option>
			                  <option value="40" data-value="PROGRESS0040">40%</option>
			                  <option value="50" data-value="PROGRESS0050">50%</option>
			                  <option value="60" data-value="PROGRESS0060">60%</option>
			                  <option value="70" data-value="PROGRESS0070">70%</option>
			                  <option value="80" data-value="PROGRESS0080">80%</option>
			                  <option value="90" data-value="PROGRESS0090">90%</option>
			                  <option value="100" data-value="PROGRESS0100">100%</option>
			                  
		                  
		                	</select>
		                      
		                     
		                       	 
		                        
		                </td>
		                      
		                      
					</tr>
					
					</tbody>
				</table>
                
              </div>
              
              
              <!-- /.mailbox-read-info -->
              <div class="mailbox-controls with-border">
              
              
              <textarea id="compose-textarea" class="form-control" style="height: 300px; display: none;" value>${task.workContents }</textarea>
             
              
              
              	
                 
              </div>
              
              

              <!-- /.mailbox-read-message -->
            </div>
            <!-- /.card-body -->
            
            <!-- /.card-footer -->
            <div class="card-footer">
              <button id="editTask" type="button" class="btn btn-default"><i class="fas fa-pencil-alt"></i> 수정</button>
              <button id="backTask" type="button" class="btn btn-default" onclick="location.href='${cPath}/project/${project.pCode }/task/taskList.do'"><i class="fas fa-undo-alt"></i> 뒤로가기</button>
            </div>
            <!-- /.card-footer -->
          </div>
          <!-- /.card -->
        </div>
        
        
        
        
        <script>
        
        	var dataValue = "${task.topWorkCode }";
        	var modifyList = "${task.modifyHistoryList }";
        	
        	$('#editTask').on('click', function () {

        		var result = $('#workNameInput').val();
        		
        		var data = {
        			    'workCode' : '${task.workCode}',
        				'workName' : $("#workNameInput").val(),
        				'topWorkCode' : dataValue,
        				'workName' : $('#workNameInput').val(),
        				'workContents' : $('#compose-textarea').val(),
         				'workStart' : $('#dateInputStart').val(),
        				'workDeadline' : $('#dateInputDeadline').val(),
        				'progress' : $('#taskProgress').val(),
        			 	'importance' : $('.importanceBadge').attr('data-value'),
        				'workStatus' : $('#taskStatus').val(),
        				'memNickname' : '${project.memId}',
        				'memId' : '${task.memId }'
        		}
        		
        		
        		// 미입력 칸 확인
        		if(!result) {
        			alert("업무 제목을 입력해주세요.")
        		}else {
        			
        			if(confirm("수정 내용을 저장하시겠습니까?")){
        		
        				
	        			$.ajax ({
	        				url : '${cPath}/project/${project.pCode}/task/taskUpdateCheck.do',
	        				data : data,
	        				method : 'post',
	        				success : function(resp) {
	        					
	        					if(resp == "OK") {
	        						alert("수정을 성공했습니다.");
	        						location.href="${cPath}/project/${project.pCode}/task/taskList.do"
	        						
	        					}else {
	        						alert("수정을 실패했습니다. 다시 시도하세요.")
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
			    $('#compose-textarea').summernote();
			  })


   			$("[name='taskStatus']").val("${task.workStatus}");
   			$("[name='taskProgress']").val("${task.progress}");
   			
   			
   			
			  $('#testBtn').on('click', function () {
				  $('#workNameInput').val("최종 프로젝트 테스트 수정");
				  $('#taskStatus').val("STATUS002");
				  $('#dateInputStart').val("2021-12-20"); 
				  $('#dateInputDeadline').val("2022-01-30"); 
				  $('#compose-textarea').summernote('editor.insertText', '업무 내용 수정 - 최종 프로젝트 테스트 업무 수정입니다.');
				  
				  
			  })
       			
       </script>