<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
#container1, #container2, #container3 {
   height: 800px;
   width: 30%;
}


.container-fluid h-100 {
   width: 2000px;
}

.col-sm {
   margin: 0px 10px;
   padding-right: 0;
    padding-left: 0;
}


.card-success:not(.card-outline)>.card-header {
   background: #3f6791;
}

.progress {

   border-radius: 10px;
    margin: 10px 0px;
}

.card-header h5{
   font-weight: bold;
}


.card-light.card-outline {
   border-top : 2px solid #3f6791a6;
}


#content {
	padding-top: 30px;
}

.col-12 h4{
	margin-left: 50px;
    margin-bottom: 0;
}


.cardMove {
	overflow: auto;
	height: 100%;
}

.row {
	margin-right: 0;
	margin-left: 0;
}

.progress-description {
	color : gray;
	font-size: 14px;
}

.card-body p {
	margin-top: 10px;
}
</style>



   
	<div class="row" style="margin-bottom: 30px;">
		<div class="col-12" style="margin-top: 10px;">
			<h4>
				<i class="fas fa-clipboard-list"></i> 칸반 [내 업무]
			</h4>
		</div>
	</div>
	
      <div class="row" style="padding: 50px; padding-top: 0;">

         <div id="container1" class="col-sm card card-row card-success">

            <div class="card-header">
               <h3 class="card-title">To Do</h3>

            </div>
         
            <div class="cardMove" style="padding: 0">
            <c:forEach items="${taskList }" var="tasklist">
               <c:if test="${tasklist.workStatus eq 'STATUS001'}">
      

                  <div>
                     <div id="${tasklist.workCode }" class="card-body">
                        <div class="card card-light card-outline">
                           <div class="card-header">
                              <h5 class="card-title">${tasklist.workName}</h5>
                           </div>
                           <div class="card-body">
                              <c:if test="${tasklist.workStatus eq 'STATUS001' }">
                                 <td><span class="badge bg-primary sta">TODO</span></td>
                              </c:if>
                              <c:if test="${tasklist.importance eq 'IMPORTANCE001' }">
                                 <td><span class="badge bg-dark sta">긴급</span></td>
                              </c:if>

                              <c:if test="${tasklist.importance eq 'IMPORTANCE002' }">
                                 <td><span class="badge bg-danger sta">높음</span></td>
                              </c:if>

                              <c:if test="${tasklist.importance eq 'IMPORTANCE003' }">
                                 <td><span class="badge bg-warning sta">보통</span></td>
                              </c:if>

                              <c:if test="${tasklist.importance eq 'IMPORTANCE004' }">
                                 <td><span class="badge bg-primary sta">낮음</span></td>
                              </c:if>
                              <div class="progress">
                                 <div class="progress-bar bg-success progress-bar-striped progress-bar-animated"
                                    style="width:${tasklist.progressName}%">${tasklist.progressName}</div>

                              </div>
                           <input type="hidden" class="progressColumn" value="${tasklist.progress }"/>
                              <span class="progress-description">현재 진척도 - ${tasklist.progressName}% </span>
                              <p>${tasklist.workContents}</p>
                              <div class="work-state"></div>
                           </div>
                        </div>
                     </div>
                  </div>
               </c:if>
            </c:forEach>
           </div>
         </div>
         <div id="container2" class="col-sm card card-row card-success">

            <div class="card-header">
               <h3 class="card-title">ING</h3>

            </div>

            <div class="cardMove" style="padding: 0">
            <c:forEach items="${taskList }" var="tasklist">
               <c:if test="${tasklist.workStatus eq 'STATUS002'}">


                  <div >
                     <div id="${tasklist.workCode }" class="card-body">
                        <div class="card card-light card-outline">
                           <div class="card-header">
                              <h5 class="card-title">${tasklist.workName}</h5>
                           </div>
                           <div class="card-body">
                              <c:if test="${tasklist.workStatus eq 'STATUS002' }">
                                 <td><span class="badge bg-warning sta">ING</span></td>
                              </c:if>
                              <c:if test="${tasklist.importance eq 'IMPORTANCE001' }">
                                 <td><span class="badge bg-dark sta">긴급</span></td>
                              </c:if>

                              <c:if test="${tasklist.importance eq 'IMPORTANCE002' }">
                                 <td><span class="badge bg-danger sta">높음</span></td>
                              </c:if>

                              <c:if test="${tasklist.importance eq 'IMPORTANCE003' }">
                                 <td><span class="badge bg-warning sta">보통</span></td>
                              </c:if>

                              <c:if test="${tasklist.importance eq 'IMPORTANCE004' }">
                                 <td><span class="badge bg-primary sta">낮음</span></td>
                              </c:if>
                              <div class="progress">
                                 <div class="progress-bar bg-success progress-bar-striped progress-bar-animated"
                                    style="width:${tasklist.progressName}%">${tasklist.progressName}</div>

                              </div>
                                 <input type="hidden" class="progressColumn" value="${tasklist.progress }"/>
                              <span class="progress-description">현재 진척도 - ${tasklist.progressName}%</span>
                              <p>${tasklist.workContents}</p>
                              <div class="work-state"></div>
                           </div>
                        </div>
                     </div>
                  </div>
               </c:if>
            </c:forEach>
            </div>
         </div>
         
         <div id="container3" class="col-sm card card-row card-success">

            <div class="card-header">
               <h3 class="card-title">DONE</h3>

            </div>

            <div class="cardMove" style="padding: 0">
            <c:forEach items="${taskList }" var="tasklist">
               <c:if test="${tasklist.workStatus eq 'STATUS003'}">


                  <div>
                     <div id="${tasklist.workCode }" class="card-body">
                        <div class="card card-light card-outline">
                           <div class="card-header">
                              <h5 class="card-title">${tasklist.workName}</h5>
                           </div>
                           <div class="card-body">
                              <c:if test="${tasklist.workStatus eq 'STATUS003' }">
                                 <span class="badge bg-danger sta">DONE</span>
                              </c:if>
                              <c:if test="${tasklist.importance eq 'IMPORTANCE001' }">
                                 <span class="badge bg-dark sta">긴급</span>
                              </c:if>

                              <c:if test="${tasklist.importance eq 'IMPORTANCE002' }">
                                 <span class="badge bg-danger sta">높음</span>
                              </c:if>

                              <c:if test="${tasklist.importance eq 'IMPORTANCE003' }">
                                 <span class="badge bg-warning sta">보통</span>
                              </c:if>

                              <c:if test="${tasklist.importance eq 'IMPORTANCE004' }">
                                 <span class="badge bg-primary sta">낮음</span>
                              </c:if>
                               <div class="progress">
                                 <div class="progress-bar bg-success progress-bar-striped progress-bar-animated"
                                    style="width:${tasklist.progressName}%">${tasklist.progressName}</div>
                              </div>
                                 <input type="hidden" class="progressColumn" value="${tasklist.progress }"/>
                                 

                              <span class="progress-description">현재 진척도 - ${tasklist.progressName}% </span>
                              <p>${tasklist.workContents}</p>
                              <div class="work-state"></div>
                           </div>
                        </div>
                     </div>
                  </div>
               </c:if>
            </c:forEach>
            </div>
         </div>



      </div>



