//appleRegCheck.js

//alert("check")

function check(){
	let lBox = document.appleForm.a_location;
	let pBox = document.appleForm.a_price;
	let iBox = document.appleForm.a_introduce;
	
	if(isEmpty(lBox)){
		alert("지역 입력 ㄱㄱ");
		lBox.value="";
		lBox.focus();
		return false;
	} else if(isEmpty(pBox) || isNotNumber(pBox)){
		alert("가격 제대로 입력 ㄱㄱ");
		pBox.value="";
		pBox.focus();
		return false;
	} else if(isEmpty(iBox) || atLeastLetter(iBox, 5)){
		alert("소개 제대로 입력 ㄱㄱ");
		iBox.value="";
		iBox.focus();
		return false;
	}
	
	return true;
}