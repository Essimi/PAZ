<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="${cPath }/resources/ganttchart/css/style.css" rel="stylesheet" type="text/css"/>
<script src="${cPath }/resources/ganttchart/js/ganttchart.js" type="text/javascript"></script>

<div class="row">
	<div class="col-12">
		<div class="card">
			<div class="card-header">
				<h2 class="card-title">간트 차트</h2>
				<div class="card-tools">
					<div class="input-group input-group-sm" style="width: 150px;">
					</div>
				</div>
			</div>
			</div>
			</div>
			</div>
			
<script>

	
	$(function() {
	  "use strict";
	  $(".gantt").gantt({
	    source: [
	      
	      
			      {
			    	  name: "Sprint 0",
				        desc: "하위4",
				        values: [
				          {
				            from: "/Date(1320192000000)/",
				            to: "/Date(1322401600000)/",
				            label: "Requirement Gathering",
				            customClass: "ganttRed"
				            
				          }
				        ]
				      },
				      {
					        name: "Sprint 1",
					        desc: "Analysis",
					        values: [
					          {
					            from: "/Date(1320192000000)/",
					            to: "/Date(1322401600000)/",
					            label: "Requirement Gathering",
					            customClass: "ganttRed"
					          }
					        ]
					      }
	    ],
	    navigate: "scroll",
	    scale: "weeks",
	    maxScale: "months",
	    minScale: "days",
	    itemsPerPage: 10,
	    onItemClick: function(data) {
	      alert("Item clicked - show some details");
	      console.log(data);
	    },
	    onAddClick: function(dt, rowId) {
	      alert("Empty space clicked - add an item!");
	    },
	    onRender: function() {
	      if (window.console && typeof console.log === "function") {
	        console.log("chart rendered");
	      }
	    }
	  });
	});

</script>


    </script>
    
<div class="gantt"></div>
    
    