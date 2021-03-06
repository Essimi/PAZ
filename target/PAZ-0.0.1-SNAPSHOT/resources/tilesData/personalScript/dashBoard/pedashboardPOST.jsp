<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
//월별 이슈 발생건 출력
//배열로 넘어오기 때문에 배열을 지정해줍니다.
let monthArray = []
let monthArrayValue = []

//반복문을 돌며 선언한 배열에 저장합니다.
<c:forEach items="${monthIssue }" var="monthIssue">
	monthArray.push(['${monthIssue.issueDate}월']);
	monthArrayValue.push([parseInt('${monthIssue.issueCount}')]);
</c:forEach>

//월간 이슈 차트
const chart = new Highcharts.Chart({
  chart: {
    renderTo: 'monthIssueCount',
    type: 'column',
    width : 1500,
	height : 340,
    options3d: {
      enabled: false,
      alpha: 15,
      beta: 15,
      depth: 50,
      viewDistance: 25,   
    }
  },
  title: {
    text: ''
  },
  xAxis: {
		 categories: monthArray
  },
  yAxis:{
	title:{
		text : ''
	}  
  },
  subtitle: {
    text: ''
  },
  plotOptions: {
    column: {
      depth: 25
    }
  },
  series: [{
    data: monthArrayValue,
    name : 'monthIssueCount'
  }]
});

	
	
	
	
	
	
	
	
	
	
	
	
//내 업무 상태 출력
let Todo = parseInt('${myTaskStatusMap.Todo}');
let Process = parseInt('${myTaskStatusMap.Process}');
let Done = parseInt('${myTaskStatusMap.Done}');

//도넛형 차트
Highcharts.chart('taskRatio', {
chart: {
 plotBackgroundColor: null,
 plotBorderWidth: null,
 plotShadow: false,
 type: 'pie'
},
title: {
 text: ''
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
 data: [{
   name: 'PROCESS',
   y: Process
 }, {
   name: 'TODO',
   y: Todo,
   color: '#ffd966'
 }, {
   name: 'DONE',
   y: Done
 }]
}]
});

//내 이슈 상태 출력
let Emergency = parseInt('${myIssueStatusMap.IMPORTANCE001}');
let High = parseInt('${myIssueStatusMap.IMPORTANCE002}');
let Medium = parseInt('${myIssueStatusMap.IMPORTANCE003}');
let Low = parseInt('${myIssueStatusMap.IMPORTANCE004}');

//도넛형 차트
Highcharts.chart('issueRatio', {
chart: {
 plotBackgroundColor: null,
 plotBorderWidth: null,
 plotShadow: false,
 type: 'pie'
},
title: {
 text: ''
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
 data: [{
   name: 'Emergency',
   y: Emergency,
   color: '#cb1c1c'
 }, {
   name: 'High Priority',
   y: High,
   color: '#ffd966'
 }, {
   name: 'Medium Priority',
   y: Medium
 }, {
     name: 'Low Priority',
     y: Low,
     color:'#75b4ef'
 }]
}]
});

//상위업무별 이슈 발생건 출력
//배열로 넘어오기 때문에 배열을 지정해줍니다.
let rootTaskIssueNameArray = []
let rootTaskIssueCountArray = []

//반복문을 돌며 선언한 배열에 저장합니다.
<c:forEach items="${rootTaskIssue }" var="rootTaskIssue">
	rootTaskIssueNameArray.push(['${rootTaskIssue.workName}']);
	rootTaskIssueCountArray.push([parseInt('${rootTaskIssue.issueCount}')]);
</c:forEach>

/// Bar Chart
const barChart = Highcharts.chart('issueCount', {
	  title: {
	    text: ''
	  },
	  subtitle: {
	    text: ''
	  },
	  xAxis: {
	    categories: rootTaskIssueNameArray
	   
	  },
	  yAxis:{
			title:{
				text : ''
			}  
	  },
	  series: [{
	    type: 'column',
	    colorByPoint: true,
	    data: rootTaskIssueCountArray,
	    showInLegend: false,
	    name : "issueCount"
	  }]
	});
	
//버튼클릭시 형태를 변경합니다.
$('#plain').on('click', function(){

	barChart.update({
		chart: {
			inverted : false,
			polar : false,
		}
	});
});

//버튼클릭시 형태를 변경합니다.
$('#inverted').on('click', function(){

	barChart.update({
		chart: {
			inverted : true,
			polar : false,
		}
	});
});

//버튼클릭시 형태를 변경합니다.
$('#polar').on('click', function(){

	barChart.update({
		chart: {
			inverted : false,
			polar : true,
		}
	});
});
</script>