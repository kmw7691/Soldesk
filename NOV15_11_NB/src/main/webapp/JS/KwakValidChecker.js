//KwakValidChecker.js

//개발자가 의도한대로 되하지않으면 true값
//(뭔가 문제가 되면 true, 정상적이면 false인 컨셉)


//<input>넣었을때
//		아무것도 안썼으면 true, 뭐라도썼으면 false
function isEmpty(input){
	return (!input.value);
}


//<input>, 글자 수 넣었을때
function atLeastLetter(input, len){
	return (input.value.length < len);
}


//<input>넣었을때
//		한글/특수문자가 적혀있다면 true, 아니면 false
function containsAnother(input){
	let pass = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ@._";
	
	let iv = input.value;
	for(let i = 0; i < iv.length; i++){
		if(pass.indexOf(iv[i]) == -1){ //pass에 있는 내용중 내가 쓴 내용이없으면
			return true;
		}		
	}
	return false;
}


//<input> x 2넣었을때(pw, pw확인)
//		내용이다르면 true, 같으면 false
function notEqualPw(input1, input2){
	return (input1.value !== input2.value);	
}


//<input>, 문자열 세트 넣었을때
//		없으면 true, 있으면 false(입력한 pw에 지정한 문자열이 없는 경우)
function notContains(input, passSet){
	let iv = input.value;
	for(let i = 0; i < passSet.length; i++){
		if(iv.indexOf(passSet[i]) !== -1){
			return false;
		}
	}
	return true;
}


//<input>넣었을때
//		숫자 아닌게 있으면 true, 숫자만 있으면 false
function isNotNumber(input){
	return isNaN(input.value);
}


//<input>, 확장자 넣었을때
//		확장자명 아니면 true, 맞으면 false
function isNotType(input, type){
	//.gif  .png
	type = "." + type;
	return (input.value.indexOf(type) == -1);
}























