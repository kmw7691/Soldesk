//nov15_check.js

//alert("check")

function check(){
	let numBox = document.nbForm.userAns;
	
	//빈칸x 3자리 숫자만 각자리수중복x
	if(isEmpty(numBox) || atLeastLetter(numBox, 3)
					   || isNotNumber(numBox)
					   || numBox.value[0] == numBox.value[1]
					   || numBox.value[1] == numBox.value[2]
					   || numBox.value[2] == numBox.value[0]){
		alert("제대로기입 ㄱㄱ");
		numBox.value="";
		numBox.focus();
		return false;							
	}
	
	return true;
}