//세션 (Session)
//쿠키와 세션의 차이는 데이터의 저장장소
//쿠키는 데이터를 브라우저에 저장하는 반면,
//세션은 서버에 저장을함
//세션은 서버에 각 사용자의 개인 저장소를 만들어주는 개념
//그런데 HTTP는 상태를 저장하지 않기 때문에
//  각 사용자를 식별해 줄수 있는 값이 필요 => 쿠키
//그 정보를 '세션쿠키' 라고함

//특징
//  - 세션은 서버에 저장됨
//  - 서버는 세션쿠키로 사용자를 식별
//  - 세션 '쿠키'이기 때문에 브라우저가 종료되면 세션쿠키도 사라짐

//npm install express-session =>설치

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

app.get('/',(req,res)=>{
    const {user} = req.session;
    if(user){
        res.render('login', {user});
        return;
    }

    res.render('index');
});

app.post('/',(req,res)=>{
    const {name} = req.body;
    req.session.user = name;
    res.redirect('/');
    //브라우저의 개발자도구 - Application - Storage - Cookies에서
    //세션쿠키 확인가능
});

//세션삭제
app.get('/delete', (req,res)=>{
    res.session.destroy();
})

//세션데이터 보기
app.get('/lookSession', (req,res)=>{
    res.render('sessionData', {sessions : req.session});
});

//세션데이터 추가
app.get('/addSession',(req,res)=>{
    req.session.addData = 'addData';
    console.log(req.sessionID);
    res.redirect('/');
});

app.listen(3000, ()=>{
    console.log('서버동작중..');
});