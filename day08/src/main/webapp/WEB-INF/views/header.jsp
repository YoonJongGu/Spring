<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day08</title>
<style>
	table {
		border-collapse: collapse;
		border: 2px solid black;
		margin-bottom: 50px;
	}
	thead {
		background-color: #ddd;
	}
	th, td {
		border: 1px solid grey;
		padding: 10px 20px;
	}
</style>
</head>
<body>

<h1><a href="${cpath }/">day08</a></h1>

<ul>
	<li><a href="${cpath }/ex01">ex01 - member5 회원가입 및 회원목록</a></li>
</ul>
