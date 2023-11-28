//01_Variable.js

//JavaScript
//		인터프리터언어 -> 오류 안잡음. 오타주의

//alert("연결완");

//1.변수
//		데이터를 담는그릇

//변수에 접근하는 방법(우리가 확인하는거 - ex) syso)
//	1)alert() 		: 경고창을 띄워주는 함수
alert("구에에에ㅔㄱ");
//	2)console.log() : log를 띄워주는 함수
console.log("check");

////////////////////////////

//name = "kwak";
//age = 100;	//전역변수의 형태라 위험함

//이걸 방지하기위해 변수 선언하는 형태 3가지
//		var let const
//		자바는 : 자료형 변수명
//		JS는	 : 변수형태 변수명

//var : var(iable) >> 중복선언가능 + 초기화
var a = 10;	//a라는 변수 선언하면서 초기화
console.log(a);
var a = 20; //a라는 변수 선언하면서 초기화
console.log(a);
var a;		//변수선언 : 마지막에 해당변수에 할당한 값이 변수에 저장
console.log(a);
//기존에 선언해둔 변수를 까먹고 다시 값을 할당하는 실수가 있을수 있어서 사용 잘 안함

//let : Java변수만들 때와 비슷한 느낌(변수명 중복x)
let name = "kwak";
console.log(name);
//let name = "minwoo"; //이미 name이 kwak으로 선언되어서 에러발생
name = "minwoo"; //let빼고 쓰면 값 변경 가능

//const : 값이 절대로 바뀌지않는 상수
//			수정불가능, 수정하려고하면 에러발생
//			const변수명은 대문자로 사용하는 문화
const PI = 3.141592;
console.log(PI);
//PI = 6.135413144; //error
//console.log(PI);

//정리
//		JS에서 변수 선언할때
//			변할수 있는 값은 var, let
//			변하지 않는 값은 const

//JS 변수명 짓는 조건(Java와 동일)
//	1.변수는 문자, 숫자, $, _ 만 가능
//  2.첫글자로 숫자/대문자 사용 x
//	3.예약어 사용 x
//	4.변수명은 읽기 쉽고 이해하기 좋게
//	5.const변수 만들땐 전부 대문자로




























