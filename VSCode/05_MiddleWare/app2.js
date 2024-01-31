//자주사용하는 미들웨어

//npm install morgan cookie-parser express express-session

const express = require('express')
const morgan = require('morgan');
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

app.listen(3000, ()=>{
    console.log('연결 굿');
});