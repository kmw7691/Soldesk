const express = require('express');
const User = require('../schemas/user');

const router = express.Router();

router.get('/', async(req,res,next)=>{
    try {
        const users = await Yser.find({});
        
    } catch (error) {
        
    }
})