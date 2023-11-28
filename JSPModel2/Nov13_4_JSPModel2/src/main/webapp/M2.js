//M2.js
console.log('df')
function checkValid(){
	let xBox = document.vForm.x;
	let yBox = document.vForm.y;

	if(isEmpty(xBox) || isNotNumber(xBox)){
		alert("x값 제대로 입력 ㄱㄱ");
		xBox.value="";
		xBox.focus();
		return false;
	} else if(isEmpty(yBox) || isNotNumber(yBox)){
		alert("y값 제대로 입력 ㄱㄱ");
		yBox.value="";
		yBox.focus();
		return false;
	}
	
	return true;
}