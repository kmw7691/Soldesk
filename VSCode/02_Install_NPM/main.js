//NPM은 Node Package Manager의 약자
//Node.js로 생성한 패키지/프로젝트를 관리하는 도구

//터미널에
//npm init -y
//      :npm을 쓸 수 있는 초기 환경 설정
//      -y : 이걸 안쓰면 초기 설정값들 일일히 입력해서 설정한 후
//           yes입력해야댐
//           -y옵션을 통해 입력없이 한번에 처리해 줌

// 그리고 패키지/프로젝트 정보를 가지고 있는 것이
// npm init -y 명령어를 실행하면서 만들어진 package.json

// {
//     "name": "02_install_npm",        //이 프로젝트의 이름
//     "version": "1.0.0",              //이 프로젝트의 버전
//     "description": "",               //이 프로젝트에 대한 설명
//     "main": "main.js",               //실행 시 첫 진입점이 되는 모듈
//     "scripts": {                     //스크립트 명령어를 담고 있음
//       "test": "echo \"Error: no test specified\" && exit 1"
//     },
//     "keywords": [],                  //패키지를 문자열 배열로 설명해줌
//     "author": "",                    //작성자
//     "license": "ISC"                 //패키지에 대한 권한
//     "dependencies"                   //모듈 의존성
//   }

//3rd party module 불러오기
//터미널에 npm install cowsay 입력
//      =>package-lock.json 생기면서
//        package.json 둘다 cowsay에 대한 dependecies가 생김
//package-lock.json : 나중에 이 프로젝트를 배포할 때,
//      이 프로젝트에 대한 필요한 모듈의 버전을 명시해 둔 곳
//      이걸 토대로 다른 컴퓨터에서 이 프로젝트를 실행할 때,
//      이 내용을 바탕으로 npm install 하면
//      관련된 모듈들이 한번에 설치가 될것
const cowsay = require('cowsay');
console.log(cowsay.say({
    text : 'I want to go Home',
}));