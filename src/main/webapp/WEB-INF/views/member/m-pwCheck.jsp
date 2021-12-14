<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function pwck(){
		const pw = document.getElementById('m_password').value;
		const DBpw = '${member.m_password}';
		if(pw==DBpw){
			pwCheck_form.submit();
		} else{
			alert("비밀번호가 틀렸어요 ㅠㅠ");
		}

		}

	</script>




</head>
<body>
<h2>m-pwCheck.jsp</h2>
<form action="/member/updateform?m_number=${member.m_number}" method="post" name="pwCheck_form"> 
	<input type="hidden" name="m_number" value="${member.m_number}" readonly>
	아이디 : <input type="text" name= m_id value="${member.m_id}" readonly><br>
	비밀번호 : <input type="text" name="m_password" id="m_password"><br>
	<input type="button" value="확인" onclick="pwck()">


</form>
</body>
</html>