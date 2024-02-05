// comments/  post방식 => 댓글 등록

// comments/댓글번호 => 수정 => 그 번호에 해당하는 댓글의 내용 수정
//                   => 삭제 => 그 번호에 해당하는 댓글 삭제

const express = require('express');
const { Comment } = require('../models');

const router = express.Router();

router.post('/', async (req, res, next) => {
    try {
        const comment = await Comment.create({
            commenter: req.body.id,
            comment: req.body.comment,
        });
        console.log(comment);
        res.status(201).json(comment);
    } catch (err) {
        console.error(err);
        next(err);
    }
});

router.route('/:id')
    .patch(async (req, res, next) => {
        try {
            const result = await Comment.update({
                comment: req.body.comment,
            }, {
                where: { id: req.params.id },
            });
            res.json(result);
        } catch (err) {
            console.error(err);
            next(err);
        }
    })
    .delete(async (req, res, next) => {
        try {
            const result = await Comment.destroy({where: {id: req.params.id}});
            res.json(result);
        } catch (err) {
            console.error(err);
            next(err);
        }
    });

module.exports = router;