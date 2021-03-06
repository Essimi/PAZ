<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<script>

/* 업무 담당자별 할당 비율 */
// data: [{
//     name: 'Chrome',
//     y: 61.41
//   }]
let taskManagement = []

<c:forEach items="${taskManagerRatio}" var="taskManagerRatioSelect">
taskManagement.push({
	name: '${taskManagerRatioSelect.memNickname}',
	y: ${taskManagerRatioSelect.taskCount}
});
</c:forEach>

Highcharts.chart('plTaskManagement', {
  chart: {
    plotBackgroundColor: null,
    plotBorderWidth: null,
    plotShadow: false,
    type: 'pie'
  },
  title: {
    text: '업무 담당자별 할당 비율'
  },
  tooltip: {
    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
  },
  accessibility: {
    point: {
      valueSuffix: '%'
    }
  },
  plotOptions: {
    pie: {
      allowPointSelect: true,
      cursor: 'pointer',
      dataLabels: {
        enabled: false
      },
      showInLegend: true
    }
  },
  series: [{
    name: 'Brands',
    colorByPoint: true,
    data: taskManagement
  }]
});




/* 이슈 받은건, 요청건 횟수 통계  */
 	//이슈 요청건에 대한 정보
let issueRequest=[]
<c:forEach items="${issueManagerment }" var="issueRequestList">
	issueRequest.push([
		${issueRequestList.issueCount}		
	]);
</c:forEach>
	//이슈받은 건에 대한 정보
let issueReceive=[]
<c:forEach items="${issueManagerment }" var="issutReceiveList">
	issueReceive.push([
		${issutReceiveList.recipientCount}		
	]);
</c:forEach>
	//회원 아이디에 대한정보
let memid=[]
<c:forEach items="${issueManagerment }" var="memidList">
	memid.push([
		'${memidList.memNickname}'		
	]);
</c:forEach> 
 
 
 
Highcharts.chart('managementTask', {

  chart: {
    polar: true,
    type: 'line'
  },

  title: {
    text: '회원 소속별 분야 그래프',
    x: -80
  },

  pane: {
    size: '80%'
  },

  xAxis: {
    categories: memid,
    tickmarkPlacement: 'on',
    lineWidth: 0
  },

  yAxis: {
    gridLineInterpolation: 'polygon',
    lineWidth: 0,
    min: 0
  },

  tooltip: {
    shared: true,
    pointFormat: '<span style="color:{series.color}">{series.name}: <b>{point.y:,.0f}</b><br/>'
  },

  legend: {
    align: 'right',
    verticalAlign: 'middle',
    layout: 'vertical'
  },

  series: [{
    name: '요청 받음',
    data: issueReceive,
    pointPlacement: 'on'
  }, {
    name: '요청함',
    data: issueRequest,
    pointPlacement: 'on'
  }],

  responsive: {
    rules: [{
      condition: {
        maxWidth: 500
      },
      chartOptions: {
        legend: {
          align: 'center',
          verticalAlign: 'bottom',
          layout: 'horizontal'
        },
        pane: {
          size: '70%'
        }
      }
    }]
  }

});

/* 팀원별 업무 상태 그래프 */
 
 //팀원 이름
 let teamStateNickName = []
 //팀원 TODO
 let teamStateToDo = []
 //팀원 PROCESS
 let teamStateProcess = []
 //팀원 done
 let teamStateDone = []
 
 
 <c:forEach items="${teamState}" var="teamState">
 teamStateNickName.push(
		'${teamState.memNickname}'
	)
</c:forEach>

 //  data: [49, 71, 106, 129, 144, 176]
 <c:forEach items="${teamState}" var="teamState">
 teamStateToDo.push(
 		${teamState.todo}	
 	)
 </c:forEach>
 
<c:forEach items="${teamState}" var="teamState">
teamStateProcess.push(
 		${teamState.process}	
 	)
 </c:forEach>

 <c:forEach items="${teamState}" var="teamState">
 teamStateDone.push(
 		${teamState.done}	
 	)
 </c:forEach> 	
 	
 Highcharts.chart('teamStateDash', {
  chart: {
    type: 'column'
    
  },
  title: {
    text: '팀원별 업무 상태 그래프',
    width : 3000,
	height : 500
  },
  xAxis: {
    categories: teamStateNickName,
    crosshair: true
  },
  yAxis: {
    min: 0,
    title: {
      text: '업무량'
    }
  },
  tooltip: {
    headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
    pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
      '<td style="padding:0"><b>{point.y:f}</b></td></tr>',
    footerFormat: '</table>',
    shared: true,
    useHTML: true
  },
  plotOptions: {
    column: {
      pointPadding: 0.2,
      borderWidth: 0
    }
  },
  series: [{
    name: 'TODO',
    data: teamStateToDo

  }, {
    name: 'process',
    data: teamStateProcess

  }, {
    name: 'DONE',
    data: teamStateDone

  }]
});
 
 
 
 
 /* 팀원별 주간 업무시간 */
	/* 근무시간 토탈 정보 */
	let workTimeTotal = []
	 <c:forEach items='${teamWorkTime}' var='teamWorkTime'>
		 workTimeTotal.push({
			name : "${teamWorkTime.memNickname}" ,
			y : ${teamWorkTime.total},
			drilldown : "${teamWorkTime.memNickname}"
	 })
	 </c:forEach>
	 
	/* 드릴다운의 데이터 */ 
	 let workTimeDay = []
	 <c:forEach items="${teamWorkTime}" var='teamWorkTime'>
	 	workTimeDay.push({
	 		name : "${teamWorkTime.memNickname}" ,
	 		id : "${teamWorkTime.memNickname}" ,
		 	data :[
						[
		 			"월" ,
		 	 		${teamWorkTime.monday}
		 		],
		 		[
		 			"화" ,
		 	 		${teamWorkTime.tuesday}
		 		],
		 		[
		 			"수" ,
		 	 		${teamWorkTime.wednesday}
		 		],
		 		[
		 			"목" ,
		 	 		${teamWorkTime.thursday}
		 		],
		 		[
		 			"금" ,
		 	 		${teamWorkTime.friday}
		 		]
				]
		 	})
	 </c:forEach>
 
 
 
 Highcharts.chart('workTime', {
  chart: {
    type: 'column'
  },
  title: {
    text: '주간업무시간(지난주)'
  },

  accessibility: {
    announceNewData: {
      enabled: true
    }
  },
  xAxis: {
    type: 'category'
  },
  yAxis: {
    title: {
      text: '주간업무시간 (지난주)'
    }

  },
  legend: {
    enabled: false
  },
  plotOptions: {
    series: {
      borderWidth: 0,
      dataLabels: {
        enabled: true,
        format: '{point.y:f}시간'
      }
    }
  },

  tooltip: {
    headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
    pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:f}</b>시간<br/>'
  },

  series: [
    {
      name: "프로젝트 팀",
      colorByPoint: true,
      data: workTimeTotal
    }
  ],
  drilldown: {
    series: workTimeDay
  }
});
 </script>