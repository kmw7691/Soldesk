// js/go.js

// 회원가입 페이지로 이동하기
function signupGo() {
	location.href = "SignUpController";
}

function logout(){
	let real = confirm("ㄹㅇ?");
	if(real){
		location.href="LoginController";
	}
}

function memberInfoGo(){
	location.href = "MemberInfoController";
}

function memberDelete(){
	let t = prompt("ㄹㅇ? (Y / N)");
	
	if(t=='y' || t=='Y'){
		location.href = "MemberDeleteController";
	}
}