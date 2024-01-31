const express = require('express');
const path = require('path');

const app = express(); //객체생성
const port = 3000;

//get방식 요청
app.get('/',(req,res)=>{
    res.send('첫 요청 성공');
});

//url추가하기
app.get('/kwak',(req,res)=>{
   res.send('I am a boy');
});

app.listen(port,()=>{
    console.log(`Express가 ${port}번 포트에서 동작중...`);
});

//내용 바꿀때마다 서버 껏켰..
//nodemon 설치
//npm install -g nodemon
// -g : global(전역객체) / 한번 설치해놓으면 계속 쓸 수 있음

//라우터 (Router)
//라우터는 클라이언트의 요청 경로(path)를 보고
// 이 요청을 처리할 수 있는 곳으로 기능을 전달해주는 역할을 함
//라우팅이란, 네트워크 용어로 어떤 네트워크 안에서 통신되는
//      데이터를 보낼 경로를 선택하는 과정
// 간단히 말해서, 갈림길에서 어디로 가야할지 선택하는 과정

//업그레이드
//단순한 문자열 대신에 HTML로 응답하고싶다면
//res.sendFile() 메소드를 사용하면 되는데, 
//이때 파일의 경로를 path 모듈을 사용해서 지정해야함

//index.html 만들기
//package.json 파일의 script부분에
//      "start" : "nodemon app.js" 넣기 (기존에 있던 내용 삭제)

app.get('/success',(req,res)=>{
    //res.send('문자열');

    //__dirname : 현재경로 위치
    //              에 있는 index.html 파일을 열어라
    res.sendFile(path.join(__dirname,'/index.html'))
});