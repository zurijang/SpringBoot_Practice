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
			<h1>로그인</h1>
		</div>
		<div>
			<form name="form" action="/login" method="post">
				<div>
					<label>이메일 <input type="text" name="email" /></label>
				</div>
				<div>
					<label>비밀번호 <input type="password" name="password" /></label>
				</div>
				<div>
					<a href="/signup">회원가입</a>
					<button type="submit">로그인</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>