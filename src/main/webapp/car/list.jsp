<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>차량 목록 페이지</title>
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
		<h1>차량 목록 페이지</h1>
	</nav>
	<a href="/WebTest_city_ban_name_sol_11/car?action=init">메인 화면으로</a>
	<a href="/WebTest_city_ban_name_sol_11/car?action=mvregist">등록하기</a>
	<table border="1px">
		<thead>
			<tr>
				<th>차량 번호</th>
				<th>모델</th>
				<th>브랜드</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="car" items="${list }">
				<tr>
					<td><a href="/WebTest_city_ban_name_sol_11/car?action=info&number=${car.number}">${car.number }</td>
					<td>${car.model }</td>
					<td>${car.brand }</td>
				</tr>	
			</c:forEach>
		</tbody>
	</table>
</body>
</html>