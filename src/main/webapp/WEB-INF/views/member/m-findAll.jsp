<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!--JSTL -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table,tr,td,th{
		border: 1px solid black;
	}
</style>
</head>
<body>
<a href="/member/index">첫화면</a>
	<table>
		<tr>
			<th>회원번호</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>삭제</th>
			
			
			
		</tr>
		
		<c:forEach items= "${memberList}" var="memberList">
			<tr> 
				<td>${memberList.m_number}</td>
				<td>${memberList.m_id}</td>
				<td>${memberList.m_password}</td>
				<td>${memberList.m_name}</td>
				<td>${memberList.m_email}</td>
				<td>${memberList.m_phone}</td>
				<td><a href="/member/delete?m_number=${memberList.m_number}">삭제</a>
			</tr>
		</c:forEach>
	</table>

		


	<h2>findAll.jsp</h2>
	${memberList} 
</body>
</html>