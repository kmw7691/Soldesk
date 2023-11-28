//04_Arrow_Functon.js
//alert('check')

//화살표함수(Arrow Function)
//		01_Function.js에서 다뤗던 함수 : [함수 선언문]
//		화살표함수 : 함수 표현식

///////////////////////////////////////////////////

//함수선언문
function sayHi(){
	console.log('kwak')
}

sayHi();

//함수 표현식
let say = function saHi(){
	console.log('hi')
}

say();

//함수 선언문과 함수 표현식의 문법적 차이
//		ㄴ호출하는 타이밍

test();	//함수선언문은 어디서든지 호출해서 사용가능 
		//+ 함수 만들기 전 단계에서 먼저 부를 수 있음
function test(){
	console.log('test')
}

//JavaScript는 프로그램이 실행되기 전에 모든 [함수선언문]을 찾아 모아서
//메모리에 저장하고 있다가 필요할때 내부적으로 끌어올려서 사용
//		이미 저장되어 있기 때문에 ->  함수가 선언보다 먼저 호출되어도 오류x
//						   -> 실제 코드가 끌어올려지는것은 아님
//							ㄴ 호이스팅(Hoisting)이라고 함

//[함수표현식]은 코드에 도달하면 생성

//그래서 둘중에 뭐쓰냐? ->편한거 ㄱ
// 함수선언문이 자유롭긴함

/////////////////////////////////////

//화살표함수(함수표현식)은 node.js에서 사용할거라 알아두기만하자
//1.
let add = function(num1, num2){
	return num1 + num2;
}
console.log(add(1,2))

//2. function생략, 대신 => 사용
let add2= (num1, num2) =>{
	return num1+num2;
}
console.log(add2(10,11))


//3. return 생략가능, 대신 소괄호 사용
let add3 = (num1, num2) =>(
	num1+num2
)
console.log(add3(5, 3))


//4.return시킬 코드가 한줄이면 괄호도 생략가능
let add4 = (num1, num2) => num1 + num2;
console.log(add4(10,20))



//5.파라미터가 하나만 필요하면 -> 파라미터의 소괄호도 생략가능
let sayHi2 = name => `Hello, ${name}`
console.log(sayHi2('kwak'))


//6.파라미터가 없는 함수는 소괄호 생략 [불가능]
let what = ()=>{
	console.log('ㅁㄹㄻ')
}
what();

//Function(독립적) vs Method(종속적)

let person ={
	name : 'kawk',
	walk : function(){
		console.log('당당')
	}	//Method : 객체(object)의 속성(프로퍼티)으로 할당된 function
}

console.log(person)
















