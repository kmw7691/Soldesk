const express = require('express');
const User = require('../schemas/user');
const Comment = require('../schemas/comment');

const router = express.Router();


//get방식으로 데이터를 json형식으로 반환
router.route('/')
    .get(async(req, res, next)=>{
        try {
            const users = await User.find({});
            res.json(users);
        }catch (error) {
            console.error(error);
            next(error);
        }
    })
    .post(async(req,res,next)=>{
        //POST방식으로 데이터를 등록(.create({})    )
        //  *정의한 스키마에 부합하지 않는 데이터를 넣으면 에러뜸
        // _id (PK)는 자동으로 생성됨
        try {
            const user = await User.create({
                name:req.body.name,
                age: req.body.age,
                married: req.body.married,
            });
            console.log(user);
            res.status(201).json(user);
        } catch (error) {
            
        }
    });

//댓글을 조회하는 라우터
//find메소드의 옵션으로 댓글을 쓴 사용자의 아이디로 댓글을 조회한 후
//populate 메소드로 관련있는 컬렉션의 도큐먼트를 불러옴
//Comment 스키마 commenter 필드의 ref가 User로 되어 있으므로,
//자동으로 User에서 해당 다큐먼트를 찾아서 합치게 됨
router.get('/:id/comments', async(req,res,next)=>{
    try {
        const comments = await Comment.find({commenter: req.params.id})
            .populate('commenter');
        console.log(comments);
        res.json(comments);
    } catch (error) {
        console.log(error);
        next(error);
    }
});