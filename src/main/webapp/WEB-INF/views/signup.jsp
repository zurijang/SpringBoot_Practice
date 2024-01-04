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
		<h1>회원가입</h1>
	</div>
	<div>
		<form name="form" method="post" action="/signup">
			<div>
				<label>이메일 <input type="text" name="email" /></label>
			</div>
			<div>
				<label>비밀번호 <input type="password" name="password" /></label>
			</div>
			<div>
				<button type="submit">회원가입</button>
			</div>
		</form>
	</div>
</body>
</html>