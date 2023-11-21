//01_Function

//alert("check");

//함수(Function)
//		서비스를 만들다보면 같거나 비슷한 기능을 또 사용하게 되는 경우가 발생
//		매번 새롭게 만들지않고 자주 사용하는 기능을 하나로 묶어다 불러다쓰자~

// function vs method
//		function : 하나의 기능을 구현하도록 구성 - 독립적존재
//		method : class내부에 정의한 함수(function) - 종속적존재

/*
function 함수명(파라미터){
	내용
}
*/

//함수명(파라미터); 로 호출

//파라미터가 없는 함수
function showError(){
	alert("에러어ㅓ");
}

//showError();
//원하는 타이밍에 함수를 부르고 싶다면, 다양한 이벤트를 동해 부르면된다

//파라미터 있는함수
function sayMyName(){
	let msg = `Hello, ${name}`;
	alert(msg);
}

//파라미터가 필요한 함수에서 파라미터를 안쓰면 
//sayMyName(); //undefined

//undefined를 방치
function sayMyName2(){
	let msg="Hello"
	if(name){
		msg += `, ${name}`;
	}
	alert(msg);
}

//sayMyName2();

let msg = "Hellow";//현재 js파일 어디에서나 접근이 가능한변수 : 전역변수(Global Variable)
console.log("함수호출전");
console.log(msg);
function sayMyName3(){
	let msg = "Hello"; //해당함수 안에서만 접근 가능한변수 : 지역변수(Local Variable)
	if(name){
		msg += `, ${name}`		
	}
	console.log("함수내부");
	console.log(msg);
}

sayMyName3('kwak');
console.log("함수호출후");
console.log(msg);

//지역변수는 함수 안에서 전역변수와 같은 이름으로 지을 수 있고, 서로 간섭x
//전역변수는 많아지면 관리하기 힘들어지니까
//		함수에서 필요한 변수는 가능하면 함수안에서 만드는 지역변수를 사용하는것이 편함

//OR을 사용해서 기본값 넣기
function sayHello(name){
	let newName = name || 'Friend';
	let msg = `Hello, ${newName}`
	console.log(msg);
}

sayHello();
sayHello('minwoo');

//파라미터에 default값을 정하기
function sayHello2(name = 'Friend'){
	let msg = `Hello, ${name}`;
	console.log(msg)
}

sayHello2();
sayHello2('kwak');

//정리 : 
//		함수는 한번에 하나의 작업만 하는것이 좋다
//		여러작업이 진행되어야 한다면 함수를 나눠서 구분하기(1함수 = 1기능)
//		함수명은 읽기쉽고 어떤기능이 들어있는지 알수 있게 네이밍
//		함수명 중복 불가



















