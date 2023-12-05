<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<script src="https://cdn.canvasjs.com/canvasjs.min.js"></script>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript">
	$(()=>{
		//alert('check')
		
		//AJAX hour / temp / wfKor 정보 테이블에 ㅜㄱ
		//http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1135063000
		$.ajax({
			url:'http://localhost/dec052/k.weather.get',
			success:function(we){
				let td1 = $('<th></th>').text('hour');
				let td2 = $('<th></th>').text('temp');
				let td3 = $('<th></th>').text('wfKor');
				let trr = $('<tr></tr>').append(td1, td2, td3);
				$('table').prepend(trr);
				
				let ar = [];
				
				$(we).find('data').each(function(i,w){
					let hour = $(w).find('hour').text();
					let temp = $(w).find('temp').text();
					let wfKor = $(w).find('wfKor').text();
					
					let hTd = $('<td align="center"></td>').text(hour);
					let tTd = $('<td align="center"></td>').text(temp);
					let wTd = $('<td align="center"></td>').text(wfKor);
					
					let tr = $('<tr></tr>').append(hTd, tTd, wTd);
					
					$('table').append(tr);
					
					ar[i] = 
					{
						label:hour,
						y:temp * 1, //js에서 숫자형으로 바꿀때
					};
				});
				
				var chart = new CanvasJS.Chart("chartContainer", {
					animationEnabled: true,
					exportEnabled: true,
					theme: "dark2",// "light1", "light2", "dark1", "dark2"
					title:{
						text: "날씨"              
					},
					data: [              
					{
						// Change type to "doughnut", "line", "splineArea", etc.
						type: "column",
						dataPoints: ar
					}
					]
				});
				chart.render();
			}
		});
	});
</script>
</head>
<body>
	<div id="chartContainer" 
		style="height: 300px; width: 100%;"></div>
	
	<hr>
	
	<table border="1">
		
	</table>
</body>
</html>