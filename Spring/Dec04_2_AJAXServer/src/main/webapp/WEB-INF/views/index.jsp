<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>idnex.jsp</title>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript">
	$(()=>{
		//alert('check');
		
		/*
		$.ajax({
			url:'error.getJSON',
			success:function(asd){
				//alert(asd);
				//JavaScript객체 -> 문자열 그대로 변환 가능
				alert(JSON.stringify(asd));
			}
		});
		*/
		
		//JSON으로 AJAX하기 간단한 ver
		//$.getJSON('요청주소?파라미터=값&...', 값을 받아오는데 성공하면 발동하는 함수)
		$.getJSON('error.getJSON', function(eee){
			//alert(JSON.stringify(eee));
			
			//jQuery반복문 사용 - 테이블만들기
			$.each(eee.error, function(i, e){
				let td1 = $('<td></td>').text(e.e_what);
				let td2 = $('<td></td>').text(e.e_where);
				
				let tr = $('<tr></tr>').append(td1, td2);
				$('table').append(tr);
			})
		});
		
		//버튼을 클릭 -> input에 있는 e_what에대한 내용이 error테이블에 있었으면
		$('button').click(function(){
			let erVal = $('input').val();
			$.getJSON('error.searchJSON?e_what=' + erVal,(err) => {
					$('table').empty();
				
					$.each(err.error,function(i,e){
						let td1 = $('<td></td>').text(e.e_what);						
						let td2 = $('<td></td>').text(e.e_where);						
						
						let tr = $('<tr></tr>').append(td1, td2);
						
						$('table').append(tr);
					})
				});
			});
			$('input').keyup(()=>{
				$('button').trigger('click');
			});
	});
</script>
</head>
<body>
	<input>
	<button>검색</button>
	<hr>
	<table border="1"></table>
	<hr>
	<c:forEach var="e" items="${errors }">
		${e.e_what } - ${e.e_where }<p>
	</c:forEach>
</body>
</html>