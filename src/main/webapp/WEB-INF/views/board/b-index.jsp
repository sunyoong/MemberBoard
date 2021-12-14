<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>b-index.jsp</h2>
	${sessionScope.loginId}
	<!-- <a href="/board/findAll">게시글 목록</a> -->
	<a href="/board/paging">게시판</a>
	<a href="/member/detail?m_number=${sessionScope.loginNumber}">내정보</a>
</body>
</html>