//05_Object.js
//alert('check')

//객체(object) - JSON Parsing
let dog = {
	name:'슈나이더',
	age:3,
}

//객체는 중괄호 안에서 구성
//		key와 Value로 구성된 프로퍼티(속성)이 중괄호 안에 포함
//		각각 쉼표로 구분, 마지막에는 쉼표가 잇던없던 상관x

//접근
console.log(dog.name);	//변수명.key값 -> value값이 리턴
console.log(dog[`age`]) //변수명.key값 -> value값이 리턴

//속성추가
dog.gender = 'Male'
dog[`furColor`] = 'black'
console.log(dog)

//속성삭제
delete dog.furColor;
console.dog



let name = 'kwak'
let age = 100
let person={
	name:name,
	age:age,
	gender:'male'
}
console.log(person)


let person2={
	name,
	age,
	gender:'male'
}//조건 : key이름과 value에서 받아올 변수명이 같아야함
console.log(person2)
console.log(person2.name)
//존재하지 않는 속성에 접근하려하면 에러가아닌 undefined가 나옴
console.log(person2.hairColor)


//in연상자 이용 : 어떤속성이 있는지 확인 가능
console.log('phone' in person2)	//false
console.log('age' in person2)	//true


//java : foreach문과 미슷
for(let k in person2){
	console.log(k)			//key값
	console.log(person2[k]) //value값
}


//함수로 객체만들기
function makeObject(){
	return{
		name,
		price,
		shop:'myCafe'
	}
}

let coffee = makeObject('아메리카노', 3500);
console.log(coffee)




















