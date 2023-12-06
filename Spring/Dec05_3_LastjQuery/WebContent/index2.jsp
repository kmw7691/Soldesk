<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index2.jsp</title>
<script type="text/javascript" src="jQuery.js"></script>
<script type="text/javascript">
	//alert('check');
	//https://dapi.kakao.com/v2/search/image
	//Authorization: KakaoAK ${REST_API_KEY}
	$(()=>{
		$('button').click(()=>{
			let iVal = $('input').val();
			//alert(iVal);
			
			$.ajax({
				url:'https://dapi.kakao.com/v2/search/image',
				data:{query : iVal},
				beforeSend:function(req){
					req.setRequestHeader(
						'Authorization', 'KakaoAK 67b21c8f256d346fd25aebcfb3725693'
					);
				},
				success:function(imgJSON){
					//alert(JSON.stringify(imgJSON));
					$('table').empty();
					
					$.each(imgJSON.documents, function(i, m){
						//alert(m.collection);
						
						let img = $('<img>').attr('src', m.thumbnail_url);
						let td1 = $('<td align="center"></td>').append(img);
						let td2 = $('<td align="center"></td>').text(m.display_sitename);
						let td3 = $('<td align="center"></td>').text(m.collection);
						
						let trr = $('<tr></tr>').append(td1, td2, td3);
						$('table').append(trr);
					});
					
					let th1 = $('<th></th>').text('미리보기 이미지');
					let th2 = $('<th></th>').text('출처');
					let th3 = $('<th></th>').text('컬렉션');
					
					let trr = $('<tr></tr>').append(th1, th2, th3);
					$('table').prepend(trr);
				}	
			})
		})
		$('input').keyup(()=>{
			$('button').trigger('click');
		});
	});
	
</script>
</head>
<body>
	<!-- 
		미리보기 이미지   thumbnail_url
		출처	display_sitename
		컬렉션   collection
	 -->
	 
	 <input>
	<button>검색</button>
	<hr>
	<table border="1"></table>
</body>
</html>