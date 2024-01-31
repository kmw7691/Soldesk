const fs = require('fs');

//파일쓰기
//writeFile : 파일이 존재하지 않으면 그 파일을 생성하고 내용을 적어냄
//이어쓰기 기능 x
let data = '파일 시스템 예제';

// console.log('파일을 생성합니다');

// fs.writeFile('text1.txt', data, 'utf-8', function(error){
//     // 에러가 발생했다면 에러를 호출함
//     if(error){
//         throw error
//     }
//     //정상적으로 만들었다면 메시지 출력
//     console.log('파일이 생성되었습니다');
// });
// console.log('파일생성중');

//결과가 이상함
//소스코드랑 순서가 안맞음
//코드 순서는 생성합니다 -> 생성되었습니다 -> 생성 중

//콘솔 결과는 생성합니다 -> 생성중 -> 생성되었습니다
//이 현상은 Node.js 개발자의 의도
//이렇게 소스코드의 작동순서가 위에서 아래로 순차대로
//  실행되지 않는 상황을 비동기(Async)라고 함
//순서의 작동을 보증하지 않겠다 라는 뜻

//개발자는 왜 이렇게 만들었을까
//      생성할 파일의 크기가 10TB가 넘는 큰 파일이라고 가정
//      컴퓨터가 아무리 빨라도 초단위가 넘게 걸릴것
//      그 말인즉, 파일 생성이 완료되기 전까지는
//      다음 코드 실행x
//          => 이게 '렉'임

//비동기 방식은 이런 현상을 없애줌
//파일을 생성하면서, 동시에 다른 작업도 가능하게 만들어 주는 것

//이 비동기의 장점은 간단한 작업을 하기 위해서
//     오래 걸리는 작업을 기다릴 필요가 없다는 것

// fs.unlink('text1.txt', function(error){
//     if(error){
//         throw error
//     }
//     console.log('파일삭제 성공');
// });

//근데 '난 렉이걸려도 순서대로 됫으면 좋겠다'
//  fs.writeFileSync()
//  sync : 동기 라는 의미 

// console.log('파일을 생성합니다');
// console.log('파일 생성 중');
// fs.writeFileSync('text1.txt',data); //encoding 기본값이 utf-8
// console.log('파일이 생성되었습니다');

//콜백 함수를 넘길 필요도 없고, 순서대로 작동함

// Node.js의 최대 장점은 비동기로 작동한다는 점
// 파일 사이즈가 작다면 동기 / 크다면 비동기 방식으로 사용할 것을 추천


//파일 읽기
// fs.readFile('text1.txt', 'utf-8', function(error,data){
//     console.log(data);    
// });

//파일 이어서쓰기
fs.appendFile('text1.txt', '\n데이터 추가', function(error){
    if(error){
        throw error
    }
    console.log('이어쓰기 끝');
});