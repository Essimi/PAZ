<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/commonjs/custom/jquery.form.min.js"></script>
    
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/commonjs/custom/paging.js">
</script>

<script>
/* 개선사항 리스트 비동기 페이징 */
let listBody= $("#listBody");

let pagingArea = $("#pagingArea");

let searchForm = $("#searchForm").paging()

	.ajaxForm({
		url : '${cPath}/admin/adminMain.do',								// 경로 설정
		dataType : 'json',                                      // 타입 json
		success : function(resp){                               //콜백 함수 
			listBody.empty();                                   //실행하면 기존의파일 비워줌
			pagingArea.empty();                                 //실행하면 기존의파일 비워줌
	//			searchForm.find("[name='page']").val("");       //
			let reviewList = resp.dataList;                     //요청의 데이터리스트 가져옴
			let pagingHTML = resp.pagingHTML;                   //요청의 페이징HTML 가져옴
			let trTags=[];                                      //배열 tr태그 만듦
			if(reviewList){                                     //
				$.each(reviewList,function(idx,review){         //반복문 리뷰리스트를
					let trTag = $("<tr>").append(               //추가한다 TR을 
						$("<td>").text(review.feedback)	        //값을 넣는다 TEXT에 피드백 값을
					)                     //???
					 trTags.push(trTag);                        //배열 TR에다가 값을 넣는다.
				});                                             //
			}else{                                              //
				let trTag = $("<tr>").html(                     //값이 없으면 아래와 같은 창 띄움
								$("<td>").text("조건에 맞는 리뷰 없음.")			
				                                                //
				);                                              //
				trTags.push(trTag);                             //
			}                                                   //
			                                                    //
			listBody.append(trTags);                            // listBody에 추가한다. 배열 TR을
			pagingArea.html(pagingHTML);                        // pagingArea안에 pagingHTML실행
		},                                                      //
		error:function(xhr, jQuery, error){                     //
			console.log(jQuery);                                //
			console.log(error);                                 //
		}                                                       //
	}).submit();                                                //으로 위에 지목한 URL로 이동

</script>



<script>

<!-- 결제 환불 그래프 스크립트 -->        
let array= []
<c:forEach items="${payDataList }" var="AdminDashboard">
	array.push([
		'${AdminDashboard.monthDate}월',${AdminDashboard.amountSum}
	]);
</c:forEach>

Highcharts.chart('payRfund', {
	title: {
	    text: '매출'
	  },
	  chart: {
	    type: 'column'
	  },
	  xAxis: {
	    type: 'category',
	    labels: {
	      rotation: -45,
	      style: {
	        fontSize: '13px',
	        fontFamily: 'Verdana, sans-serif'
	      }
	    }
	  },
	  yAxis: {
	    min: 0,
	    title: {
	      text: '금액'
	    }
	  },
	  legend: {
	    enabled: false
	  },
	  tooltip: {
	    pointFormat: '이번달 수익: <b>{point.y:f} 원</b>'
	  },
	  series: [{
	    name: 'Population',
	    data: array,
	    dataLabels: {
	      enabled: true,
	      rotation: -90,
	      color: '#FFFFFF',
	      align: 'right',
	      format: '{point.y:f}', // one decimal
	      y: 10, // 10 pixels down from the top
	      style: {
	        fontSize: '13px',
	        fontFamily: 'Verdana, sans-serif'
	      }
	    }
	  }]
	});


<!--  남녀 비율 그래프  -->
Highcharts.chart('jender', {
	  chart: {
	    plotBackgroundColor: null,
	    plotBorderWidth: 0,
	    plotShadow: false
	  },
	  title: {
	    text: '성별 비율',
	    align: 'center',
	    verticalAlign: 'middle',
	    y: 60
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
	      dataLabels: {
	        enabled: true,
	        distance: -50,
	        style: {
	          fontWeight: 'bold',
	          color: 'white'
	        }
	      },
	      startAngle: -90,
	      endAngle: 90,
	      center: ['50%', '75%'],
	      size: '110%'
	    }
	  },
	  series: [{
	    type: 'pie',
	    name: '비율',
	    innerSize: '50%',
	    data: [
	      ['남', ${genderDataList[0].countGender}],
	      ['여', ${genderDataList[1].countGender}]
	  
	    ]
	  }]
	});
	

