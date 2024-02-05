const mongoose = require('mongoose');

// 스키마 : 데이터베이스를 매핑하는데 사용되는 정보(문서)의 형식
//  몽구스의 모든 것은 스키마로 시작 !

// 몽구스 모듈에서 _id는 알아서 기본키로 생성하므로 딱히 명시할 필요 X
// < 자료형 >
// 몽구스에서의 자료형은 몽고디비와는 다르고, 그 종류는
// String : 문자열, Number : 숫자, Date : 날짜
// Buffer : 버퍼 (이진데이터), Boolean : 참 or 거짓
// Mixed : 혼합타입 (다양한 타입 저장 가능) , Array : 배열
// ObjectId (각 문서마다 만들어지는 Id)

// 옵션
//  type : 자료형 지정
//  required : NOT NULL 과 같은 기능
//  unique : true면 고유한 값이 들어가야 함
//  default : 기본값

const { Schema } = mongoose;
const userSchema = new Schema({
    name: {
        type: String,
        required: true,
        unique: true,
    },
    age: {
        type: Number,
        required: true,
    },
    married: {
        type: Boolean,
        required: true,
    },
    comment: String,
    createAt: {
        type: Date,
        default: Date.now,
    },
});

module.exports = mongoose.model('User', userSchema);




