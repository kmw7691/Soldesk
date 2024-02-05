const Sequelize = require('sequelize');

const User = require('./user');
const Comment = require('./comment');

const env = process.env.NODE_ENV || 'development';
const config = require(__dirname + '/../config/config.json')[env];
const db = {};

const sequelize = new Sequelize(config.database, 
                                config.username, 
                                config.password, 
                                config);
db.sequelize = sequelize;

db.User = User;
db.Comment = Comment;

User.initiate(sequelize);
Comment.initiate(sequelize);

User.associate(db);
Comment.associate(db);

module.exports = db;

// db 객체에 User와 Comment 모델을 담아둠
// 앞으로 db 객체를 require해서 User와 Comment 모델에 접근할 수 있음
// 각 모델의 initiate 메소드는 static initiate 메소드를 호출 한 것
// 모델.init()가 실행되어야 테이블이 모델로 연결이 됨
// 다른 테이블과 관계를 설정하는 static associate 메소드도 실행

// users 테이블과 comments 테이블의 관계 설정
// 사용자(작성자) 한 명은 댓글을 여러개 작성할 수 있음
// 하지만 댓글 하나에 사용자(작성자)가 여러명일 수는 없음
//    => 일대다 (1:N) 관계

// 일대일, 다대다 관계가 있는데
// 사용자와 사용자에 대한 정보테이블을 일대일(1:1) 관계의 예시
// 게시글 테이블과 해시태그 테이블을 다대다(N:M) 관계의 예시









