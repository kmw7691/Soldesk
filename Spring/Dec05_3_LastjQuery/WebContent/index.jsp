<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<script type="text/javascript" src="jQuery.js"></script>
<script type="text/javascript">
	//alert('check')
	$(()=>{
		//	67b21c8f256d346fd25aebcfb3725693
		$('button').click(()=>{
			let iVal = $('input').val();
			//alert(iVal);
			
			//$.getJSON : 요청 헤더에 대한 기능이 없어서 사용불가
			//https://dapi.kakao.com/v3/search/book?query=값
			$.ajax({
				url:'https://dapi.kakao.com/v3/search/book',
				data:{query : iVal},
				beforeSend:function(req){ //요청보내기 전에 실행시킬 콜백함수(요청헤더처리부분)
					req.setRequestHeader(
							'Authorization', 'KakaoAK 67b21c8f256d346fd25aebcfb3725693'		
					);
				},
				success:function(bookJSON){
					//alert(JSON.stringify(bookJSON));
					//내가 검색한 검색어가 포함된 책들을
					//	이미지(사진), 책제목, 출판사, 정가, 판매가 뽑아서 테이블 구성
					$('table').empty();
					
					let td1 = $('<td></td>').text('title');
					let td2 = $('<td></td>').text('publisher');
					let td3 = $('<td></td>').text('price');
					let td4 = $('<td></td>').text('sale_price');
					
					let trr = $('<tr></tr>').append(td1, td2, td3, td4);
					$('table').prepend(trr);
					
					$(bookJSON).find('documents').each(function(i,b){
						let title = $(b).find('title').text();
						let publisher = $(b).find('publisher').text();
						let price = $(b).find('price').text();
						let sale_price = $(b).find('sale_price').text();
						
						let titleTd = $('<td align="center"></td>').text(title);
						let pubTd = $('<td align="center"></td>').text(publisher);
						let priceTd = $('<td align="center"></td>').text(price);
						let saleTd = $('<td align="center"></td>').text(sale_price);
						
						let tr = $('<tr></tr>').append(titleTd, pubTd, priceTd, saleTd);
						
						$('table').append(tr);
					});
				}
			});
		});
	});
</script>
</head>
<body>
	<input><button>검색</button>
	<hr>
	<table border="1"></table>
</body>
</html>