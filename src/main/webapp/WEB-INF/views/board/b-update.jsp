<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	/*  function idCheck(){
		const id = document.getElementById("m_id").value;
		const idCk = document.getElementById("idCk");
		$.ajax({
			type : "post",
			url: "/member/memberId",
			data: {"m_id": id},
			dataType: 'text',
			success: function(result){
			
			}
			error: function(){
			
			}
			
			
			
			
		})
		
		
	}
 */
 
 

</script>
</head>
<body>
<h2>b-update.jsp</h2>
	
	<form action="/board/update" method="post">
	<input type="hidden" name="page" value="${page}" readonly>
	<input type="hidden" name="b_number" value="${board.b_number}" readonly>
	작성자 :<input type="text" name="m_id" value="${board.m_id}" readonly><br>
	제목 : <input type="text" name="b_title" value="${board.b_title}"><br>
	내용 : <input type="text" name="b_contents" value="${board.b_contents}"><br>
	<input type="submit" value="수정">
	</form>
	
</body>
</html>