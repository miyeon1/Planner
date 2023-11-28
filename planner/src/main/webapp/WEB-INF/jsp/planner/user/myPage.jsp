<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	아이디 : ${user.id } <br/>
	비밀번호 : ${user.pw } <br/>
	주소 : ${user.adress } <br/>
	상세주소 : ${user.detailAdress } <br/>
	직급 : ${user.rank } <br/>
	이름 : ${user.name } <br/>
	회사명 : ${user.companyNm } <br/>
	이메일 : ${user.email } <br/>
	전화번호 : ${user.tel } <br/>
	
	<form action="/logOut.do" method="post">
		<button type="submit" formaction="/logOut.do">로그아웃</button>
	</form>
</body>
</html>