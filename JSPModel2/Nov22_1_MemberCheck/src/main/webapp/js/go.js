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

function boardDelete(b_no){
	let t = confirm("ㄹㅇ 글삭?")
	if(t){
		location.href = "BoardDeleteController?b_no=" + b_no;
	}
}

function boardUpdate(b_no){
	let t = confirm("ㄹㅇ 수정?")
	if(t){
		location.href = "BoardUpdateController?b_no=" + b_no;
	}
}
