//만들어둔 모듈을 가져와서 사용하는 것을 로드(Load)라고 함

//require('./2_math_tools.js');

//require는 모듈을 로드해주는 함수
//그 파라미터로 2_math_tools 모듈의 상대경로를 적음
//그리고 이 require함수는 모듈을 로드해서 객체하나를 
//    리턴하는 성질이 있음
//경로에서 js확장자는 생략가능

// let m = require('./2_math_tools.js');
// console.log(m.add(1,2))     //에러

//모듈을 로드할때 규칙이 있음
//2_math_tools의 add()함수를 외부로 공개해주지 않았기 때문에 에러가 발생함

//공개한것들 불러오기
//let 대신  const(상수화)를 시켜서
//나중에 이 변수를 다른 의도로 재사용하는것을 방지
// const math = require('./2_math_tools.js');

// console.log(math.add(10,2));
// console.log(math.subract(10,2));
// console.log(math.multiply(10,2));
// console.log(math.divide(10,2));

//exports했던 것을 하나의 객체로 만들고 그것을 공개하는 방법
const calculator = require('./2_math_tools.js');
console.log('--------------------');
console.log(calculator.PI);
console.log(calculator.multiply(3,6));

