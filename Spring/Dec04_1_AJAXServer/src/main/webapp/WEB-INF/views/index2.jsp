<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index2.jsp</title>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript">
	$(()=>{
		//alert('check');
		
		//AJAX(Asynchronous JavaScript And Xml)
		//	JavaScript를 통해서 서버에 데이터를 요청하는 방법(비동기식)
		
		//id가 btn인거 클릭하면 alert('버튼누름');
		$('#btn').click(function(){
			//alert('버튼누름');
			$.ajax({//함수x 객체x
				url:'fruit.getXML', //url속성 :  xml을만든 cxontrller의 밸류값
				success: function(asd){ //url 요청 성공하면 진행
					//alert(asd); //objectXMLDocument
					
					//asd : xml파일 자체
					//xml에 fruit라는 DOM객체 하나 부를때마다 나오는 콜백함수
					$(asd).find('fruit').each(function(i,f){
						//alert(i+1 + ')' + f);
						let f_name = $(f).find('f_name').text();
						let f_price = $(f).find('f_price').text();
						let f_location = $(f).find('f_location').text();
						
						alert(f_location + ')' + f_name + ' - ' + f_price);
					});
				}
			});
		});
		
		//fruit.getXML에 요청해서
		//나오는 모든 데이터를 가지고
		//테이블을 구성
		
		$.ajax({
			url: 'fruit.getXML',
			success: function(aaa){
				//alert('aaa');
				
				let th1 = $('<th></th>').text('과일이름');
				let th2 = $('<th></th>').text('과일가격');
				let th3 = $('<th></th>').text('원산지');
				let trr = $('<tr></tr>').append(th1, th2, th3);
				$('#fruitTbl').prepend(trr);
				
				$(aaa).find('fruit').each(function(i,f){
					let f_name = $(f).find('f_name').text();
					let f_price = $(f).find('f_price').text();
					let f_location = $(f).find('f_location').text();
					
					let nameTd = $('<td align="center"></td>').text(f_name);
					let priceTd = $('<td align="center"></td>').text(f_price);
					let locTd = $('<td align="center"></td>').text(f_location);
					
					let tr = $('<tr></tr>').append(nameTd, priceTd, locTd);
					
					$('#fruitTbl').append(tr);
				});
			}
		});
		
		//input에 숫자입력 -> 버튼누르면
		//입력한 숫자 이하의 가격인 과일들 이름 가격 원산지데이터로
		//fruitTbl구성
		//http://localhost/dec041/fruit.searchXML?f_price=3000
		$('#searchBtn').click(function(){
			let frVal = $('#fruitInput').val();
			$.ajax({
				//fruit.searchXML?f_price + frVal
				url: 'fruit.searchXML',
				data:{f_price : frVal},//?뒤의 변수명=값부분 따로 떼서
				success:function(qwe){
					$('#fruitTbl').empty();
				
					let th1 = $('<th></th>').text('과일이름');
					let th2 = $('<th></th>').text('과일가격');
					let th3 = $('<th></th>').text('원산지');
					let trr = $('<tr></tr>').append(th1, th2, th3);
					$('#fruitTbl').prepend(trr);
					
					$(qwe).find('fruit').each(function(i,f){
						let f_name = $(f).find('f_name').text();
						let f_price = $(f).find('f_price').text();
						let f_location = $(f).find('f_location').text();
						
						let nameTd = $('<td align="center"></td>').text(f_name);
						let priceTd = $('<td align="center"></td>').text(f_price);
						let locTd = $('<td align="center"></td>').text(f_location);
						
						let tr = $('<tr></tr>').append(nameTd, priceTd, locTd);
						
						$('#fruitTbl').append(tr);
					});
				}
			});
		});
		
		$('#fruitInput').keyup(function(e){
			if(e.keyCode==13){ //enter
				$('#searchBtn').trigger('click');
			}
		});
	});
</script>
</head>
<body>
	<h1>
		<a href="fruit.getXML">Fruit XML 보러가기~</a>
	</h1>
	<button id="btn">버튼</button>
	<hr>
	<input id="fruitInput">
	<button id="searchBtn">검색</button>
	<table id="fruitTbl" border="1">

	</table>
</body>
</html>