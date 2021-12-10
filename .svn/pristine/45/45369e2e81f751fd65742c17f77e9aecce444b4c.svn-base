<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="${cPath }/resources/adminLTE3/jsgantt-improved-master/dist/jsgantt.js" type="text/javascript"></script>


<div class="invoice mb-3">
   <div class="row" style="margin-bottom: 30px;">
      <div class="col-12" style="margin-top: 10px;">
         <h4>
            <i class="fas fa-stream" style="margin-right: 10px;"></i> 간트차트
         </h4>
      </div>
   </div>
<div>

		<div class="container-fluid">
			<select name="taskStatus" id="taskStatus"
				class="form-control custom-select">

				<option selected value>현황</option>
				<option value="STATUS001">TODO</option>
				<option value="STATUS002">PROCESS</option>
				<option value="STATUS003">DONE</option>

			</select>
			<div id="selectDiv">

				<!-- 담당자 -->
				<select name="taskMember" id="taskMember"
					class="form-control custom-select">
					<option selected value>담당자</option>

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
			</div>

		</div>

		<div style="position: relative" class="gantt" id="GanttChartDIV">
   </div>
   
</div>

</div>
<script>
	$(function() {

		let search = function(item) {
			var status = taskStatus.val();
			var memId = taskMember.val();

			let task = item.getDataObject();

			item.setVisible(0);
			//1. status와 id가 둘다 선택되었을 때 
			if (status && memId) {
				if (task.status == status && task.memId == memId) {
					item.setVisible(1);
				}
			} else if (status && !memId) {
				if (task.status == status) {
					item.setVisible(1);
				}
			} else if (!status && memId) {
				if (task.memId == memId) {
					item.setVisible(1);
				}
			} else {
				item.setVisible(1);
			}

			//console.log(item.getCategory());
			console.log(status);

		};

		let taskStatus = $("#taskStatus").change(function() {

			let array = chartG.getList();

			array.forEach(search);

			chartG.Draw();
		});

		let taskMember = $("#taskMember").change(function() {
			let array = chartG.getList();

			array.forEach(search);

			chartG.Draw();
		});

	});
	// 상위업무 1 에 하위업무가 들어가려면 pId가 11 , 12 이런식으로 들어가야한다. 
	const loadGanttPage = function() {

		let g = new JSGantt.GanttChart(
				document.getElementById('GanttChartDIV'), 'day');

		g.setOptions({
			vCaptionType : 'Complete', // Set to Show Caption : None,Caption,Resource,Duration,Complete,     
			vQuarterColWidth : 36,
			vDateTaskDisplayFormat : 'day dd month yyyy', // Shown in tool tip box
			vDayMajorDateDisplayFormat : 'mon yyyy',// Set format to dates in the "Major" header of the "Day" view
			vWeekMinorDateDisplayFormat : 'dd mon', // Set format to display dates in the "Minor" header of the "Week" view
			vLang : 'en',
			vShowTaskInfoLink : 1, // Show link in tool tip (0/1)
			vShowEndWeekDate : 0, // Show/Hide the date for the last day of the week in header for daily
			vUseSingleCell : 10000, // Set the threshold cell per table row (Helps performance for large data.
			vAdditionalHeaders : { // Add data columns to your table
				category : {
					title : 'Status'
				},

			},
			vFormatArr : [ 'Day', 'Week', 'Month' ]
		// Even with setUseSingleCell using Hour format on such a large chart can cause issues in some browsers,

		});

		<c:forEach items="${taskList }" var="tasklist">
		g
				.AddTaskItemObject({
					pID : "${tasklist.topWorkCode}${tasklist.workCode}",
					pName : "${tasklist.topWorkName}${tasklist.workName}",
					pStart : "${tasklist.workStart}",
					pEnd : "${tasklist.workDeadline}",
					pClass : "gtaskyellow",
					pLink : "",
					pMile : 0,
					pRes : "${tasklist.memNickname}",
					pComp : "${tasklist.progressName}",
					pGroup : "${tasklist.topWorkCode==null ? 1 : tasklist.topWorkCode}",
					pParent : "${tasklist.topWorkCode==null ? 0 : tasklist.topWorkCode}",
					pOpen : 1,
					pDepend : "",
					pCaption : "",
					pNotes : "${tasklist.workContents}",
					category : "${tasklist.workStatusName}",
					memId : "${tasklist.memId}",
					status : "${tasklist.workStatus}"
				});

		</c:forEach>

		g.Draw();
		return g;
	}

	let chartG = loadGanttPage();
</script>