<!-- 프로젝트 분야 -->
let memClassificationList=[]
let rand = null;


<c:forEach items="${classification }" var="memClassification">


// rand = Math.floor(Math.random() * 1000)+3000;



memClassificationList.push({
	name : '${memClassification.memCompanylist }',
	value : ${memClassification.memCompanycount},
// 	color: '#EC' + rand
});
</c:forEach>


Highcharts.chart('memderClassification', {
	  series: [{
	    type: "treemap",
	    layoutAlgorithm: 'stripes',
	    alternateStartingDirection: true,
	    levels: [{
	      level: 1,
	      layoutAlgorithm: 'sliceAndDice',
	      dataLabels: {
	        enabled: true,
	        align: 'left',
	        verticalAlign: 'top',
	        style: {
	          fontSize: '15px',
	          fontWeight: 'bold'
	        }
	      }
	    }],
	    
	    data : [ {
	        name: '${classification[0].memCompanylist}',
	        value: ${classification[0].memCompanycount},
	        color: '#6799FF'
	      }, {
	        name: '${classification[1].memCompanylist}', 
	        value: ${classification[1].memCompanycount}, 
	        color: '#A566FF'
	      }, {
	        name: '${classification[2].memCompanylist}', 
	        value: ${classification[2].memCompanycount}, 
	        color: '#86E57F'
	      }, {
	        name: '${classification[3].memCompanylist}', 
	        value: ${classification[3].memCompanycount}, 
	        color: '#F15F5F'
	      }, {
	        name: '${classification[4].memCompanylist}', 
	        value: ${classification[4].memCompanycount}, 
	        color: '#FAED7D'
	              }]
	    
	  }],
	  title: {
	    text: '소속별'
	  }
	});
	
<!-- 로그인 로그아웃 시간별 대시보드 -->
let loginMapList=[]
<c:forEach items="${loginMap.loginInfo }" var="loginInfo">
	loginMapList.push([
			${loginInfo.loginCount}
		]);
	
</c:forEach>

let logoutMapList=[]
<c:forEach items="${loginMap.logoutInfo }" var="logoutInfo">
	logoutMapList.push([
			${logoutInfo.logoutCount}
		]);
	
</c:forEach>


Highcharts.chart('loginLogoutTime', {

	  title: {
	    text: '로그인-로그아웃 기반 시간별 활동 그래프'
	  },

	  yAxis: {
	    title: {
	      text: '접속 횟수'
	    }
	  },

	  xAxis: {
	    accessibility: {
	      rangeDescription: '시간'
	    }
	  },

	  legend: {
	    layout: 'vertical',
	    align: 'right',
	    verticalAlign: 'middle'
	  },

	  plotOptions: {
	    series: {
	      label: {
	        connectorAllowed: false
	      },
	      pointStart: 0
	    }
	  },

	  series: [{
	    name: '로그인 횟수',
	    data: loginMapList
	  }, {
	    name: '로그아웃 횟수',
	    data: logoutMapList
	  }],

	  responsive: {
	    rules: [{
	      condition: {
	        maxWidth: 500
	      },
	      chartOptions: {
	        legend: {
	          layout: 'horizontal',
	          align: 'center',
	          verticalAlign: 'bottom'
	        }
	      }
	    }]
	  }

	});
	
	
<!-- 연령대 대시보드 -->
let membarAgeList=[]
<c:forEach items="${ageDataList }" var="AgeDashboard">
	membarAgeList.push([
			'${AgeDashboard.memAge}대'
		]);
	
</c:forEach>
/* 연령별 수 반복문 */
let memberAgecountList=[]
<c:forEach items="${ageDataList }" var="AgeDashboard">
	memberAgecountList.push([
			${AgeDashboard.ageCount}
		]);
	
