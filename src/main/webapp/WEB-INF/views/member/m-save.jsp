<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	function idCheck(){
		const id = document.getElementById("m_id").value;
		const idCk = document.getElementById("id-dup-chk");
		$.ajax({
			type: 'post',
			url: '/member/idCheck',
			data: {'m_id': id},
			dataType: 'text',
			success: function(result){
			if(result=="o"){
				idCk.innerHTML = '사용이 가능한 아이디입니다.';
				idCk.style.color = 'green';
			} else{
				idCk.innerHTML = '이미 사용중인 아이디입니다.';
				idCk.style.color = 'red';
			}
			},
			error: function(){
				console.log('ㅎㅎㅎ다시 오타를...');
				
			
			}
			
		})
		
		
		
		
		
	}



</script>

</head>
<body>
	<h2>m-insert.jsp</h2>
	<form action="/member/save" method=post enctype="multipart/form-data">
	아이디 : <input type="text" name="m_id" id="m_id" onblur="idCheck()">
	<span id="id-dup-chk"></span>
	비밀번호 : <input type="password" name="m_password">
	이름 : <input type="text" name="m_name">
	이메일 : <input type="text" name="m_email">@<input type="text" name="domain"> 
	<select id="domainSel">
		<option value="naver.com">naver.com</option>
		<option value="google.com">google.com</option>
		<option value="daum.net">daum.net</option>
	</select>
	전화번호 : <input type="text" name="m_phone">
	프로필사진 : <input type="file" name="m_file">
	<input type="submit" value="가입완료">
	</form>
</body>
</html>