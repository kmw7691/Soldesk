//BMIM2.js
//alert("check")

function checkValid(){
	let nBox = document.bmiForm.name;
	let hBox = document.bmiForm.height;
	let wBox = document.bmiForm.weight;
	let pBox = document.bmiForm.photo;
	
	if(isEmpty(nBox) || atLeastLetter(nBox, 2)){
		alert("이름 제대로 기입 ㄱㄱ");
		nBox.value()="";
		nBox.focus();
		return false;
	} else if (isEmpty(hBox) || atLeastLetter(hBox, 3)
		|| isNotNumber(hBox)) {
		alert("키 제대로 기입 ㄱ");
		hBox.value = "";
		hBox.focus();
		return false;
	} else if (isEmpty(wBox) || atLeastLetter(wBox, 2)
		|| isNotNumber(wBox)) {
		alert("몸무게 제대로 기입 ㄱ");
		wBox.value = "";
		wBox.focus();
		return false;
	} else if (isEmpty(pBox) || (isNotType(pBox, "jpg")
		&& isNotType(pBox, "png")
		&& isNotType(pBox, "gif"))) {
		alert("사진 제대로 기입 ㄱ");
		pBox.value = "";
		pBox.focus();
		return false;
	}
	return true;
}