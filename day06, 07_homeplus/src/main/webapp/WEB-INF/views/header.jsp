<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.menu {
		display: flex;
		justify-content: space-around;
	}
	.menu > form > p {
		padding: 30px;
	}
	.menu > form > p > input[type=submit] {
		margin: 0 30px;
	}
	.wrap {
		display: flex;
		flex-wrap: wrap;
		width: 1000px;
		margin: auto;
	}
	.item {
		margin: 10px;
		text-align: center;
		width: 200px;
	}
	.detail {
		display: flex;
		width: 1000px;
		margin: 30px auto;
	}
	.detail > .image {		
		margin-right: 30px;
	}
	.review {
		width: 1000px;
		margin: auto
	}
	.title {
		font-size: 20px;
		font-weight: bold;
	}
</style>
</head>
<body>

<h1><a href="${cpath }/">Homeplus</a></h1>
<hr>