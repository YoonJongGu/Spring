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
	table {
		border-collapse: collapse;
		border: 2px solid black; 
	}
	th, td {
		border: 1px solid grey;
		padding: 10px 20px;
	}
</style>
</head>
<body>
<h1><a href="${cpath }/">day02_member</a></h1>
<hr>