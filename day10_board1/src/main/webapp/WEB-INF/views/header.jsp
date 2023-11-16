<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	a {
		text-decoration: none;
		color: inherit;	
	}
	a:hover {
		text-decoration: underline;
	}
	nav {
		display: flex;
		justify-content: space-around;
	}
	table {
		border-collapse: collapse;
		border: 2px solid black;		
	}
	thead {
		background-color: #dadada;
	}
	th, td {
		border: 1px solid grey;
		padding: 5px 10px;
	}
	.loginInfo {
		text-align: right;
		height: 25px;
	}
	.hidden {
		visibility: hidden;
	}
</style>
</head>
<body>

<h1><a href="${cpath }/">Member, Board 구현</a></h1>
<div class="${not empty login ? 'loginInfo' : 'hidden'}">${login.username }님 환영합니다</div>
<hr>

<nav>	
	<c:if test="${empty login }">
	<div><a href="${cpath }/member/join">회원가입</a></div>
	<div><a href="${cpath }/member/login">로그인</a></div>
	</c:if>
	<c:if test="${not empty login }">
	<div><a href="${cpath }/member/logout">로그아웃</a></div>
	<div><a href="${cpath }/member/mypage/${login.idx}">마이페이지</a></div>
	</c:if>
	<div><a href="${cpath }/board/board">게시판</a></div>
</nav>
<hr>
