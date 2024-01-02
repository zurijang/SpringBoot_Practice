<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>board_regist</h1>
	<form action="/board/regist" method="post">
		<div>
			제목 <input type="text" name="title" />
		</div>
		<div>
			내용 <input type="text" name="content" />
		</div>
		<div>
			<button type="submit">등록</button>
		</div>
	</form>
</body>
</html>