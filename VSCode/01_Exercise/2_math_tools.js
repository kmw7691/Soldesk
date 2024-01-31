//모듈(Module) 이란?
//      하나의 프로그램을 이루는 하나하나의 조각
//      일반적으로 JS파일 하나를 말함
//          (라이브러리 느낌)

// 이 모듈은 두가지의 종류로 나뉘는데

//      1. 내가 직접 만든 모듈
//          말그대로 내가 직접 만든 모듈

//      2. 이미 만들어져 있는 모듈
//          은 또다시 두가지의 종류로 나뉨
//              1)외장모듈
//                  개발자들이 만들어놓은 모듈
//                  이 외장모듈을 사용하기 위해서는 NPM이라는 것을 사용
//                                               (Node Package Manager)
//                  Java - Maven / Python - pip처럼
//                  자바스크립트 개발자들이 유용한 패키지들을 만들어 두었고
//                  그 코드들이 공개되어있는 곳이 NPM
//                  제 3자가 만든 모듈이라해서 서드파티(3rd-party)모듈이라고도 함

//              2)내장모듈
//                  Node를 설치하고나면 기본적으로 제공되는 모듈
//                  따로 NPM사용 안해도 됨
//                  = 코어모듈 이라고도 함
///////////////////////////////////////////////

//함수하나 생성
function add(a,b){
    return a + b;
}

//다른 공간에서 사용하기 위해서는 이 모듈을 가져와야함

//add함수를 모듈 외부로 공개하기
//export : 내보내기
exports.add = add;
//앞의 add : 모듈 외부로 공개할 이름
//뒤쪽 add : 모듈 내부에서의 이름
//  => 모듈 외부에도 add는 이름으로 공개한다는 뜻이 됨

// PI = 3.141592;
// add = function add(a,b){return a + b};
// subract = function subract(a,b){return a - b};
// multiply = function multiply(a,b){return a * b};
// divide = function divide(a,b){return a / b};

//객체로 표현하기
let calculator ={
    PI: 3.141592,
    add:(a,b) => a+b,
    subract: (a,b)=> a-b,
    multiply: (a,b) =>a*b,
    divide: (a,b)=> a/b
}

module.exports = calculator;

//위에서 만든 내용을 전부 다 하나의 객체에 넣었음
// => calculator
// + 이 객체 자체를 그대로 외부에 공개를 함

//exports : 공개하고 싶은 것을 하나씩 공개할때 사용
//      exports.속성 = 값
//module.exprots : 공개하고 싶은 것들을 모아서
//                  하나의 객체로 만들어 공개할 때 사용