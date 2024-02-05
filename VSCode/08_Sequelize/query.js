// SQL문을 시퀄라이즈로 작업하기
const { User } = require('./models'); // models 폴더에 있는것들 사용 가능

// 1. insert into beaver.users (name, age, married, comments) values 
//      ('asdf', 100, 0, '안녕하새우!');
User.create({
    name: 'asdf',
    age: 100,
    married: false,
    comment: '안녕하새우!',
});

// 2. select * from beaver.users;
// findAll 메소드
User.findAll({});

// 3. attributes 옵션을 사용해서 원하는 컬럼만 가져올 수 있음
// select name, married from beaver.users;
User.findAll({
    attributes: ['name', 'married'],
});

// 4. 조건 검색
// select name, age from beaver.users where married 1 and age > 30;
User.findAll({
    attributes: ['name', 'age'],
    where: {
        married: true,
        age: { [Op.gt] : 30},
    }
});

// 연산자 관련
// Sequelize 객체 내부의 Op 객체를 불러왔고
// Op.gt (초과) / Op.gte (이상) / Op.lt (미만) / Op.lte (이하)
// Op.ne (같지 않음) / Op.or (또는) / Op.in (배열 요소 중 하나)
// Op.notIn (배열 요소와 모두 다름)
// 정도의 연산자가 자주 사용 됨

// Op.or 예시
// select id, name from beaver.users where married = 0 or age > 30;
User.findAll({
    attributes: ['id', 'name'],
    where: {
        [Op.or] : [{ married: false}, { age: { [Op.gt]: 30 } }]
    }
});

// Update
// update beaver.users set comment = '바꿀 내용' where id = 2;
User.update({
    comment: '바꿀 내용',
}, {
    where: { id: 2}
});
// 첫번째 파라미터는 수정할 내용, 
//  두번째 파라미터는 어떤 데이터를 바꿀지를 특정

// Delete
// delete from beaver.users where id = 2;
User.destroy({
    where: { id: 2}
});
//---------------------------------------------------------










