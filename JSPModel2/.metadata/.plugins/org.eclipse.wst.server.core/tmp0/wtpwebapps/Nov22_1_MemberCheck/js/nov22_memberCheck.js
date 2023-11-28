//nov22_memberCheck.js

//alert("check");


function signUpCheck(){
	let m_id = document.signupForm.m_id;
	let m_pw = document.signupForm.m_pw;
	let m_pwChk = document.signupForm.m_pwChk;
	let m_name = document.signupForm.m_name;
	let m_phone = document.signupForm.m_phone;
	let m_photo = document.signupForm.m_photo;
	
	if(isEmpty(m_id) || containsAnother(m_id)){
		alert("ID똑바로 ㄱ");
		m_id.value="";
		m_id.focus();
		return false;
	} else if(isEmpty(m_pw) || notEqualPw(m_pw, m_pwChk)){
		alert("PW똑바로 ㄱ");
		m_pw.value="";
		m_pw.focus();
		return false;
	} else if(isEmpty(m_name)){
		alert("이름똑바로 ㄱ");
		m_name.value="";
		m_name.focus();
		return false;
	} else if(isEmpty(m_phone) || atLeastLetter()){
		alert("전번똑바로 ㄱ");
		m_phone.value="";
		m_phone.focus();
		return false;
	} else if(isEmpty(m_photo) || (isNotType(m_photo, "png")
				&& isNotType(m_photo, "jpg") && isNotType(m_photo, "gif"))){
		alert("사진똑바로 ㄱ");
		m_photo.value="";
		m_photo.focus();
		return false;				
	}
	
	return true;
}


function loginCheck(){
	let m_id = document.loginForm.m_id;
	let m_pw = document.loginForm.m_pw;
	
	//alert(m_id.value);
	
	if(isEmpty(m_id) || containsAnother(m_id)){
		alert("ID똑바로 ㄱ");
		m_id.value="";
		m_id.focus();
		return false;
	} else if(isEmpty(m_pw)){
		alert("PW똑바로 ㄱ");
		m_pw.value="";
		m_pw.focus();
		return false;
	}
	return true;
	
}