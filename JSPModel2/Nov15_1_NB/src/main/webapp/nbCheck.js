//nbCheck.js

function checkValid(){
	let fBox = document.mbForm.first;
	let sBox = document.mbForm.second;
	let tBox = document.mbForm.third;
	
	if(isEmpty(fBox) || isNotNumber(fBox)){
		alert("1번 숫자 재입력 ㄱ");
		fBox.value()="";
		fBox.focus();
		return false
	} else if(isEmpty(sBox) || isNotNumber(sBox)){
		alert("2번 숫자 재입력 ㄱ");
		sBox.value()="";
		sBox.focus();
		return false
	} else if(isEmpty(tBox) || isNotNumber(tBox)){
		alert("3번 숫자 재입력 ㄱ");
		tBox.value()="";
		tBox.focus();
		return false
	}
	return true;
}
