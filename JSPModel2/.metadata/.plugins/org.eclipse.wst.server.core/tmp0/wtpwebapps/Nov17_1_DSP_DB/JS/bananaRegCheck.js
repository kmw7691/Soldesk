//bananaRegCheck.js

//alert("check")

//전부 빈칸 x
//개수 가격 숫자만
//생산지역 설명 최소 다섯글자


function check(){
	let mBox = document.bananaForm.maker;
	let lBox = document.bananaForm.location;
	let hBox = document.bananaForm.howmany;
	let pBox = document.bananaForm.price;
	let iBox = document.bananaForm.introduce;
	
	if(isEmpty(mBox)){
		alert("상표 입력 ㄱㄱ");
		mBox.value="";
		mBox.focus();
		return false;
	} else if(isEmpty(lBox) || atLeastLettrt(lBox, 5)){
		alert("지역 입력 ㄱㄱ");
		lBox.value="";
		lBox.focus();
		return false;
	} else if(isEmpty(hBox)){
		alert("갯수 입력 ㄱㄱ");
		hBox.value="";
		hBox.focus();
		return false;
	}  else if(isEmpty(pBox) || isNotNumber(pBox)){
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