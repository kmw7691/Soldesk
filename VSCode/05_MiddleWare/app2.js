//자주사용하는 미들웨어

//npm install morgan cookie-parser express express-session

const express = require('express')
const morgan = require('morgan');
const path = require('path');

const app = express();

//1. morgan - 요청과 응답에 대한 정보를 콘솔에 알려줌
app.use(morgan('dev'));
//GET /kwak 404 2.396 ms - 143
//각각
//요청방식 / 주소 / 상태코드 / 응답속도 - 응답바이트
//를 알려줌

// app.get('/', (req,res)=>{
//     res.send('fafqerfqfafqwrqwr');
// });

//기본주소값으로 get방식 요청
//  => HTML + CSS파일

app.get('/', (req,res)=>{
    res.sendFile(path.join(__dirname,'/index.html'))
})

//연결 분명 했는데 css가 안먹힘
//그래서 static이라는 미들웨어가 필요함
//  정적(static) 파일을 제공하는 역할을 해줌
//express 객체안에 있는 기능이라 꺼내 쓰기만 하면됨
//app.use('요청경로', express.static('실제경로')); 로 사용

//css폴더를 지정하게됨
app.use('/', express.static(path.join(__dirname, 'css')));
//주소값 뒤에 /index.css 를 쳐보면 해당 코드가 나옴
//실제 폴더 경로에는 'css'라는 폴더명이 들어있고
//요청 주소에는 'css' 폴더명이 안들어가는데
//서버의 폴더경로와 요청경로가 달라서
//이 서버의 구조를 쉽게 파악할 수 없다는 보안상 장점이 있음
//css뿐만 아니라 js, 이미지 파일 등등
//브라우저에서 접근 가능해짐

app.listen(3000, ()=>{
    console.log('연결 굿');
});