<script>


$(function() {
var beforeDrop ; 
    var Toast = Swal.mixin({
      toast: true,
      position: 'top-end',
      showConfirmButton: false,
      timer: 3000
    });

   let one = document.querySelector('#container1 .cardMove')
   let two = document.querySelector('#container2 .cardMove')
   let three = document.querySelector('#container3 .cardMove')

   var drake = dragula([ one, two, three ])

   drake
         .on(
               'drag',
               function(el, source) {
                  document.getElementsByTagName('body')[0].style.backgroundColor = '#28a0ef';
                  console.log(el);
                  console.log(source);
                  
                  beforeDrop = $(source).prop('id');
                  console.log(beforeDrop);
               })
   drake
         .on(
               'drop',
               function(el, target) {
                  el.style.border = '5px dashed white';

                  const work_code = $(el).children('.card-body').prop('id');
                  var work_state = $(el).find('.work-state').text();
                  
                  const pro = `<div class="progress-bar bg-success progress-bar-striped progress-bar-animated" style="width:100%">100</div>`;
                  
                  var sta = `<span class="badge bg-danger">DONE</span>`;
                  var sta2 = `<span class="badge bg-warning">ING</span>`;
                  var sta3 = `<span class="badge bg-primary">TODO</span>`;
                  
                  var status = $(el).find('span.sta').first().text();
                  console.log("status", status);
                  
                  var work_progress = $(el).find('.progress').text();
                  var work_progressCol = $(el).find('.progressColumn').val();
                  console.log("progressCol", work_progressCol)
                  

                  const con1 = $("#container1 .cardMove").find("#" + work_code).length;
                  const con2 = $("#container2 .cardMove").find("#" + work_code).length;
                  const con3 = $("#container3 .cardMove").find("#" + work_code).length;

                  console.log(con1, con2, con3)
               if(con1 == 1){
                     work_state = 'STATUS001';
                     }else if(con3 == 1){
                        work_state = 'STATUS003';
                        work_progressCol = 'PROGRESS0100';   
                     }else if(con2 == 1){
                     if(beforeDrop == 'container1'){
                        work_state = 'STATUS002';
                     
                     }else if(beforeDrop == 'container3'){
                           work_state = 'STATUS002';
                           work_progress = 'PROGRESS0100';   
                     }else{
                        work_state = 'STATUS002'
                     }
                     }
                  console.log(work_state);
                  console.log(work_progress);
                  $.ajax({
                        type : "post",
                        url : "${cPath}/project/{pCode}/kanban/kanban.do",
                        data : {
                           "con1" : con1,
                           "con2" : con2,
                           "con3" : con3,
                           "workStatus" : work_state,
                           "workCode" : work_code,
                           "progress" : work_progressCol
                        },
                        success : function(data){
                           switch (work_state) {
                        case 'STATUS003':
                           var progress = $(el).find('.card-body').find('.progress').empty().append(pro);
                           var status = $(el).find('span.sta').first().empty().append(sta);
                           
                           break;
                        case 'STATUS002':
                           var status = $(el).find('span.sta').first().empty().append(sta2);
                           break;
                        case 'STATUS001':
                           var status = $(el).find('span.sta').first().empty().append(sta3);
                           break;
                        
                        default:
                           break;
                        }
                             
                            //location.reload();
                           toastr.success("이동완료");
                           
                        },
                        error : function () {
                           toastr.error('오류.');
                     }
                        
                     }) 
                    

                  //el.innerText = "Drag MEEEE :)"
                  document.getElementsByTagName('body')[0].style.backgroundColor = 'black';
               })
});
</script>