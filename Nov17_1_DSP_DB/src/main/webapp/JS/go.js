//go.js

function goAppleDetail(loc){
	location.href = "AppleDetailController?a_location=" + loc;
}

function deleteApple(loc){
	let t = confirm("ㄹㅇ?");
	if(t){
		location.href = "AppleDeleteController?a_location=" +loc; 
	}
}

function goBananaDetail(loc){
	location.href = "BananaDetailController?location=" + loc;
}

function deleteBanana(loc){
	let t = confirm("ㄹㅇ?");
	if(t){
		location.href = "BananaDeleteController?location=" +loc; 
	}
}