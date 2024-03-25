<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
		<a href="/WebTest_city_ban_name_sol_11/car?action=mvlogin">로그인</a>
		<div>
		<c:if test="${not empty userinfo}">
			<span> ${userinfo.id}님 로그인 중</span> 
			<a href="/WebTest_city_ban_name_sol_11/car?action=logout">로그아웃</a>
		</c:if>
		</div>
