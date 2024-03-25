<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>차량 등록 페이지</title>
<style>
nav {
	display: flex;
	justify-content: space-between;
	align-items: center
}

nav a {
	margin-right: 10px
}
</style>
</head>
<body>
	<nav>
		<h1>차량 등록 페이지</h1>
	</nav>
	<form action="/WebTest_city_ban_name_sol_11/car?action=regist" method="post">
		<fieldset>
			<input type="hidden" name="action" value="regist"> <br>
			<label> 차 번호 <input type="text" name="number"></label> <br>
			<label> 모델 <input type="text" name="model"></label> <br>
			<label> 가격 <input type="number" name="price"></label> <br>
			<label> 브랜드 <input type="text" name="brand"></label> <br>
			<label> 차량 크기 <select name="size">
					<option value="소형">소형</option>
					<option value="중형">중형</option>
					<option value="대형">대형</option>
			</select> 
			</label> <br> <input type="submit" value="등록"> 
			<br> 
			<a href="/WebTest_city_ban_name_sol_11/car?action=list">목록으로</a>
		</fieldset>
	</form>
</body>
</html>