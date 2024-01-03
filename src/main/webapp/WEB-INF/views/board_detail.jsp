<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>게시글 상세보기</h1>
	</div>
	<div>
		<table>
			<tr>
				<th>BID</th>
				<td>${board.bid}</td>
				<th>제목</th>
				<td>${board.title}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3">${board.content}</td>
			</tr>
		</table>
	</div>
	<div>
		<a href="/board/delete/${board.bid}">삭제</a>
		<a href="/board/list">목록</a>
	</div>
</body>
</html>