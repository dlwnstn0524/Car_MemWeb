<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>차량 상세 페이지</title>
<style type="text/css">
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
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
	<h1>차량 상세 페이지</h1>
	</nav>
	<a href="/WebTest_city_ban_name_sol_11/car?action=list">목록으로</a>
	<div>
		<table border="1px">
			<tr>
				<td>차량 번호</td>
				<td>${dto.number }</td>
			</tr>
			<tr>
				<td>모델</td>
				<td>${dto.model }</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>${dto.price }</td>
			</tr>
			<tr>
				<td>브랜드</td>
				<td>${dto.brand }</td>
			</tr>
			<tr>
				<td>차량크기</td>
				<td>${dto.size }</td>
			</tr>
		</table>
	</div>
		<a href="/WebTest_city_ban_name_sol_11/car?action=mvupdate&number=${dto.number }">수정</a>
		<a href="/WebTest_city_ban_name_sol_11/car?action=delete&number=${dto.number}">삭제</a>
</body>
</html>