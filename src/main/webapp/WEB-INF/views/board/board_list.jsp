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
		<div>
			<h1>내맘대로 게시판</h1>
		</div>
		<div>
			<table>
			<tr>
				<th>BID</th>
				<th>TITLE</th>
				<th>DELETE</th>
			</tr>
			<c:if test="${not empty list}">
				<c:forEach var="board" items="${list}">
					<tr>
						<td>${board.bid}</td>
						<td><a href="/board/detail?bid=${board.bid}">${board.title}</a></td>
						<td><a href="/board/delete?bid=${board.bid}">삭제</a></td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty list}">
				<tr>
					<td colspan="3">등록된 게시글이 없습니다.</td>
				</tr>
			</c:if>
			</table>
		</div>
		<div>
			<a href="/board/regist">등록</a>
		</div>
	</div>
</body>
</html>