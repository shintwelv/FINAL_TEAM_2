<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	$(document).ready(function(){
		dataRead();
	});
	
	var cpuChartObj;
	var sessionChartObj;
	var physicalMemoryObj;
	var memoryUsageObj;
	var hddObj;
	var hddUsageObj	
	
	var dataCheckTimeData = new Map();
	
	var cpuChartData = new Map();
	
	var sessionChartData = new Map();
	
	var physicalMemoryTotalData = new Map();
	var physicalmemoryFreeSizeData = new Map();
	
	var memoryUsageData = new Map();
	
	var hddTotalData = new Map();
	var hddUsageData = new Map();
	var hddIdleData = new Map();
	
	var memoryUsagePercentData;
	var memoryIdelPercentData;
	
	var hddUsagePercentData;
	var hddIdlePercentData;
	
	setInterval(function() {
		dataRead();
	}, 30000);
	
	function dataRead() {
		$.ajax({
			type : "POST",
			url : "cpuChartData.do",
            beforeSend : function(xhr)
            {   
                xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
            },
			success : function(data) {
				memoryUsagePercentData = data[0].memoryUsagePercent; 
				memoryIdelPercentData = data[0].memoryIdelPercent;
				hddUsagePercentData = data[0].hddUsagePercent;
				hddIdlePercentData = data[0].hddIdlePercent;
				
				if(data.length < 10) {
					for(var i=0; i<data.length-1; i++) {
						dataCheckTimeData.set("dataCheckTime["+i+"]", data[i].dataCheckTime);
						
						cpuChartData.set("cpuUsage["+i+"]", data[i].cpuUsage);
						
						sessionChartData.set("sessionCount["+i+"]", data[i].sessionCount);
						
						physicalMemoryTotalData.set("memoryTotalSize["+i+"]", data[i].memoryTotalSize);
						physicalmemoryFreeSizeData.set("memoryFreeSize["+i+"]", data[i].memoryFreeSize);
						
						hddTotalData.set("hddTotal["+i+"]", data[i].hddTotal);
						hddUsageData.set("hddUsage["+i+"]", data[i].hddUsage);
						hddIdleData.set("hddIdle["+i+"]", data[i].hddIdle);
					}
					for(var i=data.length; i<10; i++) {
						dataCheckTimeData.set("dataCheckTime["+i+"]", "undefined");
						cpuChartData.set("cpuUsage["+i+"]", "undefined");
						sessionChartData.set("sessionCount["+i+"]", "undefined");
						
						physicalMemoryTotalData.set("memoryTotalSize["+i+"]", "undefined");
						physicalmemoryFreeSizeData.set("memoryFreeSize["+i+"]", "undefined");
						hddTotalData.set("hddTotal["+i+"]", "undefined");
						hddUsageData.set("hddUsage["+i+"]", "undefined");
						hddIdleData.set("hddIdle["+i+"]", "undefined");
					}
				}
				if(data.length >= 10)
					for(var i=0; i<10; i++) {
						dataCheckTimeData.set("dataCheckTime["+i+"]", data[i].dataCheckTime);
						cpuChartData.set("cpuUsage["+i+"]", data[i].cpuUsage);
						sessionChartData.set("sessionCount["+i+"]", data[i].sessionCount);
						
						physicalMemoryTotalData.set("memoryTotalSize["+i+"]", data[i].memoryTotalSize);
						physicalmemoryFreeSizeData.set("memoryFreeSize["+i+"]", data[i].memoryFreeSize);
						hddTotalData.set("hddTotal["+i+"]", data[i].hddTotal);
						hddUsageData.set("hddUsage["+i+"]", data[i].hddUsage);
						hddIdleData.set("hddIdle["+i+"]", data[i].hddIdle);
					}
				chartDraw(data, data.length-1);
			},
			error : function() {
				alert("Error !!");
			}
		})
	};
	
	function chartDraw(ServerInfo, length) {
		if(cpuChartObj != null) {
			cpuChartObj.destroy();
		}
		if(sessionChartObj != null) {
			sessionChartObj.destroy();
		}
		if(physicalMemoryObj != null) {
			physicalMemoryObj.destroy();
		}
		if(memoryUsageObj != null ) {
			memoryUsageObj.destroy();
		}
		if(hddObj != null) {
			hddObj.destroy();
		}
		if( hddUsageObj != null) {
			hddUsageObj.destroy();
		}
		
		// CPU Chart
		cpuChartObj = new Chart(document.getElementById("cpuChart").getContext("2d"), {
		    type: 'line',
		    data: {
		    labels: [ dataCheckTimeData.get("dataCheckTime[0]"), dataCheckTimeData.get("dataCheckTime[1]"), dataCheckTimeData.get("dataCheckTime[2]"), dataCheckTimeData.get("dataCheckTime[3]"), dataCheckTimeData.get("dataCheckTime[4]"), dataCheckTimeData.get("dataCheckTime[5]"), dataCheckTimeData.get("dataCheckTime[6]"), dataCheckTimeData.get("dataCheckTime[7]"), dataCheckTimeData.get("dataCheckTime[8]"), dataCheckTimeData.get("dataCheckTime[9]") ],
		      datasets: [
		        {
		          type : 'line',
	        	  fill : false,         // 채우기 없음
                  lineTension : 0.2,  // 0이면 꺾은선 그래프, 숫자가 높을수록 둥글해짐
		          backgroundColor: "rgb(255, 255, 255)",
		          borderColor: 'rgb(255, 153, 0)',
		          data: [ cpuChartData.get("cpuUsage[0]"), cpuChartData.get("cpuUsage[1]"), cpuChartData.get("cpuUsage[2]"), cpuChartData.get("cpuUsage[3]"), cpuChartData.get("cpuUsage[4]"), cpuChartData.get("cpuUsage[5]"), cpuChartData.get("cpuUsage[6]"), cpuChartData.get("cpuUsage[7]"), cpuChartData.get("cpuUsage[8]"), cpuChartData.get("cpuUsage[9]") ]
		        }
		      ]
		    },
		    options: {
		      responsive: false,
		      title: {
			        display: true,
			        text: 'CPU Usage'
			      },
		      legend: {
		    	  display: false,
                  labels: {
                       fontColor: 'black' // label color
                      }
                   },
             	  scales: {
                 		// y축
                  yAxes: [{
                      stacked: true,
                      ticks: {
                          steps: 10,
                          stepValue: 5,
                          max: 100,
                          fontColor:'black' // y축 폰트 color
                      }
                  }],
                  // x축
                  xAxes: [{
                      stacked: true,
                     ticks: {
                         fontColor:'black' // x축 폰트 color
                     }
                  }]
               }
		    }
		});
		
		// Session Chart
		sessionChartObj = new Chart(document.getElementById("sessionChart").getContext("2d"), {
		    type: 'line',
		    data: {
		    	labels: [ dataCheckTimeData.get("dataCheckTime[0]"), dataCheckTimeData.get("dataCheckTime[1]"), dataCheckTimeData.get("dataCheckTime[2]"), dataCheckTimeData.get("dataCheckTime[3]"), dataCheckTimeData.get("dataCheckTime[4]"), dataCheckTimeData.get("dataCheckTime[5]"), dataCheckTimeData.get("dataCheckTime[6]"), dataCheckTimeData.get("dataCheckTime[7]"), dataCheckTimeData.get("dataCheckTime[8]"), dataCheckTimeData.get("dataCheckTime[9]") ],
		      datasets: [
		        {
		          type : 'line',
	        	  fill : false,
                  lineTension : 0.2,
		          backgroundColor: "rgb(255, 255, 255)",
		          borderColor: 'rgb(200, 118, 30)',
		        data: [ sessionChartData.get("sessionCount[0]"), sessionChartData.get("sessionCount[1]"), sessionChartData.get("sessionCount[2]"), sessionChartData.get("sessionCount[3]"), sessionChartData.get("sessionCount[4]"), sessionChartData.get("sessionCount[5]"), sessionChartData.get("sessionCount[6]"), sessionChartData.get("sessionCount[7]"), sessionChartData.get("sessionCount[8]"), sessionChartData.get("sessionCount[9]")]
		        }
		      ]
		    },
		    options: {
		      responsive: false,
		      title: {
			        display: true,
			        text: 'Session Count'
			      },
		      legend: {
		    	  display: false,
                  labels: {
                       fontColor: 'black' // label color
                      }
                   },
             	  scales: {
                  yAxes: [{
                      stacked: true,
                      ticks: {
                    	  stepSize: 1,
                          fontColor:'black' // y축 폰트 color
                      }
                  }],
                  xAxes: [{
                      stacked: true,
                     ticks: {
                         fontColor:'black' // x축 폰트 color
                     }
                  }]
               }
		    }
		});	
		
		physicalMemoryObj = new Chart(document.getElementById("physicalMemoryChart").getContext("2d"), {
		    type: 'bar',
		    data: {
		    	labels: [ dataCheckTimeData.get("dataCheckTime[0]"), dataCheckTimeData.get("dataCheckTime[1]"), dataCheckTimeData.get("dataCheckTime[2]"), dataCheckTimeData.get("dataCheckTime[3]"), dataCheckTimeData.get("dataCheckTime[4]"), dataCheckTimeData.get("dataCheckTime[5]"), dataCheckTimeData.get("dataCheckTime[6]"), dataCheckTimeData.get("dataCheckTime[7]"), dataCheckTimeData.get("dataCheckTime[8]"), dataCheckTimeData.get("dataCheckTime[9]") ],
		      	datasets: [
		        {
		        	label: 'Memory Total',
		          	backgroundColor: "#3e95cd",
		        	data: [ physicalMemoryTotalData.get("memoryTotalSize[0]"), physicalMemoryTotalData.get("memoryTotalSize[1]"), physicalMemoryTotalData.get("memoryTotalSize[2]"), physicalMemoryTotalData.get("memoryTotalSize[3]"), physicalMemoryTotalData.get("memoryTotalSize[4]"), physicalMemoryTotalData.get("memoryTotalSize[5]"), physicalMemoryTotalData.get("memoryTotalSize[6]"), physicalMemoryTotalData.get("memoryTotalSize[7]"), physicalMemoryTotalData.get("memoryTotalSize[8]"), physicalMemoryTotalData.get("memoryTotalSize[9]")]
		         
		        },
		        {
		        	label: 'Memory Free',
		        	backgroundColor: "#f5a55f",
		        	data: [ physicalmemoryFreeSizeData.get("memoryFreeSize[0]"), physicalmemoryFreeSizeData.get("memoryFreeSize[1]"), physicalmemoryFreeSizeData.get("memoryFreeSize[2]"), physicalmemoryFreeSizeData.get("memoryFreeSize[3]"), physicalmemoryFreeSizeData.get("memoryFreeSize[4]"), physicalmemoryFreeSizeData.get("memoryFreeSize[5]"), physicalmemoryFreeSizeData.get("memoryFreeSize[6]"), physicalmemoryFreeSizeData.get("memoryFreeSize[7]"), physicalmemoryFreeSizeData.get("memoryFreeSize[8]"), physicalmemoryFreeSizeData.get("memoryFreeSize[9]")]
			    }
		      ]
		    },
		    options: {
		    	responsive: false,
		    	scales: {
					yAxes: [{
						ticks: {
							beginAtZero: true
						}
					}]
				},
		      title: {
		        display: true,
		        text: 'PhysicalMemory Info'
		      }
		    }
		});
		
		
		memoryUsageObj = new Chart(document.getElementById("memoryUsagePercentChart").getContext("2d"), {
		    type: 'pie',
		    data: {
		    	labels: ["Memory Usage Percent", "Memory Idel Percent" ],
		      	datasets: [
		        {
		        	label: 'Memory Using Percent',
		          	backgroundColor: ["#3e95cd", "#f5a55f"],
		        	data: [memoryUsagePercentData, memoryIdelPercentData]	
		         
		        }
		      ]
		    },
		    options: {
		      responsive: false,
		      title: {
		        display: true,
		        text: 'MemoryUsing Info'
		      }
		      
		    }
		});
		

		hddObj = new Chart(document.getElementById("hddChart").getContext("2d"), {
		    type: 'bar',
		    data: {
		    	labels: [ dataCheckTimeData.get("dataCheckTime[0]"), dataCheckTimeData.get("dataCheckTime[1]"), dataCheckTimeData.get("dataCheckTime[2]"), dataCheckTimeData.get("dataCheckTime[3]"), dataCheckTimeData.get("dataCheckTime[4]"), dataCheckTimeData.get("dataCheckTime[5]"), dataCheckTimeData.get("dataCheckTime[6]"), dataCheckTimeData.get("dataCheckTime[7]"), dataCheckTimeData.get("dataCheckTime[8]"), dataCheckTimeData.get("dataCheckTime[9]") ],
		      	datasets: [
		        {
		        	label: 'HDD Total',
		          	backgroundColor: "#3e95cd",
		        	data: [ hddTotalData.get("hddTotal[0]"), hddTotalData.get("hddTotal[1]"), hddTotalData.get("hddTotal[2]"), hddTotalData.get("hddTotal[3]"), hddTotalData.get("hddTotal[4]"), hddTotalData.get("hddTotal[5]"), hddTotalData.get("hddTotal[6]"), hddTotalData.get("hddTotal[7]"), hddTotalData.get("hddTotal[8]"), hddTotalData.get("hddTotal[9]") ]
		         
		        },
		        {
		        	label: 'HDD Usage',
		        	backgroundColor: "#f5a55f",
		        	data: [ hddUsageData.get("hddUsage[0]"), hddUsageData.get("hddUsage[1]"), hddUsageData.get("hddUsage[2]"), hddUsageData.get("hddUsage[3]"), hddUsageData.get("hddUsage[4]"), hddUsageData.get("hddUsage[5]"), hddUsageData.get("hddUsage[6]"), hddUsageData.get("hddUsage[7]"), hddUsageData.get("hddUsage[8]"), hddUsageData.get("hddUsage[9]") ]
			    },
		        {
		        	label: 'HDD Idle',
		        	backgroundColor: "#68c48e",
		        	data: [ hddIdleData.get("hddIdle[0]"), hddIdleData.get("hddIdle[1]"), hddIdleData.get("hddIdle[2]"), hddIdleData.get("hddIdle[3]"), hddIdleData.get("hddIdle[4]"), hddIdleData.get("hddIdle[5]"), hddIdleData.get("hddIdle[6]"), hddIdleData.get("hddIdle[7]"), hddIdleData.get("hddIdle[8]"), hddIdleData.get("hddIdle[9]"), ]
			    }
		      ]
		    },
		    options: {
		    	responsive: false,
		    	scales: {
					yAxes: [{
						ticks: {
							beginAtZero: true
						}
					}]
				},
		      title: {
		        display: true,
		        text: 'PhysicalHDD Info'
		      }
		    }
		});
		

		
		hddUsageObj = new Chart(document.getElementById("hddUsagePercentChart").getContext("2d"), {
		    type: 'pie',
		    data: {
		    	labels: ["HDD Usage Percent", "HDD Idle Percent" ],
		      	datasets: [
		        {
		        	label: 'HDDUsingPercent',
		          	backgroundColor: ["#3e95cd", "#f5a55f"],
		        	data: [hddUsagePercentData, hddIdlePercentData]
		         
		        },
		      ]
		    },
		    options: {
		      responsive: false,
		      title: {
		        display: true,
		        text: 'HDDUsing Info'
		      }
		      
		    }
		});
		
	}
</script>
<style>
	#Canvas{
		display: flex;
		text-align: center;
		justify-content:center;
	}
</style>
</head>
<body>
	<h3>CPU, Session INFO</h3>
	<hr>
	<a href="/admin/board.do"><button>게시판으로 돌아가기</button></a><br><br>
	<div id="Canvas">
		<canvas id="cpuChart" width="600" height="300"></canvas>&nbsp&nbsp
		<canvas id="sessionChart" width="600" height="300"></canvas>
	</div>
	
	<h3>Memory INFO</h3>
	<hr>		
	<div id="Canvas">
		<canvas id="physicalMemoryChart" width="1000" height="300"></canvas>&nbsp&nbsp
		<canvas id="memoryUsagePercentChart" width="600" height="300"></canvas>
	</div>

	<h3>HDD INFO</h3>
	<hr>		
	<div id="Canvas">
		<canvas id="hddChart" width="1000" height="300"></canvas>&nbsp&nbsp
		<canvas id="hddUsagePercentChart" width="600" height="300"></canvas>
	</div>
	
</body>
</html>


