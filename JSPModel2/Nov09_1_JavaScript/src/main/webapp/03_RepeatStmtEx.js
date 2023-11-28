//03_RepeatStmtEx.js
//alert('check')

//document.write()
//		ㄴ웹페이지가 로딩될때 생성되면 웹페이지에 가장먼저 출력
//		ㄴ보통 테스트용도 or 디버깅용도
//		ㄴ중간에 document.write()가 실행되면
//		ㄴ웹페이지 안에 먼저 로딩된 모든 데이터를 지우고 본인의 데이터를 출력

function test(){
	document.write("<table border='1'>");
	document.write("<tr>");
	document.write("<td>테이블을 이렇게</td>");
	document.write("</tr>");
	document.write("<tr>");
	document.write("<td>document.write()는</td>");
	document.write("</tr>");
	document.write("<tr>");
	document.write("<td>테스트용도</td>");
	document.write("</tr>");
	document.write("</table>");
}

function makeTable(){
	let row = prompt('행 개수 입력')
	let col = prompt('열 개수 입력')
	
	alert(row + " x " + col + "의 table을 생성")
	
	let count = 1;
	document.write("<table border='1'>");
	for(let i=0;i<row;i++){
		document.write("<tr>")
		for(let j=0;j<col;j++){
			document.write("<td align='center'>")
			document.write(count)
			document.write("</td>")
			count++;
		}
		document.write("</tr>")
	}
	document.write("</table>")
}