<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> mypage.jsp</h2>
${member}
<a href="/member/pwCheck?m_number=${member.m_number}">회원정보수정</a>

<%-- <c:if test="${member.m_password eq pwCheck}"> 
</c:if>
 --%>


 </body>
</html>