//nov16_Check.js

function check(){
	let xBox = document.calcForm.x;
	let yBox = document.calcForm.y;
	
	//alert(xBox.value);
	
	if(isEmpty(xBox) || isNotNumber(xBox)
		|| isEmpty(yBox) || isNotNumber(yBox)){
			alert("제대로 입력ㄱㄱ");
			xBox.value="";
			yBox.value="";
			xBox.focus();
			return false;			
		}
	
	return true;	
}