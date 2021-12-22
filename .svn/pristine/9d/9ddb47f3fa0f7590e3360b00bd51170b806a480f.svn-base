<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>



	document.addEventListener('DOMContentLoaded',
			function() {
		let scheduleName = $(this).parents('#calendarModal').data("scheduleName");
		let scheduleContent = $(this).parents('#calendarModal').data("scheduleContent");
				var calendarEl = document.getElementById('calendar');
				var colorCode = "#e9ac00";
						/* + Math.round(Math.random() * 0xffffff).toString(16); */

				var calendar = new FullCalendar.Calendar(calendarEl, {
					initialView : 'dayGridMonth',
					

					events : '${cPath}/project/${project.pCode}/calendar/calendarfordata.do',
						
					eventColor : colorCode,
					eventClick : function(info) {
						let event = info.event;
					 	$('#modalTitle').html(event.title);
						$('#modalBody').html(event.extendedProps.scheduleContent);
						$('#eventUrl').attr('href', event.url); 
						$('#calendarModal').modal();
					}

				});
				
				
				calendar.render();
			});
</script>


<!-- <div class="invoice mb-3"> -->

<style>
	.modalContent {
		padding: 10px;
    	border-top: 3px solid #3f6791;
	}
	
	.modal-header h4 {
		font-weight: 600;
	}
	
	.modalBody {
		height: 150px;
	}
	
</style>



	<div class="invoice mb-3">
	
	<div class="row" >
		<div class="col-12" style="margin-top: 10px;">
			<h4>
				<i class="fas fa-calendar-check" style="margin-right: 10px;"></i>일정 관리
			</h4>
		</div>
	</div>
	
	<hr>
	
		<div id="calendar"></div>
		<div id="calendarModal" class="modal fade">
		<div class="modal-dialog">
		    <div class="modal-content modalContent">
		        <div class="modal-header">
		            <h4 id="modalTitle" class="modal-title"></h4>
		            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span> <span class="sr-only">close</span></button>
		        </div>
		        <div id="modalBody" class="modal-body modalBody"></div>
		        <div class="modal-footer">
		            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		        </div>
		    </div>
		</div>
		</div>
	
	</div>

<!-- </div> -->






