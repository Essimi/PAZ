<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<script>
document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    var colorCode = "#" + Math.round(Math.random() * 0xffffff).toString(16);
    
    var calendar = new FullCalendar.Calendar(calendarEl, {
      initialView: 'dayGridMonth',
      
      events: '${cPath}/calendar/calendarfordata.do',
      eventColor : colorCode,
      eventClick: function() {
  	    alert('a day has been clicked!');
  	  }
      
   
    });
    calendar.render();
  });
</script>



	<div id="calendar"></div>
	
		
	
	
	
