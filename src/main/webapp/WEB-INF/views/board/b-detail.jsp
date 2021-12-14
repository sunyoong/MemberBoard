<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script> 
</head>
<body>
<h2>b_datil.jsp</h2>
글번호 : ${board.b_number}
제목 : ${board.b_title}
작성자 : ${board.m_id}
조회수 : ${board.b_hits}
날짜 : ${board.b_date}<br>
내용 : ${board.b_contents}
파일 : ${board.b_filename}
	<img alt="" src="/resources/board/upload/${board.b_filename}"> 
	
	
<!-- 댓글등록  -->
<div id="comment">
	<%-- <span id="c_writer" name="c_writer" value="${loginId}">▶${loginId}</span><br>
	<textarea id="c_contents" name="c_contents" row="5" > </textarea> --%>
	<%--<input type="text" name="c_writer" id="c_writer" value="${loginId}" readonly> --%>
	작성자 : ${loginId} <input type="text" name="c_contents" id="c_contents" placeholder="내용">
	<button onclick="write1()">확인</button>
</div>

<!-- 댓글리스트  -->
<div id="comment-List"> 
	<table>
	<tr>
		<th>번호</th> 
		<th>작성자</th>
		<th>내용</th>
		<th>날짜</th>
	</tr>
	<c:forEach items="${commentList}" var="comment">
		<tr>
			<td>${comment.c_number}</td>
			<td>${comment.c_writer}</td>
			<td>${comment.c_contents}</td>
			<td>${comment.c_date}</td>
		</tr>
	</c:forEach>
	</table>
</div>

<a href="/board/paging">목록</a>
</body>
<script>
/* 댓글 저장을 하기 위한 스크립트 */

	function write1(){
	console.log("ㅎㅇ");
	
	//const writer = document.getElementById('c_writer').value;
	const writer = '${loginId}'; //이걸로 하고 위에 지워버려요 이렇게 하면
	let contents = document.getElementById('c_contents').value;
	const b_num = '${board.b_number}';
	
	console.log(writer);
	console.log(contents);
	console.log(b_num);
	
	let view = document.getElementById('comment-List');
	
	$.ajax({
		type: 'post',
		url: '/comment/save',
		data: {"b_number":b_num, "c_writer":writer, "c_contents":contents},
		dataType: 'json',
		success:function(result){
			console.log("바밤바");
			console.log(result);
			
			let output = "<table>";
			output += "<tr>";
			output += "<th>번호</th><th>작성자</th><th>내용</th><th>날짜</th>";
			output += "</tr>";
			$.each(result,function(i){
			output += "<tr>";
			output += "<td>"+(i+1)+"</td>";// 번호
			output += "<td>"+result[i].c_writer+"</td>";// 작성자
			output += "<td>"+result[i].c_contents+"</td>";// 내용
			output += "<td>"+result[i].c_date+"</td>";// 날짜
			output += "</tr>";				
			});
			output += "</table>";
			
			view.innerHTML = output;
			document.getElementById("c_contents").value = ""; // 내용 값을 초기화
		},
		error: function(){
			console.log("죠스바"); 
		}
		
	});
}

/* function write(){
		console.log("댓글등록버튼 클릭");
		const commentWriter = document.getElementById('c_writer').value;
		const commentContents = document.getElementById('c_contents').value;
		const boardNum = '${board.b_number}';
		
		console.log(commentWriter);
		console.log(commentContents);
		console.log(boardNum);
		
		$.ajax({
			type: 'post',
			url: '/comment/save',
			data: {"c_writer" : commentWriter, 
					"c_contents" : commentContents,
					"b_number" : boardNum},
			dataType: 'json',
			success: function(){
				console.log("result");	
			}
			error: function(){
				console.log("에러 찾읍시다");	
			}
			
			
			
		});
		
		} */
		
		
		

</script>
</html>