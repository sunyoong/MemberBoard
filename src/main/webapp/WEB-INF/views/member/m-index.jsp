<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function login-ing(){
		
		
	}


</script>
</head>

<body>
	로그인 아이디: ${sessionScope.loginId}
	<h2>m-index.jsp</h2>
	<c:if test="${sessionScope.loginId != null}">
	<a href="/board/index">게시글</a><br>
	<a href="/member/mypage?m_number=${sessionScope.loginNumber}">MY</a><br>
	<a href="/member/logout">로그아웃</a><br>
	</c:if> 
	<c:if test="${sessionScope.loginId == null}">
	<a href="/member/save"> 회원가입 </a><br>
	<a href="/member/login" id="login-ing()"> 로그인 </a><br>
	</c:if>
	

	<c:if test="${sessionScope.loginId == 'admin'}">
	<a href="/member/admin"> 관리자</a><br>
	</c:if>
	
	
	
	
	
</body>
</html>