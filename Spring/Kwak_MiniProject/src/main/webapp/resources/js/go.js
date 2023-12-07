function bye() {
	if (confirm("정말로 탈퇴 하시겠습니까?")) {
		location.href = "member.bye";
	}
}

function goJoin() {
	location.href = "member.join.go";
}
function memberInfoGo() {
	location.href = "member.info.go";
}
function logout() {
	var ok = confirm("정말로 로그아웃 하시겠습니까?");
	if (ok) {
		location.href = "member.logout";
	}
}
function snsMsgDelete(no) {
	if (confirm("정말로 삭제 하시겠습니까?")) {
		location.href = "board.delete?s_no=" + no;
	}
}

function snsMsgUpdate(no, txt) {
	txt = prompt("할 말", txt);
	if (txt != null && txt.length > 0 && txt.length < 250) {
		location.href = "board.update?s_no=" + no + "&s_text=" + txt;
	}
}
function snsPageChange(page) {
	location.href = "board.page.change?p=" + page;
}
function snsReplyDelete(no) {
	if (confirm("정말로 삭제 하시겠습니까?")) {
		location.href = "board.reply.delete?sr_no=" + no;
	}
}