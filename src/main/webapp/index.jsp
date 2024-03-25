<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<style>
nav {
display : flex;
justify-content : space-between;
align-items : center
}
nav a {
margin-right: 10px
}
</style>
</head>
<body>
	<nav>
		<h1>메인 페이지 입니다.</h1>
		<jsp:include page="nav.jsp" />
	</nav>
	<a href="/WebTest_city_ban_name_sol_11/car?action=list">차량 목록 페이지</a>
	<br>
	<br>

</body>
</html>