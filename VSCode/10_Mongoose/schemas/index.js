const mongoose = require('mongoose');

const connect = () => {
    // 개발환경일때만 콘솔을 통해서 몽구스가 생성하는
    // 쿼리 내용을 확인 할 수 있는 코드
    if (process.env.NODE_ENV !== 'production') {
        mongoose.set('debug', true);
    }

    // 몽구스와 몽고디비를 연결
    // 주소 형식은 
    // mongodb://[username:password]@[IP Address]:[Port]/[Database]
    // IP : localhost / Port: 27017 / Database: admin
    // 접속을 시도하는 주소의 데이터베이스는 admin이지만,
    // 실제로 사용할 데이터베이스는 nodejs
    // dbName 옵션을 줘서 nodejs 데이터베이스를 사용하게 함
    mongoose.connect('mongodb://beaver:1@localhost:27017/admin', {
        dbName: 'nodejs',
        useNewUrlParser: true, // 이거 안적으면 deprecatedError가 발생
    }).then(() => {
        console.log('MongoDB 연결 성공');
    }).catch((err) => {
        console.error('MongoDB 연결 에러', err);
    });
};
    // 이벤트 연결 => 에러 발생하면 에러 내용을 기록하고,
    //          의도치않게 서버가 종료됐다면 재연결을 시도함
    // 실행시 자주 발생하는 에러
    // MongooseServerSelectionError: connect ECONNREFUSED ::1:27017
    //      : 데이터베이스 실행 안했을 때
    // MongoServerError : Authentication Failed
    //      : 비밀번호 틀렸을 때

mongoose.connection.on('error', (error) => {
    console.error('몽고디비 연결 에러', error);
});

mongoose.connection.on('disconnected', () => {
    console.error('몽고디비 연결이 끊겼습니다. 연결을 재시도 합니다.');
    connect();
});

module.exports = connect;















