const express = require('express');
const Comment = require('../schemas/comment');

const router = express.Router();

//도큐먼트를 등록하는 라우터
//create메소드로 댓글을 저장한 후,
//populate 메소드로 반환된 comment 객체에 다른 컬렉션 다큐먼트를 불러옴
//이후, path옵션으로 어떤 필드를 합칠지 설정하고,
//합쳐진 결과를 클라이언트로 응답
router.post('/', async(req,res,next)=>{
    try {
        const comment = await Comment.create({
            commenter: req.body.id,
            comment: req.body.comment,
        });
        console.log(comment);
        const result = await Comment.populate(comment, {path: 'commenter'});
        res.status(201).json(result);
    } catch (error) {
        console.error(error);
        next(error);
    }
});

//patch는 update에 대한 라우터
//updateMany or updateOne메소드를 사용
//첫번째 파라미터로 어떤 도큐먼트를 수정할 지 지정
//두번째 파라미터로 수정할 값을 지정
//몽고디비와는 다르게 $set연산자를 사용할 필요가 없음
router.route('/:id').patch(async(req,res,next)=>{
    try {
        const result = await Comment.updateOne({
            _id: req.params.id,
        },{
            comment: req.body.comment,
        });
        res.json(result);
    } catch (error) {
        console.error(error);
        next(error);
    }
}).delete(async(req,res,next)=>{
    //delete는 삭제하기 위한 라우터
    //deleteMany or deleteOne 메소드를 사용
    //첫번째 파라미터로 어떤 도큐먼트를 삭제할지 지정
    //
    try {
        const result = await Comment.deleteOne({
            _id: req.params.id,
        });
        res.json(result);
    } catch (error) {
        console.error(error);
        next(error);
    }
});

module.exports = router;