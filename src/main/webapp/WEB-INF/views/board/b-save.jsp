<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>b-save.jsp</h2>
	
	<form action="/board/save" method="post" enctype="multipart/form-data">
	작성자 : <input type="text" name="m_id" value="${loginId}" readonly><br><br>
	제목: <input type="text" name="b_title"><br><br>
	내용: <textarea name="b_contents" row="5"></textarea><br><br>
	첨부파일: <input type="file" name="b_file"><br><br>
	<input type="submit" value="확인">
	</form>
	</body>
	
	</html>
	