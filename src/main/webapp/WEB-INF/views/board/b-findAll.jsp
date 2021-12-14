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
	<h2>b-findAll.jsp</h2>
		<a href="/board/save?m_id=${m_id}">글쓰기</a>
		<a href="/board/index?page=${paging.page}">목록으로 돌아가기</a><br>
		<a href="/">첫화면</a>
		<a href="/member/logout"> 로그아웃 </a><br>
		<form action="/board/search" method="get">
		<select name="searchtype">
			<option value="m_id">작성자</option>
			<option value="b_title">제목</option>
		</select>
		<input type="text" name="keyword" placeholder="검색어를 입력하세요">
		<input type="submit" value="확인">
		</form>
	
	<table>
	
	<tr>	
	
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>내용</th>
			<th>조회수</th>
			<th>작성일자</th>
			<!-- <th>첨부파일명</th> -->
		</tr>
	<c:forEach items="${boardList}" var="boardList">
	<tr>
		<td>${board.b_number}</td>
		<td><a href="/board/detail?b_number=${boardList.b_number}&page=${paging.page}">${boardList.b_title}</a></td>
		<td>${boardList.m_id}</td>
		<td>${boardList.b_contents}</td>
		<td>${boardList.b_hits}</td>
		<td>${boardList.b_date}</td>
		
			<c:if test = "${sessionScope.loginId eq boardList.m_id}">
		<td><a href="/board/update?b_number=${boardList.b_number}&page=${paging.page}">수정</a></td>
		<td><a href="/board/delete?b_number=${boardList.b_number}&page=${paging.page}">삭제</a></td>
			</c:if>
			
			<c:if test = "${sessionScope.loginId eq 'admin'}">
			<td><a href="/board/delete?b_number=${boardList.b_number}&page=${page}">삭제</a> 
			</c:if>
			
			

	<%-- 	<td>${board.b_filename}</td> --%>
	</tr>
	</c:forEach>
	</table>
	<div>
		<c:choose>
		<c:when test="${paging.page<=1}">
				[이전]&nbsp;
		</c:when>
		<c:otherwise>
			<a href="/board/paging?page=${paging.page-1}">[이전]</a>&nbsp;
		</c:otherwise>
		</c:choose>
		
		<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
			<c:choose>
				<c:when test="${i eq paging.page}">
					${i}
				</c:when>
				<c:otherwise>
					<a href="/board/paging?page=${i}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		
		<c:choose>
			<c:when test="${paging.page>=paging.maxPage}">
				[다음]
			</c:when>
			<c:otherwise>
				<a href="/board/paging?page=${paging.page+1}">[다음]</a>
			</c:otherwise>
		</c:choose>	

	</div>
	
	
	
	
</body>
</html>