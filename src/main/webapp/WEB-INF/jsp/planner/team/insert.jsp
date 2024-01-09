<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
팀만들기
	<form action="/teamInsert.do" method="post">
		아이디 : <input name="userId" value="${id}" readonly>
		팀 명 : <input name="name">
		<button type="submit">개설하기</button>
	</form>
</body>
</html>