const express = require('express');
const User = require('../models/user');
const Comment = require('../models/comment');

const router = express.Router();

router.route('/')
    .get(async (req, res, next) => {
        try {
            const users = await User.findAll();
            res.json(users);
        } catch (err) {
            console.log(err);
            next(err);
        }
    })
    .post(async (req, res, next) => {
        try {
            const user = await User.create({
                name: req.body.name,
                age: req.body.age,
                married: req.body.married,
            });
            console.log(user);
            res.status(201).json(user);
        } catch (err) {
            console.log(err);
            next(err);
        }
    });

// :id => 라우터 파라미터
// 라우터를 사용할 때 온전히 주소값을 지정한 라우터가
// 라우터 파라미터를 쓰는 라우터보다 위에 위치해야 정상적으로 작동함
//      => 그렇지 않으면 실행되지 않음
router.get('/:id/comments', async (req, res, next) => {
    try {
        const comments = await Comment.findAll({
            include: {
                model: User,
                where: { id: req.params.id },
            },
        });
        console.log(comments);
        res.json(comments);
    } catch (err) {
        console.log(err);
        next(err);
    }
});

module.exports = router;