const mongoose = require('mongoose');

const { Schema } = mongoose;
const { Types : {ObjectId} } = Schema;
const commentSchema = new Schema({
    //commenter의 자료형은 ObjectId이고
    //옵션으로 ref 속성의 값이 User
    //나중에 JOIN과 유사한 기능을 할 때
    commenter : {
        type: ObjectId,
        required: true,
        ref: 'User',
    },
    comment: {
        type: String,
        required: true,
    },
    createAt: {
        type: Date,
        default: Date.now,
    }
});

module.exports = mongoose.model('Comment', commentSchema);