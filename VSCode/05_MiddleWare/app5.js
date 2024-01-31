//첫접속시 아무문자열 출력

//products/write로 GET방식 요청하면
//아래의 html화면 나오게
//html => 제품의 이름, 가격, 설명입력
//     => 버튼을 누르면
//     => post방식으로 products/write로 요청
//     => 입력한 값을 문자열로만 출력

const express = require('express');
const morgan = require('morgan');
const cookieParser = require('cookie-parser');
const nunjunks = require('nunjucks');
const session = require('express-session');


const app = express();

app.use(morgan('dev'));

app.use(cookieParser());
app.use(session({
    resave:true, //요청이 왔을때 세션에 수정사항이 생기지 않아도
                 //다시 저장할 지 여부
    saveUninitialized:false, //세션에 저장할 내역이 없더라도
                             //세션을 저장할지 여부
    secret : 'secretkk',
    cookie:{    //쿠키 암호화
        httpOnly:true, //쿠키 설정과 동일
        secure:false,
    },
    name:'kwak-cookie', //세션쿠키의 이름
}));
app.use(express.json());
app.use(express.urlencoded({extended:true}));
app.set('view engine', 'html');
nunjunks.configure('views',{
    express:app,
    watch:true,
});

app.get('/', (req,res)=>{
    const 
})