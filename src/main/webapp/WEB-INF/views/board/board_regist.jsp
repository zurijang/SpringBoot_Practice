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
<script>
	function logout() {
		
		$.ajax({
			type: 'post',
			url: '/logout',
			success : function(data) {
				location.reload(true);
			}
		})
		
	}
</script>
<body>
	<div>
		<h1>board_regist</h1>
		<a href="javascript:logout();">로그아웃</a>
	</div>
	<div>
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
	</div>
</body>
</html>