</c:forEach>

/* 연령대 그래프 */
const chart = Highcharts.chart("ageList", {
	
  title: {
    text: "연령"
  },
  xAxis: {
    categories: membarAgeList
  },
  series: [
    {
      type: "column",
      colorByPoint: true,
      data:memberAgecountList,
      showInLegend: false
    }
  ]
});	



<!-- 분야별 프로젝트 생성 수 -->
/* 프로젝트 분야별 이름 반복문 */
let projectDashboardNameList=[]
<c:forEach items="${projectClassDataList }" var="ProjectDashboard">
	projectDashboardNameList.push([
		'${ProjectDashboard.partName}'
		]);
	
</c:forEach>
/* 프로젝트 분야별 수 반복문 */
let projectDashboardCountList=[]
<c:forEach items="${projectClassDataList }" var="ProjectDashboard">
	projectDashboardCountList.push([
		${ProjectDashboard.partCount}
		]);
	
</c:forEach>

/* 프로젝트 분야 그래프 */
const chartProject = Highcharts.chart("projectClass", {
  title: {
    text: "프로젝트 "
  },
  xAxis: {
	    categories: projectDashboardNameList
	  },
  series: [{
	    type: 'column',
	    colorByPoint: true,
	    data: projectDashboardCountList,
	    showInLegend: false
	  }]
	});
	
	
	
<!-- 프로젝트 기능평점 그래프 -->
/* 프로젝트 수 반복문 */
	let projectFunctionList=[]
	<c:forEach items="${dataListVO }" var="FunctionDashboard">
		projectFunctionList.push([
				${FunctionDashboard.gradeAvg}
			]);
		
	</c:forEach>
	
	/* 프로젝트 기능별 그래프 */
	Highcharts.chart('projectFunction', {

		  chart: {
		    polar: true,
		    type: 'line'
		  },

		  

		  title: {
		    text: '기능별 평점',
		    x: -80
		  },

		  pane: {
		    size: '80%'
		  },

		  xAxis: {
		    categories: ['코드', '업무', '간트차트', '칸반','채팅','깃허브'],
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
		    pointFormat: '<span style="color:{series.color}">{series.name}: <b>{point.y:,.0f}점</b><br/>'
		  },

		  legend: {
		    align: 'right',
		    verticalAlign: 'middle',
		    layout: 'vertical'
		  },

		  series: [{
		    name: '기능별 평점',
		    data: projectFunctionList,
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
	
	
<!--특정단어 입력 통계  -->
// [{
//     name: '간트차트',
//     data: [{
//       name: "간트차트",
//       value: 8
//     }]
//   }

let stackList = []

<c:forEach items="${wordStack }" var="wordStackSelect">
stackList.push({
	name : '${wordStackSelect.feedback }',
	data : [{
		name : '${wordStackSelect.feedback }',
		value : ${wordStackSelect.feedbackList}		
	}]

});
</c:forEach>

Highcharts.chart('wordStackTo', {
	  chart: {
	    type: 'packedbubble',
	    height: '80%'
	  },
	  title: {
	    text: '누적 단어통계'
	  },
	  tooltip: {
	    useHTML: true,
	    pointFormat: '<b>{point.name}:</b> {point.value} 누적됨</sub>'
	  },
	  plotOptions: {
	    packedbubble: {
	      minSize: '30%',
	      maxSize: '120%',
	      zMin: 0,
	      zMax: 5,
	      layoutAlgorithm: {
	        splitSeries: false,
	        gravitationalConstant: 0.02
	      },
	      dataLabels: {
	        enabled: true,
	        format: '{point.name}',
	        filter: {
	          property: 'y',
	          operator: '>',
	          value: 0
	        },
	        style: {
	          color: 'black',
	          textOutline: 'none',
	          fontWeight: 'normal'
	        }
	      }
	    }
	  },
	    series: stackList
	  
	});

</script>    
