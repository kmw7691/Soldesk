//06_Array.js
//alert('check')

//배열(Array) : 순서가 있는 list
let student =['홍길동', '김길동', '박길동']
console.log(student[1]);	//index는 0부터시작

//문자뿐만 아니라 숫자 객체 함수 ... 포함가능
let person = [
	'kwak',
	100,
	true,
	{
		name:'minwoo',
		age:100
	},
	function(){
        console.log('array');
    }
]

//배열의길이
console.log(person.length)
console.log(person)


let days = ['월', '화', '수']
console.log(days)

//push() : 배열끝에 추가
days.push('목')
console.log(days)

//pop() : 배열끝의 요소를 제거
days.pop();
console.log(days)

//unshift() : 제일 앞요소 추가
days.unshift('일')
console.log(days)

//shift() : 제일 앞요소 제거
days.shift();
console.log(days)

//unshift()는 여러요소 추가가능
days.unshift('목', '금', '토', '일')
console.log(days)



//배열을 사용하는 이유 중 하나 : 반복문을 원활하게 사용하기 위해서
for(let i=0;i<days.length;i++){
	console.log(days[i])
}


console.log('=-=-=-=-=-=-=-=-=-=-=')

for(let day of days){
	console.log(day)
}


































