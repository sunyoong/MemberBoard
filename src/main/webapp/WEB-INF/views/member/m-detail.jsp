<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>m-detail.jsp</h2>
	<a href="/">첫화면</a><br>
	${member}
	<table>
	<tr>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>이메일</th>
		<th>전화번호</th>
	</tr>
	<tr>
		<td>${member.m_id}</td>
		<td>${member.m_password}</td>
		<td>${member.m_name}</td>
		<td>${member.m_email}</td>
		<td>${member.m_phone}</td>
	</tr>
	</table>
</body>
</html>