//http 모듈은 node에 내장되어있는 웹관련 모듈
//Spring때와 마찬가지로, 사용자는 요청하고 서버는 응답하는 구조

const http = require('http');

http.createServer((request, response) => {
    response.writeHead(200, {'Content-Type' : 'text/html; charset=utf-8'});
    response.write('Hello, Server');
    response.end();
}).listen(3000);

//터미널에서 node index.js로 실행

//http모듈도 괜찮지만, 이것보다 더 좋은 모듈이 있음
//express 라는 모듈
//  Java의 Spring Framework, Python의 Django Framework처럼
//      JavaScript에서 사용하는 웹 프레임워크의 종류중 하나
//  Express 프레임워크는 코드의 양을 줄여주고
//      추후에 유지보수를 쉽게 하도록 만들어줌

//npm init -y로 package.json만들고
//  => npm install express 설치
//  => package.json열어서 dependencies버전확인 후
//  => app.js 파일만들기