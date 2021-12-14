<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script> 
<script>
	/* function pwCheck(){
		console.log("pwCheck이지롱")
	const pw = document.getElementById('m_password').value;
	const DBpw = '${member.m_password}';
	const mNum = '${member.m_number}';
	console.log(mNum);
	const pwResult = document.getElementById('pwResult').value;
	 
 	$.ajax({
			type: 'post',
			url: '/member/pwCheck',
			data: {'m_password' : pw,
					'm_number': mNum},
			dataType: 'text',
			sucees: function(result){
				console.log("결과는..?"+ result);
				
				
			},
			error: function(){
				console.log("또 틀렸어...");
			}
			
		})
		
	}
 */
</script>
</head>
<body>
<h2>m-update.jsp</h2>
	${member}
	${member.m_password}
	<form action="/member/update" method="post"> 
	<input type="hidden" name="m_number" value="${member.m_number}" readonly>
	아이디 : <input type="text" name= m_id value="${member.m_id}" readonly><br>
	변경할 비밀번호 : <input type="text" name="m_password"><br>
	이름 : <input type="text" name="m_name" value="${member.m_name}" readonly><br>
	이메일 : <input type="text" name="m_email" value="${member.m_email}"><br>
	전화번호 : <input type="text" name="m_phone" value="${member.m_phone}"><br>
	<input type="submit" value="수정">
<!-- 	<button id="update-chk-btn" onclick="pwCheck()">수정</button>	 -->
	</form>
	
</body>
</html>